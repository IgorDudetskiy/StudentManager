package org.example;

import controller.StudentController;
import dataSource.StudentDataSource;
import model.Faculty;
import model.Student;

import java.io.IOException;

public class Output {
    private final StudentController studentController;
    public Output(StudentController studentController){this.studentController = studentController;}

    public void printTotalStudent() {
        String message = String.format("Total students: %.2f", studentController.calculateTotalStudent());
        System.out.println(message);
    }
    public void printInfoStudent() throws IOException {
        studentController.printInfo();
    }

}
