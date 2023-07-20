

package paris2019.controladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import paris2019.modelos.Proveedores;
import paris2019.utiles.Conexion;
import paris2019.utiles.Utileria;

public class ProveedoresControlador {
    public static boolean agregar(Proveedores prov) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into proveedores(nombre_prov,ruc_prov,"
                    + "direccion_prov,telefono_prov,correo_prov,descrip_prov)"
                    + "values('" + prov.getNombre_prov() + "','"
                    + prov.getRuc_prov() + "','"
                   
                    + prov.getDireccion_prov() + "','"
                    + prov.getTelefono_prov() + "','"
                    + prov.getCorreo_prov()+  "','"
                    + prov.getDescrip_prov() + "')";
                    
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
   
    
    //se agrega provcontrolador
 public static Proveedores buscarId(Proveedores prov) {
        if (Conexion.conectar()) {
                String sql= "select * from proveedores where id_prov= '"+ prov.getId_prov()+"'";
             
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    prov.setId_prov(rs.getInt("id_prov"));
                    prov.setNombre_prov(rs.getString("nombre_prov"));
                    prov.setDescrip_prov(rs.getString("descrip_prov"));
                    prov.setRuc_prov(rs.getString("ruc_prov"));
                    prov.setDireccion_prov(rs.getString("direccion_prov"));
                    prov.setTelefono_prov(rs.getInt("telefono_prov"));
                    prov.setCorreo_prov(rs.getString("correo_prov"));

                } else {
                    prov.setId_prov(0);
                    prov.setNombre_prov("");
                    prov.setRuc_prov("");
                    prov.setDireccion_prov("");
                    prov.setDireccion_prov("");
                    prov.setCorreo_prov("");
                    prov.setTelefono_prov(0);
            
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return prov;
    }
/////////////////////////////////////////////////////////////////////////////////

    public static boolean eliminar(Proveedores prov) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from proveedores where id_prov= " + prov.getId_prov();
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
    public static boolean modificar(Proveedores prov) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update proveedores set nombre_prov='" + prov.getNombre_prov()+ "',"
                    +"ruc_prov='" + prov.getRuc_prov()+ "',"
                    +"descrip_prov='" + prov.getDescrip_prov()+ "',"
                    +"direccion_prov='" + prov.getDireccion_prov()+"',"
                    + "telefono_prov='" + prov.getTelefono_prov()+"',"
                    + "correo_prov='" + prov.getCorreo_prov()+"'"
                    + " where id_prov= " + prov.getId_prov();
          
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }
    /////////////////////////////////////////////////////////////
     public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utileria.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from proveedores where upper (nombre_prov) like '%" 
                        + nombre.toUpperCase()+ "%'"
                        + " order by id_prov offset " + offset + " limit " + Utileria.REGISTROS_PAGINA;
                System.out.println("------->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_prov") + "</td>"
                                + "<td>" + rs.getString("nombre_prov") + "</td>"
                                + "<td>" + rs.getString("ruc_prov") + "</td>"
                                + "<td>" + rs.getString("descrip_prov") + "</td>"
                                + "<td>" + rs.getString("direccion_prov") + "</td>"
                                + "<td>" + rs.getString("telefono_prov") + "</td>"
                                + "<td>" + rs.getString("correo_prov") + "</td>"
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
}
