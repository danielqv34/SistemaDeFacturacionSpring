/*
*@Author:Daniel Quiroz
 Proposito:Script de creacion de las tablas para el sistema de facturacion en JAVA with ORACLE.
 Fecha :01/09/2016
*/

DROP TABLE USUARIOS_FAC; 
DROP SEQUENCE NUM_FACTURA;
DROP SEQUENCE LIN_FACTURA;
DROP TABLE DETALLE_FACTURA;
DROP TABLE PRODUCTOS;
DROP TABLE FACTURA;
DROP TABLE CLIENTE;
DROP TABLE CIUDAD;
DROP TABLE PROVINCIA;

CREATE TABLE USUARIOS_FAC
(
ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY,
NOMBRES    NVARCHAR2(50)                      NOT NULL,
APELLIDOS  NVARCHAR2(50)                      NOT NULL,
CEDULA     CHAR(11 BYTE)                      NOT NULL UNIQUE,
TELEFONO   CHAR(10 BYTE)                      NOT NULL UNIQUE,
CELULAR    CHAR(10 BYTE)                      NOT NULL UNIQUE,
CORREO     NVARCHAR2(50)                      NOT NULL UNIQUE,
NOMBRE_USUARIO    NVARCHAR2(25)               NOT NULL UNIQUE,
CLAVE      NVARCHAR2(100)                     NOT NULL,
ROL        NUMBER(1, 0)                          NOT NULL,
ESTADO     NUMBER(1, 0) DEFAULT 1 NOT NULL
);
COMMENT ON COLUMN USUARIOS_FAC.ID IS 'Clave primaria';
COMMENT ON COLUMN USUARIOS_FAC.NOMBRES IS 'Nombre del Usuario';
COMMENT ON COLUMN USUARIOS_FAC.APELLIDOS IS 'Apellido del Usuario';
COMMENT ON COLUMN USUARIOS_FAC.CEDULA IS 'Cedula del usuario';
COMMENT ON COLUMN USUARIOS_FAC.TELEFONO IS 'Telefeno del usuario';
COMMENT ON COLUMN USUARIOS_FAC.CELULAR IS 'Celular del usuario';
COMMENT ON COLUMN USUARIOS_FAC.CORREO IS 'Correo principal del usuario';
COMMENT ON COLUMN USUARIOS_FAC.NOMBRE_USUARIO IS 'Nombre de usuario para ingresar al sistema';
COMMENT ON COLUMN USUARIOS_FAC.CLAVE IS 'Clave de acceso del usuario';
COMMENT ON COLUMN USUARIOS_FAC.ROL IS 'Rol del Usuario en el sistema 1=Administrado ; 0=Normal';
COMMENT ON COLUMN USUARIOS_FAC.ESTADO IS 'Estado del Usuario en el sistema . 1=Activo ; 0=Inactivo';




CREATE TABLE CLIENTE(
ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY,
NOMBRES NVARCHAR2(40) NOT NULL,
APELLIDOS NVARCHAR2(40) NOT NULL,
DIRECCION NVARCHAR2(150) NOT NULL,
FECHA_NACIMIENTO DATE ,
TELEFONO NUMBER(12) NOT NULL,
MAIL NVARCHAR2(50) NOT NULL UNIQUE,
CATEGORIA NVARCHAR2(15) NOT NULL,
ESTADO     NUMBER(1, 0) DEFAULT 1 NOT NULL,
FECHA_MODIFICACION DATE DEFAULT SYSDATE NOT NULL 
);
COMMENT ON COLUMN CLIENTE.ID IS 'Clave primaria';
COMMENT ON COLUMN CLIENTE.NOMBRES IS 'Nombre del Cliente';
COMMENT ON COLUMN CLIENTE.APELLIDOS IS 'Apellido del Cliente';
COMMENT ON COLUMN CLIENTE.DIRECCION IS 'Direccion del Cliente';
COMMENT ON COLUMN CLIENTE.FECHA_NACIMIENTO IS 'Fecha de nacimiento del cliente';
COMMENT ON COLUMN CLIENTE.TELEFONO IS 'Telefeno del Cliente';
COMMENT ON COLUMN CLIENTE.MAIL IS 'Correo principal del Cliente';
COMMENT ON COLUMN CLIENTE.FECHA_MODIFICACION IS 'Fecha en la cual se modifico por ultima vez el registro';
COMMENT ON COLUMN CLIENTE.ESTADO IS 'Estado del Cliente en el sistema . 1=Activo ; 0=Inactivo';


CREATE TABLE FACTURA(
ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY,
NUMERO_FACTURA NUMBER(18) NOT NULL UNIQUE,
ID_CLIENTE NUMBER NOT NULL,
FECHA_FACTURA DATE DEFAULT SYSDATE NOT NULL,
ITBIS NUMBER(18,2),
MONTO_PARCIAL NUMBER(18,2) NOT NULL,
MONTO_TOTAL NUMBER(18,2) NOT NULL,
CONSTRAINT CLIENTE_FACTURA FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(ID)
);
/*Secuencia para la generacion de las Facturas**/
CREATE SEQUENCE NUM_FACTURA
START WITH 001
INCREMENT BY 1
MINVALUE 001;
/*Secuencia para la generacion de las lineas de una Factura**/
CREATE SEQUENCE LIN_FACTURA
START WITH 001
INCREMENT BY 1
MINVALUE 001;

COMMENT ON COLUMN FACTURA.ID IS 'Clave primaria';
COMMENT ON COLUMN FACTURA.NUMERO_FACTURA IS 'Numero de la Factura';
COMMENT ON COLUMN FACTURA.ID_CLIENTE IS 'ID del cliente de la Factura';
COMMENT ON COLUMN FACTURA.FECHA_FACTURA IS 'Fecha de emision de la factura';
COMMENT ON COLUMN FACTURA.ITBIS IS 'Impuesto en RD';
COMMENT ON COLUMN FACTURA.MONTO_PARCIAL IS 'Monto sin impuestos';
COMMENT ON COLUMN FACTURA.MONTO_TOTAL IS 'Monto total de la Factura';


CREATE TABLE PRODUCTOS(
ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) PRIMARY KEY,
NOMBRE NVARCHAR2(100) NOT NULL,
DESCRIPCION NVARCHAR2(150),
CODIGO CHAR(13) UNIQUE NOT NULL,
PRECIO_COMPRA NUMBER(8,2) NOT NULL,
PRECIO_VENTA NUMBER(8,2) NOT NULL,
NOTA NVARCHAR2(1000) DEFAULT NULL,
FECHA_INICIO_VENTA DATE NOT NULL,
FECHA_FIN_VENTA DATE,
DISPONIBLE_VENTA NUMBER(1,0) NOT NULL,
FECHA_DISCONTINUIDAD DATE,
FECHA_MODIFICACION DATE NOT NULL,
ESTADO     NUMBER(1, 0) DEFAULT 1 NOT NULL
);
COMMENT ON COLUMN PRODUCTOS.ID IS 'Clave Primaria';
COMMENT ON COLUMN PRODUCTOS.NOMBRE IS 'Nombre del producto';
COMMENT ON COLUMN PRODUCTOS.DESCRIPCION IS 'Descripcion del Producto';
COMMENT ON COLUMN PRODUCTOS.CODIGO IS 'Codigo del producto';
COMMENT ON COLUMN PRODUCTOS.PRECIO_COMPRA IS 'Precio de compra del producto mostrado en RD$';
COMMENT ON COLUMN PRODUCTOS.PRECIO_VENTA IS 'Precio de venta del producto mostrado en RD$';
COMMENT ON COLUMN PRODUCTOS.FECHA_INICIO_VENTA IS 'Fecha en la cual inicio la venta del articulo';
COMMENT ON COLUMN PRODUCTOS.FECHA_FIN_VENTA IS 'Fecha en la cual se dejo de comercializar el articulo';
COMMENT ON COLUMN PRODUCTOS.DISPONIBLE_VENTA IS 'Disponibilidad de venta 1 = Disponible 0 = No Disponible';
COMMENT ON COLUMN PRODUCTOS.FECHA_DISCONTINUIDAD IS 'Fecha en la cual se descontinuo el producto';
COMMENT ON COLUMN PRODUCTOS.FECHA_MODIFICACION IS 'Fecha en la cual se modifico por ultima vez el registro';
COMMENT ON COLUMN PRODUCTOS.ESTADO IS 'Estado actual del producto 1= Activo 0= Inactivo';

CREATE TABLE DETALLE_FACTURA(
ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
ID_FACTURA NUMBER NOT NULL,
ID_PRODUCTO NUMBER NOT NULL UNIQUE,
ID_LINEA_FACTURA NUMBER UNIQUE,
DESCRIPCION NVARCHAR2(150),
CANTIDAD NUMBER(18) NOT NULL,
PRECIO_UNITARIO NUMBER(18,2) NOT NULL,
PRECIO_TOTAL NUMBER(18,2) NOT NULL,
CONSTRAINT FK_FACTURA_DET FOREIGN KEY (ID_FACTURA) REFERENCES FACTURA(ID),
CONSTRAINT FK_PRODUCTO_DET FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID),
PRIMARY KEY (ID,ID_LINEA_FACTURA)
);
COMMENT ON COLUMN DETALLE_FACTURA.ID IS 'Clave primaria';
COMMENT ON COLUMN DETALLE_FACTURA.ID_FACTURA IS 'Relacion con la tabla facturas';
COMMENT ON COLUMN DETALLE_FACTURA.ID_PRODUCTO IS 'Relacion con la tabla productos';
COMMENT ON COLUMN DETALLE_FACTURA.CANTIDAD IS 'Cantidad de productos comprados';
COMMENT ON COLUMN DETALLE_FACTURA.PRECIO_UNITARIO IS 'Precio Unitario de cada producto mostrado en RD$';
COMMENT ON COLUMN DETALLE_FACTURA.PRECIO_TOTAL IS 'Precio total de cada producto x cantidad mostrado en RD$';

CREATE TABLE PROVINCIA(
ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
NOMBRE_PROVINCIA NVARCHAR2(20) NOT NULL UNIQUE,
CAPITAL NVARCHAR2(30) NOT NULL,
CODIGO_PROVINCIA CHAR(2) NOT NULL  PRIMARY KEY
);
COMMENT ON COLUMN PROVINCIA.ID IS 'Clave primaria';
COMMENT ON COLUMN PROVINCIA.NOMBRE_PROVINCIA IS 'Nombre de la Provincia';
COMMENT ON COLUMN PROVINCIA.CAPITAL IS 'Capital de La Provincia';
COMMENT ON COLUMN PROVINCIA.CODIGO_PROVINCIA IS 'Codigo Mapa de la Provincia';


CREATE TABLE CIUDAD(
ID NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1),
NOMBRE_CIUDAD NVARCHAR2(50) NOT NULL,
CODIGO_PROVINCIA char(2) NOT NULL,
CONSTRAINT FK_PROVINCIA FOREIGN KEY (CODIGO_PROVINCIA) REFERENCES PROVINCIA(CODIGO_PROVINCIA)
);
COMMENT ON COLUMN CIUDAD.ID IS 'Clave primaria';
COMMENT ON COLUMN CIUDAD.NOMBRE_CIUDAD IS 'Nombre de la ciudad o municipio';
COMMENT ON COLUMN CIUDAD.CODIGO_PROVINCIA IS 'Provincia a la que pertence';
