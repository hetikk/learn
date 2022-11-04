package com.github.hetikk.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static String confFile = "resources/hibernate.cfg.xml";

    private static SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

}
