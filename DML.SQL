1.CREATE TABLE MY_EMPLOYEE AS SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,SALARY FROM HR.EMPLOYEES WHERE 1=2;
2.DESC MY_EMPLOYEE;
3.INSERT INTO MY_EMPLOYEE VALUES(201,'MICHAEL','HARTSTEIN',20,13000);
  SELECT * FROM MY_EMPLOYEE;
4.INSERT INTO MY_EMPLOYEE VALUES(202,'PAT','FAY',20,'');
  SELECT * FROM MY_EMPLOYEE;
5.INSERT INTO MY_EMPLOYEE(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID) VALUES(203,'SUSAN','MAVRIS',40);
  SELECT * FROM MY_EMPLOYEE;
6.insert all
  into my_employee (205, 'Shelley', 'Higgins', 110, 12000)
  into my_employee (100, 'Steven', 'King', 90, 24000)
  into my_employee (101, 'Neena', 'Kochhar', 90, 17000)
  into my_employee (102, 'Lex De', 'Haan', 90, 17000)
  into my_employee (111, 'Ismael', 'Sciarra', 100, 7700)
  into my_employee (112, 'Jose Manuel', 'Urman', 100, 7800)
  into my_employee (204, 'Hermann', 'Baer', 70, 10000)
  select 1 from dual;
7.UPDATE my_employee SET SALARY=SALARY+(SALARY*.10)
  WHERE department_id=90;
8.UPDATE my_employee SET LAST_NAME='HIGGINS'
  WHERE EMPLOYEE_id=202;
9.DELETE FROM MY_EMPLOYEE WHERE FIRST_NAME LIKE '%MAN%' AND LAST_NAME LIKE '%MAN%';
