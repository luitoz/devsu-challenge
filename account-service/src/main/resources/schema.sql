DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS account;

create table account (id SERIAL PRIMARY KEY, account_number varchar not null, account_type varchar(100) not null, initial_balance numeric, state boolean,
 customer_id integer);
create table transaction (id SERIAL PRIMARY KEY, date timestamp, transaction_type varchar, amount numeric, balance numeric, account_id int);
alter table if exists transaction add constraint FKqw58igk7s2kunxvf7ns62ktu3 foreign key (account_id) references account;
