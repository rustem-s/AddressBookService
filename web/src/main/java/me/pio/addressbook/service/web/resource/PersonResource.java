package me.pio.addressbook.service.web.resource;

import me.pio.addressbook.service.domain.Person;
import me.pio.addressbook.service.ejb.AddressBookManagement;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Rustem.Saidaliyev on 21.11.2015.
 */
@Path("/person")
public class PersonResource {

    @EJB(name = "AddressBookManagementEJB")
    private AddressBookManagement addressBookManagementEJB;

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Person> getPersonList() throws Exception{

        List<Person> personList = addressBookManagementEJB.getPersonList();

        return personList;
    }

}
