BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE cake_price (
    price_id SERIAL,
    cupcake_single NUMERIC(6, 2) NOT NULL,
    cupcake_bakers_dozen NUMERIC(6, 2) NOT NULL,
    small_cake NUMERIC(6, 2) NOT NULL,
    large_cake NUMERIC(6, 2) NOT NULL,
    small_cake_custom NUMERIC(6, 2) NOT NULL,
    large_cake_custom NUMERIC(6, 2) NOT NULL,
    CONSTRAINT PK_cake_price PRIMARY KEY (price_id)
);

CREATE TABLE cake_flavors (
    flavor_id SERIAL,
    flavor_name VARCHAR(25) NOT NULL,
    is_available BOOLEAN NOT NULL,
    CONSTRAINT PK_cake_flavor PRIMARY KEY (flavor_id)
);

CREATE TABLE cake_frostings (
    frosting_id SERIAL,
    frosting_name VARCHAR(25) NOT NULL,
    is_available BOOLEAN NOT NULL,
    CONSTRAINT PK_cake_frostings PRIMARY KEY (frosting_id)
);

CREATE TABLE cake_fillings (
    filling_id SERIAL,
    filling_name VARCHAR(25) NOT NULL,
    is_available BOOLEAN NOT NULL,
    CONSTRAINT PK_cake_fillings PRIMARY KEY (filling_id)
);

CREATE TABLE cake_sizes (
    size_id SERIAL,
    size_name VARCHAR(25) NOT NULL,
    is_available BOOLEAN NOT NULL,
    CONSTRAINT PK_cake_sizes PRIMARY KEY (size_id)
);

CREATE TABLE cake_style (
    style_id SERIAL,
    style_name VARCHAR(25) NOT NULL,
    is_available BOOLEAN NOT NULL,
    CONSTRAINT PK_cake_style PRIMARY KEY (style_id)
);

CREATE TABLE standard_cake (
    standard_cake_id SERIAL,
    cake_name VARCHAR(25) NOT NULL UNIQUE,
    description VARCHAR(500) NOT NULL,
    price NUMERIC(6, 2) NOT NULL,
    img VARCHAR(100),
    is_available BOOLEAN NOT NULL,
    CONSTRAINT PK_standard_cake PRIMARY KEY (standard_cake_id)

);

CREATE TABLE custom_cake (
    custom_cake_id SERIAL,
    cake_size_id INT,
    cake_flavor_id INT,
    cake_frosting_id INT,
    cake_filling_id INT,
    cake_style_id INT,
    extras VARCHAR(50) NOT NULL,
    price_id INT NOT NULL,
    CONSTRAINT PK_custom_cake PRIMARY KEY (custom_cake_id),
    FOREIGN KEY (cake_flavor_id) REFERENCES cake_flavors(flavor_id),
    FOREIGN KEY (cake_frosting_id) REFERENCES cake_frostings(frosting_id),
    FOREIGN KEY (cake_filling_id) REFERENCES cake_fillings(filling_id),
    FOREIGN KEY (cake_size_id) REFERENCES cake_sizes(size_id),
    FOREIGN KEY (cake_style_id) REFERENCES cake_style(style_id),
    FOREIGN KEY (price_id) REFERENCES cake_price(price_id)
);

CREATE TABLE cake_order (
    order_id SERIAL,
    standard_cake_id INT DEFAULT NULL,
    custom_cake_id INT DEFAULT NULL,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    due_date DATE NOT NULL,
    due_time TIME NOT NULL,
    writing VARCHAR (140),
    status VARCHAR (20) DEFAULT 'Pending',
    total NUMERIC(8, 2) NOT NULL,
    CONSTRAINT PK_standard_cake_order PRIMARY KEY (order_id),
    FOREIGN KEY (standard_cake_id) REFERENCES standard_cake(standard_cake_id),
    FOREIGN KEY (custom_cake_id) REFERENCES custom_cake(custom_cake_id)
);



COMMIT TRANSACTION;
