package JsonSimple;

import model.Student;
import model.StudentsJsonList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonSimpleParser {

    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_PEOPLE = "people";
    private static final String TAG_NAME = "name";
    private static final String TAG_SURNAME = "surname";

    private static final String TAG_PATRONYMIC = "patronymic";

    private static final String TAG_STUDENT_ID="studentId";

    private static final String TAG_FACULTY="faculty";
    private static final String TAG_GROUP="group";
    private static final String TAG_TUITIONBALANCE="tuitionBalance";

    public StudentsJsonList parse() {
        StudentsJsonList studentsJsonList = new StudentsJsonList();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src\\main\\resources\\test.json")) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);
            String name = (String) rootJsonObject.get(TAG_NAME_MAIN);
            JSONArray peopleJsonArray = (JSONArray) rootJsonObject.get(TAG_PEOPLE);
            List<Student> studentList = new ArrayList<>();

            for (Object it : peopleJsonArray) {
                JSONObject peopleJsonObject = (JSONObject) it;
                String namePeople = (String) peopleJsonObject.get(TAG_NAME);
                String surname = (String) peopleJsonObject.get(TAG_SURNAME);
                String patronymic = (String) peopleJsonObject.get(TAG_PATRONYMIC);
                String studentId = (String) peopleJsonObject.get(TAG_STUDENT_ID);
                String faculty = (String) peopleJsonObject.get(TAG_FACULTY);
                String group = (String) peopleJsonObject.get(TAG_GROUP);
                long tuitionBalance = (Long) peopleJsonObject.get(TAG_TUITIONBALANCE);
                Student people = new Student(namePeople,surname,patronymic,studentId,faculty,group,(int) tuitionBalance);
                studentList.add(people);
            }

            studentsJsonList.setName(name);
            studentsJsonList.setStudent(studentList);


            return studentsJsonList;
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }
}
