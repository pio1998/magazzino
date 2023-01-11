CREATE SCHEMA esercizio;
USE esercizio;

CREATE TABLE indirizzo(
	id INT PRIMARY KEY AUTO_INCREMENT,
    citta VARCHAR(45) NOT NULL,
    via VARCHAR(45) NOT NULL,
    numero_civico VARCHAR(8) NOT NULL,
    cap VARCHAR(5) NOT NULL,
    provincia CHAR(2) NOT NULL
);

CREATE TABLE azienda(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(45) NOT NULL,
	partita_iva VARCHAR(45) NOT NULL,
	capitale_sociale INT NOT NULL,
    indirizzo_id INT  NOT NULL REFERENCES indirizzo(id)
);
drop table azienda;

CREATE TABLE dipendente(
	id INT PRIMARY KEY AUTO_INCREMENT,
    matricola CHAR(3) UNIQUE NOT NULL,
    codice_fiscale CHAR(16) UNIQUE NOT NULL,
    nome VARCHAR(45) NOT NULL,
    cognome VARCHAR(45) NOT NULL,
    mansione VARCHAR(45) NOT NULL,
    stipendio INT NOT NULL,
    eta INT NOT NULL,
    azienda_id INT NOT NULL REFERENCES azienda(id)
);
drop table dipendente; 

INSERT INTO indirizzo VALUES('1','Roma','Via Roma','23','80001','RM');
INSERT INTO indirizzo VALUES('2','Napoli','Via Napoli','45','80002','NA');
INSERT INTO indirizzo VALUES('3','Catania','Via Catania','89','80003','CT');
INSERT INTO indirizzo VALUES('4','Cagliari','Via Porceddu','23','80001','CA');

INSERT INTO dipendente VALUES('1','123','cf1','mario','rossi','impiegato','1600','24','1');
INSERT INTO dipendente VALUES('2','223','cf2','maria','bianchi','manager','1900','22','1');
INSERT INTO dipendente VALUES('3','323','cf3','franco','rossi','manager','3500','34','2');
INSERT INTO dipendente VALUES('4','423','cf4','luca','bianchi','venditore','6000','54','2');
INSERT INTO dipendente VALUES('5','523','cf5','alessio','rossi','impiegato','2500','45','3');
INSERT INTO dipendente VALUES('6','623','cf6','debora','neri','venditore','4000','38','3');
INSERT INTO dipendente VALUES('7','723','cf7','luca','bianchi','impiegato','3000','38','4');
INSERT INTO dipendente VALUES('8','823','cf8','giovanni','neri','impiegato','3200','19','4');

INSERT INTO azienda VALUES('1','GOG','11000043','230000000','1');
INSERT INTO azienda VALUES('2','GIG','2100023','450000000','2');
INSERT INTO azienda VALUES('3','CCK','1100067','89000000','3');
INSERT INTO azienda VALUES('4','ITG','1100049','23000000','4');