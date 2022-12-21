package model;

public enum Group {
    A_11("A_11"),
    A_12("A_12"),
    R_11("R_11"),
    R_12("R_12");

    public String group;


    Group(String group) {
        this.group = group;

    }
    public String getGroup() {
        return group;
    }

    public boolean hasGroup() {
        return group != null;
    }


    @Override
    public String toString() {
        return group;
    }
}
