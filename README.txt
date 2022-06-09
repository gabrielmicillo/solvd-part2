EXPERIMENTS
this table uses foreign key of status, type, financiation, laboratory and order. Also has a column providing the amount of the test tubes used on each experiment.

TYPES
this table specifies the type of experiment (physics, chemistry, biology, health-related)

POSITIONS
this table specifies if the employee is a scientist or a laboratory assistant

FINANCIATIONS
this table specifies if the experiment is financiated by the state, private entity or the laboratory itself.

EMPLOYEES:
this table specifies the first and last name of the employee and take foreign key of position.

WEEKLY SHIFTS:
this table is originated on a many to many relationship between laboratories and employees. 

LAB SIZE:
specifies the size of the laboratory

LABORATORIES:
this table specifies the name of the laboratory and the amount of experiments it can perform at the same time

CITIES:
this table specifies the name of the locations of the laboratories

STATUS:
this table specifies the status of the experiment: not started / on process / finished.

PHONE NUMBERS
this table specifies the phone number of the laboratory and takes the laboratory id as foreign key

CLIENTS
this table specifies the name of the lab's clients

ORDERS
this table specifies the amount of hours required for the experiment and takes the cost of it as foreign key