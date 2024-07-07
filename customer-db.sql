DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS person;

create table person (age integer, id SERIAL PRIMARY KEY, phonenumber varchar(10) not null, address varchar(100) not null, name varchar(100) not null, 
gender varchar);
create table customer (state boolean, customer_id int not null, password varchar(255) not null, primary key (customer_id));
alter table if exists customer add constraint FKqw58igk7s2kunxvf7ns62ktu2 foreign key (customer_id) references person;
