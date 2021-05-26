package org.orakris;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    private static void insert(int id, String name, int amount, int tenure, Session session) {
        Transaction transaction = session.beginTransaction();
        Insurance insurance = new Insurance();
        insurance.setId(id);
        insurance.setName(name);
        insurance.setAmount(amount);
        insurance.setTenure(tenure);
        session.save(insurance);
        transaction.commit();
    }
    private static void retrieve(int id, Session session) {
        Insurance insurance = session.get(Insurance.class, id);
        System.out.println(insurance);
    }
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Insurance.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(reg);
        Session session = sessionFactory.openSession();

        boolean exit = false;
        while (!exit) {
            System.out.print("Select\n1.Insert\n2.Retrieve\n3.Update\n4.Delete\n0.Exit\n");
            int option = Integer.parseInt(br.readLine());
            int id;
            switch (option) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    System.out.print("Enter policy number: ");
                    id = Integer.parseInt(br.readLine());
                    System.out.print("Enter the policy name: ");
                    String name = br.readLine();
                    System.out.print("Enter the amount: ");
                    int amount = Integer.parseInt(br.readLine());
                    System.out.print("Enter the tenure: ");
                    int tenure = Integer.parseInt(br.readLine());
                    insert(id, name, amount, tenure, session);
                    break;
                case 2:
                    System.out.print("Enter the policy number: ");
                    id = Integer.parseInt(br.readLine());
                    retrieve(id, session);
                    break;
            }
        }

    }
}
