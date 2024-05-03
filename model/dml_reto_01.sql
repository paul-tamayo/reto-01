DELETE FROM accounting_movement;
DELETE FROM account;
DELETE FROM account_type;
DELETE FROM customer;

INSERT INTO account_type ("name","description") VALUES ('AHORRO','AHORRO'), ('CORRIENTE','CORRIENTE');

INSERT INTO customer ("fullname", "address", "phonenumber", "password", "enabled") VALUES ('Jose Lema', 'Otavalo sn y principal', '098254785', '1234', '1');
INSERT INTO customer ("fullname", "address", "phonenumber", "password", "enabled") VALUES ('Marianela Montalvo', 'Amazonas y NNUU', '097548965', '1234', '1');
INSERT INTO customer ("fullname", "address", "phonenumber", "password", "enabled") VALUES ('Juan Osorio', '13 junio y Equinoccial', '098874587', '1234', '1');

COMMIT;
