package Q1.Assoziationen.AbteilugVerschiedeneRollen;

public class Personal {
    private String name;

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int alter;

    public Personal(String name, int alter ){
        this.name = name;
        this.alter = alter;
    }
}
