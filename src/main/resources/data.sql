/*
create table person(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   primary key(id)
);
*/
/* for H2 DB -> CURRENT_TIMESTAMP  */
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10001,  'Ranga', 'Hyderabad', CURRENT_TIMESTAMP);
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10003,  'Pieter', 'Amsterdam',CURRENT_TIMESTAMP);
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10002,  'James', 'New York',CURRENT_TIMESTAMP);





/* For Oracle DB-> TO_CHAR(SYSDATE, 'MM-DD-YYYY HH24:MI:SS')
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10001,  'Ranga', 'Hyderabad',TO_CHAR(SYSDATE, 'MM-DD-YYYY HH24:MI:SS'));
*/

/* for Mysql DB-> sysdate()
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10002,  'James', 'New York',sysdate());
*/