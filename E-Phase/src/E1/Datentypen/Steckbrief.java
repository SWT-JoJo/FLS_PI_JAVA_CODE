package E1.Datentypen;
public class Steckbrief {
public static void main(String[] args){
    String name; 
    int age; 
    String Birthday;
    char gender;
    String hobbys; 

    name = "Jonah Maximilian Schroeder";
    age = 16;
    Birthday = "18/06/2007";
    gender = 'm';
    hobbys = "Feuerwehr";
    
    System.out.println("\n" + "Steckbrief: " + "\n");
    System.out.println("Name: " +  name + "\n" + "Alter: " +  age  );
    System.out.println("Birthday: " +  Birthday + "\n" + "Geschlecht: " + gender );
    System.out.print("Hobbys : " + hobbys + "\n");
}
}
