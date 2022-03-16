package br.com.easyhorta.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.easyhorta.Telefone;

public class TelefoneDAO {

	private EntityManager connection;

	public TelefoneDAO(EntityManager connection) {
		this.connection = connection;
	}

	public Telefone creater(Telefone telefone) {

		try {

			this.connection.persist(telefone);

			return telefone;

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public Telefone getById(Integer id) {
		try {

			Telefone telefone = this.connection.find(Telefone.class, id);

			return telefone;

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Telefone> getAll() {
		try {

			Query createQuery = this.connection.createQuery("FROM " + Telefone.class.getName());
			List<Telefone> telefones = createQuery.getResultList();

			return telefones;

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public Telefone update(Telefone telefone) {
		try {

			this.connection.merge(telefone);

			return telefone;

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public void remove(Integer id) {
		try {
			Telefone telefone = this.getById(id);
			this.connection.remove(telefone);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
