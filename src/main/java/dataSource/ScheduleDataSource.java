package dataSource;

import JsonSimple.JsonScheduleParse;
import model.Schedule;
import model.ScheduleJsonList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDataSource {
    private final JsonScheduleParse jsonScheduleParse = new JsonScheduleParse();
    private final ScheduleJsonList scheduleJsonList = jsonScheduleParse.parse();
    private final ArrayList<Schedule> listSchedule = new ArrayList<>();

    private final List<Schedule> schedules = scheduleJsonList.getSchedules();

    public ScheduleDataSource() throws IOException {
        initialData();

    }
    public List<Schedule> getSchedules() {
        return schedules;
    }
    public void initialData() {
        listSchedule.addAll(schedules);
    }

}
