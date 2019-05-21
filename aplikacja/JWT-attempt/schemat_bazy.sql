create database testa;
use testa;

CREATE TABLE testa.Login (
  id int(11) AUTO_INCREMENT PRIMARY KEY,
  username varchar(20) NOT NULL,
  password varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE testa.cars(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
marka VARCHAR(20) not null,
model varchar(20) not null,
rokProdukcji varchar(20) not null,
paliwo varchar(10) not null,
przebieg integer not null,
moc double not null,
cena double not null,
whoseAdvert varchar(4) not null
);

insert into testa.cars (marka,model,rokProdukcji,paliwo,przebieg,moc,cena,whoseAdvert) values ("ford","mondeo","1999","pb",199,22,110,1);
insert into testa.cars (marka,model,rokProdukcji,paliwo,przebieg,moc,cena,whoseAdvert) values ("ford","focus","2000","pb",1990,32,220,1);


select * from testa.Login;
select * from testa.cars;

drop table testa.cars;

drop table testa.user


CREATE TABLE testa.user (
  id          INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email       VARCHAR(32) NOT NULL,
  username    VARCHAR(32)  UNIQUE NOT NULL,
  enabled 	  BIT NOT NULL,
  password    VARCHAR(128) NOT NULL,
  role_id 	  INTEGER NOT NULL,
  constraint fk_user_role FOREIGN KEY (role_id)
      REFERENCES testa.role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE testa.role (
  id          INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role        VARCHAR(64) NOT NULL
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO testa.user (email, username, password, enabled, role_id) VALUES
  ('admin@wp.pl', 'admin', '$2a$10$ERKxvQ6dF0ThWOOx14bYI.wVy1lIlj/Bj1ou8l3wmRbzqmptr1A.6', 1,1);

INSERT INTO testa.role (role) VALUES
  ('admin');

INSERT INTO testa.user (email, username, password, enabled, role_id) VALUES
  ('user@wp.pl', 'user', 'user', 1,2);

INSERT INTO testa.role (role) VALUES
  ('user');


select * from testa.role;
select * from testa.user;
drop table testa.role;
drop table testa.user;