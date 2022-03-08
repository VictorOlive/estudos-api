package br.com.easyhorta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private Integer idTelefone;

    @Column(name = "nr_ddd")
    private Integer nrDdd;

    @Column(name = "nr_telefone")
    private Integer nr_telefone;

    //Relacionamentos
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "id_produtor")
    private Produtor idProdutor;

    // --- Constructor
    /**
     * @param nrDdd
     * @param nr_telefone
     */
    public Telefone(Integer nrDdd, Integer nr_telefone) {
        this.nrDdd = nrDdd;
        this.nr_telefone = nr_telefone;
    }

    // --- Getters & Setters
    public Integer getIdTelefone() {
        return this.idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public Integer getNrDdd() {
        return this.nrDdd;
    }

    public void setNrDdd(Integer nrDdd) {
        this.nrDdd = nrDdd;
    }

    public Integer getNr_telefone() {
        return this.nr_telefone;
    }

    public void setNr_telefone(Integer nr_telefone) {
        this.nr_telefone = nr_telefone;
    }
    
    public Cliente getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
    
        public Produtor getIdProdutor() {
        return this.idProdutor;
    }

    public void setIdProdutor(Produtor idProdutor) {
        this.idProdutor = idProdutor;
    }
}
