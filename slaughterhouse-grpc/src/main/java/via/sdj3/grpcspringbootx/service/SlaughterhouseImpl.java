package via.sdj3.grpcspringbootx.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import via.sdj3.grpcspringbootx.dao.SQLAnimalDao;
import via.sdj3.grpcspringbootx.dao.SQLProductDao;
import via.sdj3.grpcspringbootx.protobuf.*;

import java.util.List;

@GRpcService
public class SlaughterhouseImpl extends SlaughterhouseGrpc.SlaughterhouseImplBase {
    @Override
    public void getAnimalIdsOfProduct(RequestAnimalsInProduct request, StreamObserver<ResponseAnimalsInProduct> responseObserver) {
        ResponseAnimalsInProduct.Builder response = ResponseAnimalsInProduct.newBuilder();

        try {
            List<Integer> animalIds = SQLProductDao.getInstance().getIdsOfAnimals(request.getId());
            response.addAllAnimalIds(animalIds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getProductIdsWithAnimal(RequestProductsWithAnimal request, StreamObserver<ResponseProductsWithAnimal> responseObserver) {
        ResponseProductsWithAnimal.Builder response = ResponseProductsWithAnimal.newBuilder();

        try {
            List<Integer> productIds = SQLAnimalDao.getInstance().getIdsOfProducts(request.getId());
            response.addAllProductIds(productIds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
