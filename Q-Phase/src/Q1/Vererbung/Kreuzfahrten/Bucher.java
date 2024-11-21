package Q1.Vererbung.Kreuzfahrten;

public class Bucher extends Passagier{
    private final String email, iban;

    public Bucher(String vn, String nn, String email, String iban){
        super(vn, nn);
        this.email = email;
        this.iban = iban;
    }

    public String toString(){
        return (super.toString() + "\nEmail:\t" + email +"\nIBAN:\t" + iban);

    }




}
