package ro.usv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.lang.System.exit;

/**
 * @author Catalin STRATU
 * @grupa 3133b
 * @nr 2
 */
public class AsociatieProprietariClient {

    private static final AsociatieProprietariServ asociatieProprietariServ = new AsociatieProprietariServ();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> res = new ArrayList<String>();
                Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(line);
                while (m.find()) {
                    res.add(m.group(1));
                }
                switch (res.get(0)) {
                    case "add":
                        if (res.size() >= 10 && res.size() <= 12) {
                            if (Objects.equals(res.get(1), "L") && asociatieProprietariServ.getApartamentById(Integer.parseInt(res.get(2))) == null) {
                                System.out.println(res.get(0) + " " + res.get(1) + " " + res.get(2) + " " + res.get(3) + " " + res.get(4) + " " + res.get(5) + " " + res.get(6) + " " + res.get(7) + " " + res.get(8) + " " + res.get(9) + " " + res.get(10));
                                Locuinta locuinta = new Locuinta(res.get(1), Long.parseLong(res.get(2)), Double.parseDouble(res.get(3)), Integer.parseInt(res.get(4)), res.get(5), Integer.parseInt(res.get(6)), res.get(7), Integer.parseInt(res.get(8)), Integer.parseInt(res.get(9)), Integer.parseInt(res.get(10)));
                                asociatieProprietariServ.saveApartament(locuinta);
                            } else if (Objects.equals(res.get(1), "SF") && asociatieProprietariServ.getApartamentById(Integer.parseInt(res.get(2))) == null) {
                                System.out.println(res.get(0) + " " + res.get(1) + " " + res.get(2) + " " + res.get(3) + " " + res.get(4) + " " + res.get(5) + " " + res.get(6) + " " + res.get(7) + " " + res.get(8) + " " + res.get(9) + " " + res.get(10) + " " + res.get(11));
                                SediuFirma sediuFirma = new SediuFirma(res.get(1), Long.parseLong(res.get(2)), Double.parseDouble(res.get(3)), Integer.parseInt(res.get(4)), res.get(5), Integer.parseInt(res.get(6)), res.get(7), Integer.parseInt(res.get(8)), Integer.parseInt(res.get(9)), res.get(10), Integer.parseInt(res.get(11)));
                                asociatieProprietariServ.saveApartament(sediuFirma);
                            } else if (Objects.equals(res.get(1), "SF") || Objects.equals(res.get(1), "L") && asociatieProprietariServ.getApartamentById(Integer.parseInt(res.get(2))) == null) {
                                System.out.println("Eroare. save: obj. exista deja id=" + res.get(2));
                            }
                        } else {
                            String addErrPar = "";
                            for (int i = 1; i < res.size(); i++) {
                                addErrPar += res.get(i);
                                if (i != res.size() - 1) {
                                    addErrPar += " ";
                                }
                            }
                            System.out.println("add " + addErrPar);
                            System.out.println("Eroare. Numarul parametrilor nu este corect");
                        }
                        break;
                    case "clear":
                        asociatieProprietariServ.deleteApartmente();
                        System.out.println("clear");
                        System.out.println("S-au eliminat toate apartamentele");
                        break;
                    case "delete":
                        System.out.println("delete " + res.get(1));
                        if (asociatieProprietariServ.getApartamentById(Integer.parseInt(res.get(1))) == null) {
                            System.out.println("Eroare. delete: obj cu id=" + res.get(1) + " nu exista");
                        } else {
                            asociatieProprietariServ.deleteApartment(Integer.parseInt(res.get(1)));
                        }
                        break;
                    case "file":
                        asociatieProprietariServ.setStocare(res.get(1));
                        break;
                    case "list":
                        if (res.size() == 1) {
                            System.out.println("list");
                            System.out.println(asociatieProprietariServ.getApartamentente());
                        } else {
                            System.out.println("list " + res.get(1));
                            if (asociatieProprietariServ.getApartamentById(Integer.parseInt(res.get(1))) == null) {
                                System.out.println("error");
                            } else {
                                System.out.println(asociatieProprietariServ.getApartamentById(Integer.parseInt(res.get(1))));
                            }
                        }
                        break;
                    case "rem":
                        System.out.println(line);
                        System.out.println(line);
                        break;
                    case "avgsurf":
                        String tipul = "";
                        if (res.size() == 2) {
                            tipul = res.get(1);
                        }
                        if (Objects.equals(tipul, "L")) {
                            System.out.println("avgsurf " + res.get(1));
                            double avgL = asociatieProprietariServ.getAverageSurface("L");
                            if (avgL == -1) {
                                System.out.println("Nu sunt apartamente de tipul L");
                            } else {
                                System.out.println("Suprafata medie a locuintelor: " + asociatieProprietariServ.getAverageSurface("L"));
                            }
                        } else if (Objects.equals(tipul, "SF")) {
                            System.out.println("avgsurf " + res.get(1));
                            double avgSF = asociatieProprietariServ.getAverageSurface("SF");
                            if (avgSF == -1) {
                                System.out.println("Nu sunt apartamente de tipul SF");
                            } else {
                                System.out.println("Suprafata medie a sediilor de firme: " + avgSF);
                            }
                        } else if (Objects.equals(tipul, "")) {
                            System.out.println("avgsurf");
                            double avg = asociatieProprietariServ.getAverageSurface("");
                            if (avg == -1) {
                                System.out.println("Nu sunt apartamente de tipul ");
                            } else {
                                System.out.println("Suprafata medie a apartamentelor: " + asociatieProprietariServ.getAverageSurface(""));
                            }
                        } else {
                            System.out.println("avgsurf " + res.get(1));
                            double suprafata = asociatieProprietariServ.getAverageSurface(tipul);
                            if (suprafata == -1) {
                                System.out.println("Nu sunt apartamente de tipul " + tipul);
                            } else {
                                System.out.println("Suprafata medie a apartamentelor: " + suprafata);
                            }
                        }
                        break;
                    case "floor":
                        System.out.println("floor " + res.get(1));
                        Integer etaj = Integer.parseInt(res.get(1));
                        List<Long> ids = asociatieProprietariServ.findIdsFloorSmallerThan(etaj);
                        if (etaj == 0) {
                            if (ids.size() == 0) {
                                System.out.println("Ap. situate la parter []");
                            } else {
                                System.out.print("Ap. situate la parter [");
                                ap_situate_la_etaj(ids);
                            }
                        } else {
                            if (ids.size() == 0) {
                                System.out.println("Ap. situate la un etaj <=" + etaj + " []");
                            } else {
                                System.out.print("Ap. situate la un etaj <=" + etaj + " [");
                                ap_situate_la_etaj(ids);
                            }
                        }
                        break;
                    case "surfgt":
                        System.out.println("surfgt " + res.get(1));
                        Double suprafata = Double.parseDouble(res.get(1));
                        List<Long> idsSupraface = asociatieProprietariServ.findIDsSurfaceGreaterThan(suprafata);
                        if (idsSupraface.isEmpty()) {
                            System.out.println("Ap. cu suprafata cel putin egala cu " + suprafata + ": []");
                        } else {
                            System.out.print("Ap. cu suprafata cel putin egala cu " + suprafata + ": [");
                            surfgt(idsSupraface);
                        }
                        break;
                    case "stop":
                        System.out.println("stop");
                        System.out.println("La revedere!");
                        exit(0);
                }
            }
        } catch (
                Exception e) {
            System.out.println("Maaaesaj: " + e.getMessage());
        }

    }

    private static void surfgt(List<Long> idsSupraface) {
        for (int i = 0; i < idsSupraface.size(); i++) {
            if (i == idsSupraface.size() - 1) {
                System.out.print(idsSupraface.get(i));
            } else {
                System.out.print(idsSupraface.get(i) + ", ");
            }
        }
        System.out.println("]");
    }

    private static void ap_situate_la_etaj(List<Long> ids) {
        surfgt(ids);
    }
}
