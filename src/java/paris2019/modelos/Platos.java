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
public class Platos {
    private int id_plato;
   private String clasificacion;
    private String descripcion;
    private int precio;
    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
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

    public Platos(int id_plato, String clasificacion, String descripcion, int precio) {
        this.id_plato = id_plato;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
        this.precio = precio;
    }
   public Platos() {
        
    }
}
