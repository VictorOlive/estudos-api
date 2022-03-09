package br.com.easyhorta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_email")
public class Email {

    @Id
    @SequenceGenerator(name = "email", sequenceName = "sq_tb_email", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email")
    @Column(name = "id_email")
    private Integer id;

    @Column(name = "ds_email")
    private String email;

    //Relacionamentos 
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_produtor")
    private Produtor produtor;

    // --- Constructor
    /**
     * @param email
     */
    public Email(String email) {
        this.email = email;
    }
    
    // --- Getters & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produtor getProdutor() {
        return this.produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
}
