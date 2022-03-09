package br.com.easyhorta;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em = Persistence.createEntityManagerFactory("easyhorta").createEntityManager();

			Cliente victor = new Cliente("Victor", "12345678910");

            em.getTransaction().begin();
			em.persist(victor);
			
			Pedido batata = new Pedido(2.5f, 1, "batata" , victor);
			em.persist(batata);

            em.getTransaction().commit();

		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally{
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
    }
    
}
