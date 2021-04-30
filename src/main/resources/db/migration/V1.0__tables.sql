create table if not exists product (
    id bigint auto_increment not null,
    title varchar not null,
    rentable bool not null
);

create table if not exists price (
    id bigint auto_increment not null,
    commitment_months int,
    value decimal not null
);

create table if not exists product_price (
    id bigint auto_increment not null,
    product_id bigint not null,
    price_id bigint not null
);
