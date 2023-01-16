package controller;

import com.sun.jdi.event.ExceptionEvent;
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
    private static Score score;


    public StudentController(StudentDataSourceScore studentDataSourceScore, ScheduleDataSource scheduleDataSource, Score score) {
        StudentController.studentDataSourceScore = studentDataSourceScore;
        StudentController.scheduleDataSource = scheduleDataSource;
        StudentController.score = score;
    }

    public String checkId() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter id: ");
            String id = br.readLine();
            checkStudent(id);
            return id;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Student checkStudent(String id) {
        List<String> stringList = new ArrayList<>();
        for (Student s : studentDataSourceScore.getStudent()) {
            stringList.add(s.getStudentID());
        }
        if (stringList.contains(id)) {
            for (Student student : studentDataSourceScore.getStudent()) {
                if (id.equals(student.getStudentID())) {
                    infoAboutStudent(student);
                    return student;
                }
            }
        } else {
            System.out.println("Error. Try else");
            checkId();
        }
        return null;
    }

    public Student infoAboutStudent(Student student) {
        System.out.println("Your student: " + student);
        checkFaculty(student);
        viewBalance(student);
        readTuition(student);
        checkScholarship(student);
        return student;
    }


    public Student checkFaculty(Student student) {
        for (Faculty f : Faculty.values()) {
            if (Objects.equals(student.getFaculty(), f.getFaculty())) {
                System.out.println(student.getSurname() + " has the right faculty " + student.getFaculty());
                checkGroup(student);
                checkSchedule(student.getGroup());
                break;
            }
        }
        return student;
    }


    public Student checkGroup(Student student) {
        for (Group g : Group.values()) {
            Stream<Student> studentStream = Stream.of(student);
            studentStream.filter(
                    student1 -> Objects.equals(student.getGroup(), g.getGroup())).forEach(student1 ->
                    System.out.println(student.getSurname() + " has the right group " + student.getGroup()));
        }
        return student;
    }


    public double calculateTotalStudent() {
        double totalStudents = 0;
        for (Student ignored : studentDataSourceScore.getStudent()) {
            totalStudents++;
        }
        return totalStudents;
    }

    public Student viewBalance(Student student) {
        System.out.println("Your tuition balance: " + student.getTuitionBalance());

        return student;
    }

    public String readTuition(Student student) {
        try {
            BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your payment ₴: ");
            String secondValue = brr.readLine();
            checkTuition(student, secondValue);
            return secondValue;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double checkTuition(Student student,String value) {
        try {
            double payment = Integer.parseInt(value);
            if (payment <= 0) {
                throw new ArithmeticException();
            }
            printTuition(student,payment);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("You enter wrong value. Try else: ");
            readTuition(student);
        }

        return 0;
    }
    public Student printTuition(Student student,double payment){
        student.setTuitionBalance(student.getTuitionBalance() + (int) payment);
        System.out.println("thank you for your payment of $" + payment);
        System.out.println(student.getSurname()+" Your new balance: $"+student.getTuitionBalance());
        return student;
    }


    public Student checkScholarship(Student student) {
        final int allowableScore = 4;
        for (Score score : student.getScores()) {
            System.out.println("Your average score: ");
            System.out.println("Score math: " + score.getMath());
            System.out.println("Score Ukrainian language: " + score.getUkrainianLanguage());
            System.out.println("Score History Of Ukraine: " + score.getHistoryOfUkraine());
            double averageScore = ((double) score.getMath() + score.getUkrainianLanguage() + score.getHistoryOfUkraine()) / 4;
            if (averageScore >= allowableScore) {
                System.out.println(averageScore + " is greater or equal than " + allowableScore + " is good");
            } else {
                System.out.println(averageScore + " is less than " + allowableScore + " is bad");
            }
        }
        return student;
    }

    public String checkSchedule(String group) {
        for (Schedule schedule : scheduleDataSource.getSchedules()) {
            switch (group) {
                case "A_11" -> System.out.println("A_11: " + schedule.getTAG_A_11());
                case "A_12" -> System.out.println("A_12: " + schedule.getTAG_A_12());
                case "R_11" -> System.out.println("R_11: " + schedule.getTAG_R_11());
                case "R_12" -> System.out.println("R_12: " + schedule.getTAG_R_12());
            }
        }
        return group;
    }
}



