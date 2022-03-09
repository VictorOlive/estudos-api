package br.com.easyhorta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bairro")
public class Bairro {

    @Id
    @SequenceGenerator(name = "bairro", sequenceName = "sq_tb_bairro" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro")
    @Column(name = "id_bairro")
    private Integer id;

    @Column(name = "nm_bairro", length = 30)
    private String nome;

    //Relacionamentos
    @OneToMany
    @JoinColumn(name = "id_cidade")
    private List<Cidade> cidades;

    // --- Constructor
    /**
     * @param nome
     */
    public Bairro(String nome) {
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

    public List<Cidade> getCidades() {
        return this.cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
