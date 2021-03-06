package br.com.easyhorta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
public class Cidade {

    @Id
    @SequenceGenerator(name = "cidade", sequenceName = "sq_tb_cidade", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade")
    @Column(name = "id_cidade")
    private Integer id;

    @Column(name = "nm_cidade")
    private String nome;


    //Relacionamento com Bairro
    @ManyToOne
    @JoinColumn(name = "id_bairro")
    private Bairro bairro;

    //BIDIRECIONAL COM ESTADO
    @OneToMany(mappedBy = "cidade")
    private List<Estado> estados;

    // --- Constructor
    /**
     * @param nome
     */
    public Cidade(String nome) {
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

    public Bairro getBairro() {
        return this.bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
}
