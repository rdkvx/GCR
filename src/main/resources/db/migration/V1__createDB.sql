create table producer(
    id bigint not null auto_increment,
    name varchar(100) not null,
    openDate date not null,
    PRIMARY KEY(id)
);

create table console(
    id bigint not null auto_increment,
    name varchar(100) not null,
    producerId bigint not null,
    releaseDate date,
    buyDate date,
    own tinyint,
    PRIMARY KEY(id),
    FOREIGN KEY(producerId) REFERENCES producer(id)
);

create table developer(
    id bigint not null auto_increment,
    name varchar(100) not null,
    PRIMARY KEY(id)
);

create table game(
    id bigint not null auto_increment,
    name varchar(100) not null,
    consoleId bigint not null,
    developerId bigint not null,
    releaseDate date,
    buyDate date,
    PRIMARY KEY(id),
    FOREIGN KEY(consoleId) REFERENCES console(id),
    FOREIGN KEY(developerId) REFERENCES developer(id)
);