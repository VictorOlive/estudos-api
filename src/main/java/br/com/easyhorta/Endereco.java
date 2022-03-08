package br.com.easyhorta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @SequenceGenerator(name = "endereco", sequenceName = "sq_tb_endereco" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column(name = "nr_endereco")
    private Integer nrEndereco;

    @Column(name = "ds_complemento", length = 100)
    private Integer ds_complemento;

    //Relacionamentos
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @OneToOne
    @JoinColumn(name = "id_produtor")
    private Produtor idProdutor;

    @ManyToOne
    @JoinColumn(name = "id_bairro")
    private Bairro idBairro;

    // --- Constructor
    /**
     * @param nrEndereco
     * @param ds_complemento
     */
    public Endereco(Integer nrEndereco, Integer ds_complemento) {
        this.nrEndereco = nrEndereco;
        this.ds_complemento = ds_complemento;
    }
    
    // --- Getters & Setters
    public Integer getIdEndereco() {
        return this.idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getNrEndereco() {
        return this.nrEndereco;
    }

    public void setNrEndereco(Integer nrEndereco) {
        this.nrEndereco = nrEndereco;
    }

    public Integer getDs_complemento() {
        return this.ds_complemento;
    }

    public void setDs_complemento(Integer ds_complemento) {
        this.ds_complemento = ds_complemento;
    }

    public Cliente getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Bairro getIdBairro() {
        return this.idBairro;
    }

    public void setIdBairro(Bairro idBairro) {
        this.idBairro = idBairro;
    }

    public Produtor getIdProdutor() {
        return this.idProdutor;
    }

    public void setIdProdutor(Produtor idProdutor) {
        this.idProdutor = idProdutor;
    }
}
