package mysql.models;

public class Persoana {
    private int id;
    private String nume;
    private String email;
    private String adresa;

    public Persoana(int id, String nume, String email, String adresa) {
        this.id = id;
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Persoana { " +
                "id = " + id +
                ", nume = '" + nume + '\'' +
                ", email = '" + email + '\'' +
                ", adresa = '" + adresa + '\'' +
                '}';
    }
}
