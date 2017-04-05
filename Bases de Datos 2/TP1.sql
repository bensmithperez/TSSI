-- TP 1 Oracle SQL --

-- 1
-- Muestre los detalles de los trabajos con un salario minimo de 10000. 
SELECT * FROM JOBS
WHERE MIN_SALARY > 10000;

-- 2
--  Muestre el employee_id, last_name, first_name aplicando alias a estas columnas, que pertenezcan al department_id 10. 
SELECT employee_id eid, last_name eln, first_name efn
FROM EMPLOYEES 
WHERE DEPARTMENT_ID = 10;

-- 3
-- Muestre el first_name y hire_date de los empleados cuyo job_id sea “IT Programmer” o “Sales Man”. 
SELECT first_name nombre, hire_date  
FROM EMPLOYEES
WHERE job_id IN ('IT_PROG','SA_MAN');

-- 4
-- Muestre los diferentes name de los departamentos sin repetirse. 
SELECT DISTINCT department_name
FROM DEPARTMENTS;

-- 5
-- Muestre el first_name y hire_date de los empleados que se unieron entre 2002 y 2005. 
SELECT first_name, hire_date
FROM employees
WHERE TO_CHAR(hire_date,'YY') BETWEEN 02 AND 05;

-- 6
-- Muestre empleados que se unieron a la compañia luego del 1 de enero de 2008. 
SELECT *
FROM employees
WHERE hire_date > TO_DATE('01-JAN-08');

-- 7
-- Muestre el job_Title y la diferencia entre el max_salary y min_salary para trabajos con un max_salary entre 10000 y 20000
SELECT job_title , (max_salary-min_salary) diferencia
FROM jobs
WHERE max_salary BETWEEN 10000 AND 20000;
-- 8
-- Muestre detalles de los trabajos en orden descendiente de job_title 
SELECT *
FROM jobs
ORDER BY job_title DESC;

-- 9
-- Muestre empleados cuyo first_name o last_name empiece con “S”. 
SELECT *
FROM employees
WHERE first_name LIKE 'S%' OR last_name LIKE 'S%';

-- 10 ?
--  Mostrar detalles de los empleados cuyo commission_percentage es nulo, el salary está en el rango de 5000 y 10000 y el department_id es 30 
SELECT *
FROM employees
WHERE commission_pct = NULL
AND salary BETWEEN 5000 AND 10000
AND department_id = 30;

-- 11
-- Muestre el first_name y el largo del mismo para todos los empleados.
SELECT first_name, LENGTH(first_name) AS largo
FROM employees;

-- 12 ?
-- Muestre en mayúscula el first name y minúscula para el email de los empleados cuando el first name y el email sean igual independientemente de mayúsculas y minúsculas. 
SELECT upper(first_name) nombre, lower(email) mail
FROM employees
WHERE upper(first_name) = upper(email);

-- 13
-- Muestre cuantos empleados se unieron en cada mes del 2008. 
SELECT TO_CHAR(hire_date,'MM') mes, COUNT(TO_CHAR(hire_date,'MM')) cantidad
FROM employees
WHERE TO_CHAR(hire_date,'YY') = 08
GROUP BY TO_CHAR(hire_date,'MM')
ORDER BY TO_CHAR(hire_date,'MM');

-- 14
-- Muestre manager ID y número de empleados asignados a cada manager. 
SELECT manager_id, COUNT(manager_id) cantidad
FROM employees
GROUP BY manager_id
ORDER BY manager_id;

-- 15 ? lo saco de locations?...
-- Muestre el country ID y el número de ciudades en el país. 
SELECT country_id, count(city) cantidad
FROM locations
GROUP BY country_id;

-- 16 ?
-- Muestre el promedio del salary de empleados en cada departamento que tiene algún commission percentage.
SELECT department_id, AVG(salary)
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY department_id;

-- 17
-- Muestre el job ID, numero de empleados, suma de salary y diferencia entre el mayor y minimo salary.
SELECT job_id, count(job_id) cantEmpleados, sum(salary) sumaSalario, (MAX(salary)-MIN(salary)) diferenciaSalarios
FROM employees
GROUP BY job_id;

-- 18 ??
-- Muestre el job ID y promedio de salary de trabajos con un salary promedio superior a 10000. 
SELECT job_id, (max_salary+min_salary/2) promedio
FROM jobs
WHERE max_salary+min_salary/2 > 10000;

-- 19 ?
-- Muestre departamentos en que más de 5 empleados tengan commission percentage. 

-- 20
-- Cambiar el salary del employee_id 115 a 8000 si el salario es de menos de 6000. 
UPDATE employees
SET salary = 8000
WHERE salary < 6000 AND employee_id = 115;

-- verif...
SELECT salary
FROM employees
WHERE employee_id = 115;

-- 21
-- Insertar un Nuevo empleado en la tabla de empleados con todos los campos. 
INSERT INTO employees
VALUES (207,'Benjamin','Smith','info@bensmithperez.com','1234567','01-FEB-17','IT_PROG','10000',null,null,210);

-- verif 
SELECT *
FROM employees
WHERE employee_id = 207;

-- 22 (tengo que borrar otras cosas tambien)
-- Borrar el department_id 20.
DELETE FROM departments
WHERE department_id = 20;

-- 23
-- Muestre el department_name y el numero de empleados en el mismo. 
SELECT departments.department_name departamento, COUNT(employees.employee_id) cantidad
FROM departments
JOIN employees
ON departments.department_id = employees.department_id
GROUP BY departments.department_name;

-- 24
-- Muestre el job title y el salary promedio de los employees.
SELECT jobs.job_title puesto, avg(employees.salary) sPromedio
FROM jobs
JOIN employees
ON jobs.job_id = employees.job_id
GROUP BY jobs.job_title;

-- 25
--  Muestra todos los empleados pertenezcan o no a un departamento con los siguientes datos:  employee_id, last_name, department_id, department_name 
SELECT employees.employee_id, employees.last_name, employees.department_id, departments.department_name
FROM employees
JOIN departments
ON employees.department_id = departments.department_id;

-- 26 ?
-- Muestre los detalles de los departmentos gestionados por ‘Smith’. 
SELECT *
FROM departments
WHERE manager_id = (
  SELECT manager_id
  FROM EMPLOYEES
  WHERE LAST_NAME = 'Smith');
  
-- 27
-- Muestre los detalles del manager que gestione mas de 5. 


-- 28
-- Muestre los detalles de los departamentos en donde el max_salary es mayor a 10000 for solo para empleados que realizaran un trabajo en el pasado. 