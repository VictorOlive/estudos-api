package br.com.easyhorta;

import javax.persistence.*;

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

    @Column(name = "nr_cpf", length = 8)
    private Integer nrCpf;

    //Mapeamento bidirecional com Endereco
    @OneToOne(mappedBy = "idCliente")
    private Endereco endereco;

    @OneToOne(mappedBy = "idCliente")
    private Email email;
    
    // --- Constructor
    /**
     * @param nmCliente
     * @param nrCpf
     */
    public Cliente(String nmCliente, Integer nrCpf) {
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

    public Integer getNrCpf() {
        return this.nrCpf;
    }

    public void setNrCpf(Integer nrCpf) {
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
}