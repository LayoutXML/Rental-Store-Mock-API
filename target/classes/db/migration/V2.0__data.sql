-- product
insert into product ( title, rentable ) values ('Skis', true);
insert into product ( title, rentable ) values ('Snowboard', true);
insert into product ( title, rentable ) values ('Bike', false);
insert into product ( title, rentable ) values ('Roller-blades', true);
insert into product ( title, rentable ) values ('Skateboard', true);

--price
insert into price ( commitment_months, value ) values (null, 35);
insert into price ( commitment_months, value ) values (null, 25);
insert into price ( commitment_months, value ) values (null, 17);
insert into price ( commitment_months, value ) values (null, 30);
insert into price ( commitment_months, value ) values (null, 45);

insert into price ( commitment_months, value ) values (3, 30);
insert into price ( commitment_months, value ) values (3, 20);
insert into price ( commitment_months, value ) values (3, 13);
insert into price ( commitment_months, value ) values (3, 25);
insert into price ( commitment_months, value ) values (3, 40);

insert into price ( commitment_months, value ) values (6, 25);
insert into price ( commitment_months, value ) values (6, 17);
insert into price ( commitment_months, value ) values (6, 10);
insert into price ( commitment_months, value ) values (6, 20);
insert into price ( commitment_months, value ) values (6, 35);

-- product_price
insert into product_price (product_id, price_id ) values (select id from product where title = 'Skis', select id from price where commitment_months is null and value = 35);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Skis', select id from price where commitment_months = 3 and value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Skis', select id from price where commitment_months = 6 and value = 25);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Snowboard', select id from price where commitment_months is null and value = 25);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Snowboard', select id from price where commitment_months = 3 and value = 20);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Snowboard', select id from price where commitment_months = 6 and value = 17);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Bike', select id from price where commitment_months is null and value = 35);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Bike', select id from price where commitment_months = 3 and value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Bike', select id from price where commitment_months = 6 and value = 25);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Roller-blades', select id from price where commitment_months is null and value = 17);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Roller-blades', select id from price where commitment_months = 3 and value = 13);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Roller-blades', select id from price where commitment_months = 6 and value = 10);

insert into product_price (product_id, price_id ) values (select id from product where title = 'Skateboard', select id from price where commitment_months is null and value = 35);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Skateboard', select id from price where commitment_months = 3 and value = 30);
insert into product_price (product_id, price_id ) values (select id from product where title = 'Skateboard', select id from price where commitment_months = 6 and value = 25);
