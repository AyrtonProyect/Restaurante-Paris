
package paris2019.modelos;

public class Clientes {
  
        private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String direccion_cliente;
    private int telefono_cliente;

    public int getTelefono_cliente() {
        return telefono_cliente;
    }

    public int getCedula_cliente() {
        return cedula_cliente;
    }
   private int cedula_cliente;

    public void setTelefono_cliente(int telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public void setCedula_cliente(int cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }
  
    public Clientes() {
        
    }

    public Clientes(int id_cliente, String nombre_cliente, String apellido_cliente, String direccion_cliente, int telefono_cliente, int cedula_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.cedula_cliente = cedula_cliente;
    }

 

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }



}