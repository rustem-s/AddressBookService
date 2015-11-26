package me.pio.addressbook.service.ejb;

import me.pio.addressbook.service.domain.AddressBookServiceException;
import me.pio.addressbook.service.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Rustem.Saidaliyev on 21.11.2015.
 */
@Stateless(name = "AddressBookManagementEJB")
public class AddressBookManagementBean implements AddressBookManagement {

    public AddressBookManagementBean() {
    }

    public List<Person> getPersonList() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        final Session session = sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();;
        session.close();

        return personList;

    }

    @Override
    public Person createPerson(Person person) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        final Session session = sessionFactory.openSession();
        session.beginTransaction();

        Long id = (Long)session.save(person);
        person.setId(id);

        session.getTransaction().commit();

        session.close();

        return person;
    }

    @Override
    public Person findPersonById(Long id) throws AddressBookServiceException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Person person = (Person) session.get(Person.class, id);

        if (person == null)
            throw new AddressBookServiceException(String.format("Person by id %s not found", id));

        session.close();

        return person;
    }

    @Override
    public void deletePersonById(Long id) throws AddressBookServiceException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person person = (Person) session.get(Person.class, id);

        if (person == null)
            throw new AddressBookServiceException(String.format("Person by id %s not found", id));

        session.delete(person);

        session.getTransaction().commit();

        session.close();
    }

    @Override
    public Person updatePerson(Long id, Person person) throws AddressBookServiceException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Person targetPerson = (Person) session.get(Person.class, id);

        if (targetPerson == null)
            throw new AddressBookServiceException(String.format("Person by id %s not found", person.getId()));

        person.setId(id);

        session.merge(person);

        session.getTransaction().commit();

        session.close();

        return person;
    }

}
