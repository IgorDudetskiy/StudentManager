package model;

public class Score {
    private int math;
    private int ukrainianLanguage;
    private int historyOfUkraine;

    public Score(int math1, int ukrM1, int ukrH1) {
        math = math1;
        ukrainianLanguage = ukrM1;
        historyOfUkraine = ukrH1;
    }

    public Score() {
    }


    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getUkrainianLanguage() {
        return ukrainianLanguage;
    }

    public void setUkrainianLanguage(int ukrainianLanguage) {
        this.ukrainianLanguage = ukrainianLanguage;
    }

    public int getHistoryOfUkraine() {
        return historyOfUkraine;
    }

    public void setHistoryOfUkraine(int historyOfUkraine) {
        this.historyOfUkraine = historyOfUkraine;
    }

    @Override
    public String toString() {
        return "Score{" +
                "math=" + math +
                ", ukrainianLanguage=" + ukrainianLanguage +
                ", historyOfUkraine=" + historyOfUkraine +
                '}';
    }
    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }
}
