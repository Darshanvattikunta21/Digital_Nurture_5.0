SET SERVEROUTPUT ON;

DECLARE
    v_marks NUMBER := 85;
    v_grade CHAR(1);
BEGIN
    IF v_marks >= 90 THEN
        v_grade := 'A';
    ELSIF v_marks >= 80 THEN
        v_grade := 'B';
    ELSIF v_marks >= 70 THEN
        v_grade := 'C';
    ELSIF v_marks >= 60 THEN
        v_grade := 'D';
    ELSE
        v_grade := 'F';
    END IF;

    DBMS_OUTPUT.PUT_LINE('Marks: ' || v_marks);
    DBMS_OUTPUT.PUT_LINE('Grade: ' || v_grade);

    CASE v_grade
        WHEN 'A' THEN
            DBMS_OUTPUT.PUT_LINE('Result Message: Excellent');
        WHEN 'B' THEN
            DBMS_OUTPUT.PUT_LINE('Result Message: Very Good');
        WHEN 'C' THEN
            DBMS_OUTPUT.PUT_LINE('Result Message: Good');
        WHEN 'D' THEN
            DBMS_OUTPUT.PUT_LINE('Result Message: Needs Improvement');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Result Message: Fail');
    END CASE;

    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE('FOR Loop Count: ' || i);
    END LOOP;

    DECLARE
        v_count NUMBER := 1;
    BEGIN
        WHILE v_count <= 5 LOOP
            DBMS_OUTPUT.PUT_LINE('WHILE Loop Count: ' || v_count);
            v_count := v_count + 1;
        END LOOP;
    END;
END;
/
