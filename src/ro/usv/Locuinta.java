package ro.usv;

/**
 * @author Catalin STRATU
 * @grupa 3133b
 * @nr 2
 */

public class Locuinta extends Apartament {
    private Integer persoane;

    @Override
    public String toString() {
        return super.toString() +
                "nrPersoane=" + persoane +
                '}';
    }

    public Locuinta(String tip, Long id, Double suprafata, Integer anConstructie, String strada, Integer nr, String scara, Integer etaj, Integer nrApt, Integer persoane) {
        super(id, tip, suprafata, anConstructie, strada, nr, scara, etaj, nrApt);
        this.persoane = persoane;
    }
}
