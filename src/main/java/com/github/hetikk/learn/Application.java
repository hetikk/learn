package com.github.hetikk.learn;

import org.hibernate.Session;

public class Application {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();

    }

}
