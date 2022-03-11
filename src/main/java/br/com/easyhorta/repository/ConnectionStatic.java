package br.com.easyhorta.repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ConnectionStatic {
	private static EntityManager em = null;

	public static EntityManager getInstace() {

		if (em == null) {
			em = Persistence.createEntityManagerFactory("easyhorta").createEntityManager();
		}
		return em;

	}
}
