package mysql.models;

public class PiesaDeviz {
    private int id_d;
    private int id_p;
    private int cantitate;
    private double pret_r;

    public PiesaDeviz(int id_d, int id_p, int cantitate, double pret_r) {
        this.id_d = id_d;
        this.id_p = id_p;
        this.cantitate = cantitate;
        this.pret_r = pret_r;
    }

    public int getId_d() {
        return id_d;
    }

    public void setId_d(int id_d) {
        this.id_d = id_d;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public double getPret_r() {
        return pret_r;
    }

    public void setPret_r(double pret_r) {
        this.pret_r = pret_r;
    }

    @Override
    public String toString() {
        return "PiesaDeviz{" +
                "id_d=" + id_d +
                ", id_p=" + id_p +
                ", cantitate=" + cantitate +
                ", pret_r=" + pret_r +
                '}';
    }
}
