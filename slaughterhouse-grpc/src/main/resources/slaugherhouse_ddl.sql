DROP SCHEMA IF EXISTS slaughterhouse CASCADE;
CREATE SCHEMA slaughterhouse;
SET SCHEMA 'slaughterhouse';

CREATE TABLE Animal
(
    id INTEGER PRIMARY KEY,
    weight DOUBLE PRECISION
);

CREATE TABLE Tray
(
    id INTEGER PRIMARY KEY,
    type VARCHAR(255),
    capacity DOUBLE PRECISION
);

CREATE TABLE Product
(
    id INTEGER PRIMARY KEY
);

CREATE TABLE AnimalPart
(
    id INTEGER PRIMARY KEY,
    weight DOUBLE PRECISION,
    type VARCHAR(255),
    animalId INTEGER REFERENCES Animal(id),
    trayId INTEGER REFERENCES Tray(id)
);

CREATE TABLE TrayAndProduct
(
    productId INTEGER REFERENCES Product(id),
    trayId INTEGER REFERENCES Tray(id)
);
