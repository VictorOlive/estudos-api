package br.com.easyhorta;

import javax.persistence.*;

@Entity
@Table(name = "tb_bairro")
public class Bairro {

    @Id
    @SequenceGenerator(name = "bairro", sequenceName = "sq_tb_bairro" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bairro")
    @Column(name = "id_bairro")
    private Integer idBairro;

    @Column(name = "nm_bairro", length = 30)
    private String nmBairro;

    //Relacionamentos
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade idCidade;

    // --- Constructor
    /**
     * @param nmBairro
     */
    public Bairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    // --- Getters & Setters
    public Integer getIdBairro() {
        return this.idBairro;
    }

    public void setIdBairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public String getNmBairro() {
        return this.nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public Cidade getIdCidade() {
        return this.idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
    }
    
}
