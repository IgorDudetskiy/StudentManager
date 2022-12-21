package controller;

import dataSource.StudentDataSource;
import model.Faculty;
import model.Group;
import model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class StudentController {
    private static StudentDataSource studentDataSource;

    public StudentController(StudentDataSource studentDataSource) {
        StudentController.studentDataSource = studentDataSource;

    }

    public void checkFaculty() {
        int i = 0;
        for (Faculty f : Faculty.values()) {
            List<Student> students = studentDataSource.getStudent();
            while (i < students.size()) {
                try {
                    if (Faculty.valueOf(students.get(i).getFaculty()).equals(f)) {
                        System.out.println(students.get(i).getSurname() + " has faculty exist " + students.get(i).getFaculty());
                    } else {
                        System.out.println(students.get(i).getSurname() + " has faculty exist " + students.get(i).getFaculty());
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(students.get(i).getSurname() + " has NOT faculty  exist " + students.get(i).getFaculty());
                }
                i++;
            }
        }
    }

    public void checkGroup() {
        for (Student student : studentDataSource.getStudent()) {
            for (Group g : Group.values()) {
                Stream<Student> studentStream = Stream.of(student);
                studentStream.filter(
                        student1 -> Objects.equals(student.getGroup(), g.getGroup())).forEach(student1 ->
                        System.out.println(student.getSurname() + " has the right group " + student.getGroup()));

            }
        }
    }

    public double calculateTotalStudent() {
        double totalStudents = 0;
        for (Student ignored : studentDataSource.getStudent()) {
            totalStudents++;
        }
        return totalStudents;
    }

    public void infoAboutStudent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id for information about student: ");
        String a = br.readLine();
        for (Student student : studentDataSource.getStudent()) {
            if (a.equals(student.getStudentID())) {
                System.out.println("Your student: " + student.toString());
            }
        }
    }

    public void viewBalance() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter studentID for view balance: ");
            String id = br.readLine();
            for (Student student : studentDataSource.getStudent()) {
                if (id.equals(student.getStudentID())) {
                    System.out.println("Your tuition balance: " + student.getTuitionBalance());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void payTuition() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter studentID for pay for education: ");
            String id = br.readLine();
            for (Student student : studentDataSource.getStudent()) {
                if (id.equals(student.getStudentID())) {
                    BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter your payment ₴: ");
                    int payment = Integer.parseInt(brr.readLine());
                    student.setTuitionBalance(student.getTuitionBalance() + payment);
                    System.out.println("thank you for your payment of $" + payment);
                    viewBalance();
                }
            }
        } catch (Exception e) {
            payTuition();
        }
    }

    public void printInfo() throws IOException {
        checkFaculty();
        System.out.println("");
        checkGroup();
        infoAboutStudent();
        payTuition();
    }
}



