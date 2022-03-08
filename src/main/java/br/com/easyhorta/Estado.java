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
    private Integer idEstado;

    @Column(name = "nm_estado", length = 30)
    private String nmEstado;

    // --- Constructor
    /**
     * @param nmEstado
     */
    public Estado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    // --- Getters & Setters
    public Integer getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNmEstado() {
        return this.nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    
}
