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
    private Integer idCliente;

    @Column(name = "nm_cliente", length = 70, nullable = false)
    private String nmCliente;

    @Column(name = "nr_cpf", length = 11)
    private String nrCpf;

    //Mapeamento bidirecional com Endereco
    @OneToOne(mappedBy = "idCliente")
    private Endereco endereco;

    @OneToOne(mappedBy = "idCliente")
    private Email email;

    //Relacionamento
    @OneToMany
    @JoinColumn(name = "id_pedido")
    private List<Pedido> pedidos;
    
    // --- Constructor
    /**
     * @param nmCliente
     * @param nrCpf
     */
    public Cliente(String nmCliente, String nrCpf) {
        this.nmCliente = nmCliente;
        this.nrCpf = nrCpf;
    }

    // --- Getters & Setters
    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNmCliente() {
        return this.nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getNrCpf() {
        return this.nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
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
