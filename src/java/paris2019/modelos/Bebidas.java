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
public class Bebidas {
        private int id_bebida;
   private String clasificacion;
    private String descripcion;
    private int precio;
 public Bebidas() {
        
    }
    public Bebidas(int id_bebida, String clasificacion, String descripcion, int precio) {
        this.id_bebida = id_bebida;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(int id_bebida) {
        this.id_bebida = id_bebida;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
