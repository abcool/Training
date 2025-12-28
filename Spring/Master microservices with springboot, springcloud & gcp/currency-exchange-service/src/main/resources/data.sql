/*create table currency_exchange (id bigint not null, conversion_multiple decimal(19,2),
  currency_from varchar(255), currency_to varchar(255), primary key (id))
*/
insert into currency_exchange(id,currency_from,currency_to,conversion_multiple) values(1001,'USD','INR',65.00);
insert into CURRENCY_EXCHANGE(id,currency_from,currency_to,conversion_multiple) values(1002,'EUR','INR',75.00);
insert into CURRENCY_EXCHANGE(id,currency_from,currency_to,conversion_multiple) values(1003,'AUD','INR',55.00);