package br.com.easyhorta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    @OneToMany
    @JoinColumn(name = "id_cliente")
    private List<Cliente> clientes;

    @OneToMany
    @JoinColumn(name = "id_produtor")
    private List<Produtor> produtores;

    // --- Constructor
    /**
     * @param ddd
     * @param telefone
     */
    public Telefone(Integer ddd, Integer telefone) {
        this.ddd = ddd;
        this.telefone = telefone;
    }

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
    
    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Produtor> getProdutores() {
        return this.produtores;
    }

    public void setProdutores(List<Produtor> produtores) {
        this.produtores = produtores;
    }
}
