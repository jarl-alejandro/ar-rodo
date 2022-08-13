create table categories
(
    id          varchar(36)  not null,
    name        varchar(100) null,
    description varchar(140) null,
    emoji       varchar(36)  null
);

create unique index categories_id_uindex
    on categories (id);

alter table categories
    add constraint categories_pk
        primary key (id);

