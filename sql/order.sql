create table orders (
	id  int(3) NOT NULL AUTO_INCREMENT,
    ordernum  int(6) NOT NULL,
	name varchar(120) NOT NULL,
    surname varchar(120) NOT NULL,
    email varchar(120) NOT NULL,
	cost varchar(220) NOT NULL,
	PRIMARY KEY (id)
);