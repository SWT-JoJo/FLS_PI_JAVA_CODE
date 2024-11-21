package Q1.ArrayListen.Praktikum;

import java.util.ArrayList;

public class Praktikum {
    private String name;
    private ArrayList<Student> studenten = new ArrayList<>();





    public Praktikum (String name){
        this.name = name;
    }

    public void AddStudent(String name, double note){
        studenten.add(new Student(name, note));
        System.out.println("Student hinzugefügt");
    }

    public String outputStudenten(){
        String output = "";
        for(Student temp : studenten){
            output += "\t" +(studenten.indexOf(temp) + 1) + ".: " + temp.getName() + "\t(" + temp.getNote()+")\n";
        }
        return output;
    }

    public double outputDurchschniitsNote(){
        double schnitt = 0;
        for (Student temp : studenten){
            schnitt += temp.getNote();
        }

        schnitt = schnitt / studenten.size();

        return schnitt;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudenten() {
        return studenten;
    }

}
