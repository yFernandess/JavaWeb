package br.com.JavaWeb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = createSessionFactory();

	public static SessionFactory getFabricaDeSessoes() {

		return sessionFactory;

	}
	
	public static SessionFactory createSessionFactory() {

		try {

			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		} catch (Throwable error) {

			System.err.println("Session factory could not be initialized" + error);

			throw new ExceptionInInitializerError(error);

		}

	}

}