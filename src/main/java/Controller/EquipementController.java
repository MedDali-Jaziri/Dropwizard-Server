package Controller;

import DAO.EquipementDAO;
import Entity.Equipement;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("equipementService")
@Produces(MediaType.APPLICATION_JSON)
public class EquipementController {
    private final EquipementDAO equipementDAO;

    public EquipementController(EquipementDAO equipementDAO) {
        this.equipementDAO = equipementDAO;
    }

    @GET
    @Path("/getEquipement")
    @UnitOfWork
    public Equipement getEquipement(@QueryParam("equipementID")int equipementID){
        return this.equipementDAO.getEquipement(equipementID);
    }

    @GET
    @Path("/getEquipements")
    @UnitOfWork
    public List<Equipement> getEquipements(){
        return this.equipementDAO.getEquipements();
    }

    @POST
    @Path("/addEquipement")
    @UnitOfWork
    public int addEquipement(
            @Valid Equipement equipement
    ){
        return this.equipementDAO.addEquipement(equipement).getId();
    }

    @DELETE
    @Path("/deleteEquipement")
    @UnitOfWork
    public String deleteEquipement(@QueryParam("equipementID") int equipementID){
        return this.equipementDAO.deleteEquipements(equipementID);
    }

    @POST
    @Path("/updateEquipement")
    @UnitOfWork
    public String updateEquipement(@Valid Equipement equipement){
        return this.equipementDAO.updateEquipement(equipement);
    }
}
