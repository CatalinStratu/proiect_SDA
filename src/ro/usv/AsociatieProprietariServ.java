package ro.usv;

import ro.usv.dao.Dao;
import ro.usv.dao.SerializareDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Catalin STRATU
 * @grupa 3133b
 * @nr 2
 */

public class AsociatieProprietariServ implements IAsociatieProprietariServ2 {

    private Dao dao = new SerializareDao();

    //DeveloperDao DeveloperDao = new DeveloperDaoImpl();
    public AsociatieProprietariServ() {
        dao = new SerializareDao();
    }

    public AsociatieProprietariServ(String file) {
        dao = new SerializareDao(file);
    }

    @Override
    public void setStocare(String nume) {
        if (nume == null)
            dao = new SerializareDao();
        else
            dao = new SerializareDao(nume);
    }

    @Override
    public Apartament getApartamentById(int id) {
        for (Apartament ap : this.getApartamentente()) {
            if (ap.getId() == id) {
                return ap;
            }
        }
        return null;
    }

    @Override
    public List<Apartament> getApartamentente() {
        return dao.getAll();
    }

    @Override
    public void saveApartament(Apartament ap) {
        dao.save(ap);
    }

    @Override
    public void deleteApartment(int id_) {
        long id = id_;
        dao.delete(id);
    }

    @Override
    public void deleteApartmente() {
        dao.deleteAll();
    }

    @Override
    public double getAverageSurface(String tip) {
        double average = 0.0;
        int num = 0;
        if (Objects.equals(tip, "L")) {
            for (Apartament ap : this.getApartamentente()) {
                if (Objects.equals(ap.getTip(), "L")) {
                    average += ap.getSuprafata();
                    num++;
                }
            }
        } else if (Objects.equals(tip, "SF")) {
            for (Apartament ap : this.getApartamentente()) {
                if (Objects.equals(ap.getTip(), "SF")) {
                    average += ap.getSuprafata();
                    num++;
                }
            }
        } else if (Objects.equals(tip, "")) {
            for (Apartament ap : this.getApartamentente()) {
                average += ap.getSuprafata();
                num++;
            }
        } else {
            return -1;
        }
        if(num == 0){
            return -1;
        }
        return average / num;
    }

    @Override
    public List<Long> findIdsFloorSmallerThan(int etaj) {
        List<Long> ids = new ArrayList<>();
        for (Apartament ap : this.getApartamentente()) {
            if (ap.getEtaj() <= etaj) {
                ids.add(ap.getId());
            }
        }
        return ids;
    }

    @Override
    public List<Long> findIDsSurfaceGreaterThan(double smin) {
        List<Long> ids = new ArrayList<>();
        for (Apartament apartament : this.getApartamentente()) {
            if (smin <= apartament.getSuprafata()) {
                ids.add(apartament.getId());
            }
        }
        return ids;
    }
}
