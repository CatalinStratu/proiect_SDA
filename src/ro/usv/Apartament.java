package ro.usv;

import ro.usv.dao.Entitate;

/**
 * @author Catalin STRATU
 * @grupa 3133b
 * @nr 2
 */
public class Apartament extends Entitate<Long> {

    private Long id;
    private String tip;
    private Double suprafata;
    private Integer anConstructie;
    private String strada;
    private Integer nr;
    private String scara;
    private Integer etaj;
    private Integer nrApt;

    public Apartament(Long id, String tip, Double suprafata, Integer anConstructie, String strada, Integer nr, String scara, Integer etaj, Integer nrApt) {
        this.id = id;
        this.tip = tip;
        this.suprafata = suprafata;
        this.anConstructie = anConstructie;
        this.strada = strada;
        this.nr = nr;
        this.scara = scara;
        this.etaj = etaj;
        this.nrApt = nrApt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Double getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(Double suprafata) {
        this.suprafata = suprafata;
    }

    public Integer getAnConstructie() {
        return anConstructie;
    }

    public void setAnConstructie(Integer anConstructie) {
        this.anConstructie = anConstructie;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getScara() {
        return scara;
    }

    public void setScara(String scara) {
        this.scara = scara;
    }

    public Integer getEtaj() {
        return etaj;
    }

    public void setEtaj(Integer etaj) {
        this.etaj = etaj;
    }

    public Integer getNrApt() {
        return nrApt;
    }

    public void setNrApt(Integer nrApt) {
        this.nrApt = nrApt;
    }

    private String removeFirstandLast(String str) {
        str = str.substring(1, str.length() - 1);
        return str;
    }

    public String removeCommas(String str){
        return str.replace("\"", "");
    }

    @Override
    public String toString() {
        return " {" +
                "Tip=" + tip +
                ", id=" + id +
                ", suprafata=" + suprafata +
                ", anConstructie=" + anConstructie +
                ", strada='" + removeCommas(strada) + '\'' +
                ", nr=" + nr +
                ", scara=" + scara +
                ", etaj=" + etaj +
                ", nrApt=" + nrApt +
                ", ";
    }

}
