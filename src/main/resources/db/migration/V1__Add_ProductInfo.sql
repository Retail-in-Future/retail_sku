CREATE TABLE `PRODUCT_INFO` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255) NOT null,
  `product_image` VARCHAR(500) NOT null,
  `product_code` VARCHAR(255) NOT null,
  `sku` VARCHAR(255) NOT NULL,
  `sold_number` BIGINT(10),
  `stock` BIGINT(10),
  `price` NUMERIC(15, 2),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;