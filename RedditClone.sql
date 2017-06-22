create schema fourChansDrunkCousin;
use fourChansDrunkCousin;

create table Reddit(

    redDate date,
    redAuthor varChar (255),
    redTitle varChar (255),
    redUrl varChar (255),
    redID integer auto_increment,
    primary key (redID)
);

show create table Reddit;

select* from Reddit;

describe Reddit;
