package com.kelver.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	private static EntityManagerFactory EMF = null;
	
	public static EntityManager getEntityManager() {
		if (EMF == null) {
			EMF = Persistence.createEntityManagerFactory("default-jpa");
		}
		
		return EMF.createEntityManager();
	}

}
