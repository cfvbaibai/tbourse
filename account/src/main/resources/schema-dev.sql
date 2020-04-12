CREATE TABLE User (id INT IDENTITY, identity_type INT, identity_number VARCHAR(25), birth_date DATE);
CREATE TABLE Account (id INT IDENTITY, userId INT, name VARCHAR(32));
CREATE TABLE Card (id INT IDENTITY, accountId INT, number VARCHAR(32), cardType INT, balance DECIMAL, properties VARCHAR(256));