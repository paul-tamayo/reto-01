CREATE TABLE account (
  number          BIGSERIAL NOT NULL, 
  account_type_id int8 NOT NULL, 
  customer_id     int8 NOT NULL, 
  balance         numeric(9, 2) NOT NULL, 
  enabled         char(1) NOT NULL, 
  PRIMARY KEY (number));
CREATE TABLE account_type (
  id          BIGSERIAL NOT NULL, 
  name        varchar(50) NOT NULL, 
  description varchar(500), 
  PRIMARY KEY (id));
CREATE TABLE accounting_movement (
  id              BIGSERIAL NOT NULL, 
  account_number  int8 NOT NULL, 
  initial_balance numeric(9, 2) NOT NULL, 
  created         date NOT NULL, 
  final_balance   numeric(9, 2) NOT NULL, 
  value           numeric(9, 2) NOT NULL, 
  enabled         char(1) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE customer (
  id          BIGSERIAL NOT NULL, 
  fullname    varchar(500) NOT NULL, 
  address     varchar(500) NOT NULL, 
  phonenumber varchar(15) NOT NULL, 
  password    varchar(50) NOT NULL, 
  enabled     char(1) NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE account ADD CONSTRAINT FKaccount508441 FOREIGN KEY (account_type_id) REFERENCES account_type (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE account ADD CONSTRAINT FKaccount767521 FOREIGN KEY (customer_id) REFERENCES customer (id) ON UPDATE Restrict ON DELETE Restrict;
ALTER TABLE accounting_movement ADD CONSTRAINT FKaccounting778808 FOREIGN KEY (account_number) REFERENCES account (number) ON UPDATE Restrict ON DELETE Restrict;
