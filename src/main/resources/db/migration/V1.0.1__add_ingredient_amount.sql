CREATE TABLE IF NOT EXISTS ingredient_amount (
    id bigint unsigned auto_increment primary key not null,
    ingredient_id bigint unsigned not null,
    amount bigint unsigned not null,
    is_metric boolean not null,
    is_fluid boolean not null,

    FOREIGN KEY (ingredient_id) REFERENCES ingredients(id)
);