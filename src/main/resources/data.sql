INSERT INTO user(username, password, authorities)
VALUES('user', '$2a$10$SjpVAO.vRWA2KJdfg/LKiOYBlGaFaoBJAzTQ60sb5FPOCpbu9BtKa', 'USER');

INSERT INTO user(username, password, authorities)
VALUES('admin', '$2a$10$SjpVAO.vRWA2KJdfg/LKiOYBlGaFaoBJAzTQ60sb5FPOCpbu9BtKa', 'ADMIN');

INSERT INTO user(username, password, authorities)
VALUES('agent', '$2a$10$SjpVAO.vRWA2KJdfg/LKiOYBlGaFaoBJAzTQ60sb5FPOCpbu9BtKa', 'AGENT');

INSERT INTO smestaj(usluge, tip, kategorija,ocena,naziv,opis,agent_id)
VALUES('asd','asd','asd', 0,'konaci','jako jedno lepo do jaja mesto',3);

INSERT INTO smestaj(usluge, tip, kategorija,ocena,naziv,opis,agent_id)
VALUES('asd','asd','asd', 0,'konaci1','jako jedno lepo do jaja mesto',3);


INSERT INTO smestaj(usluge, tip, kategorija,ocena,naziv,opis,agent_id)
VALUES('asd','asd','asd', 0,'konaci2','jako jedno lepo do jaja mesto',3);


INSERT INTO smestaj(usluge, tip, kategorija,ocena,naziv,opis,agent_id)
VALUES('asd','asd','asd', 0,'konaci3','jako jedno lepo do jaja mesto',3);

INSERT INTO rezervacija(confirmed, end_date, smestaj_id,start_date,agent_id)
VALUES('false','2016-2-2',1,'2016-2-2', 3);

INSERT INTO rezervacija(confirmed, end_date, smestaj_id,start_date,agent_id)
VALUES('false','2016-2-2',1,'2016-2-2', 3);

INSERT INTO rezervacija(confirmed, end_date, smestaj_id,start_date,agent_id)
VALUES('false','2018-12-4',1,'2018-12-2', 3);

INSERT INTO rezervacija(confirmed, end_date, smestaj_id,start_date,agent_id)
VALUES('false','2018-2-2',1,'2016-2-2', 3);

INSERT INTO message( message, rezervacija_id,agent)
VALUES('Dobar dan agente',1, false);

INSERT INTO message(message, rezervacija_id,agent)
VALUES('Imam pitanje za vas',2, false);

INSERT INTO message( message, rezervacija_id,agent)
VALUES('Opet ja',1, false);

INSERT INTO message(message, rezervacija_id,agent)
VALUES('opet imam pitanje/smaram',2, false);