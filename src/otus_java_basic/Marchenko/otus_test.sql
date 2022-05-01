CREATE TABLE questions
(
question_id	SERIAL		PRIMARY KEY,
discription	VARCHAR(200)	NOT NULL UNIQUE
);

DROP TABLE questions

SELECT * FROM questions

INSERT INTO questions (discription)
VALUES
	('Как называется код между фигурными скобками?'),
	('Каково значение arr[1].length в следующем массиве? int[][] arr = { {1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10} '),
	('От какого класса наследуют все классы Java?');

SELECT * FROM questions


CREATE TABLE answers
(
answer_id		SERIAL 		NOT NULL,
answer_text		VARCHAR(100)	NOT NULL,
question_id		INTEGER		NOT NULL,
correct_answer		BOOLEAN		NOT NULL
);

SELECT * FROM answers

INSERT INTO answers (question_id, answer_text, correct_answer)
VALUES
	(1, 'функция', false),
	(1, 'секция', false),
	(1, 'тело', false),
	(1, 'блок', true),
	(2, '2', false),
	(2, '5', true),
	(2, '10', false),
	(3, 'Object', true),
	(3, 'List', false),
	(3, 'Runtime', false),
	(3, 'Collection', false),
	(3, 'String', false);

DROP TABLE answers

SELECT * FROM answers	

CREATE TABLE users
(
name		VARCHAR(100)		NOT NULL,
success		INTEGER			NOT NULL,
user_id		SERIAL			NOT NULL UNIQUE,
test_id		INTEGER			NOT NULL			
);

DROP TABLE users

INSERT INTO users (name, test_id, success)
VALUES
	('Anton', 1, 3),
	('Ivan', 1, 1),
	('Mike', 1, 2),
	('Egor', 1, 3),
	('Egor', 2, 2),
	('Ivan', 2, 4),
	('Anton', 2, 3);

CREATE TABLE test
(
test_id		SERIAL		PRIMARY KEY,
test_name	VARCHAR(100)	NOT NULL UNIQUE,
question_id	INTEGER[]	NOT NULL UNIQUE
);

DROP TABLE test

INSERT INTO test (test_id, test_name, question_id)
VALUES 
	(1, 'Test of JAVA', '{1, 2, 3}'),
	(2, 'Test of Docker', '{4, 5, 6, 7}');


SELECT * FROM test
SELECT user_id, name, success  
FROM users JOIN test on test.test_id = users.test_id


SELECT name, test_id, success FROM users WHERE name = 'Anton' 
SELECT name, test_id, success FROM users WHERE name = 'Ivan' 

SELECT discription, answer_id, answer_text FROM questions FULL JOIN answers on questions.question_id = answers.question_id

SELECT discription, answer_text FROM questions FULL JOIN answers on questions.question_id = answers.question_id
WHERE correct_answer = true