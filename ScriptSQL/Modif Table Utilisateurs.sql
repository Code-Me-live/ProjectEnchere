ALTER TABLE UTILISATEURS ADD CONSTRAINT uk_pseudo UNIQUE (pseudo);

ALTER TABLE UTILISATEURS ADD CONSTRAINT uk_email UNIQUE (email);

ALTER TABLE UTILISATEURS ALTER COLUMN email VARCHAR(255);

ALTER TABLE UTILISATEURS ALTER COLUMN rue VARCHAR(255);
