INSERT INTO u807522414_Invitarte.cliente
(nombre, apellido, cuit)
VALUES
		('Pablo', 'Miguez', '20xxxxxxxx0'),
		('Martin', 'Miguez', '20xxxxxxxx0'),
		('Daniela', 'Miguez', '27xxxxxxxx8'),
		('Ivette', 'Hak', '27xxxxxxxx8'),
		('Roberto', 'Hak', '20xxxxxxxx0'),
		('Ivan', 'Hak', '20xxxxxxxx0'),
		('Fabricio', 'Vera', '20xxxxxxxx0'),
		('Guadalupe', 'Vera', '20xxxxxxxx0'),
		('Fabiana', 'Hak', '20xxxxxxxx0'),
		('Margarita', 'Sizun', '20xxxxxxxx0');
		
	
INSERT INTO u807522414_Invitarte.rubro
(rubro)
VALUES
		('Libreria'),
		('Bazar'),
		('Almacen'),
		('Verduleria'),
		('Bijouterie'),
		('Carniceria'),
		('Cotillon'),
		('Ropa');
	
INSERT INTO u807522414_Invitarte.producto
(codigo, nombre, fecha_creacion, id_rubro)
VALUES
		('AAA00', 'Remera', '2022-01-01', 8),
		('AAA01', 'Costeletas Ternera', '2022-01-01', 6),
		('AAA02', 'Pulsera', '2022-01-02', 5),
		('AAA03', 'Lapicera', '2022-01-02', 1),
		('AAA04', 'Papa', '2022-03-03', 4),
		('AAA05', 'Polenta', '2022-03-16', 3),
		('AAA06', 'Bonete', '2022-04-01', 7),
		('AAA07', 'Corabate Luces', '2022-04-024', 7),
		('AAA08', 'Vasos', '2022-05-06', 2),
		('AAA09', 'Platos', '2022-05-18', 2),
		('AAB00', 'Lapiz', '2023-01-25', 1),
		('AAB01', 'Goma', '2023-01-25', 1),
		('AAB02', 'Mantel', '2023-01-25', 2),
		('AAB03', 'Taza', '2023-01-25', 2),
		('AAB04', 'Leche', '2023-01-25', 3),
		('AAB05', 'Arvejas', '2023-01-25', 3),
		('AAB06', 'Pantalon', '2023-01-25', 8);
	

INSERT INTO u807522414_Invitarte.venta
(codigo_producto, fecha, cantidad, precio_unitario, id_cliente)
VALUES
		('AAA00', '2023-01-25', 1, 100, 1),
		('AAA00', '2023-01-25', 3, 100, 3),
		('AAA01', '2023-01-25', 2, 500, 5),
		('AAA02', '2023-01-25', 5, 50, 7),
		('AAA03', '2023-01-25', 6, 50, 9),
		('AAA04', '2023-01-25', 4, 70, 2),
		('AAA05', '2023-01-25', 8, 200, 4),
		('AAA06', '2023-01-25', 7, 250, 6),
		('AAA07', '2023-01-25', 5, 150, 8),
		('AAA08', '2023-01-25', 3, 600, 10),
		('AAA09', '2023-01-25', 1, 1000, 1),
		('AAA00', '2023-01-25', 2, 100, 2),
		('AAA01', '2023-01-25', 4, 500, 3),
		('AAA02', '2023-01-25', 6, 50, 4),
		('AAA03', '2023-01-25', 8, 50, 5),
		('AAA04', '2023-01-25', 10, 70, 6),
		('AAA05', '2023-01-25', 13, 200, 7),
		('AAA06', '2023-01-25', 17, 250, 8),
		('AAA07', '2023-01-25', 9, 150, 9),
		('AAA08', '2023-01-25', 6, 600, 10),
		('AAA09', '2023-01-25', 1, 1000, 1),/**/
		('AAB00', '2023-01-25', 1, 50, 2),
		('AAB01', '2023-01-25', 2, 20, 3),
		('AAB02', '2023-01-25', 3, 1500, 10),
		('AAB03', '2023-01-25', 4, 600, 9),
		('AAB04', '2023-01-25', 5, 300, 8),
		('AAB05', '2023-01-25', 6, 200, 4),
		('AAB06', '2023-01-25', 1, 2000, 5),
		('AAB00', '2023-01-25', 2, 100, 7),
		('AAB01', '2023-01-25', 3, 50, 6),
		('AAB02', '2023-01-25', 21, 20, 1),
		('AAB03', '2023-01-25', 15, 1500, 10),
		('AAB04', '2023-01-25', 19, 600, 2),
		('AAB05', '2023-01-25', 31, 300, 9),
		('AAB00', '2023-01-25', 44, 200, 3),
		('AAB06', '2023-01-25', 88, 2000, 8);
