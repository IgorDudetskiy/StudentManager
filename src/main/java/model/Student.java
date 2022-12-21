package model;


import java.util.Collection;
import java.util.Objects;

public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private String studentID;

    private String faculty;
    private String group;
    private int tuitionBalance;





    public Student(String name, String surname, String patronymic, String studentID, String faculty, String group, int tuitionBalance) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.studentID = studentID;
        this.faculty = faculty;
        this.group = group;
        this.tuitionBalance = tuitionBalance;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public  String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public int getTuitionBalance() {
        return tuitionBalance;
    }

    public void setTuitionBalance(int tuitionBalance) {
        this.tuitionBalance = tuitionBalance;
    }

    @Override
    public String toString() {
        return "Student: " +
                "name='" + name + '\'' +"\n"+
                " surname='" + surname + '\'' +"\n"+
                " patronymic='" + patronymic + '\''+"\n" +
                " studentID='" + studentID + '\''+"\n" +
                " faculty='" + faculty + '\''+"\n" +
                " group='" + group + '\''+"\n";
    }
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof  Student)) return false;
//        Student student = (Student) o;
//        return Objects.equals(name, student.name) &&
//                Objects.equals(surname, student.surname) &&
//                Objects.equals(patronymic, student.patronymic)&&
//                Objects.equals(studentID, student.studentID) &&
//                Objects.equals(faculty, student.faculty) &&
//                Objects.equals(group, student.group);
//    }
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic,studentID,faculty,group);
    }
}



