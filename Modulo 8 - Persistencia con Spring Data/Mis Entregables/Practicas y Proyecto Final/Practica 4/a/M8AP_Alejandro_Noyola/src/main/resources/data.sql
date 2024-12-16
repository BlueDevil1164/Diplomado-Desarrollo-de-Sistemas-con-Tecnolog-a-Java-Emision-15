-- Inserciones en la tabla comprador
INSERT INTO comprador (nombreComprador, apellidoComprador, edad, genero, correo, usuarioComprador, contrasena) VALUES
('Valerie', 'Noyola', 27, 'F', 'Vale1164@gmail.com', 'GoldenEyes1164', 'Vale@r360'),
('Michael', 'Smith', 30, 'M', 'mike.smith@gmail.com', 'MikeS30', 'Strong@123'),
('Laura', 'Johnson', 25, 'F', 'laura.johnson@gmail.com', 'LJ_25', 'Sunshine@25'),
('David', 'Martínez', 35, 'M', 'david.martinez@gmail.com', 'DaveM35', 'Secure@456'),
('Sofia', 'Garcia', 29, 'F', 'sofia.garcia@gmail.com', 'Sofi29', 'Password#789'),
('Carlos', 'Hernández', 40, 'M', 'carlos.hernandez@gmail.com', 'CHern40', 'Strongman@2021'),
('Emma', 'Lopez', 22, 'F', 'emma.lopez@gmail.com', 'EmLo22', 'Emma@Lpz22'),
('Joshua', 'Brown', 33, 'M', 'josh.brown@gmail.com', 'JoshB33', 'SecurePass@333'),
('Natalia', 'Torres', 28, 'F', 'natalia.torres@gmail.com', 'NatyT28', 'Nat@Torres28'),
('Brian', 'Davis', 37, 'M', 'brian.davis@gmail.com', 'BriD37', 'Dav1s@123'),
('Camila', 'Ramírez', 26, 'F', 'camila.ramirez@gmail.com', 'CamiR26', 'Camila@Ram26');


-- Inserciones en la tabla laptops
INSERT INTO laptops (modelo, pantalla, marca, color, ram) VALUES
('15-fa1006la', 15.6, 'HP', 'Rojo', 8.00),
('XPS13-9310', 13.4, 'Dell', 'Negro', 16.00),
('MacBook Air M1', 13.3, 'Apple', 'Plata', 8.00),
('ThinkPad X1 Carbon', 14.0, 'Lenovo', 'Negro', 16.00),
('Aspire 5 A515', 15.6, 'Acer', 'Azul', 12.00),
('VivoBook 15', 15.6, 'Asus', 'Gris', 8.00),
('Pavilion x360', 14.0, 'HP', 'Oro', 8.00),
('Inspiron 14 5000', 14.0, 'Dell', 'Plata', 12.00),
('Yoga Slim 7', 14.0, 'Lenovo', 'Gris', 16.00),
('ZenBook 14', 14.0, 'Asus', 'Blanco', 8.00);

INSERT INTO Categoria (id_categoria, categoria, abreviatura) VALUES
(1, 'Smartphones', 'SPH'),
(2, 'Laptops', 'LTP'),
(3, 'Tablets', 'TBL'),
(4, 'Televisores', 'TV'),
(5, 'Audífonos', 'AUD');


-- Insertar electrónicos
INSERT INTO Electronicos (idElectronico, nombreElectronico, precio, existencias, codigoDeBarras, precioDeVenta, costoDeProduccion, id_categoria) VALUES
('E001', 'iPhone 13', 799.99, 50, 123456789012, 899.99, 600.00, 1),
('E002', 'Samsung Galaxy S21', 699.99, 30, 987654321098, 799.99, 550.00, 1),
('E003', 'MacBook Air', 999.99, 20, 112233445566, 1099.99, 800.00, 2),
('E004', 'Dell XPS 13', 1099.99, 15, 223344556677, 1199.99, 900.00, 2),
('E005', 'iPad Pro', 799.99, 40, 334455667788, 899.99, 700.00, 3),
('E006', 'Samsung Galaxy Tab S7', 649.99, 25, 445566778899, 749.99, 500.00, 3),
('E007', 'Sony Bravia 55"', 1199.99, 10, 556677889900, 1299.99, 1000.00, 4),
('E008', 'LG OLED 65"', 1499.99, 8, 667788990011, 1599.99, 1200.00, 4),
('E009', 'AirPods Pro', 249.99, 100, 778899001122, 299.99, 150.00, 5),
('E010', 'Sony WH-1000XM4', 349.99, 80, 889900112233, 399.99, 200.00, 5);


INSERT INTO Marca (marca, StarRate, electronicos_matricula) VALUES
('Samsung', 5, 'E123456'),
('Apple', 4, 'E234567'),
('Sony', 3, 'E345678'),
('LG', 4, 'E456789'),
('Xiaomi', 5, 'E567890');



INSERT INTO Proveedores (nombreProveedor) VALUES
('Foxconn'),
('Pegatron'),
('Flextronics'),
('Jabil Circuit'),
('Wistron');

INSERT INTO Electronicos_Proveedores (matricula, id_proveedor, anio) VALUES
('E001', 1, 2022),
('E002', 2, 2022),
('E003', 1, 2023),
('E004', 3, 2023),
('E005', 1, 2022),
('E006', 2, 2023),
('E007', 4, 2022),
('E008', 4, 2023),
('E009', 5, 2022),
('E010', 5, 2023);


-- Inserciones en la tabla vendedor
INSERT INTO vendedor (nombreVendedor, apellidoVendedor, edad, genero, correo, usuarioVendedor, contrasena) VALUES
('Sylvester', 'Stallone', 64, 'M', 'Rocky7@gmail.com', 'TigerEyes1164', 'Vale@r360'),
('Arnold', 'Schwarzenegger', 73, 'M', 'Terminator@gmail.com', 'IronMan2473', 'Hasta@laVis123'),  -- Acortada
('Gal', 'Gadot', 36, 'F', 'WonderGal@gmail.com', 'AmazonQueen36', 'Lass0ofTruth21'),  -- Acortada
('Keanu', 'Reeves', 57, 'M', 'NeoReeves@gmail.com', 'JohnWick57', 'Matrix#Reloaded'),
('Scarlett', 'Johansson', 38, 'F', 'BlackWidow@gmail.com', 'ScarJo38', 'Avengers@123'),
('Tom', 'Cruise', 59, 'M', 'EthanHunt@gmail.com', 'TopGunCruise59', 'Mission@Pos987'),  -- Acortada
('Zoe', 'Saldana', 44, 'F', 'AvatarZoe@gmail.com', 'GamoraZ44', 'Nebula@Guardians20'),  -- Acortada
('Chris', 'Hemsworth', 38, 'M', 'ThorGod@gmail.com', 'Thunder38', 'Mjolnir#Hammer45'),  -- Acortada
('Jennifer', 'Lawrence', 31, 'F', 'Mockingjay@gmail.com', 'Katniss31', 'Catching@Fire9'),  -- Acortada
('Dwayne', 'Johnson', 49, 'M', 'RockNation@gmail.com', 'TheRock49', 'Smackdown@321'),
('Natalie', 'Portman', 40, 'F', 'JaneFoster@gmail.com', 'MightyThor40', 'EndGame@Infinity12');  -- Acortada
