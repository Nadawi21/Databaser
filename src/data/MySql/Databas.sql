drop database if exists SkoShoppen;
create database SkoShoppen;
use SkoShoppen;

CREATE TABLE Stad (
    OrtId INT NOT NULL PRIMARY KEY,
    Ortnamn VARCHAR(30) NOT NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lastUpdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Kund (
    personnummer VARCHAR(13) NOT NULL UNIQUE PRIMARY KEY,
    förnamn VARCHAR(30) NOT NULL,
    efternamn VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    lösenord VARCHAR(30),
    OrtIdFK INT NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lastUpdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (OrtIdFK)
        REFERENCES stad (OrtId)
        ON DELETE SET NULL
);
-- om en stad försvinner är det bättre att behålla kunduppgifterna kvar

create table Färg
(FärgId int not null auto_increment primary key,
Färgnamn varchar(30) not null,
created timestamp default CURRENT_TIMESTAMP,
lastUpdate timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP);

create table Lagersaldo
(LagerId int not null auto_increment primary key,
Kvantitet int,
created timestamp default CURRENT_TIMESTAMP,
lastUpdate timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP);

create table Produkt
(ProduktId int not null auto_increment primary key,
märke varchar(30) not null,
storlek int not null,
pris int,
LagerIdFK int not null,
FärgIdFK int not null,
created timestamp default CURRENT_TIMESTAMP,
lastUpdate timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP,
foreign key(LagerIdFK) references Lagersaldo(LagerId),
foreign key (FärgIdFK) references Färg(FärgId));

create table Kategori
(KategoriId int not null auto_increment primary key,
Typ varchar(30) not null unique,
created timestamp default CURRENT_TIMESTAMP,
lastUpdate timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP);

create table Kategoriserar
(ProduktIdFK int null,
kategoriIdFK int not null,
created timestamp default CURRENT_TIMESTAMP,
lastUpdate timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP,
foreign key (ProduktIdFK) references Produkt(ProduktId) on delete cascade, 
-- om en produkt tas bort så tas dess kategorisering bort också. Annars behålls en kategorisering av en produkt som inte finns. 
foreign key (kategoriIdFK) references Kategori(kategoriId));

create table Beställning
(BeställningsId int not null auto_increment primary key,
Datum DATE,
personnummerFK varchar(13) null,
status ENUM('active', 'paid'),
created timestamp default CURRENT_TIMESTAMP,
lastUpdate timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP,
foreign key (personnummerFK) references Kund(personnummer) on delete set null); 
-- om en kund försvinner är det bra att behålla deras Beställning, men sätta personnummer på null

create table Kundorder
(BeställningsIdFK int null,
ProduktIdFK int null,
antal int,
created timestamp default CURRENT_TIMESTAMP,
lastUpdate timestamp default CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP,
foreign key (BeställningsIdFK) references Beställning(BeställningsId) on delete cascade, 
-- om en beställning raderas, raderas även kundordern. En kundorder utan beställning är inte bra sätt att lagra data. 
foreign key (ProduktIdFK) references Produkt(ProduktId) on delete set null); 
-- om en produkt tas bort vill man ha kvar kunduppgifterna

insert into Stad(OrtId, Ortnamn) VALUES
(1, 'Malmö'),
(2, 'Södertälje'),
(3, 'Älvsjö'),
(4, 'Luleå');


insert into Kund(personnummer, förnamn, efternamn, email, lösenord, OrtIdFK) VALUES
('19581113-4031',	'Sara',	'Andersson',	'sara.anders@hotmail.com', '1234', 1),
('19970429-7420',	'Nada',	'Razooq',	'nada.razooq@yh.nackademin.se', '5678', 2),
('19880616-5310',	'Karina',	'Sarkissova',	'k.sarkissova@yh.jensen.se','8901', 3),
('20000613-6520',	'Julian',	'Denno',	'julian.denno@yahoo.se', '2345', 2),
('19800124-6427',	'Konstantin',	'Ivanov',	'konstantin@gmail.com', '6789', 4);

insert into Färg(Färgnamn) VALUES
('Svart'),
('Vit'),
('Röd'),
('Gul'),
('Mörkblå');

insert into Lagersaldo(Kvantitet) VALUES
(50),
(49),
(5),
(80),
(120),
(60),
(99),
(75);

insert into Kategori(KategoriId, Typ) values
(1, 'Sandaler'),
(2, 'Ballerina'),
(3, 'Sneakers'),
(4, 'Sportsko'),
(5, 'Kängor'),
(6, 'Sommarskor'),
(7, 'Vinterskor');

insert into Produkt(märke, storlek, pris, LagerIdFK, FärgIdFK) VALUES
('Ecco',	38,	499, 1, 1),
('Ecco',	40,	499, 2, 2),
('Adidas',	45,	999, 3, 3),
('Nike',	27,	399, 4, 4),
('Puma',	34,	499, 5, 1),
('Reebok',	39,	1199, 6, 5),
('Dr Martens',	43,	1999, 7, 1),
('Din Sko',	40,	599, 8, 3);

insert into Kategoriserar(ProduktIdFK, KategoriIdFK) VALUES
(1, 1),
(1, 2),
(1, 6),
(2, 5),
(2, 7),
(3, 3),
(3, 4),
(4, 3),
(4, 6),
(5, 2),
(5, 6),
(6, 5),
(6, 7),
(7, 4),
(8, 1),
(8, 6);

insert into Beställning(Datum, personnummerFK, status) VALUES
('2024-12-15', '19970429-7420', 'active'),
('2025-01-02', '20000613-6520', 'paid'),
('2024-11-25', '19880616-5310', 'active'),
('2025-01-16', '19800124-6427', 'paid'),
('2025-01-05', '19581113-4031', 'paid'),
('2025-01-06', '19581113-4031', 'paid'),
('2025-01-16', '19800124-6427', 'active');

insert into Kundorder(BeställningsIdFK, ProduktIdFK, antal) VALUES
(1, 8, 1),
(2, 3, 1),
(3, 4, 1),
(3, 5, 1),
(4, 4, 2),
(5, 7, 1),
(6, 2, 1),
(6, 3, 2),
(7, 1, 1);

commit