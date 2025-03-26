
CREATE TABLE customer
(
	id                  SERIAL PRIMARY KEY NOT NULL,
	user_name           VARCHAR(64) NOT NULL UNIQUE,
	email               VARCHAR(64) NOT NULL UNIQUE,
	name                VARCHAR(64) NOT NULL,
	surname             VARCHAR(64) NOT NULL,
	date_of_birth       DATE,
	telephone_number    VARCHAR(64)
);

CREATE TABLE producer
(
	id                  SERIAL PRIMARY KEY NOT NULL,
	producer_name       VARCHAR(64) NOT NULL UNIQUE,
	address             VARCHAR(128)
);

CREATE TABLE product (
    id                  SERIAL PRIMARY KEY NOT NULL,
    product_code        VARCHAR(255) NOT NULL UNIQUE,
    product_name        VARCHAR(255) NOT NULL,
    product_price       NUMERIC(7,2) NOT NULL,
    adults_only         BOOLEAN NOT NULL,
    description         TEXT NOT NULL,
    producer_id         INT NOT NULL,
    CONSTRAINT fk_product_producer
        FOREIGN KEY (producer_id)
            REFERENCES producer(id)
);

CREATE TABLE PURCHASE
(
	id                  SERIAL PRIMARY KEY NOT NULL,
	customer_id         INT NOT NULL,
	product_id          INT NOT NULL,
	quantity            INT NOT NULL check (quantity > 0),
	date_time           TIMESTAMP WITH TIME ZONE NOT NULL,
	CONSTRAINT fk_purchase_customer
            FOREIGN KEY (customer_id)
                REFERENCES customer(id),
    CONSTRAINT fk_purchase_product
            FOREIGN KEY (product_id)
                REFERENCES product(id)
);

CREATE TABLE OPINION
(
	id                  SERIAL PRIMARY KEY NOT NULL,
	customer_id         INT NOT NULL,
	product_id          INT NOT NULL,
	stars               INT NOT NULL check (STARS between 1 and 5),
	comment             TEXT NOT NULL,
	date_time           TIMESTAMP WITH TIME ZONE NOT NULL,

	CONSTRAINT fk_purchase_customer
                FOREIGN KEY (customer_id)
                    REFERENCES customer(id),
        CONSTRAINT fk_purchase_product
                FOREIGN KEY (product_id)
                    REFERENCES product(id)
);

alter sequence customer_id_seq restart with 101;
alter sequence producer_id_seq restart with 21;
alter sequence product_id_seq restart with 51;
alter sequence purchase_id_seq restart with 301;
alter sequence opinion_id_seq restart with 141;