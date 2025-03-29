CREATE TABLE Asesor (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(100),
    especializacion VARCHAR2(100)
);

CREATE TABLE Cliente (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(100),
    apellido VARCHAR2(100),
    dni VARCHAR2(20) UNIQUE,
    asesor_id NUMBER REFERENCES Asesor(id)
);

CREATE TABLE Cuenta (
    id NUMBER PRIMARY KEY,
    tipo VARCHAR2(20) CHECK (tipo IN ('ahorro', 'corriente', 'CDT')),
    saldo NUMBER DEFAULT 0,
    tasa_interes NUMBER(10,4),
    cliente_id NUMBER REFERENCES Cliente(id)
);

CREATE TABLE Transaccion (
    id NUMBER PRIMARY KEY,
    monto NUMBER,
    tipo VARCHAR2(20),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cuenta_id NUMBER REFERENCES Cuenta(id)
);

CREATE TABLE CDT (
    id NUMBER PRIMARY KEY,
    monto_invertido NUMBER(19,4) NOT NULL,
    tasa_interes NUMBER(10,4) NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    cliente_id NUMBER REFERENCES Cliente(id)
);

CREATE TABLE Producto_Financiero (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(100),
    descripcion VARCHAR2(500),
    tasa NUMBER(10,4) NOT NULL
)