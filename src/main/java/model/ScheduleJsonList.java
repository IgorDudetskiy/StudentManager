package model;

import java.util.List;

public class ScheduleJsonList {
    private String scheduleName;
    private List<Schedule> schedules;



    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "ScheduleJsonList{" +
                "scheduleName='" + scheduleName + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
