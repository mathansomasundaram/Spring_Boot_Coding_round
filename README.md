# Student Result Management System


## Objective
The Student Result Management System is a Spring Boot application that allows users to manage student details based on their SAT Score. It provides functionalities to find the result of the student, insert, view, update, and delete student records.

## Features
+ **Insert Student Data**: Users can insert student data, including their name, SAT Score, and other relevant details, into the system. The system calculates the result (PASS/FAIL) based on the SAT score provided. If SAT score >=30%, Pass otherwise Fail.
+ **View Student Details**: Users can view the details of all the students stored in the system, including their names, SAT Scores, and results (PASS or FAIL).
+ **Get Student Rank**: The application provides functionality to get the rank of a student based on their SAT Score. The rank is determined by sorting the students in descending order of their scores. Users can retrieve the name, score, and rank of the student.
+ **Update Student Details**: Users can update the student details, such as their SAT Scores or any other relevant information.
+ **Delete Student Record**: Users can delete a student record from the system based on their name.

## API Endpoints
+ **/**: Displays the menu option where users can select actions like insert, delete, view, display rank, and update.
+ **/process**: Invokes the respective JSP page based on the user's input.
+ **/insertData**: Inserts student data into the system.
+ **/findResult**: Finds the result of a student based on their SAT Score.
+ **/deleteStudent**: Deletes a student record from the system.
+ **/findRank**: Finds the rank of a particular student.
+ **/updateData**: Updates the SAT Score based on the name.
+ **/GetUserDetailsforUpdate**: Fetches the student details for updating the record.

Please refer to the respective API endpoints for detailed usage instructions.

## Project Structure
+ **_HomeController.java_**: Controller file that handles the requests and responses for the Student Result Management System.
+ **_StudentDao.java_**: Data access class that interacts with the database for student-related operations.
+ **_Student.java_**: Entity class representing the Student entity with attributes like name, SAT Score, etc.
+ **_HibernateConfig.java_**: Hibernate configuration class for setting up the Hibernate ORM framework.
+ Log Details: Log messages for the application are stored in the **_application.log_** file.
+ Views/JSP: JSP files for the application can be found under the path **_/src/main/webapp/views_**.
+ Table Details: The details of the database tables can be found in the **_CreateQuery.sql_** file.

## Getting Started
To get started with the Student Result Management System, follow these steps:

1. Clone the repository to your local machine.
2. Configure the required dependencies and settings.
3. Run the application.
4. Access the application using the provided API endpoints.

