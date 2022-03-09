package br.com.easyhorta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @SequenceGenerator(name = "cliente", sequenceName = "sq_tb_cliente" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "nm_cliente", length = 70, nullable = false)
    private String nome;

    @Column(name = "nr_cpf", length = 11)
    private String cpf;

    //Mapeamento bidirecional com Endereco
    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;

    @OneToOne(mappedBy = "cliente")
    private Email email;

    //@OneToMany(mappedBy = "id_telefone")
    //private Telefone telefone;

    //Relacionamento
    @OneToMany
    @JoinColumn(name = "id_pedido")
    private List<Pedido> pedidos;
    
    // --- Constructor
    /**
     * @param nome
     * @param cpf
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // --- Getters & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
