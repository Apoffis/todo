create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values( 1 );
insert into hibernate_sequence values( 1 );

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password VARCHAR (64) NOT NULL,
    username VARCHAR (64) NOT NULL UNIQUE,
    PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE todo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR (64) NOT NULL,
    completed BOOLEAN NOT NULL,
    PRIMARY KEY (id)
) engine=MyISAM;