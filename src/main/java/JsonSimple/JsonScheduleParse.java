package JsonSimple;

import javafx.application.Application;
import model.Schedule;
import model.ScheduleJsonList;
import model.Student;
import model.StudentsJsonList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonScheduleParse {

    private static final String TAG_SCHEDULE_NAME = "scheduleName";
    private static final String TAG_SCHEDULE_GROUP = "group";
    private static final String TAG_A_11 = "A_11";
    private static final String TAG_A_12 = "A_12";
    private static final String TAG_R_11 = "R_11";
    private static final String TAG_R_12 = "R_12";


    public ScheduleJsonList parse() {
        ScheduleJsonList scheduleJsonList = new ScheduleJsonList();
        JSONParser parser = new JSONParser();


        try (FileReader reader = new FileReader("src/main/resources/schedule.json")) {
            JSONObject scheduleJsonObject = (JSONObject) parser.parse(reader);
            String name = (String) scheduleJsonObject.get(TAG_SCHEDULE_NAME);
            JSONArray scheduleJsonArray = (JSONArray) scheduleJsonObject.get(TAG_SCHEDULE_GROUP);
            List<Schedule> scheduleList = new ArrayList<>();

            for (Object it : scheduleJsonArray) {
                JSONObject scheduleJSONObject = (JSONObject) it;
                JSONObject a11 = (JSONObject) scheduleJSONObject.get(TAG_A_11);
                String A_11 = a11.toString();
                JSONObject a12 = (JSONObject) scheduleJSONObject.get(TAG_A_12);
                String A_12 = a12.toString();
                JSONObject r11 = (JSONObject) scheduleJSONObject.get(TAG_R_11);
                String R_11 = r11.toString();
                JSONObject r12 = (JSONObject) scheduleJSONObject.get(TAG_R_12);
                String R_12 = r12.toString();

                Schedule schedule = new Schedule(A_11,A_12,R_11,R_12);
                scheduleList.add(schedule);
            }
            scheduleJsonList.setScheduleName(name);
            scheduleJsonList.setSchedules(scheduleList);
            return scheduleJsonList;
        }  catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }
        return null;
    }
}

