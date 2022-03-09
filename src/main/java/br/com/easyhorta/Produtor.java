package br.com.easyhorta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produtor")
public class Produtor {
    
    @Id
    @SequenceGenerator(name = "produtor", sequenceName = "sq_tb_produtor" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtor")
    @Column(name = "id_produtor")
    private Integer id;

    @Column(name = "nm_Produtor", length = 50)
    private String nome;

    //Mapeamento bidirecional com Endereco
    @OneToOne(mappedBy = "produtor")
    private Endereco endereco;

    @OneToOne(mappedBy = "produtor")
    private Email email;

    //BIDIRECIONAL COM PEDIDO
    @OneToMany(mappedBy = "produtor")
    private List<Pedido> pedidos;
    
    //BIDIRECIONAL COM SERVICO
    @OneToMany(mappedBy = "produtor")
    private List<Servico> servicos;

    //BIDIRECIONAL COM TELEFONE
    @OneToMany(mappedBy = "produtor")
    private List<Telefone> telefones;

    //Relacionamento dos produtos
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_produtor"),
    inverseJoinColumns = @JoinColumn(name = "id_produto"),
    name = "tb_produtor_produto")
    private List<Produto> produtos;
    
    // --- Constructor
    /**
     * @param nome
     */
    public Produtor(String nome) {
        this.nome = nome;
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

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    
    public List<Telefone> getTelefones() {
        return this.telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

}
