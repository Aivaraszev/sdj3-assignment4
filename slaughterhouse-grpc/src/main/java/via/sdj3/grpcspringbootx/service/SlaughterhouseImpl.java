package via.sdj3.grpcspringbootx.service;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcspringbootx.repository.AnimalRepository;
import via.sdj3.grpcspringbootx.repository.ProductRepository;

import java.util.List;

@GRpcService
public class SlaughterhouseImpl extends SlaughterhouseGrpc.SlaughterhouseImplBase {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    AnimalRepository animalRepository;

    @Override
    public void getAnimalIdsOfProduct(RequestAnimalsInProduct request, StreamObserver<ResponseAnimalsInProduct> responseObserver) {
        ResponseAnimalsInProduct.Builder response = ResponseAnimalsInProduct.newBuilder();

        try {
            List<Long> animalIds = animalRepository.findAllAnimalsByProductId(request.getId());
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
            List<Long> productIds = productRepository.findAllProductsByAnimalId(request.getId());
            response.addAllProductIds(productIds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
