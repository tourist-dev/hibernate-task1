package org.orakris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Insurance insurance = new Insurance();
        insurance.setId(1);
        insurance.setName("vehicle policy");
        insurance.setAmount(100000);
        insurance.setTenure(10);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Insurance.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(insurance);
        tx.commit();
    }
}
