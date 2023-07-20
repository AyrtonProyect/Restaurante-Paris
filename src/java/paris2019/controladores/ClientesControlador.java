
package paris2019.controladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import paris2019.modelos.Clientes;

import paris2019.utiles.Conexion;
import paris2019.utiles.Utileria;
public class ClientesControlador {
    public static boolean agregar(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into clientes(nombre_cliente,apellido_cliente,"
                    + "direccion_cliente,telefono_cliente,cedula_cliente)"
                    + "values('" + cliente.getNombre_cliente() + "','"
                    + cliente.getApellido_cliente() + "','"
                    + cliente.getDireccion_cliente() + "','"
                    + cliente.getTelefono_cliente() + "','"
                    + cliente.getCedula_cliente()  + "')";
                   
                    
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
                System.out.println(sql);

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }

        }
        return valor;

    }
   
    
    //se agrega clientecontrolador
 public static Clientes buscarId(Clientes cliente) {
        if (Conexion.conectar()) {
                String sql= "select * from clientes where id_cliente= '"+ cliente.getId_cliente()+"'";
             
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                    cliente.setApellido_cliente(rs.getString("apellido_cliente"));
                    cliente.setDireccion_cliente(rs.getString("direccion_cliente"));
                    cliente.setTelefono_cliente(rs.getInt("telefono_cliente"));
                    cliente.setCedula_cliente(rs.getInt("cedula_cliente"));
                    
                } else {
                    cliente.setId_cliente(0);
                    cliente.setNombre_cliente("");
                    cliente.setApellido_cliente("");
                    cliente.setDireccion_cliente("");
                    cliente.setTelefono_cliente(0);
                    cliente.setCedula_cliente(0);
                }
               
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return cliente;
    }
 ///////////////////////////////////////////////////////////////////////////////
 public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utileria.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from clientes where upper (nombre_cliente) like '%" 
                        + nombre.toUpperCase()+ "%'"
                        + " order by id_cliente offset " + offset + " limit " + Utileria.REGISTROS_PAGINA;
                System.out.println("------->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_cliente") + "</td>"
                                + "<td>" + rs.getString("nombre_cliente") + "</td>"
                                + "<td>" + rs.getString("apellido_cliente") + "</td>"
                                + "<td>" + rs.getString("direccion_cliente") + "</td>"
                                + "<td>" + rs.getString("telefono_cliente") + "</td>"
                                + "<td>" + rs.getString("cedula_cliente") + "</td>"
                                + "</tr>";

                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2> NO EXISTEN REGISTROS...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error:" + ex);
                }
                Conexion.cerrar();

            } catch (Exception ex) {
                System.err.println("Error:" + ex);
            }
        }
        Conexion.cerrar();
         
        return valor;
       
    }

/////////////////////////////////////////////////////////////////////////////////

    public static boolean eliminar(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from clientes where id_cliente= " + cliente.getId_cliente();
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    /////////////////////////////////////////////////////////
    public static boolean modificar(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update clientes set nombre_cliente='" + cliente.getNombre_cliente()+ "',"
                    +"apellido_cliente='" + cliente.getApellido_cliente()+ "',"
                    +"direccion_cliente='" + cliente.getDireccion_cliente()+"',"
                    + "telefono_cliente='" + cliente.getTelefono_cliente()+"',"
                    + "cedula_cliente='" + cliente.getCedula_cliente()+"'"
                    + " where id_cliente= " + cliente.getId_cliente();
          
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

   
}