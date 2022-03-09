package br.com.easyhorta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estado")
public class Estado {

    @Id
    @SequenceGenerator(name = "estado", sequenceName = "sq_tb_estado", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado")
    @Column(name = "id_estado")
    private Integer id;

    @Column(name = "nm_estado", length = 30)
    private String nome;

    // --- Constructor
    /**
     * @param nome
     */
    public Estado(String nome) {
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

    
}
