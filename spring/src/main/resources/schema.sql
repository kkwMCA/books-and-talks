-- userid username noPost profiledesc
-- 100     sumedh    1      xyz

create table if not exists users(
    username varchar(100) not null unique,
    email varchar(100) not null unique,
    noPost varchar(100) not null,
    profiledesc text not null,
    primary key(username)
);


create table if not exists post(
    postid number not null unique,
    postname text not null,
    img VARBINARY(MAX) not null,
    description text not null,
    primary key(postid)
);
