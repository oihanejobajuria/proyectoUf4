CREATE TABLE games (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     title CHAR(255) NOT NULL,
     year CHAR(255),
     description CHAR(255),
     PRIMARY KEY (id)
);

CREATE TABLE musicas (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     title CHAR(255) NOT NULL,
     artist CHAR(255) NOT NULL,
     disk CHAR(255),
     year CHAR(255),
     PRIMARY KEY (id)
);
CREATE TABLE users (
     playername CHAR(255) NOT NULL,
     username CHAR(255) NOT NULL,
     game1 CHAR(255) ,
     game2 CHAR(255),
     game3 CHAR(255),
     PRIMARY KEY (playername)
);

