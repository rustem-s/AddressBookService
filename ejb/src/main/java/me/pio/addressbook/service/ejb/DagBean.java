package me.pio.addressbook.service.ejb;

import me.pio.addressbook.service.domain.Common;

import javax.ejb.Stateless;

/**
 * Created by Rustem.Saidaliyev on 22.11.2015.
 */
@Stateless(name = "DagEJB")
public class DagBean implements Dag {
    public DagBean() {
    }

    @Override
    public String sayHey() {
        Common common = new Common();
        return "EJB says hey. Via EJB: " + common.sayHey();
    }
}
