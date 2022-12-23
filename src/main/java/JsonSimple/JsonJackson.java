package JsonSimple;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Schedule;
import model.Score;
import model.Student;
import model.StudentsJsonList;

import java.io.File;
import java.io.IOException;

public class JsonJackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StudentsJsonList studentsJsonList = mapper.readValue(new File("src/main/resources/testNew.json"), StudentsJsonList.class);
        System.out.println(studentsJsonList.getStudent());

    }
}
