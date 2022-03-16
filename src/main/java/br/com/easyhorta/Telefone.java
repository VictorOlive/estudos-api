package br.com.easyhorta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_telefone")
public class Telefone {
    
    @Id
    @SequenceGenerator(name = "telefone", sequenceName = "sq_tb_telefone", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone")
    @Column(name = "id_telefone")
    private Integer id;

    @Column(name = "nr_ddd")
    private Integer ddd;

    @Column(name = "nr_telefone")
    private Integer telefone;

    //Relacionamentos
    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Produtor produtor;



    public Telefone(Integer id, Integer ddd, Integer telefone, Cliente cliente, Produtor produtor) {
        this.id = id;
        this.ddd = ddd;
        this.telefone = telefone;
        this.cliente = cliente;
        this.produtor = produtor;
    }

    public Telefone() {}


    // --- Getters & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDdd() {
        return this.ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getTelefone() {
        return this.telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
    
    public Produtor getProdutor() {
        return this.produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Telefone [ ddd=" + ddd + ", id=" + id + ", telefone="
                + telefone + "]";
    }
}
