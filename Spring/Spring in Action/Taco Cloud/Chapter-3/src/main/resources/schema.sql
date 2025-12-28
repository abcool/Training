create table if not exists Taco_Order (
id identity,
delivery_name varchar(50) not null,
delivery_Street varchar(50) not null,
delivery_City varchar(50) not null,
delivery_State varchar(20) not null,
delivery_Zip varchar(10) not null,
cc_Number varchar(16) not null,
cc_Expiration varchar(5) not null,
cc_CVV varchar(3) not null,
order_Date timestamp not null
);

create table if not exists Taco(
tacoId identity,
name varchar(50) not null,
taco_Order bigint not null,
taco_Order_Key bigint not null,
created_On timestamp not null
);
create table if not exists Ingredient(
id varchar(4) not null,
name varchar(25) not null,
type varchar(10) not null,
primary key(id)
);
create table if not exists Ingredient_Ref(
ingredient varchar(4) not null,
taco bigint not null,
taco_Key bigint not null
);


alter table Taco add foreign key(taco_Order) references Taco_Order(id);

ALTER TABLE Ingredient_Ref
ADD FOREIGN KEY (ingredient) REFERENCES Ingredient(id);


