package dataSource;



import com.fasterxml.jackson.databind.ObjectMapper;
import model.StudentsJsonList;
import model.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataSourceScore {

    ObjectMapper mapper = new ObjectMapper();
    StudentsJsonList studentsJsonList = mapper.readValue(new File("src/main/resources/StudentList.json"), StudentsJsonList.class);
    private final List<Student> students = studentsJsonList.getStudent();
    private final ArrayList<Student> listStudents = new ArrayList<>();

    public StudentDataSourceScore() throws IOException {
        initialData();
    }

    public void initialData() {
        listStudents.addAll(students);


    }


    public List<Student> getStudent() {
        return listStudents;
    }
}

