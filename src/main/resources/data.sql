INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Luke Murphy', 'murphyluke01@gmail.com', 'password', '22/04/1999', FALSE);
INSERT INTO users(name, email, password, dob, islibrarian) VALUES('Adam Shorten O Reilly', 'a.s.oreilly99@gmail.com', 'p2', '09/09/1999', TRUE);

INSERT INTO artifacts(name, type, onLoan, owner, reserved, reserver, datecreated, dateexpires) VALUES('Harry Potter 1', 'Book', TRUE, 1, FALSE, null, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, reserver, datecreated, dateexpires) VALUES('Harry Potter 2', 'Movie', TRUE, 1, FALSE, null, '04/03/2020', '11/03/2020');
INSERT INTO artifacts(name, type, onLoan, owner, reserved, reserver) VALUES('Harry Potter 3', 'Book', FALSE, null, FALSE, null);
INSERT INTO artifacts(name, type, onLoan, owner, reserved, reserver) VALUES('Harry Potter 4', 'Movie', FALSE, null, FALSE, null);
INSERT INTO artifacts(name, type, onLoan, owner, reserved, reserver) VALUES('Harry Potter 5', 'Movie', FALSE, null, FALSE, null);
INSERT INTO artifacts(name, type, onLoan, owner, reserved, reserver) VALUES('Harry Potter 6', 'Book', FALSE, null, FALSE, null);
INSERT INTO artifacts(name, type, onLoan, owner, reserved, reserver) VALUES('Harry Potter 7', 'Book', FALSE, null, FALSE, null);
