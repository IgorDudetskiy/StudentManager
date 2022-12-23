package model;

import model.Student;

import java.util.List;

public class StudentsJsonList{

    private String name;
    private List<Student> students;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }
    public String toString(){
        return "StudentsList{ " +"name = "+name+'\''+", student = "+ students+ '}';
    }
}
