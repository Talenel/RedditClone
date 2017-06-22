#create schema fourChansDrunkCousin;
use fourChansDrunkCousin;

create table users(

    username varChar (50) not null,
    password varChar (50) not null,
	enabled boolean not null default true,
    primary key (username)
);

create table authorities(

    username varChar (50) not null,
    authority varChar (50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username,authority);

insert into users (username, password) values ('DJakademiks','Smite');

insert into users (username, password) values ('Andrewcandoall','Shootmania');

insert into authorities (username, authority) values ('DJakademiks','ADMIN');

insert into authorities (username, authority) values ('Andrewcandoall','ADMIN');

show create table users;

select* from users;

describe users;

show create table authorities;

select* from authorities;

describe authorities;