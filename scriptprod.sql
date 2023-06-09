\c pawtropolis;

\c pawtropolis;

CREATE TABLE room
(
    id   serial PRIMARY KEY NOT NULL,
    name varchar(30)        NOT NULL,
    isPlayerIn BOOLEAN      NOT NULL
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