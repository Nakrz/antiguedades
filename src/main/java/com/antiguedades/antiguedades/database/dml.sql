
INSERT INTO pais (id_pais, nombre_pais) VALUES
(1, 'Chile'),
(2, 'Argentina'),
(3, 'Colombia'),
(4, 'México'),
(5, 'Perú'),
(6, 'Brasil');


INSERT INTO region (id_region, nombre_region, id_pais) VALUES
(1, 'Metropolitana', 1),
(2, 'Buenos Aires', 2),
(3, 'Cundinamarca', 3),
(4, 'Jalisco', 4),
(5, 'Lima', 5),
(6, 'Sao Paulo', 6);


INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES
(1, 'Santiago', 1),
(2, 'Buenos Aires', 2),
(3, 'Bogotá', 3),
(4, 'Guadalajara', 4),
(5, 'Lima', 5),
(6, 'Sao Paulo', 6),
(7, 'Valparaíso', 1),
(8, 'Rosario', 2);


INSERT INTO rol (id_rol, nombre_rol) VALUES
(1, 'Administrador'),
(2, 'Cliente'),
(3, 'Empleado'),
(4, 'Visita'),
(5, 'Proveedor');


INSERT INTO disponibilidad (id_disponibilidad, nombre) VALUES
(1, 'Disponible'),
(2, 'No Disponible'),
(3, 'Reservado'),
(4, 'En Mantenimiento');


INSERT INTO categorias (id_categoria, nombre_categoria) VALUES
(1, 'Antigüedades'),
(2, 'Arte'),
(3, 'Muebles'),
(4, 'Decoración'),
(5, 'Libros');


INSERT INTO administrador (id_administrador, nombre_administrador, apellido_administrador, correo) VALUES
(1, 'Juan', 'Pérez', 'juan.perez@example.com'),
(2, 'María', 'González', 'maria.gonzalez@example.com'),
(3, 'Luis', 'Martínez', 'luis.martinez@example.com'),
(4, 'Ana', 'Fernández', 'ana.fernandez@example.com'),
(5, 'Carlos', 'Rojas', 'carlos.rojas@example.com');


INSERT INTO empleado (id_empleado, nombre_empleado, apellido_empleado, correo_empleado, telefono_empleado, id_jefe) VALUES
(1, 'Carlos', 'López', 'carlos.lopez@example.com', 123456789, 1),
(2, 'Laura', 'Martínez', 'laura.martinez@example.com', 987654321, 1),
(3, 'Pedro', 'García', 'pedro.garcia@example.com', 555555555, 2),
(4, 'Lucía', 'Hernández', 'lucia.hernandez@example.com', 444444444, 2),
(5, 'Javier', 'Jiménez', 'javier.jimenez@example.com', 333333333, 3);


INSERT INTO cliente (id_cliente, nombre_cliente, apellido_cliente, correo_cliente, telefono_cliente, rol, id_ciudad) VALUES
(1, 'Pedro', 'Sánchez', 'pedro.sanchez@example.com', 123123123, 2, 1),
(2, 'Ana', 'Torres', 'ana.torres@example.com', 321321321, 2, 2),
(3, 'Jorge', 'Suárez', 'jorge.suarez@example.com', 456456456, 2, 3),
(4, 'Sofia', 'Mendoza', 'sofia.mendoza@example.com', 789789789, 1, 4),
(5, 'Diego', 'Morales', 'diego.morales@example.com', 159159159, 2, 5);


INSERT INTO ranking_antiguedad (id_ranking, valor_ranking) VALUES
(1, 'Bajo'),
(2, 'Medio'),
(3, 'Alto'),
(4, 'Excelente'),
(5, 'Coleccionista');


INSERT INTO epoca_antiguedad (id_epoca, nombre_epoca) VALUES
(1, 'Precolombino'),
(2, 'Colonial'),
(3, 'Moderno'),
(4, 'Contemporáneo'),
(5, 'Antiguo');


INSERT INTO antiguedades (id_antiguedad, nombre_antiguedad, id_categoria, id_disponibilidad, id_ranking, id_epoca, origen, estado_conservacion, precio, id_administrador) VALUES
(1, 'Vase Precolombino', 1, 1, 3, 1, 'Perú', 'Bueno', 1500.00, 1),
(2, 'Silla Colonial', 2, 1, 2, 2, 'Chile', 'Regular', 800.00, 2),
(3, 'Cuadro Moderno', 2, 1, 1, 3, 'Argentina', 'Excelente', 3000.00, 1),
(4, 'Mueble Antiguo', 3, 1, 4, 4, 'Colombia', 'Bueno', 1200.00, 2),
(5, 'Escultura Contemporánea', 2, 1, 5, 4, 'México', 'Nuevo', 4500.00, 1);


INSERT INTO tipo_transaccion (id_tipo_transaccion, descripcion) VALUES
(1, 'Venta'),
(2, 'Alquiler'),
(3, 'Subasta'),
(4, 'Donación');


INSERT INTO metodo_pago (id_metodo_pago, nombre_metodo_pago) VALUES
(1, 'Tarjeta de Crédito'),
(2, 'Transferencia Bancaria'),
(3, 'Efectivo'),
(4, 'PayPal');


INSERT INTO transacciones (id_transaccion, id_antiguedad, id_cliente, id_administrador, fecha_transaccion, id_tipo_transaccion, id_metodo_pago, cantidad) VALUES
(1, 1, 1, 1, '2024-09-19', 1, 1, 1),
(2, 2, 2, 2, '2024-09-20', 2, 2, 1),
(3, 3, 3, 1, '2024-09-21', 1, 3, 1),
(4, 4, 4, 2, '2024-09-22', 3, 1, 1),
(5, 5, 5, 1, '2024-09-23', 1, 4, 1);


INSERT INTO direccion_cliente (id_direccion, id_cliente, direccion1, direccion2, id_ciudad) VALUES
(1, 1, 'Av. Libertador 1234', 'Depto 56', 1),
(2, 2, 'Calle Falsa 123', NULL, 2),
(3, 3, 'Calle Real 45', NULL, 3),
(4, 4, 'Av. Central 789', 'Piso 3', 4),
(5, 5, 'Calle Verde 12', 'Casa 2', 5);


INSERT INTO despachos (id_despacho, id_transaccion, fecha_despacho, id_direccion, id_cliente) VALUES
(1, 1, '2024-09-21', 1, 1),
(2, 2, '2024-09-22', 2, 2),
(3, 3, '2024-09-23', 3, 3),
(4, 4, '2024-09-24', 4, 4),
(5, 5, '2024-09-25', 5, 5);





