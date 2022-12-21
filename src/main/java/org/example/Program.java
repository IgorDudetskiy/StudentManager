package org.example;

import controller.StudentController;
import dataSource.StudentDataSource;
import model.Student;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        Output output = new Output(new StudentController(new StudentDataSource()));
        output.printTotalStudent();
        output.printInfoStudent();
    }
}
