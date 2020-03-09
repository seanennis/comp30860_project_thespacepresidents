INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'password', '22/04/1999', FALSE);
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Adam Shorten O Reilly', 'a.s.oreilly99@gmail.com', 'p2', '09/09/1999', TRUE);

INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES(1, 'Harry Potter 1', 'Book', TRUE, 1, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES(2, 'Harry Potter 2', 'Movie', TRUE, 1, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES(3, 'Harry Potter 3', 'Book', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES(4, 'Harry Potter 4', 'Book', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES(5, 'Harry Potter 5', 'Movie', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES(6, 'Harry Potter 6', 'Book', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(artifact_id, name, type, onLoan, owner, reserved, renewed, reserver, datecreated, dateexpires) VALUES(7, 'Harry Potter 7', 'Movie', FALSE, null, FALSE, FALSE, FALSE, '04/03/2020', '11/03/2020');

INSERT INTO loans(owner, artifact, artifactType, dateCreated, dateExpired, active) VALUES(1, 'Populous', 'Video Game', '20/01/2020', '27/01/2020', FALSE);
INSERT INTO loans(owner, artifact, artifactType, dateCreated, dateExpired, active) VALUES(1, 'Baldurs Gate', 'Video Game', '10/02/2020', '17/02/2020', FALSE);

INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'p', '22/04/1999', FALSE);
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'p', '22/04/1999', FALSE);
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'p', '22/04/1999', FALSE);