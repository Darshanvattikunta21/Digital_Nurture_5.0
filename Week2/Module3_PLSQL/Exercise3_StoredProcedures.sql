SET SERVEROUTPUT ON;

CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(50),
    salary NUMBER,
    department VARCHAR2(30)
);

INSERT INTO employees (emp_id, emp_name, salary, department) VALUES (101, 'Rahul', 50000, 'IT');
INSERT INTO employees (emp_id, emp_name, salary, department) VALUES (102, 'Priya', 60000, 'HR');
INSERT INTO employees (emp_id, emp_name, salary, department) VALUES (103, 'Amit', 55000, 'IT');
INSERT INTO employees (emp_id, emp_name, salary, department) VALUES (104, 'Neha', 65000, 'Finance');
COMMIT;

CREATE OR REPLACE PROCEDURE get_employee(p_emp_id IN NUMBER) AS
    v_emp_name employees.emp_name%TYPE;
    v_salary employees.salary%TYPE;
    v_department employees.department%TYPE;
BEGIN
    SELECT emp_name, salary, department
    INTO v_emp_name, v_salary, v_department
    FROM employees
    WHERE emp_id = p_emp_id;

    DBMS_OUTPUT.PUT_LINE('Employee ID: ' || p_emp_id);
    DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_emp_name);
    DBMS_OUTPUT.PUT_LINE('Salary: ' || v_salary);
    DBMS_OUTPUT.PUT_LINE('Department: ' || v_department);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found');
END;
/

CREATE OR REPLACE PROCEDURE update_salary(
    p_emp_id IN NUMBER,
    p_new_salary IN NUMBER,
    p_status OUT VARCHAR2
) AS
BEGIN
    UPDATE employees
    SET salary = p_new_salary
    WHERE emp_id = p_emp_id;

    IF SQL%ROWCOUNT = 1 THEN
        COMMIT;
        p_status := 'SUCCESS';
        DBMS_OUTPUT.PUT_LINE('Salary updated successfully');
    ELSE
        p_status := 'NOT FOUND';
        DBMS_OUTPUT.PUT_LINE('Employee not found');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        p_status := 'ERROR';
        DBMS_OUTPUT.PUT_LINE('Error occurred while updating salary');
END;
/

CREATE OR REPLACE PROCEDURE get_dept_employees(p_dept IN VARCHAR2) AS
    CURSOR c_emp IS
        SELECT emp_id, emp_name, salary
        FROM employees
        WHERE department = p_dept;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employees in department: ' || p_dept);
    FOR r_emp IN c_emp LOOP
        DBMS_OUTPUT.PUT_LINE('ID: ' || r_emp.emp_id || ', Name: ' || r_emp.emp_name || ', Salary: ' || r_emp.salary);
    END LOOP;
END;
/

DECLARE
    v_status VARCHAR2(20);
BEGIN
    get_employee(101);

    update_salary(101, 70000, v_status);
    DBMS_OUTPUT.PUT_LINE('Status: ' || v_status);

    get_dept_employees('IT');
END;
/
