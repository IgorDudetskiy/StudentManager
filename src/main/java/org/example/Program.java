package org.example;
import dataSource.ScheduleDataSource;
import controller.StudentController;
import dataSource.StudentDataSourceScore;
import model.Score;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {

        Output output = new Output(new StudentController(new StudentDataSourceScore(),new ScheduleDataSource(), new Score()));
        output.printTotalStudent();
        output.printInfoStudent();
    }
}
