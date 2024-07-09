create database phonebooktest;
use phonebooktest;

create table user_country (
	country_id int primary key auto_increment,
    country_name varchar(50)
);


create table userDB (
  user_id int auto_increment primary key,
  Fname varchar(50) not null,
  Lname varchar(50) not null,
  user_email varchar(100) unique,
  user_phoneNumber varchar(50) not null,
  user_password varchar(20) not null,
  user_gender varchar(10) not null,
  country_id int not null,
  reg_date datetime,
  FOREIGN KEY (country_Id) REFERENCES user_country(country_id)
);

insert into user_country (country_name) 
values ("Egypt"),
	   ("Algeria"),
       ("Bahrain"),
       ("Comoros"),
       ("Djibouti"),
       ("Iraq"),
       ("Jordan"),
       ("Kuwait"),
       ("Lebanon"),
       ("Libya"),
       ("Mauritania"),
       ("Morocco"),
       ("Oman"),
       ("Palestine"),
       ("Qatar"),
       ("Saudi Arabia"),
       ("Somalia"),
       ("Sudan"),
       ("Syria"),
       ("Tunisia"),
       ("United Arab Emirates (UAE)"),
       ("Yemen"),
       ("United States"),
       ("China"),
       ("India"),
       ("Russia"),
       ("Brazil"),
       ("United Kingdom"),
       ("France"),
       ("Germany"),
       ("Japan"),
       ("Canada"),
       ("Australia"),
       ("South Africa"),
       ("Mexico"),
       ("Turkey"),
       ("South Korea"),
       ("Indonesia"),
       ("Nigeria"),
       ("Italy"),
       ("Spain"),
       ("Argentina"),
       ("Iran"),
       ("Pakistan"),
       ("Bangladesh"),
       ("Vietnam"),
       ("Thailand"),
       ("Malaysia"),
       ("Singapore"),
       ("Philippines"),
       ("Kenya"),
       ("Peru"),
       ("Chile"),
       ("Colombia"),
       ("Venezuela");
drop table user_country;
drop table userDB;

select userDB.Lname, CONCAT(userDB.Fname, ' ', userDB.Lname) AS userName , userDB.user_email , userDB.user_phoneNumber, userDB.user_gender ,user_country.country_name 
from userDB , user_country 
where userDB.country_id = user_country.country_id && userDB.user_email = ? && user_password = ?;

select user_email,user_password from userDB where user_id = 2;

select * from user_country;
select * from userDB;