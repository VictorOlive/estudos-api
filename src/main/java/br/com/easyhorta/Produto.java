package br.com.easyhorta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "produto", sequenceName = "sq_tb_produto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nm_produto")
    private String nmProduto;

    //Mapeamento bidirecional
    @ManyToMany(mappedBy = "produtos")
    private List<Produtor> produtores;

    // --- Constructor
    /**
     * @param nmProduto
     */
    public Produto(String nmProduto) {
        this.nmProduto = nmProduto;
    }
    
    // --- Getters & Setters
    public Integer getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNmProduto() {
        return this.nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }
    
    public List<Produtor> getProdutores() {
        return this.produtores;
    }

    public void setProdutores(List<Produtor> produtores) {
        this.produtores = produtores;
    }
}
