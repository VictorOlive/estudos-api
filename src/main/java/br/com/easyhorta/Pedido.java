package br.com.easyhorta;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
    
    @Id
    @SequenceGenerator(name = "pedido", sequenceName = "sq_tb_pedido" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "vl_pedido")
    private Float vlPedido;

    @Column(name = "qt_pedido")
    private Integer qtPedido;

    @Column(name = "dt_hr_pedido")
    private LocalDateTime dtHrPedido = LocalDateTime.now();

    @Column(name = "ds_pedido")
    private String dsPedido;

    //Relacionamento com Produtor
    @ManyToOne
    @JoinColumn(name = "id_produtor")
    private Produtor idProdutor;

    //Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // --- Constructor
    /**
     * @param vlPedido
     * @param qtPedido
     * @param dtHrPedido
     * @param dsPedido
     */
    public Pedido(Float vlPedido, Integer qtPedido, String dsPedido, Cliente cliente) {
        this.vlPedido = vlPedido;
        this.qtPedido = qtPedido;
        this.dsPedido = dsPedido;
        this.cliente = cliente;
    }
    
    // --- Getters & Setters
    public Integer getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Float getVlPedido() {
        return this.vlPedido;
    }

    public void setVlPedido(Float vlPedido) {
        this.vlPedido = vlPedido;
    }

    public Integer getQtPedido() {
        return this.qtPedido;
    }

    public void setQtPedido(Integer qtPedido) {
        this.qtPedido = qtPedido;
    }

    public LocalDateTime getDtHrPedido() {
        return this.dtHrPedido;
    }

    public void setDtHrPedido(LocalDateTime dtHrPedido) {
        this.dtHrPedido = dtHrPedido;
    }

    public String getDsPedido() {
        return this.dsPedido;
    }

    public void setDsPedido(String dsPedido) {
        this.dsPedido = dsPedido;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
