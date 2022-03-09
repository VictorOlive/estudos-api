package br.com.easyhorta;

import java.util.List;

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
    private Integer id;

    @Column(name = "nr_endereco")
    private Integer numero;

    @Column(name = "ds_complemento", length = 100)
    private Integer descricao;

    //Relacionamentos
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_produtor")
    private Produtor produtor;

    @ManyToOne
    @JoinColumn(name = "id_bairro")
    private List<Bairro> bairros;

    // --- Constructor
    /**
     * @param numero
     * @param descricao
     */
    public Endereco(Integer numero, Integer descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }
    
    // --- Getters & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getDescricao() {
        return this.descricao;
    }

    public void setDescricao(Integer descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Bairro> getBairros() {
        return this.bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }

    public Produtor getProdutor() {
        return this.produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
}
