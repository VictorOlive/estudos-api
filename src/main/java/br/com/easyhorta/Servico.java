package br.com.easyhorta;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name = "tb_servico")
public class Servico {

    @Id
    @SequenceGenerator(name = "servico", sequenceName = "sq_tb_servico", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico")
    @Column(name = "id_servico")
    private Integer idServico;

    @Column(name = "nm_servico", length = 100)
    private String nmServico;

    @Column(name = "ds_servico", length = 1000)
    private String dsServico;

    @Column(name = "dt_hr_servico")
    private LocalDate dtHrServico;

    @Column(name = "vl_servico")
    private Float vlServico;

    //Relacionamentos
    @ManyToOne
    @JoinColumn(name = "id_produtor")
    private Produtor idProdutor;

    // --- Constructor
    /**
     * @param nmServico
     * @param dsServico
     * @param dtHrServico
     * @param vlServico
     */
    public Servico(String nmServico, String dsServico, LocalDate dtHrServico, Float vlServico) {
        this.nmServico = nmServico;
        this.dsServico = dsServico;
        this.dtHrServico = dtHrServico;
        this.vlServico = vlServico;
    }
    
    // --- Getters & Setters    
    public Integer getIdServico() {
        return this.idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public String getNmServico() {
        return this.nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public String getDsServico() {
        return this.dsServico;
    }

    public void setDsServico(String dsServico) {
        this.dsServico = dsServico;
    }

    public LocalDate getDtHrServico() {
        return this.dtHrServico;
    }

    public void setDtHrServico(LocalDate dtHrServico) {
        this.dtHrServico = dtHrServico;
    }

    public Float getVlServico() {
        return this.vlServico;
    }

    public void setVlServico(Float vlServico) {
        this.vlServico = vlServico;
    }

    public Produtor getIdProdutor() {
        return this.idProdutor;
    }

    public void setIdProdutor(Produtor idProdutor) {
        this.idProdutor = idProdutor;
    }
    
}
