CREATE DATABASE springcloud CHARACTER SET UTF8 ;
USE springcloud ;
CREATE TABLE product (
productId BIGINT AUTO_INCREMENT ,
productName VARCHAR(50) ,
 productDesc VARCHAR(50) ,
CONSTRAINT pk_product_id PRIMARY KEY(productId)
) ;

INSERT INTO product(productName,productDesc) VALUES ('java编程',springcloud11) ;
INSERT INTO product(productName,productDesc) VALUES ('Springboot',springcloud11) ;
INSERT INTO product(productName,productDesc) VALUES ('西游记',springcloud11) ;
INSERT INTO product(productName,productDesc) VALUES ('水浒传',springcloud11) ;
INSERT INTO product(productName,productDesc) VALUES ('西厢记',springcloud11) ;

