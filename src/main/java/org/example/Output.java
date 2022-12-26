package org.example;

import controller.StudentController;

import java.io.IOException;

public class Output {
    private final StudentController studentController;
    public Output(StudentController studentController){this.studentController = studentController;}

    public void printTotalStudent() {
        System.out.println("Total students in list: "+ studentController.calculateTotalStudent());
    }
    public void printInfoStudent() {
        studentController.printInfo();
    }

}
