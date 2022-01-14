package ro.usv;

/**
 * @author Catalin STRATU
 * @grupa 3133b
 * @nr 2
 */
public class SediuFirma extends Apartament {

    private String removeFirstandLast(String str) {
        str = str.substring(1, str.length() - 1);
        return str;
    }

    private String first4(String str) {
        String firstFourChars = "";     //substring containing first 4 characters

        if (str.length() > 4)
        {
            firstFourChars = str.substring(0, 4);
        }
        else
        {
            firstFourChars = str;
        }
        return firstFourChars;
    }

    @Override
    public String toString() {
        String denumireNoua = removeFirstandLast(denumire);
        String firstFourChars =  first4(denumireNoua);
        return super.toString() +
                "denumire='" + denumireNoua + '\'' +
                ", CUI=" + cui +
                '}';
    }

    private String denumire;
    private Integer cui;

    public SediuFirma(String tip, Long id, Double suprafata, Integer anConstructie, String strada, Integer nr, String scara, Integer etaj, Integer nrApt, String denumire, Integer cui) {
        super(id, tip, suprafata, anConstructie, strada, nr, scara, etaj, nrApt);
        this.denumire = denumire;
        this.cui = cui;
    }
}
