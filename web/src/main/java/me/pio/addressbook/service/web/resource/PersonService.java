package me.pio.addressbook.service.web.resource;

import me.pio.addressbook.service.domain.AddressBookServiceException;
import me.pio.addressbook.service.domain.Person;
import me.pio.addressbook.service.ejb.AddressBookManagement;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Rustem.Saidaliyev on 21.11.2015.
 */
@Path("/person")
@Produces({MediaType.APPLICATION_JSON})
public class PersonService {

    @EJB(name = "AddressBookManagementEJB")
    private AddressBookManagement addressBookManagementEJB;

    @Path("/list")
    @GET
    public List<Person> list() throws Exception{

        List<Person> personList = addressBookManagementEJB.getPersonList();

        return personList;
    }

    @Path("/create")
    @PUT
    public Person create(Person person) throws Exception{

        person = addressBookManagementEJB.createPerson(person);

        return person;
    }

    @Path("/show/{id}")
    @GET
    public Person find(@PathParam("id") long id) throws AddressBookServiceException {

        Person person = addressBookManagementEJB.findPersonById(id);

        return person;
    }

    @Path("/delete/{id}")
    @DELETE
    public void delete(@PathParam("id") long id) throws AddressBookServiceException {

        addressBookManagementEJB.deletePersonById(id);

    }

    @Path("/update")
    @POST
    public void update(Person person) throws AddressBookServiceException {

        addressBookManagementEJB.updatePerson(person);

    }
}
