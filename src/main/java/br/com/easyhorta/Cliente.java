package br.com.easyhorta;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @SequenceGenerator(name = "cliente", sequenceName = "sq_tb_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "nm_cliente", length = 70, nullable = false)
    private String nome;

    @Column(name = "nr_cpf", length = 11)
    private String cpf;

    // Mapeamento bidirecional com Endereco
    @OneToOne(mappedBy = "cliente" )
    private Endereco endereco;

    // BIDIRECIONAL COM TELEFONE
    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.ALL})
    private List<Telefone> telefones;

    // Relacionamento com pedidos
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;


    public Cliente(Integer id, String email, String nome, String cpf, Endereco endereco, List<Telefone> telefones,
            List<Pedido> pedidos) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefones = telefones;
        this.pedidos = pedidos;
    }

    public Cliente() {
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

    public List<Telefone> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", email=" + email + ", endereco=" + endereco + ", id=" + id + ", nome=" + nome
                + ", telefones=" + telefones + "]";
    }
}
