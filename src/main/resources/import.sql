INSERT INTO pais (id_pais, nombre_pais) VALUES (1, 'Chile');
INSERT INTO pais (id_pais, nombre_pais) VALUES (2, 'Argentina');
INSERT INTO pais (id_pais, nombre_pais) VALUES (3, 'Colombia');
INSERT INTO pais (id_pais, nombre_pais) VALUES (4, 'Mexico');
INSERT INTO pais (id_pais, nombre_pais) VALUES (5, 'Peru');
INSERT INTO pais (id_pais, nombre_pais) VALUES (6, 'Brasil');

INSERT INTO region (id_region, nombre_region, id_pais) VALUES (1, 'Metropolitana', 1);
INSERT INTO region (id_region, nombre_region, id_pais) VALUES (2, 'Buenos Aires', 2);
INSERT INTO region (id_region, nombre_region, id_pais) VALUES (3, 'Cundinamarca', 3);
INSERT INTO region (id_region, nombre_region, id_pais) VALUES (4, 'Jalisco', 4);
INSERT INTO region (id_region, nombre_region, id_pais) VALUES (5, 'Lima', 5);
INSERT INTO region (id_region, nombre_region, id_pais) VALUES (6, 'Sao Paulo', 6);

INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (1, 'Santiago', 1);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (2, 'Buenos Aires', 2);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (3, 'Bogota', 3);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (4, 'Guadalajara', 4);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (5, 'Lima', 5);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (6, 'Sao Paulo', 6);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (7, 'Valparaiso', 1);
INSERT INTO ciudad (id_ciudad, nombre_ciudad, id_region) VALUES (8, 'Rosario', 2);

INSERT INTO rol (id_rol, nombre_rol) VALUES (1, 'Comprador');
INSERT INTO rol (id_rol, nombre_rol) VALUES (2, 'Vendedor');
INSERT INTO rol (id_rol, nombre_rol) VALUES (3, 'Mantenimiento');
INSERT INTO rol (id_rol, nombre_rol) VALUES (4, 'Visita');
INSERT INTO rol (id_rol, nombre_rol) VALUES (5, 'Coleccionista');

INSERT INTO disponibilidad (id_disponibilidad, nombre) VALUES (1, 'Disponible');
INSERT INTO disponibilidad (id_disponibilidad, nombre) VALUES (2, 'No Disponible');
INSERT INTO disponibilidad (id_disponibilidad, nombre) VALUES (3, 'Reservado');
INSERT INTO disponibilidad (id_disponibilidad, nombre) VALUES (4, 'En Mantenimiento');

INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (1, 'Antiguedades');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (2, 'Arte');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (3, 'Muebles');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (4, 'Decoración');
INSERT INTO categorias (id_categoria, nombre_categoria) VALUES (5, 'Libros');

INSERT INTO administrador (id_administrador, nombre_administrador, apellido_administrador, correo) VALUES (1, 'Juan', 'Perez', 'juan.perez@example.com');
INSERT INTO administrador (id_administrador, nombre_administrador, apellido_administrador, correo) VALUES (2, 'Maria', 'Gonzalez', 'maria.gonzalez@example.com');
INSERT INTO administrador (id_administrador, nombre_administrador, apellido_administrador, correo) VALUES (3, 'Luis', 'Martinez', 'luis.martinez@example.com');
INSERT INTO administrador (id_administrador, nombre_administrador, apellido_administrador, correo) VALUES (4, 'Ana', 'Fernandez', 'ana.fernandez@example.com');
INSERT INTO administrador (id_administrador, nombre_administrador, apellido_administrador, correo) VALUES (5, 'Carlos', 'Rojas', 'carlos.rojas@example.com');

INSERT INTO empleado (id_empleado, nombre_empleado, apellido_empleado, correo_empleado, telefono_empleado, id_jefe) VALUES (1, 'Carlos', 'López', 'carlos.lopez@example.com', 123456789, 1);
INSERT INTO empleado (id_empleado, nombre_empleado, apellido_empleado, correo_empleado, telefono_empleado, id_jefe) VALUES (2, 'Laura', 'Martinez', 'laura.martinez@example.com', 987654321, 1);
INSERT INTO empleado (id_empleado, nombre_empleado, apellido_empleado, correo_empleado, telefono_empleado, id_jefe) VALUES (3, 'Pedro', 'Garcia', 'pedro.garcia@example.com', 555555555, 2);
INSERT INTO empleado (id_empleado, nombre_empleado, apellido_empleado, correo_empleado, telefono_empleado, id_jefe) VALUES (4, 'Lucia', 'Hernandez', 'lucia.hernandez@example.com', 444444444, 2);
INSERT INTO empleado (id_empleado, nombre_empleado, apellido_empleado, correo_empleado, telefono_empleado, id_jefe) VALUES (5, 'Javier', 'Jimenez', 'javier.jimenez@example.com', 333333333, 3);

INSERT INTO cliente (id_cliente, nombre_cliente, apellido_cliente, correo_cliente, telefono_cliente, rol, id_ciudad) VALUES (1, 'Pedro', 'Sanchez', 'pedro.sanchez@example.com', 123123123, 2, 1);
INSERT INTO cliente (id_cliente, nombre_cliente, apellido_cliente, correo_cliente, telefono_cliente, rol, id_ciudad) VALUES (2, 'Ana', 'Torres', 'ana.torres@example.com', 321321321, 2, 2);
INSERT INTO cliente (id_cliente, nombre_cliente, apellido_cliente, correo_cliente, telefono_cliente, rol, id_ciudad) VALUES (3, 'Jorge', 'Suarez', 'jorge.suarez@example.com', 456456456, 2, 3);
INSERT INTO cliente (id_cliente, nombre_cliente, apellido_cliente, correo_cliente, telefono_cliente, rol, id_ciudad) VALUES (4, 'Sofia', 'Mendoza', 'sofia.mendoza@example.com', 789789789, 1, 4);
INSERT INTO cliente (id_cliente, nombre_cliente, apellido_cliente, correo_cliente, telefono_cliente, rol, id_ciudad) VALUES (5, 'Diego', 'Morales', 'diego.morales@example.com', 159159159, 2, 5);

INSERT INTO ranking_antiguedad (id_ranking, valor_ranking) VALUES (1, 'Bajo');
INSERT INTO ranking_antiguedad (id_ranking, valor_ranking) VALUES (2, 'Medio');
INSERT INTO ranking_antiguedad (id_ranking, valor_ranking) VALUES (3, 'Alto');
INSERT INTO ranking_antiguedad (id_ranking, valor_ranking) VALUES (4, 'Excelente');
INSERT INTO ranking_antiguedad (id_ranking, valor_ranking) VALUES (5, 'Coleccionista');

INSERT INTO epoca_antiguedad (id_epoca, nombre_epoca) VALUES (1, 'Precolombino');
INSERT INTO epoca_antiguedad (id_epoca, nombre_epoca) VALUES (2, 'Colonial');
INSERT INTO epoca_antiguedad (id_epoca, nombre_epoca) VALUES (3, 'Moderno');
INSERT INTO epoca_antiguedad (id_epoca, nombre_epoca) VALUES (4, 'Contemporaneo');
INSERT INTO epoca_antiguedad (id_epoca, nombre_epoca) VALUES (5, 'Antiguo');

INSERT INTO antiguedades (id_antiguedad, nombre_antiguedad, id_categoria, id_disponibilidad, id_ranking, id_epoca, origen, estado_conservacion, precio, id_administrador) VALUES (1, 'Vase Precolombino', 1, 1, 3, 1, 'Peru', 'Bueno', 1500.00, 1);
INSERT INTO antiguedades (id_antiguedad, nombre_antiguedad, id_categoria, id_disponibilidad, id_ranking, id_epoca, origen, estado_conservacion, precio, id_administrador) VALUES (2, 'Silla Colonial', 2, 1, 2, 2, 'Chile', 'Regular', 800.00, 2);
INSERT INTO antiguedades (id_antiguedad, nombre_antiguedad, id_categoria, id_disponibilidad, id_ranking, id_epoca, origen, estado_conservacion, precio, id_administrador) VALUES (3, 'Cuadro Moderno', 2, 1, 1, 3, 'Argentina', 'Excelente', 3000.00, 1);
INSERT INTO antiguedades (id_antiguedad, nombre_antiguedad, id_categoria, id_disponibilidad, id_ranking, id_epoca, origen, estado_conservacion, precio, id_administrador) VALUES (4, 'Mueble Antiguo', 3, 1, 4, 4, 'Colombia', 'Bueno', 1200.00, 2);
INSERT INTO antiguedades (id_antiguedad, nombre_antiguedad, id_categoria, id_disponibilidad, id_ranking, id_epoca, origen, estado_conservacion, precio, id_administrador) VALUES (5, 'Escultura Contemporanea', 2, 1, 5, 4, 'Mexico', 'Nuevo', 4500.00, 1);

INSERT INTO tipo_transaccion (id_tipo_transaccion, descripcion) VALUES (1, 'Venta');
INSERT INTO tipo_transaccion (id_tipo_transaccion, descripcion) VALUES (2, 'Alquiler');
INSERT INTO tipo_transaccion (id_tipo_transaccion, descripcion) VALUES (3, 'Subasta');
INSERT INTO tipo_transaccion (id_tipo_transaccion, descripcion) VALUES (4, 'Donación');


INSERT INTO metodo_pago (id_metodo_pago, nombre_metodo_pago) VALUES (1, 'Tarjeta de Credito');
INSERT INTO metodo_pago (id_metodo_pago, nombre_metodo_pago) VALUES (2, 'Transferencia Bancaria');
INSERT INTO metodo_pago (id_metodo_pago, nombre_metodo_pago) VALUES (3, 'Efectivo');
INSERT INTO metodo_pago (id_metodo_pago, nombre_metodo_pago) VALUES (4, 'PayPal');


INSERT INTO transacciones (id_transaccion, id_antiguedad, id_cliente, id_administrador, fecha_transaccion, id_tipo_transaccion, id_metodo_pago, cantidad) VALUES (1, 1, 1, 1, '2024-09-19', 1, 1, 1);
INSERT INTO transacciones (id_transaccion, id_antiguedad, id_cliente, id_administrador, fecha_transaccion, id_tipo_transaccion, id_metodo_pago, cantidad) VALUES (2, 2, 2, 2, '2024-09-20', 2, 2, 1);
INSERT INTO transacciones (id_transaccion, id_antiguedad, id_cliente, id_administrador, fecha_transaccion, id_tipo_transaccion, id_metodo_pago, cantidad) VALUES (3, 3, 3, 1, '2024-09-21', 1, 3, 1);
INSERT INTO transacciones (id_transaccion, id_antiguedad, id_cliente, id_administrador, fecha_transaccion, id_tipo_transaccion, id_metodo_pago, cantidad) VALUES (4, 4, 4, 2, '2024-09-22', 3, 1, 1);
INSERT INTO transacciones (id_transaccion, id_antiguedad, id_cliente, id_administrador, fecha_transaccion, id_tipo_transaccion, id_metodo_pago, cantidad) VALUES (5, 5, 5, 1, '2024-09-23', 1, 4, 1);


INSERT INTO direccion_cliente (id_direccion, id_cliente, direccion1, direccion2, id_ciudad) VALUES (1, 1, 'Av. Libertador 1234', 'Depto 56', 1);
INSERT INTO direccion_cliente (id_direccion, id_cliente, direccion1, direccion2, id_ciudad) VALUES (2, 2, 'Calle Falsa 123', NULL, 2);
INSERT INTO direccion_cliente (id_direccion, id_cliente, direccion1, direccion2, id_ciudad) VALUES (3, 3, 'Calle Real 45', NULL, 3);
INSERT INTO direccion_cliente (id_direccion, id_cliente, direccion1, direccion2, id_ciudad) VALUES (4, 4, 'Av. Central 789', 'Piso 3', 4);
INSERT INTO direccion_cliente (id_direccion, id_cliente, direccion1, direccion2, id_ciudad) VALUES (5, 5, 'Calle Verde 12', 'Casa 2', 5);


INSERT INTO despachos (id_despacho, id_transaccion, fecha_despacho, id_direccion, id_cliente) VALUES (1, 1, '2024-09-21', 1, 1);
INSERT INTO despachos (id_despacho, id_transaccion, fecha_despacho, id_direccion, id_cliente) VALUES (2, 2, '2024-09-22', 2, 2);
INSERT INTO despachos (id_despacho, id_transaccion, fecha_despacho, id_direccion, id_cliente) VALUES (3, 3, '2024-09-23', 3, 3);
INSERT INTO despachos (id_despacho, id_transaccion, fecha_despacho, id_direccion, id_cliente) VALUES (4, 4, '2024-09-24', 4, 4);
INSERT INTO despachos (id_despacho, id_transaccion, fecha_despacho, id_direccion, id_cliente) VALUES (5, 5, '2024-09-25', 5, 5);