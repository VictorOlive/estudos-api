package br.com.easyhorta;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_produtor")
public class Produtor {
    
    @Id
    @SequenceGenerator(name = "produtor", sequenceName = "sq_tb_produtor" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtor")
    @Column(name = "id_produtor")
    private Integer idProdutor;

    @Column(name = "nm_Produtor", length = 50)
    private String nmProdutor;

    //Mapeamento bidirecional com Endereco
    @OneToOne(mappedBy = "idProdutor")
    private Endereco endereco;

    //Relacionamento dos produtos
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_produtor"),
    inverseJoinColumns = @JoinColumn(name = "id_produto"),
    name = "tb_produtor_produto")
    private List<Produto> produtos;
    
    // --- Constructor
    /**
     * @param nmProdutor
     */
    public Produtor(String nmProdutor) {
        this.nmProdutor = nmProdutor;
    }

    // --- Getters & Setters
    public Integer getIdProdutor() {
        return this.idProdutor;
    }

    public void setIdProdutor(Integer idProdutor) {
        this.idProdutor = idProdutor;
    }

    public String getNmProdutor() {
        return this.nmProdutor;
    }

    public void setNmProdutor(String nmProdutor) {
        this.nmProdutor = nmProdutor;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
