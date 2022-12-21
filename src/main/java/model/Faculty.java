package model;

import java.util.ArrayList;
import java.util.List;

public enum Faculty{
    Automobile("Automobile"),
    Road_Building("Road_Building");

    private String faculty;

    Faculty(String faculty) {
        this.faculty = faculty;
    }



    public String getFaculty() {
        return faculty;
    }

    public boolean hasFaculty() {
        return faculty != null;
    }


}


