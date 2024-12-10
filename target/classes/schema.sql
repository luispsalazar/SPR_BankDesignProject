create table ACCOUNT(
	ACCOUNT_ID int auto_increment PRIMARY KEY,
	BALANCE double NOT NULL,
	FOREIGN KEY(CUST_ID) REFERENCES CUSTOMER_ID
);

insert into ACCOUNT(BALANCE, CUST_ID) values(2300,1001);
insert into ACCOUNT(BALANCE, CUST_ID) values(45000,1002);
insert into ACCOUNT(BALANCE, CUST_ID) values(120,1001);


create table SAVINGS_ACCOUNT(
	ACCOUNT_ID int auto_increment PRIMARY KEY,
	INTEREST_RATE double NOT NULL
);

insert into SAVINGS_ACCOUNT(INTEREST_RATE) values(4.5);
insert into SAVINGS_ACCOUNT(INTEREST_RATE) values(5.0);

create table CHECKING_ACCOUNT(
	ACCOUNT_ID int PRIMARY KEY,
	NEXT_CHECK_NUMBER int NOT NULL
);

insert into CHECKING_ACCOUNT(NEXT_CHECK_NUMBER) values(1);

create table CUSTOMER(
	CUSTOMER_ID int auto_increment=1001 PRIMARY KEY,
	CUSTOMER_NAME varchar(255) READONLY NOT NULL,
	CUSTOMER_ADDRESS NOT NULL,
	FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS_ID
);

insert into CUSTOMER(CUSTOMER_TYPE, CUSTOME_NAME, CUSTOMER_ADDRESS) values(COMPANY, FDM,1);
insert into CUSTOMER(CUSTOMER_TYPE, CUSTOME_NAME, CUSTOMER_ADDRESS) values(PERSON, JOHN,2);


create table ADDRESS(
	ADDRESS_ID int auto_increment PRIMARY KEY,
	STREET_NUMBER varchar(255) NOT NULL,
	POSTAL_CODE NOT NULL,
	CITY varchar(255) NOT NULL,
	PROVINCE varchar(255) NOT NULL
);

insert into ADDRESS(STREET_NUMBER,POSTAL_CODE,CITY,PROVINCE) values(13 KENWORTH STREET, T3R3E2, TORONTO, ONTARIO);
insert into ADDRESS(STREET_NUMBER,POSTAL_CODE,CITY,PROVINCE) values(2 QUEEN STREET, R436Y6, CALENDON, ONTARIO);

