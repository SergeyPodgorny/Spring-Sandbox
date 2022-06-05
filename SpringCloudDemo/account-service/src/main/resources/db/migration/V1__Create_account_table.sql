CREATE TABLE accounts (account_id bigint primary key not null,
                        name varchar(255) not null,
                        email varchar(255) unique not null,
                        phone varchar(255) not null,
                        creation_date timestamp not null);
