CREATE DATABASE pawtropolis;

\c pawtropolis;

CREATE TABLE Room(
    id serial PRIMARY KEY NOT NULL,
    name varchar(30) NOT NULL
);

CREATE TABLE ItemInRoom(
    id serial PRIMARY KEY NOT NULL,
    name varchar(20) NOT NULL,
    description varchar(255),
    requestedSlots smallint NOT NULL,
    id_room int NOT NULL,
    FOREIGN KEY (id_room) REFERENCES Room(id)
);

CREATE TABLE Bag(
    id  serial PRIMARY KEY NOT NULL,
    maxSlots smallint NOT NULL
);

CREATE TABLE ItemInBag(
    id serial PRIMARY KEY NOT NULL,
    name varchar(20) NOT NULL,
    description varchar(255),
    requestedSlots smallint NOT NULL,
    id_bag int NOT NULL,
    FOREIGN KEY (id_bag) REFERENCES Bag(id)
);

CREATE TABLE Player(
    id serial PRIMARY KEY NOT NULL,
    name varchar(20) NOT NULL,
    lifePoints int NOT NULL,
    last_visited_room int,
    id_bag int NOT NULL,
    FOREIGN KEY (last_visited_room) REFERENCES Room(id),
    FOREIGN KEY (id_bag) REFERENCES Bag(id)
);

CREATE TABLE Room_Connection(
    id serial PRIMARY KEY NOT NULL,
    id_room1 serial NOT NULL,
    id_room2 serial NOT NULL,
    direction varchar(10) NOT NULL,
    FOREIGN KEY (id_room1) REFERENCES Room(id),
    FOREIGN KEY (id_room2) REFERENCES Room(id),
    CONSTRAINT uc_room_pairing UNIQUE (id_room1,id_room2)
);

CREATE TABLE Lion(
    id serial PRIMARY KEY NOT NULL,
    name varchar(30) NOT NULL,
    favFood varchar(100),
    age smallint,
    weight float,
    height float,
    dateOfJoin date,
    id_room int,
    tailLength float,
    FOREIGN KEY (id_room) REFERENCES Room(id)
);

CREATE TABLE Tiger(
    id serial PRIMARY KEY NOT NULL,
    name varchar(30) NOT NULL,
    favFood varchar(100),
    age smallint,
    weight float,
    height float,
    dateOfJoin date,
    id_room int,
    tailLength float,
    FOREIGN KEY (id_room) REFERENCES Room(id)
);

CREATE TABLE Eagle(
    id serial PRIMARY KEY NOT NULL,
    name varchar(30) NOT NULL,
    favFood varchar(100),
    age smallint,
    weight float,
    height float,
    dateOfJoin date,
    id_room int,
    wingSpan float,
    FOREIGN KEY (id_room) REFERENCES Room(id)
);

CREATE TABLE Direction(
    id serial PRIMARY KEY NOT NULL,
    name varchar(10) NOT NULL
);

INSERT INTO Room(name) VALUES('DAJE ROMA DAJE'); 
INSERT INTO Room(name) VALUES('LA STANZA DEL BOSS'); 
INSERT INTO Room(name) VALUES('VIALE MARCONI'); 
INSERT INTO Room(name) VALUES('NAPOLI'); 
INSERT INTO Room(name) VALUES('DRUGVILLE'); 
INSERT INTO Room(name) VALUES('SECCO REFRESH'); 

INSERT INTO ItemInRoom(name,description,requestedSlots,id_room) VALUES('excalibur','la famosa spada nella roccia che re Artù dovette estrarre per diventare re di Camelot, per poi sposare Ginevra e farsela rubare da Lancillotto',1,1);
INSERT INTO ItemInRoom(name,description,requestedSlots,id_room) VALUES('scudo','scudo rotondo',1,2);
INSERT INTO ItemInRoom(name,description,requestedSlots,id_room) VALUES('siringa','ti cura di 50hp e ti fa...forse non ti cura',1,2);
INSERT INTO ItemInRoom(name,description,requestedSlots,id_room) VALUES('orologio','Oggetto rarissimo, conservalo bene nel taschino dietro dello zaino che non hai',1,3);
INSERT INTO ItemInRoom(name,description,requestedSlots,id_room) VALUES('elmo','ti protegge dagli headshot',1,3);
INSERT INTO ItemInRoom(name,description,requestedSlots,id_room) VALUES('soldi','i soldi quelli veri',1,4);

INSERT INTO Direction(name) VALUES('NORTH');
INSERT INTO Direction(name) VALUES('SOUTH');
INSERT INTO Direction(name) VALUES('EAST');
INSERT INTO Direction(name) VALUES('WEST');

INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 1, 5, direction
FROM Direction
WHERE Direction.name = 'EAST';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 1, 4, direction
FROM Direction
WHERE Direction.name = 'SOUTH';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 5, 2, direction
FROM Direction
WHERE Direction.name = 'EAST';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 4, 3, direction
FROM Direction
WHERE Direction.name = 'WEST';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 2, 6, direction
FROM Direction
WHERE Direction.name = 'EAST';

INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 5, 1, direction
FROM Direction
WHERE Direction.name = 'WEST';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 4, 1, direction
FROM Direction
WHERE Direction.name = 'NORTH';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 2, 5, direction
FROM Direction
WHERE Direction.name = 'WEST';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 3, 4, direction
FROM Direction
WHERE Direction.name = 'EAST';
INSERT INTO Room_Connection (id_room1, id_room2, direction)
SELECT 6, 2, direction
FROM Direction
WHERE Direction.name = 'WEST';

INSERT INTO Lion(name,favFood,age,weight,height,dateOfJoin,id_room,tailLength) VALUES('Giancarlo','sushi',56,2.3,4.4,'2000-2-12',1,2.8);
INSERT INTO Eagle(name,favFood,age,weight,height,dateOfJoin,id_room,wingSpan) VALUES('l aquila assassina','umani',1000,3.3,6.8,'2000-2-12',2,3);
INSERT INTO Tiger(name,favFood,age,weight,height,dateOfJoin,id_room,tailLength) VALUES('Amal','indiano',24,70,1.2,'2000-2-12',3,4.1);
INSERT INTO Lion(name,favFood,age,weight,height,dateOfJoin,id_room,tailLength) VALUES('Evil Amal','indiano',56,2.3,4.4,'2000-2-12',1,2.8);
INSERT INTO Lion(name,favFood,age,weight,height,dateOfJoin,id_room,tailLength) VALUES('Calogero','tè al limone',56,2.3,4.4,'2000-2-12',1,2.8);
INSERT INTO Lion(name,favFood,age,weight,height,dateOfJoin,id_room,tailLength) VALUES('Salvatore','er sambucone molinari',56,2.3,4.4,'2000-2-12',1,2.8);