package br.com.easyhorta;

import javax.persistence.*;

@Entity
@Table(name = "tb_email")
public class Email {

    @Id
    @SequenceGenerator(name = "email", sequenceName = "sq_tb_email", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email")
    @Column(name = "id_email")
    private Integer idEmail;

    @Column(name = "ds_email")
    private String dsEmail;

    //Relacionamentos 
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "id_produtor")
    private Produtor idProdutor;

    // --- Constructor
    /**
     * @param dsEmail
     */
    public Email(String dsEmail) {
        this.dsEmail = dsEmail;
    }
    
    // --- Getters & Setters
    public Integer getIdEmail() {
        return this.idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getDsEmail() {
        return this.dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }
    
    public Cliente getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Produtor getIdProdutor() {
        return this.idProdutor;
    }

    public void setIdProdutor(Produtor idProdutor) {
        this.idProdutor = idProdutor;
    }
}
