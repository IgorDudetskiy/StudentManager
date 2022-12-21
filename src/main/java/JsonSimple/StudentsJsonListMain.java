package JsonSimple;

import model.StudentsJsonList;

public class StudentsJsonListMain {
    public static void main(String[] args) {
        JsonSimpleParser parser = new JsonSimpleParser();
        StudentsJsonList studentsJsonList = parser.parse();
       // System.out.println(studentsJsonList.getStudent());
    }
}
