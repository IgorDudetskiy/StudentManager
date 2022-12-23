package model;

public class Score {
    private int math;
    private int ukrM;
    private int ukrH;

    public Score(int math1, int ukrM1, int ukrH1) {
        math = math1;
        ukrM = ukrM1;
        ukrH = ukrH1;
    }

    public Score() {
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math1) {
        math = math1;
    }

    public int getUkrM() {
        return ukrM;
    }

    public void setUkrM(int ukrM1) {
        ukrM = ukrM1;
    }

    public int getUkrH() {
        return ukrH;
    }

    public void setUkrH(int ukrH1) {
        ukrH = ukrH1;
    }

    @Override
    public String toString() {
        return "Score{" +
                "Math=" + math +
                ", UkrM=" + ukrM +
                ", UkrH=" + ukrH +
                '}';
    }
}
