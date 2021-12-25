DROP TABLE IF EXISTS public.addresses;
CREATE TABLE public.addresses
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    phoneNumber INTEGER,
    street      VARCHAR,
    city        VARCHAR,
    state       VARCHAR,
    country     VARCHAR,
    pinCode     INTEGER,
);

DROP TABLE IF EXISTS public.customers;
CREATE TABLE public.customers
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR,
    password VARCHAR,
    email    VARCHAR,
);

DROP TABLE IF EXISTS public.customers_addresses;
CREATE TABLE public.customers_addresses
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    customer_id BIGINT,
    address_id  BIGINT,
    FOREIGN KEY (customer_id) REFERENCES public.customers (id),
    FOREIGN KEY (address_id) REFERENCES public.addresses (id),
);

DROP TABLE IF EXISTS public.providers;
CREATE TABLE public.providers
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
);

DROP TABLE IF EXISTS public.heavers;
CREATE TABLE public.heavers
(
    id     BIGINT PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR,
    age    SMALLINT,
    salary INTEGER,
    bonus  INTEGER,
);

DROP TABLE IF EXISTS public.stocks;
CREATE TABLE public.stocks
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    quantity    INTEGER,
    provider_id BIGINT,
    heaver_id   BIGINT,
    FOREIGN KEY (provider_id) REFERENCES public.providers (id),
    FOREIGN KEY (heaver_id) REFERENCES public.heavers (id),
);

DROP TABLE IF EXISTS public.cars;
CREATE TABLE public.cars
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    model   VARCHAR,
    year    SMALLINT,
    pinCode VARCHAR,
);

DROP TABLE IF EXISTS public.details;
CREATE TABLE public.details
(
    id     BIGINT PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR,
    type   VARCHAR,
    price  DOUBLE,
    car_id BIGINT,
    FOREIGN KEY (car_id) REFERENCES public.cars (id),
);

DROP TABLE IF EXISTS public.details_stocks;
CREATE TABLE public.details_stocks
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    stock_id  BIGINT,
    detail_id BIGINT,
    FOREIGN KEY (stock_id) REFERENCES public.stocks (id),
    FOREIGN KEY (detail_id) REFERENCES public.details (id),
);

DROP TABLE IF EXISTS public.sellers;
CREATE TABLE public.sellers
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR,
    age      SMALLINT,
    salary   INTEGER,
    category SMALLINT,
);

DROP TABLE IF EXISTS public.orders;
CREATE TABLE public.orders
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    date        TIMESTAMP,
    sum         INTEGER,
    seller_id   BIGINT,
    detail_id   BIGINT,
    stock_id    BIGINT,
    customer_id BIGINT,
    address_id  BIGINT,
    FOREIGN KEY (seller_id) REFERENCES public.sellers (id),
    FOREIGN KEY (detail_id) REFERENCES public.details (id),
    FOREIGN KEY (stock_id) REFERENCES public.stocks (id),
    FOREIGN KEY (customer_id) REFERENCES public.customers (id),
    FOREIGN KEY (address_id) REFERENCES public.addresses (id),
);

DROP TABLE IF EXISTS public.roles;
CREATE TABLE public.roles
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
);

DROP TABLE IF EXISTS public.users;
CREATE TABLE public.users
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR,
    password VARCHAR,
);

DROP TABLE IF EXISTS public.users_roles;
CREATE TABLE public.users_roles
(
    user_id BIGINT,
    role_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES public.users (id),
    FOREIGN KEY (role_id) REFERENCES public.roles (id),
);
