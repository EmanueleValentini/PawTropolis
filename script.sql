\c pawtropolis;

CREATE TABLE room
(
    id   serial PRIMARY KEY NOT NULL,
    name varchar(30)        NOT NULL,
    isPlayerIn boolean
);

CREATE TABLE item_in_room
(
    id             serial PRIMARY KEY NOT NULL,
    name           varchar(20)        NOT NULL,
    description    varchar(255),
    requestedSlots smallint           NOT NULL,
    id_room        int                NOT NULL,
    FOREIGN KEY (id_room) REFERENCES Room (id)
);

CREATE TABLE bag
(
    id    serial PRIMARY KEY NOT NULL,
    slots smallint
);

CREATE TABLE item_in_bag
(
    id             serial PRIMARY KEY NOT NULL,
    name           varchar(20)        NOT NULL,
    description    varchar(255),
    requestedSlots smallint           NOT NULL,
    id_bag         int                NOT NULL,
    FOREIGN KEY (id_bag) REFERENCES Bag (id)
);

CREATE TABLE player
(
    id         serial PRIMARY KEY NOT NULL,
    name       varchar(255)       NOT NULL,
    lifePoints int                NOT NULL,
    id_bag     int                NOT NULL,
    FOREIGN KEY (id_bag) REFERENCES Bag (id)
);

CREATE TABLE lion
(
    id         serial PRIMARY KEY NOT NULL,
    name       varchar(30)        NOT NULL,
    favFood    varchar(100),
    age        smallint,
    weight     float,
    height     float,
    dateOfJoin date,
    id_room    int,
    tailLength float,
    FOREIGN KEY (id_room) REFERENCES Room (id)
);

CREATE TABLE tiger
(
    id         serial PRIMARY KEY NOT NULL,
    name       varchar(30)        NOT NULL,
    favFood    varchar(100),
    age        smallint,
    weight     float,
    height     float,
    dateOfJoin date,
    id_room    int,
    tailLength float,
    FOREIGN KEY (id_room) REFERENCES Room (id)
);

CREATE TABLE eagle
(
    id         serial PRIMARY KEY NOT NULL,
    name       varchar(30)        NOT NULL,
    favFood    varchar(100),
    age        smallint,
    weight     float,
    height     float,
    dateOfJoin date,
    id_room    int,
    wingSpan   float,
    FOREIGN KEY (id_room) REFERENCES Room (id)
);

CREATE TABLE room_connection
(
    id           serial PRIMARY KEY NOT NULL,
    id_room1     smallint           NOT NULL,
    id_room2     smallint           NOT NULL,
    direction    varchar(6)       NOT NULL,
    FOREIGN KEY (id_room1) REFERENCES Room (id),
    FOREIGN KEY (id_room2) REFERENCES Room (id),
    CONSTRAINT uc_room_pairing UNIQUE (id_room1, id_room2)
);

INSERT INTO room(name, isPlayerIn)
VALUES ('DAJE ROMA DAJE',true);
INSERT INTO room(name, isPlayerIn)
VALUES ('LA STANZA DEL BOSS',false);
INSERT INTO room(name, isPlayerIn)
VALUES ('VIALE MARCONI',false);
INSERT INTO room(name,isPlayerIn)
VALUES ('NAPOLI',false);
INSERT INTO room(name, isplayerin)
VALUES ('DRUGVILLE',false);
INSERT INTO room(name,isPlayerIn)
VALUES ('SECCO REFRESH',false);

INSERT INTO item_in_room(name, description, requestedSlots, id_room)
VALUES ('excalibur',
        'la famosa spada nella roccia che re Artù dovette estrarre per diventare re di Camelot, per poi sposare Ginevra e farsela rubare da Lancillotto',
        1, 1);
INSERT INTO item_in_room(name, description, requestedSlots, id_room)
VALUES ('kys', 'te bannano da lol SIUM', 4, 1);

INSERT INTO item_in_room(name, description, requestedSlots, id_room)
VALUES ('scudo', 'scudo super resistente', 1, 2);
INSERT INTO item_in_room(name, description, requestedSlots, id_room)
VALUES ('siringa', 'ti cura di 50hp e ti fa...forse non ti cura', 1, 2);
INSERT INTO item_in_room(name, description, requestedSlots, id_room)
VALUES ('orologio', 'Oggetto rarissimo, conservalo bene nel taschino dietro dello zaino che non hai', 1, 3);
INSERT INTO item_in_room(name, description, requestedSlots, id_room)
VALUES ('elmo', 'ti protegge dagli headshot', 1, 3);
INSERT INTO item_in_room(name, description, requestedSlots, id_room)
VALUES ('soldi', 'i soldi quelli veri', 1, 4);

INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (1,5,'EAST');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (1,4,'SOUTH');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (5,2,'EAST');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (4,3,'WEST');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (2,6,'EAST');

INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (5,1,'WEST');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (4,1,'NORTH');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (2,5,'WEST');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (3,4,'EAST');
INSERT INTO Room_Connection (id_room1, id_room2, direction) VALUES (6,2,'WEST');

INSERT INTO lion(name, favFood, age, weight, height, dateOfJoin, id_room, tailLength)
VALUES ('Giancarlo', 'sushi', 56, 2.3, 4.4, '2000-2-12', 1, 2.8);
INSERT INTO eagle(name, favFood, age, weight, height, dateOfJoin, id_room, wingSpan)
VALUES ('l aquila assassina', 'umani', 1000, 3.3, 6.8, '2000-2-12', 2, 3);
INSERT INTO tiger(name, favFood, age, weight, height, dateOfJoin, id_room, tailLength)
VALUES ('Amal', 'indiano', 24, 70, 1.2, '2000-2-12', 3, 4.1);
INSERT INTO lion(name, favFood, age, weight, height, dateOfJoin, id_room, tailLength)
VALUES ('Evil Amal', 'indiano', 56, 2.3, 4.4, '2000-2-12', 1, 2.8);
INSERT INTO lion(name, favFood, age, weight, height, dateOfJoin, id_room, tailLength)
VALUES ('Calogero', 'tè al limone', 56, 2.3, 4.4, '2000-2-12', 1, 2.8);
INSERT INTO lion(name, favFood, age, weight, height, dateOfJoin, id_room, tailLength)
VALUES ('Salvatore', 'er sambucone molinari', 56, 2.3, 4.4, '2000-2-12', 1, 2.8);

INSERT INTO bag(slots)
VALUES (5);

INSERT INTO player(name, lifePoints, id_bag)
VALUES ('testa de cazzo non hai scelto il nome', 42, 1);

INSERT INTO item_in_bag(name, description, requestedSlots, id_bag)
VALUES ('sgrodo', 'un foglio con scritto porcodio', 1, 1)