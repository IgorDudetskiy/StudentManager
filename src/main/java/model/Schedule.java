package model;

public class Schedule {
    private  String TAG_A_11 = "A_11";
    private  String TAG_A_12 = "A_12";
    private  String TAG_R_11 = "R_11";
    private String TAG_R_12 = "R_12";

    public Schedule(String TAG_A_11, String TAG_A_12, String TAG_R_11, String TAG_R_12) {
        this.TAG_A_11 = TAG_A_11;
        this.TAG_A_12 = TAG_A_12;
        this.TAG_R_11 = TAG_R_11;
        this.TAG_R_12 = TAG_R_12;
    }

    public String getTAG_A_11() {
        return TAG_A_11;
    }

    public void setTAG_A_11(String TAG_A_11) {
        this.TAG_A_11 = TAG_A_11;
    }

    public String getTAG_A_12() {
        return TAG_A_12;
    }

    public void setTAG_A_12(String TAG_A_12) {
        this.TAG_A_12 = TAG_A_12;
    }

    public String getTAG_R_11() {
        return TAG_R_11;
    }

    public void setTAG_R_11(String TAG_R_11) {
        this.TAG_R_11 = TAG_R_11;
    }

    public String getTAG_R_12() {
        return TAG_R_12;
    }

    public void setTAG_R_12(String TAG_R_12) {
        this.TAG_R_12 = TAG_R_12;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "TAG_A_11='" + TAG_A_11 + '\'' +
                ", TAG_A_12='" + TAG_A_12 + '\'' +
                ", TAG_R_11='" + TAG_R_11 + '\'' +
                ", TAG_R_12='" + TAG_R_12 + '\'' +
                '}';
    }
}
