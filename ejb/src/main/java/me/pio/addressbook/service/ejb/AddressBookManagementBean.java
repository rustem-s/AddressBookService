package me.pio.addressbook.service.ejb;

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
    public Person create(Person person) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        final Session session = sessionFactory.openSession();
        session.beginTransaction();

        Long id = (Long)session.save(person);
        person.setId(id);

        session.getTransaction().commit();

        session.close();

        return person;
    }


}
