package br.com.easyhorta;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.easyhorta.repository.ClienteDAO;
import br.com.easyhorta.repository.ConnectionStatic;
import br.com.easyhorta.repository.TelefoneDAO;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = ConnectionStatic.getInstace();

		ClienteDAO clienteDAO = new ClienteDAO(em);
		TelefoneDAO telefoneDAO = new TelefoneDAO(em);

		Telefone telefone = new Telefone(null, 11, 1, null, null);
		Telefone telefone2 = new Telefone(null, 11, 2, null, null);
		Telefone telefone3 = new Telefone(null, 11, 3, null, null);

		List<Telefone> telefones = new ArrayList<>();
		telefones.add(telefone);
		telefones.add(telefone2);
		telefones.add(telefone3);

		Cliente cliente = new Cliente(null, "email", "nome", "0", null, telefones, null);
		telefone.setCliente(cliente);
		telefone2.setCliente(cliente);
		telefone3.setCliente(cliente);
		cliente.setTelefones(telefones);



		try {
			em.getTransaction().begin();
			clienteDAO.creater(cliente);
			
			em.getTransaction().commit();

			em.getTransaction().begin();
			Cliente cliente5 = clienteDAO.getById(1);
			em.getTransaction().commit();

			System.out.println(cliente5);

			em.getTransaction().begin();
			Telefone telefone4 = cliente5.getTelefones().get(0);
			telefone4.setTelefone(4);
			telefoneDAO.update(telefone4);
			em.getTransaction().commit();

			em.getTransaction().begin();
			Cliente cliente6 = clienteDAO.getById(1);
			em.getTransaction().commit();

			System.out.println(cliente6);

			em.getTransaction().begin();
			clienteDAO.remove(1);
			em.getTransaction().commit();

			em.getTransaction().begin();
			Cliente cliente7 = clienteDAO.getById(1);
			em.getTransaction().commit();

			System.out.println(cliente7);


		} catch (Exception e) {

			System.out.println(e);
			e.printStackTrace();
		}

		em.close();
	}

}
