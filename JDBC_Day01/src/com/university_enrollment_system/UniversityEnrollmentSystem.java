package com.university_enrollment_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UniversityEnrollmentSystem {

    public static void main(String[] args) {
        try {
            // Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle DB
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", "system", "Ajit");

            Statement st = con.createStatement();

//            // Students Table
//            st.execute("CREATE TABLE Students (" +
//                       "student_id NUMBER(5) PRIMARY KEY, " +
//                       "name VARCHAR2(20), " +
//                       "email VARCHAR2(30), " +
//                       "department VARCHAR2(20))");
//
//            // Courses Table
//            st.execute("CREATE TABLE Courses (" +
//                       "course_id NUMBER(5) PRIMARY KEY, " +
//                       "course_name VARCHAR2(50), " +
//                       "credits NUMBER(8,2))");
//
//            // Enrollments Table (Foreign Keys included)
//            st.execute("CREATE TABLE Enrollments (" +
//                       "enrollment_id NUMBER(10) PRIMARY KEY, " +
//                       "student_id NUMBER(5), " +
//                       "course_id NUMBER(5), " +
//                       "enrollment_date DATE, " +
//                       "FOREIGN KEY (student_id) REFERENCES Students(student_id), " +
//                       "FOREIGN KEY (course_id) REFERENCES Courses(course_id))");
//
//            // Sequences
//            st.execute("CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1");
//            st.execute("CREATE SEQUENCE course_seq START WITH 1 INCREMENT BY 1");
//            st.execute("CREATE SEQUENCE enrollment_seq START WITH 1 INCREMENT BY 1");
//
//            System.out.println("✅ Tables and sequences created successfully!");
            
            st.execute("insert into students values(student_seq.nextval,'Ajit','rajkr80923097@gmail.com','10')");
          //  st.execute("insert into courses values(course_seq.nextval,"))
            System.out.println("Data Inserted...");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
