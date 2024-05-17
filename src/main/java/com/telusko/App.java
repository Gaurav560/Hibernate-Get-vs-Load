package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App {
    public static void main(String[] args)  {

        // creating session object

        Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionfactory = con.buildSessionFactory(reg);
        System.out.println(sessionfactory);
        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();



        //load gives proxy object.it will not give original object un-till that object is used somewhere in the project.
        //where as save method gives actual object.save throw a null when the object is not present where as load
        //throws object not found exception .

//Laptop lap=session.get(Laptop.class,1);
Laptop lap=session.load(Laptop.class,101);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lap);

             tx.commit();


    }
}
