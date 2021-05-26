package org.orakris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Insurance insurance = new Insurance();
        insurance.setId(9);
        insurance.setName("House insurance policy");
        insurance.setAmount(100000);
        insurance.setTenure(50);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Insurance.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(reg);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(insurance);
        tx.commit();
    }
}
