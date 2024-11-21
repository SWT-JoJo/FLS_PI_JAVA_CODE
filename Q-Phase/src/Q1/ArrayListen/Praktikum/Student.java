package Q1.ArrayListen.Praktikum;

public class Student {
    private double note;
    private String name;

    public Student(String name, double note){
        this.name = name;
        this.note  = note;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
