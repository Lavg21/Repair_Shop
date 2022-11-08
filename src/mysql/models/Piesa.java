package mysql.models;

public class Piesa {
    private int id_p;
    private String descriere;
    private String fabricant;
    private int cantitate_stoc;
    private double pret_c;

    public Piesa(int id_p, String descriere, String fabricant, int cantitate_stoc, double pret_c) {
        this.id_p = id_p;
        this.descriere = descriere;
        this.fabricant = fabricant;
        this.cantitate_stoc = cantitate_stoc;
        this.pret_c = pret_c;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public int getCantitate_stoc() {
        return cantitate_stoc;
    }

    public void setCantitate_stoc(int cantitate_stoc) {
        this.cantitate_stoc = cantitate_stoc;
    }

    public double getPret_c() {
        return pret_c;
    }

    public void setPret_c(double pret_c) {
        this.pret_c = pret_c;
    }

    @Override
    public String toString() {
        return "id_p: " + id_p +
                "\ndescriere: " + descriere +
                "\nfabricant: " + fabricant +
                "\ncantitate_stoc: " + cantitate_stoc +
                "\npret_c: " + pret_c;
    }
}
