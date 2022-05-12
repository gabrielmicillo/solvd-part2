USE gabriel_micillo;

INSERT INTO Status (exp_status)
VALUES ("not started"),
("on process"),
("blocked"),
("finished");

INSERT INTO Experiment_Types (type_name, cost_per_hour)
VALUES ("Chemistry", 50),
("Physics", 100),
("Health", 75),
("Technology", 80),
("Biology", 25);

INSERT INTO Financiations (fin_origin)
VALUES ("State"),
("Private entity"),
("Mixed"),
("This laboratory");

INSERT INTO Labs_Size (lab_size, square_meters)
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

INSERT INTO Experiments (test_tube_usage, status_id, experiment_types_id, financiations_id, lab_id)
VALUES (10, (SELECT id FROM Status WHERE exp_status = "on process"), (SELECT id FROM Experiment_Types WHERE type_name = "Chemistry"), (SELECT id FROM Financiations WHERE fin_origin = "State"), (SELECT id FROM Laboratories WHERE name = "Perrando")),
(15, (SELECT id FROM Status WHERE exp_status = "not started"), (SELECT id FROM Experiment_Types WHERE type_name = "Health"), (SELECT id FROM Financiations WHERE fin_origin = "Private entity"), (SELECT id FROM Laboratories WHERE name = "Tesla")),
(18, (SELECT id FROM Status WHERE exp_status = "blocked"), (SELECT id FROM Experiment_Types WHERE type_name = "Technology"), (SELECT id FROM Financiations WHERE fin_origin = "Mixed"), (SELECT id FROM Laboratories WHERE name = "Sarmiento")),
(20, (SELECT id FROM Status WHERE exp_status = "finished"), (SELECT id FROM Experiment_Types WHERE type_name = "Physics"), (SELECT id FROM Financiations WHERE fin_origin = "This laboratory"), (SELECT id FROM Laboratories WHERE name = "Guemes"));

INSERT INTO Clients (first_name, last_name)
VALUES ("Jorge", "Valdano"),
("Marcos", "Lanzelotta"),
("Dennis", "Maguire"),
("Appa", "Nahametilakh"),
("Toko", "Ekambi");

INSERT INTO Orders (hours_required, experiment_id, client_id)
VALUES (15, (SELECT id FROM Experiments WHERE test_tube_usage = 10), (SELECT id FROM Clients WHERE first_name = "Jorge")),
(20, (SELECT id FROM Experiments WHERE test_tube_usage = 20), (SELECT id FROM Clients WHERE first_name = "Toko")),
(50, (SELECT id FROM Experiments WHERE test_tube_usage = 20), (SELECT id FROM Clients WHERE first_name = "Marcos")),
(35, (SELECT id FROM Experiments WHERE test_tube_usage = 18), (SELECT id FROM Clients WHERE first_name = "Appa")),
(10, (SELECT id FROM Experiments WHERE test_tube_usage = 15), (SELECT id FROM Clients WHERE first_name = "Dennis"));

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

INSERT INTO Employees (first_name, last_name, position_id, experiment_id)
VALUES ("Jorge", "Vega", (SELECT id FROM Positions WHERE position_name ="Scientist"), (SELECT id FROM Experiments WHERE test_tube_usage =15)),
("Pablo", "Santos", (SELECT id FROM Positions WHERE position_name ="Lab_assistant"), (SELECT id FROM Experiments WHERE test_tube_usage =18)),
("Enrique", "Pereyra", (SELECT id FROM Positions WHERE position_name ="Scientist"), (SELECT id FROM Experiments WHERE test_tube_usage =20));

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

INSERT INTO Employees_Competences (experiment_types_id, employee_id, employee_competence)
VALUES ((SELECT id FROM Experiment_Types WHERE type_name ="Chemistry"), (SELECT id FROM Employees WHERE first_name ="Jorge"), 7),
((SELECT id FROM Experiment_Types WHERE type_name ="Physics"), (SELECT id FROM Employees WHERE first_name ="Jorge"), 8),
((SELECT id FROM Experiment_Types WHERE type_name ="Health"), (SELECT id FROM Employees WHERE first_name ="Jorge"), 5),
((SELECT id FROM Experiment_Types WHERE type_name ="Chemistry"), (SELECT id FROM Employees WHERE first_name ="Pablo"), 4),
((SELECT id FROM Experiment_Types WHERE type_name ="Technology"), (SELECT id FROM Employees WHERE first_name ="Pablo"), 6),
((SELECT id FROM Experiment_Types WHERE type_name ="Physics"), (SELECT id FROM Employees WHERE first_name ="Pablo"), 2),
((SELECT id FROM Experiment_Types WHERE type_name ="Chemistry"), (SELECT id FROM Employees WHERE first_name ="Enrique"), 8),
((SELECT id FROM Experiment_Types WHERE type_name ="Technology"), (SELECT id FROM Employees WHERE first_name ="Enrique"), 1),
((SELECT id FROM Experiment_Types WHERE type_name ="Biology"), (SELECT id FROM Employees WHERE first_name ="Enrique"), 5);