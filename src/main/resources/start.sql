INSERT INTO public.addresses (id, phoneNumber, street, city, state, country, pinCode)
VALUES (1, 298687764, 'Folush', 'Hrodna', 'Hrodna Region', 'Belarus', 230006);
INSERT INTO public.addresses (id, phoneNumber, street, city, state, country, pinCode)
VALUES (2, 336549871, 'Strelkovaya', 'Hrodna', 'Hrodna Region', 'Belarus', 230009);

INSERT INTO public.customers (id, name, password, email)
VALUES (1, 'Dzmitry', '1488', 'amator@gmail.com');
INSERT INTO public.customers (id, name, password, email)
VALUES (2, 'Volha', 'Dance', 'love@gmail.com');

INSERT INTO public.customers_addresses (id, customer_id, address_id)
VALUES (1, 1, 1);
INSERT INTO public.customers_addresses (id, customer_id, address_id)
VALUES (2, 1, 2);

INSERT INTO public.providers (id, name)
VALUES (1, 'Yuriy');
INSERT INTO public.providers (id, name)
VALUES (2, 'Vasiliy');

INSERT INTO public.heavers (id, name, age, salary, bonus)
VALUES (1, 'Anton', 25, 500, 100);
INSERT INTO public.heavers (id, name, age, salary, bonus)
VALUES (2, 'Artyom', 30, 600, 200);

INSERT INTO public.stocks (id, quantity, provider_id, heaver_id)
VALUES (1, 1, 1, 1);
INSERT INTO public.stocks (id, quantity, provider_id, heaver_id)
VALUES (2, 3, 1, 2);

INSERT INTO public.cars (id, model, year, pinCode)
VALUES (1, 'ZAZ-965', 1969, 'KLP30061969');
INSERT INTO public.cars (id, model, year, pinCode)
VALUES (2, 'VAZ-2107', 1990, 'ABC14881990');

INSERT INTO public.details (id, name, type, price, car_id)
VALUES (1, 'Engine', 'Chassis', 107.58, 1);
INSERT INTO public.details (id, name, type, price, car_id)
VALUES (2, 'Wheel', 'Chassis', 25.14, 1);

INSERT INTO public.details_stocks (id, stock_id, detail_id)
VALUES (1, 1, 1);
INSERT INTO public.details_stocks (id, stock_id, detail_id)
VALUES (2, 2, 1);

INSERT INTO public.sellers (id, name, age, salary, category)
VALUES (1, 'Danuta', 20, 700, 2);
INSERT INTO public.sellers (id, name, age, salary, category)
VALUES (2, 'Anna', 30, 800, 1);

INSERT INTO public.orders (id, date, sum, seller_id, detail_id, stock_id, customer_id, address_id)
VALUES (1, '2019-12-12 12:44:55', 1524, 1, 1, 1, 1, 1);
INSERT INTO public.orders (id, date, sum, seller_id, detail_id, stock_id, customer_id, address_id)
VALUES (2, '2019-11-11 16:15:14', 123, 2, 2, 2, 2, 2);

INSERT INTO public.roles (id, name)
VALUES (1, 'ROLE_USER');
INSERT INTO public.roles (id, name)
VALUES (2, 'ROLE_ADMIN');

INSERT INTO public.users (id, name, password)
VALUES (1, 'user.simple', '$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K');
INSERT INTO public.users (id, name, password)
VALUES (2, 'user.admin', '$2a$10$l/D6AGt8vYJG.cW/lIT44uy.TAYkV9UYJ8bPuGKBwuva/ERc9Ct4K');

INSERT INTO public.users_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO public.users_roles (user_id, role_id)
VALUES (2, 2);
