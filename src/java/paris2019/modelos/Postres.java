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
public class Postres {
        private int id_postre;
   private String clasificacion;
 private String descripcion;
    private int precio;
    public Postres(int id_postre, String clasificacion, String descripcion, int precio) {
        this.id_postre = id_postre;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId_postre() {
        return id_postre;
    }

    public void setId_postre(int id_postre) {
        this.id_postre = id_postre;
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
    public Postres(){
        
    }

}
