package br.com.easyhorta;

import javax.persistence.*;

@Entity
@Table(name = "tb_cidade")
public class Cidade {

    @Id
    @SequenceGenerator(name = "cidade", sequenceName = "sq_tb_cidade", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cidade")
    @Column(name = "id_cidade")
    private Integer idCidade;

    @Column(name = "nm_cidade")
    private String nmCidade;

    //Relacionamentos
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado idEstado;

    // --- Constructor
    /**
     * @param nmCidade
     */
    public Cidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    // --- Getters & Setters
    public Integer getIdCidade() {
        return this.idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNmCidade() {
        return this.nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public Estado getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

}
