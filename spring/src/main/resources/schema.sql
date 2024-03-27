-- userid username noPost profiledesc
-- 100     sumedh    1      xyz

create table if not exists user(
    username varchar(100) not null unique,
    email varchar(100) not null unique,
    noPost varchar(100) not null,
    profiledesc text not null,
    primary key(username)
);

