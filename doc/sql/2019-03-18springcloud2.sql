
CREATE DATABASE springcloud2 CHARACTER SET UTF8 ;
USE springcloud2 ;
CREATE TABLE product (
productId BIGINT AUTO_INCREMENT ,
productName VARCHAR(50) ,
 productDesc VARCHAR(50) ,
CONSTRAINT pk_prodcut_id PRIMARY KEY(prodcutId)
) ;

INSERT INTO product(productName,productDesc) VALUES ('java编程',springcloud2()) ;
INSERT INTO product(productName,productDesc) VALUES ('Springboot',springcloud2()) ;
INSERT INTO product(productName,productDesc) VALUES ('西游记',springcloud2()) ;
INSERT INTO product(productName,productDesc) VALUES ('水浒传',springcloud2()) ;
INSERT INTO product(productName,productDesc) VALUES ('西厢记',springcloud2()) ;

