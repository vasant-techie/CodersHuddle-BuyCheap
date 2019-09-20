-- we don't know how to generate root <with-no-name> (class Root) :(
create table OUTLETS
(
    OUTLET_ID INTEGER not null
        constraint OUTLETS_PK
            primary key,
    OUTLET_NAME VARCHAR(80)
);

create table STORES
(
    STORE_ID INTEGER not null
        constraint STORES_PK
            primary key,
    STORE_NAME VARCHAR(100),
    CITY VARCHAR(50),
    AREA VARCHAR(50),
    DISTANCE_FROM_LANDMARK INTEGER,
    ZIP_CODE INTEGER,
    PHONE_NUMBER INTEGER,
    STREET_NAME VARCHAR(100),
    OUTLET_ID INTEGER
        constraint STORES_OUTLETS_OUTLET_ID_FK
            references OUTLETS,
    DISCOUNT_PERCENTAGE INTEGER,
    COUPON_CODE VARCHAR(50)
);

create table USERS
(
    USERNAME VARCHAR(50)
        unique,
    PASSWORD VARCHAR(50),
    NAME VARCHAR(100),
    CITY VARCHAR(50),
    AREA VARCHAR(50),
    ZIP_CODE INTEGER
);

create table USER_PREFERENCES
(
    USERNAME VARCHAR(50)
        constraint USER_PREFERENCES_USERS_USERNAME_FK
            references USERS (USERNAME),
    RADIUS INTEGER,
    OUTLETID INTEGER
);

