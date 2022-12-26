package controller;

import dataSource.ScheduleDataSource;
import dataSource.StudentDataSourceScore;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class StudentController {
    private static StudentDataSourceScore studentDataSourceScore;
    private static ScheduleDataSource scheduleDataSource;


    public StudentController(StudentDataSourceScore studentDataSourceScore, ScheduleDataSource scheduleDataSource) {
        StudentController.studentDataSourceScore = studentDataSourceScore;
        StudentController.scheduleDataSource = scheduleDataSource;

    }

    public int calculateTotalStudent() {
        int totalStudents = 0;
        for (Student ignored : studentDataSourceScore.getStudent()) {
            totalStudents++;
        }
        return totalStudents;
    }

    public void infoAboutStudent() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter id for get information about student: ");
            String id = br.readLine();
            for (Student student : studentDataSourceScore.getStudent()) {
                if (id.equals(student.getStudentID())) {
                    System.out.println("Your student: " + student);
                    checkFaculty(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkFaculty(Student student) {
        try {
            for (Faculty f : Faculty.values()) {
                if (Objects.equals(student.getFaculty(), f.getFaculty())) {
                    System.out.println(student.getSurname() + " has the right faculty " + student.getFaculty());
                    checkGroup(student);
                    checkSchedule(student.getGroup());
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void checkGroup(Student student) throws IOException {
        for (Group g : Group.values()) {
            Stream<Student> studentStream = Stream.of(student);
            studentStream.filter(
                    student1 -> Objects.equals(student.getGroup(), g.getGroup())).forEach(student1 ->
                    System.out.println(student.getSurname() + " has the right group " + student.getGroup()));
        }
    }
    public void checkSchedule(String gr) {
        for (Schedule schedule : scheduleDataSource.getSchedules()) {
            switch (gr) {
                case "A_11" -> System.out.println("A_11: " + schedule.getTAG_A_11());
                case "A_12" -> System.out.println("A_12: " + schedule.getTAG_A_12());
                case "R_11" -> System.out.println("R_11: " + schedule.getTAG_R_11());
                case "R_12" -> System.out.println("R_12: " + schedule.getTAG_R_12());
            }
        }
    }


    public void viewBalance() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter studentID for view balance: ");
            String id = br.readLine();
            for (Student student : studentDataSourceScore.getStudent()) {
                if (id.equals(student.getStudentID())) {
                    System.out.println("Your tuition balance: " + student.getTuitionBalance());
                    payTuition(id);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void payTuition(String id) throws IOException {
        for (Student student : studentDataSourceScore.getStudent()) {
            if (id.equals(student.getStudentID())) {
                BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter tuition fee ₴: ");
                int payment = Integer.parseInt(brr.readLine());
                student.setTuitionBalance(student.getTuitionBalance() + payment);
                System.out.println("thank you for your payment of ₴" + payment);
                System.out.println("Your balance: ₴" + student.getTuitionBalance());
            }
        }
    }



    public void checkScholarship() {
        final int allowableScore = 4;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter studentID for view your average score: ");
            String id = br.readLine();
            for (Student student : studentDataSourceScore.getStudent()) {
                for (Score score : student.getScores()) {
                    if (id.equals(student.getStudentID())) {
                        System.out.println("Score Mathematics: " + score.getMath());
                        System.out.println("Score Ukrainian language: " + score.getUkrainianLanguage());
                        System.out.println("Score History of Ukraine: " + score.getHistoryOfUkraine());
                        double averageScore = ((double) score.getMath() + score.getUkrainianLanguage()
                                + score.getHistoryOfUkraine()) / score.getColumnCount();
                        String message = String.format("Average Score: %.2f ", averageScore);
                        if (averageScore >= allowableScore) {
                            System.out.println(message + " is greater or equal than " + allowableScore + ". This is good");
                        } else {
                            System.out.println(message + " is less than " + allowableScore + ". This is bad");
                        }
                    }
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void printInfo() {
        infoAboutStudent();
        viewBalance();
        checkScholarship();
    }
}



