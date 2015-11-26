package me.pio.addressbook.service.ejb;

import me.pio.addressbook.service.domain.AddressBookServiceException;
import me.pio.addressbook.service.domain.Person;

import java.util.List;

/**
 * Created by Rustem.Saidaliyev on 22.11.2015.
 */
public interface AddressBookManagement {

    public List<Person> getPersonList();

    public Person createPerson(Person person);

    public Person findPersonById(Long id) throws AddressBookServiceException;

    public void deletePersonById(Long id) throws AddressBookServiceException;

    public Person updatePerson(Long id, Person person) throws AddressBookServiceException;
}
