CREATE TABLE PRODUCT_INFO (
  id INT NOT null,
  product_name VARCHAR(255) NOT null,
  product_image VARCHAR(500) NOT null,
  product_code VARCHAR(255) NOT null,
  SKU VARCHAR(255) NOT NULL
  sold INT,
  stock INT,
  price NUMERIC(15, 2)
)