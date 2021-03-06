USE gabriel_micillo;

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
FROM Experiment_Types
LEFT JOIN Orders
ON Experiment_Types.id = Orders.experiment_id;

SELECT *
FROM Experiments
RIGHT JOIN Financiations
ON Experiments.financiations_id = Financiations.id;

SELECT * FROM Orders
JOIN Experiments ON Orders.experiment_id = Experiments.id
JOIN Experiment_Types ON Experiments.experiment_types_id = Experiment_Types.id
JOIN Financiations ON Experiments.financiations_id = Financiations.id
JOIN Laboratories ON Experiments.lab_id = Laboratories.id
JOIN Labs_Size ON Laboratories.labs_size_id = Labs_Size.id
JOIN Cities ON Laboratories.city_id = Cities.id
JOIN Clients ON Orders.client_id = Clients.id
JOIN Phone_Numbers ON Laboratories.id = Phone_Numbers.lab_id
JOIN Employees ON Experiments.id = Employees.experiment_id
JOIN Positions ON Employees.position_id = Positions.id; 

SELECT AVG(cost_per_hour), id	
FROM Experiment_Types GROUP BY id;

SELECT AVG(cost_per_hour), id	
FROM Experiment_Types GROUP BY id;

SELECT AVG(cost_per_hour), id	
FROM Experiment_Types GROUP BY id HAVING AVG(cost_per_hour) > 90;