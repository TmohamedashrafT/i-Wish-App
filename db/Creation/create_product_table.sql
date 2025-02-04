create table product_table  (

Product_id number(8) primary key  not null ,
Product_name varchar2(100),
Product_price number(8,3),
manufacture_date date


);


CREATE SEQUENCE product_id_seq
START WITH 1
INCREMENT BY 1
NOCYCLE;


CREATE OR REPLACE TRIGGER product_id_trigger
BEFORE INSERT ON product_table
FOR EACH ROW
BEGIN
    :NEW.Product_id := product_id_seq.NEXTVAL;
END;