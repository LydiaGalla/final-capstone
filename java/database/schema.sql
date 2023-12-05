BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE customer (
	customer_id SERIAL,
	firstname VARCHAR(25) NOT NULL,
	lastname VARCHAR(25) NOT NULL,
	email VARCHAR(50) NOT NULL,
	phone VARCHAR(20) NOT NULL,
	CONSTRAINT PK_customer PRIMARY KEY (customer_id)
);

CREATE TABLE employee (
    employee_id SERIAL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    firstname VARCHAR(25) NOT NULL,
    lastname VARCHAR(25) NOT NULL,
    CONSTRAINT PK_employee PRIMARY KEY (employee_id)
);

CREATE TABLE standard_cake (
    standard_cake_id SERIAL,
    cake_name VARCHAR(25) NOT NULL UNIQUE,
    description VARCHAR(500) NOT NULL,
    price NUMERIC(8, 2) NOT NULL,
    is_available BOOLEAN NOT NULL,
    CONSTRAINT PK_standard_cake PRIMARY KEY (standard_cake_id)
);

CREATE TABLE custom_cake (
    custom_cake_id SERIAL,
    cake_style VARCHAR(25) NOT NULL,
    cake_size VARCHAR(25) NOT NULL,
    cake_flavor VARCHAR(25) NOT NULL,
    frosting_flavor VARCHAR(25) NOT NULL,
    filling_flavor VARCHAR(25) NOT NULL,
    extras VARCHAR(50) NOT NULL,
    CONSTRAINT PK_custom_cake PRIMARY KEY (custom_cake_id)
);

CREATE TABLE cake_order (
    order_id SERIAL,
    customer_id INTEGER,
    standard_cake_id INTEGER,
    custom_cake_id INTEGER,
    due_date DATE NOT NULL,
    due_time TIME NOT NULL,
    writing VARCHAR (140) NOT NULL,
    status VARCHAR (20) NOT NULL,
    quantity INTEGER NOT NULL,
    CONSTRAINT PK_cake_order PRIMARY KEY (order_id),
    CONSTRAINT check_standard_custom_cake CHECK (
    (standard_cake_id IS NOT NULL AND custom_cake_id IS NULL) OR
    (standard_cake_id IS NULL AND custom_cake_id IS NOT NULL)
    )
    CONSTRAINT FK_cake_order_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);


COMMIT TRANSACTION;
