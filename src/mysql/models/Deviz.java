package mysql.models;

import java.util.Date;

public class Deviz {
    private int id_d;
    private Date data_introducere;
    private String aparat;
    private String simptome;
    private String defect;
    private Date data_constatare;
    private Date data_finalizare;
    private int durata;
    private int manopera_ora;
    private int total;
    private int id_client;
    private int id_depanator;

    public Deviz(int id_d, Date data_introducere, String aparat, String simptome, String defect, Date data_constatare, Date data_finalizare, int durata, int manopera_ora, int total, int id_client, int id_depanator) {
        this.id_d = id_d;
        this.data_introducere = data_introducere;
        this.aparat = aparat;
        this.simptome = simptome;
        this.defect = defect;
        this.data_constatare = data_constatare;
        this.data_finalizare = data_finalizare;
        this.durata = durata;
        this.manopera_ora = manopera_ora;
        this.total = total;
        this.id_client = id_client;
        this.id_depanator = id_depanator;
    }

    public int getId_d() {
        return id_d;
    }

    public void setId_d(int id_d) {
        this.id_d = id_d;
    }

    public Date getData_introducere() {
        return data_introducere;
    }

    public void setData_introducere(Date data_introducere) {
        this.data_introducere = data_introducere;
    }

    public String getAparat() {
        return aparat;
    }

    public void setAparat(String aparat) {
        this.aparat = aparat;
    }

    public String getSimptome() {
        return simptome;
    }

    public void setSimptome(String simptome) {
        this.simptome = simptome;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public Date getData_constatare() {
        return data_constatare;
    }

    public void setData_constatare(Date data_constatare) {
        this.data_constatare = data_constatare;
    }

    public Date getData_finalizare() {
        return data_finalizare;
    }

    public void setData_finalizare(Date data_finalizare) {
        this.data_finalizare = data_finalizare;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getManopera_ora() {
        return manopera_ora;
    }

    public void setManopera_ora(int manopera_ora) {
        this.manopera_ora = manopera_ora;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_depanator() {
        return id_depanator;
    }

    public void setId_depanator(int id_depanator) {
        this.id_depanator = id_depanator;
    }

    @Override
    public String toString() {
        return  "id_d: " + id_d +
                "\ndata_introducere: " + data_introducere +
                "\naparat: " + aparat +
                "\nsimptome: " + simptome +
                "\ndefect: " + defect +
                "\ndata_constatare: " + data_constatare +
                "\ndata_finalizare: " + data_finalizare +
                "\ndurata: " + durata +
                "\nmanopera_ora: " + manopera_ora +
                "\ntotal: " + total +
                "\nid_client: " + id_client +
                "\nid_depanator: " + id_depanator;
    }
}
