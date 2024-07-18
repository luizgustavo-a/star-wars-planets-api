create table planets(
    id bigint not null auto_increment,
    name varchar(100) not null unique,
    climate varchar(100) not null,
    terrain varchar(100) not null,
    number_apparitions integer not null,
    primary key(id)
);