package Q1.ArrayListen.Schule;

public class Tutor {
    private String name;
    private String kuerzel;

    public Tutor(String name, String kuerzel){
        this.kuerzel = kuerzel;
        this.name = name;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
