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

-- Inserciones en la tabla electronicos
INSERT INTO electronicos (nombreElectronico, precio, existencias, codigoDeBarras, precioDeVenta, costoDeProduccion) VALUES
('Smartphone', 999.99, 50, 1234567890123, 1099.99, 800.500),
('Laptop', 1499.99, 30, 9876543210123, 1599.99, 1200.750),
('Tablet', 599.99, 100, 1231231231231, 649.99, 450.400),
('Smartwatch', 199.99, 200, 3213213213213, 249.99, 150.300),
('Cámara Digital', 499.99, 80, 4567890123456, 549.99, 350.500),
('Televisor 4K', 799.99, 40, 6543210987654, 899.99, 600.750),
('Auriculares Inalámbricos', 129.99, 300, 7890123456789, 159.99, 90.250),
('Consola de Videojuegos', 399.99, 70, 0123456789123, 449.99, 300.700),
('Bocina Bluetooth', 99.99, 150, 0987654321098, 129.99, 70.200),
('Monitor 27 pulgadas', 299.99, 60, 2109876543210, 349.99, 220.450),
('Cámara de Seguridad', 199.99, 120, 3456789012345, 249.99, 140.600),
('Router WiFi', 89.99, 250, 5432109876543, 109.99, 60.300),
('Impresora Láser', 249.99, 90, 6789012345678, 299.99, 180.400),
('Proyector HD', 599.99, 40, 4321098765432, 649.99, 450.750);

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
