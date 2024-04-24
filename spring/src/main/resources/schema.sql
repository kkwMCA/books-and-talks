-- userid username noPost profiledesc
-- 100     sumedh    1      xyz

create table if not exists users(
    username varchar(100) not null unique AUTO_INCREMENT,
    email varchar(100) not null unique,
    noPost varchar(100) not null,
    profiledesc text not null,
    password text not null,
    primary key(username)
);


create table if not exists post(
    postid number not null unique AUTO_INCREMENT,
    username text not null,
    postname text not null,
    img text not null,
    description text not null,
    likes number not null,
    primary key(postid)
);


create table if not exists comment(
    commentid number not null unique AUTO_INCREMENT,
    postid number not null unique,
    commentdata text,
    primary key(commentid)
);