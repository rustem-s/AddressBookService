package me.pio.addressbook.service.ejb;

import me.pio.addressbook.service.domain.Person;

import java.util.List;

/**
 * Created by Rustem.Saidaliyev on 22.11.2015.
 */
public interface AddressBookManagement {

    public List<Person> getPersonList();

    public Person create(Person person);
}
