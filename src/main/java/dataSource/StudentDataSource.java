package dataSource;


import JsonSimple.JsonSimpleParser;
import model.StudentsJsonList;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDataSource {
    JsonSimpleParser parser = new JsonSimpleParser();
    StudentsJsonList studentsJsonList = parser.parse();
    private ArrayList<Student> listStudent = new ArrayList<>();
    private final List<Student> students = studentsJsonList.getStudent();


    public StudentDataSource() {
        initialData();

    }

    public void initialData() {
        listStudent.add(new Student("Ivan", "Ivanov", "Ivanovich", "3421", "Automobile", "A_11",0));
        listStudent.add(new Student("Petro", "Petrov", "Petroovich", "6011", "Road_Building", "R_11",0));
        listStudent.add(new Student("Taras", "Tarasov", "Tarasovich", "8427", "Mechanical", "A_12",500));
        listStudent.addAll(students);
    }


    public ArrayList<Student> getStudent() {
        return listStudent;
    }
}
