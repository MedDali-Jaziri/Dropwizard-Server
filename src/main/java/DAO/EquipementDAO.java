package DAO;

import Entity.Equipement;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class EquipementDAO extends AbstractDAO<Equipement> {
    public EquipementDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Equipement getEquipement(int id){
        return get(id);
    }

    public Equipement addEquipement(Equipement equipement){
        return persist(equipement);
    }

    public List<Equipement> getEquipements(){
        return list(currentSession().createQuery("SELECT e FROM Equipement e"));
    }

    public String deleteEquipements(int id){
        Equipement equipementDele = getEquipement(id);
        currentSession().delete(equipementDele);
        return "Delete book with sucess";
    }

    public String updateEquipement(Equipement equipement){
        currentSession().update(equipement);
        return "Update book with sucess";
    }
}
