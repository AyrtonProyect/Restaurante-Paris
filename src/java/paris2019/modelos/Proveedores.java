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
public class Proveedores {
    private int id_prov;
    private String nombre_prov;
    
    private String ruc_prov;
    private String descrip_prov;
    private String direccion_prov;
    private int telefono_prov;
    private String correo_prov;
    public Proveedores(int id_prov, String nombre_prov, String descrip_prov, String ruc_prov, String direccion_prov, int telefono_prov, String correo_prov) {
        this.id_prov = id_prov;
        this.nombre_prov = nombre_prov;
        this.descrip_prov = descrip_prov;
        this.ruc_prov = ruc_prov;
        this.direccion_prov = direccion_prov;
        this.telefono_prov = telefono_prov;
        this.correo_prov = correo_prov;
    }

 public Proveedores() {
        
    }
   public String getDescrip_prov() {
        return descrip_prov;
    }

    public void setDescrip_prov(String descrip_prov) {
        this.descrip_prov = descrip_prov;
    }
    public void setDireccion_prov(String direccion_prov) {
        this.direccion_prov = direccion_prov;
    }

    public void setTelefono_prov(int telefono_prov) {
        this.telefono_prov = telefono_prov;
    }

    public void setCorreo_prov(String correo_prov) {
        this.correo_prov = correo_prov;
    }

    public String getDireccion_prov() {
        return direccion_prov;
    }

    public int getTelefono_prov() {
        return telefono_prov;
    }

    public String getCorreo_prov() {
        return correo_prov;
    }


    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public void setNombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }

    public void setRuc_prov(String ruc_prov) {
        this.ruc_prov = ruc_prov;
    }

 

    public int getId_prov() {
        return id_prov;
    }

    public String getNombre_prov() {
        return nombre_prov;
    }

    public String getRuc_prov() {
        return ruc_prov;
    }


   

  
}
