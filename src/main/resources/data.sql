<<<<<<< HEAD
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'password', '22/04/1999', FALSE);

INSERT INTO artifacts(name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES('Harry Potter 1', 'Book', TRUE, 1, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES('Harry Potter 2', 'Movie', TRUE, 1, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES('Harry Potter 3', 'Book', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES('Harry Potter 4', 'Book', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES('Harry Potter 5', 'Movie', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES('Harry Potter 6', 'Book', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES('Harry Potter 7', 'Movie', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
=======
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'p', '22/04/1999', FALSE);
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'p', '22/04/1999', FALSE);
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'p', '22/04/1999', FALSE);



INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver, datecreated, dateexpires) VALUES(1, 'Harry Potter 1', 'Book', TRUE, 1, FALSE, null, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver, datecreated, dateexpires) VALUES(2, 'Harry Potter 2', 'Movie', TRUE, 1, FALSE, null, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(1, 'Harry Potter 1', 'Book', FALSE, null, FALSE, null);
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(3, 'Harry Potter 2', 'Book', FALSE, null, FALSE, null);


/*INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(3, 'Harry Potter 3', 'Book', FALSE, null, FALSE, null);
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(4, 'Harry Potter 4', 'Movie', FALSE, null, FALSE, null);
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(3, 'Harry Potter 3', 'Book', FALSE, null, FALSE, null);
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(5, 'Harry Potter 5', 'Movie', FALSE, null, FALSE, null);
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(4, 'Harry Potter 4', 'Movie', FALSE, null, FALSE, null);
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(7, 'Harry Potter 7', 'Book', FALSE, null, FALSE, null);
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, reserver) VALUES(6, 'Harry Potter 6', 'Book', FALSE, null, FALSE, null);*/
>>>>>>> db2c90c3abc7d95c5274f995c8ba22f1270c4813
