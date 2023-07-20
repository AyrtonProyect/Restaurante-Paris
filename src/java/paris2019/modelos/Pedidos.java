/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paris2019.modelos;

/**
 *
 * @author Antony_99
 */
    
public class Pedidos {
private int id_cliente;
    private int cedula_cliente;
    private int total;
    private int nropedido;
    private String fecha;
  public Pedidos(int id_cliente, int cedula_cliente, int total, int nropedido, String fecha) {
        this.id_cliente = id_cliente;
        this.cedula_cliente = cedula_cliente;
      
        this.total = total;
        this.nropedido = nropedido;
        this.fecha = fecha;
    }
    public Pedidos() {
        
    }
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(int cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNropedido() {
        return nropedido;
    }

    public void setNropedido(int nropedido) {
        this.nropedido = nropedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
}
