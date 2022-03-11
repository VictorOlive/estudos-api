package br.com.easyhorta.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.easyhorta.Cliente;

public class ClienteDAO {

	private EntityManager connection;

	public ClienteDAO(EntityManager connection) {
		this.connection = connection;
	}

	public Cliente creater(Cliente cliente) {

		try {

			this.connection.persist(cliente);

			return cliente;

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public Cliente getById(Integer id) {
		try {

			Cliente cliente = this.connection.find(Cliente.class, id);

			return cliente;

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> getAll() {
		try {

			Query createQuery = this.connection.createQuery("FROM " + Cliente.class.getName());
			List<Cliente> clientes = createQuery.getResultList();

			return clientes;

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	public Cliente update(Cliente cliente) {
		try {

			this.connection.merge(cliente);

			return cliente;

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

			Cliente cliente = this.getById(id);
			this.connection.remove(cliente);

		} catch (Exception e) {
			if (this.connection.getTransaction().isActive()) {
				this.connection.getTransaction().rollback();
			}
			e.printStackTrace();
		}
	}
}
