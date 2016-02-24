package br.com.xyinc.xyincgps.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	public static EntityManager getEntityManager() throws Throwable{
		try {
			factory = Persistence.createEntityManagerFactory("xyincgps");
			em = factory.createEntityManager();
			
			return em;
		} catch (Throwable t) {
			t.printStackTrace();
			throw new Throwable(t);
		}
	}

}
