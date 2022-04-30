USE mydb;

INSERT INTO Status (exp_status)
VALUES ("not started"),
("on process"),
("blocked"),
("finished");
INSERT INTO Types (type_name)
VALUES ("Chemistry"),
("Physics"),
("Health"),
("Technology"),
("Biology");
INSERT INTO Financiations (fin_origin)
VALUES ("State"),
("Private entity"),
("Mixed"),
("This laboratory");
INSERT INTO Labs_size (lab_size, square_meters)
VALUES ("Small", 50),
("Medium", 100),
("Extra", 150),
("Big", 200);
INSERT INTO Cities (city_name)
VALUES ("Rosario"),
("Chicago"),
("Cordoba");

INSERT INTO Laboratories (name, exp_capacity, labs_size_id, city_id)
VALUES ("Perrando", 150, (SELECT id FROM Labs_Size WHERE lab_size ="Big"), (SELECT id FROM Cities WHERE city_name ="Rosario")),
("Guemes", 80, (SELECT id FROM Labs_Size WHERE lab_size ="Medium"), (SELECT id FROM Cities WHERE city_name ="Rosario")),
("Sarmiento", 85, (SELECT id FROM Labs_Size WHERE lab_size ="Extra"), (SELECT id FROM Cities WHERE city_name ="Chicago")),
("Tesla", 35, (SELECT id FROM Labs_Size WHERE lab_size ="Small"), (SELECT id FROM Cities WHERE city_name ="Cordoba"));

INSERT INTO Costs (cost_per_hour, type_id)
VALUES (50, (SELECT id FROM Types WHERE type_name ="Chemistry")),
(100, (SELECT id FROM Types WHERE type_name ="Physics")),
(75, (SELECT id FROM Types WHERE type_name ="Health")),
(80, (SELECT id FROM Types WHERE type_name ="Technology")),
(25, (SELECT id FROM Types WHERE type_name ="Biology"));

INSERT INTO Orders (hours_required, cost_id)
VALUES (15, (SELECT id FROM Costs WHERE cost_per_hour = 50)),
(20, (SELECT id FROM Costs WHERE cost_per_hour = 100)),
(50, (SELECT id FROM Costs WHERE cost_per_hour = 75)),
(35, (SELECT id FROM Costs WHERE cost_per_hour = 80)),
(10, (SELECT id FROM Costs WHERE cost_per_hour = 25));

INSERT INTO Experiments (test_tube_usage, status_id, types_id, financiations_id, lab_id, order_id)
VALUES (10, (SELECT id FROM Status WHERE exp_status = "on process"), (SELECT id FROM Types WHERE type_name = "Chemistry"), (SELECT id FROM Financiations WHERE fin_origin = "State"), (SELECT id FROM Laboratories WHERE name = "Perrando"), (SELECT id FROM Orders WHERE hours_required = 15)),
(15, (SELECT id FROM Status WHERE exp_status = "not started"), (SELECT id FROM Types WHERE type_name = "Health"), (SELECT id FROM Financiations WHERE fin_origin = "Private entity"), (SELECT id FROM Laboratories WHERE name = "Tesla"), (SELECT id FROM Orders WHERE hours_required = 20)),
(18, (SELECT id FROM Status WHERE exp_status = "blocked"), (SELECT id FROM Types WHERE type_name = "Technology"), (SELECT id FROM Financiations WHERE fin_origin = "Mixed"), (SELECT id FROM Laboratories WHERE name = "Sarmiento"), (SELECT id FROM Orders WHERE hours_required = 35)),
(20, (SELECT id FROM Status WHERE exp_status = "finished"), (SELECT id FROM Types WHERE type_name = "Physics"), (SELECT id FROM Financiations WHERE fin_origin = "This laboratory"), (SELECT id FROM Laboratories WHERE name = "Guemes"), (SELECT id FROM Orders WHERE hours_required = 50));

INSERT INTO Phone_Numbers (phone_number, lab_id)
VALUES (45678, (SELECT id FROM Laboratories WHERE name = "Perrando")),
(78941, (SELECT id FROM Laboratories WHERE name = "Guemes")),
(89123, (SELECT id FROM Laboratories WHERE name = "Sarmiento")),
(21564, (SELECT id FROM Laboratories WHERE name = "Guemes")),
(87123, (SELECT id FROM Laboratories WHERE name = "Perrando")),
(21742, (SELECT id FROM Laboratories WHERE name = "Sarmiento")),
(87152, (SELECT id FROM Laboratories WHERE name = "Sarmiento")),
(14951, (SELECT id FROM Laboratories WHERE name = "Tesla"));


INSERT INTO Positions (position_name)
VALUES ("Scientist"),
("Receptionist"),
("Lab_assistant");

INSERT INTO Employees (first_name, last_name, position_id)
VALUES ("Jorge", "Vega", (SELECT id FROM positions WHERE position_name ="Scientist")),
("Pablo", "Santos", (SELECT id FROM positions WHERE position_name ="Lab_assistant")),
("Enrique", "Pereyra", (SELECT id FROM positions WHERE position_name ="Scientist"));

INSERT INTO Weekly_Shifts (lab_id, employee_id, weekly_shifts)
VALUES ((SELECT id FROM Laboratories WHERE name ="Perrando"), (SELECT id FROM Employees WHERE first_name ="Jorge"), 5),
((SELECT id FROM Laboratories WHERE name ="Guemes"), (SELECT id FROM Employees WHERE first_name ="Jorge"), 7),
((SELECT id FROM Laboratories WHERE name ="Tesla"), (SELECT id FROM Employees WHERE first_name ="Jorge"), 2),
((SELECT id FROM Laboratories WHERE name ="Perrando"), (SELECT id FROM Employees WHERE first_name ="Pablo"), 7),
((SELECT id FROM Laboratories WHERE name ="Guemes"), (SELECT id FROM Employees WHERE first_name ="Pablo"), 3),
((SELECT id FROM Laboratories WHERE name ="Tesla"), (SELECT id FROM Employees WHERE first_name ="Pablo"), 4),
((SELECT id FROM Laboratories WHERE name ="Perrando"), (SELECT id FROM Employees WHERE first_name ="Enrique"), 2),
((SELECT id FROM Laboratories WHERE name ="Guemes"), (SELECT id FROM Employees WHERE first_name ="Enrique"), 9),
((SELECT id FROM Laboratories WHERE name ="Tesla"), (SELECT id FROM Employees WHERE first_name ="Enrique"), 4);

UPDATE Employees
SET first_name = 'Marcos', last_name= 'Battaglia'
WHERE id = 2;

UPDATE Employees
SET first_name = 'Pedro', last_name= 'Portillo'
WHERE id = 3;

UPDATE Phone_Numbers
SET phone_number = 84512
WHERE id = 1;

UPDATE Phone_Numbers
SET phone_number = 54812
WHERE id = 2;

UPDATE Phone_Numbers
SET phone_number = 98521
WHERE id = 3;

UPDATE Cities
SET city_name = 'Santa Fe'
WHERE id = 1;

UPDATE Cities
SET city_name = 'Catamarca'
WHERE id = 2;

DELETE FROM Phone_Numbers WHERE phone_number=21564;
DELETE FROM Phone_Numbers WHERE phone_number=87123;
DELETE FROM Phone_Numbers WHERE phone_number=21742;
DELETE FROM Phone_Numbers WHERE phone_number=14951;

DELETE FROM Weekly_Shifts WHERE weekly_shifts=9;
DELETE FROM Weekly_Shifts WHERE weekly_shifts=5;

ALTER TABLE Employees
ADD email varchar(45);
ALTER TABLE Cities
ADD country varchar(45);
ALTER TABLE Positions
ADD wage INT;
ALTER TABLE Laboratories
ADD employees_quantity INT;

SELECT *
FROM Employees
INNER JOIN Positions
ON Employees.position_id = Positions.id;

SELECT *
FROM Costs
LEFT JOIN Orders
ON Costs.id = Orders.cost_id;

SELECT *
FROM Experiments
RIGHT JOIN Financiations
ON Experiments.financiations_id = Financiations.id;

SELECT AVG(cost_per_hour), id	
FROM Costs GROUP BY id;

SELECT AVG(cost_per_hour), id	
FROM Costs GROUP BY id;

SELECT AVG(cost_per_hour), id	
FROM Costs GROUP BY id HAVING AVG(cost_per_hour) > 90;
