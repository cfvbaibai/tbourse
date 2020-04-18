CREATE TABLE User (id INT IDENTITY, identity_type INT, identity_number VARCHAR(25), birth_date DATE);
CREATE TABLE Account (id INT IDENTITY, user_id INT, name VARCHAR(32));
CREATE TABLE Card (id INT IDENTITY, account_id INT, number VARCHAR(32), card_type INT, balance DECIMAL, properties VARCHAR(256));
CREATE TABLE Tran (id INT IDENTITY, card_id INT, utc_time DATETIME, amount DECIMAL, opponent VARCHAR(64), memo VARCHAR(256));