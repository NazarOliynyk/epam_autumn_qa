package db;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class DbConfiguration {

    private SessionFactory sessionFactory;
    private Session manager;

    public void setConfiguration(){

        Configuration configuration = new Configuration().configure();
        configuration
                .addAnnotatedClass(FAQitem.class);

        sessionFactory= configuration.buildSessionFactory();
        manager = sessionFactory.openSession();
        manager.beginTransaction();
    }

    void save(FAQitem faQitem){
        //manager.beginTransaction();
        manager.save(faQitem);
        //manager.getTransaction().commit();
    }

    public List<FAQitem> findAll(){

        return  manager.createQuery("select u from FAQitem u", FAQitem.class).list();
    }

    void quitConfiguration(){
        manager.getTransaction().commit();
        manager.close();
        sessionFactory.close();
    }
}
