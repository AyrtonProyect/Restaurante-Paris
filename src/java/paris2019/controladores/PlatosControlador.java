
package paris2019.controladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import paris2019.modelos.Platos;

import paris2019.utiles.Conexion;
import paris2019.utiles.Utileria;
public class PlatosControlador {
    public static boolean agregar(Platos plato) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into platos(clasificacion,"
                    + "descripcion,precio)"
                    + "values('" + plato.getClasificacion()+ "','"
                    + plato.getDescripcion() + "','"
                    + plato.getPrecio()  + "')";
                   
                    
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
   
    
    //se agrega platocontrolador
 public static Platos buscarId(Platos plato) {
        if (Conexion.conectar()) {
                String sql= "select * from platos where id_plato= '"+ plato.getId_plato()+"'";
             
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    plato.setId_plato(rs.getInt("id_plato"));
                      plato.setClasificacion(rs.getString("clasificacion"));
                    plato.setDescripcion(rs.getString("descripcion"));
                  
                    plato.setPrecio(rs.getInt("precio"));
                  
                    
                } else {
                    plato.setId_plato(0);
                    plato.setClasificacion("");
                    plato.setDescripcion("");
                   
                    plato.setPrecio(0);
   
                }
               
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return plato;
    }
 ///////////////////////////////////////////////////////////////////////////////
 public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utileria.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from platos where upper (clasificacion) like '%" 
                        + nombre.toUpperCase()+ "%'"
                        + " order by id_plato offset " + offset + " limit " + Utileria.REGISTROS_PAGINA;
                System.out.println("------->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_plato") + "</td>"
                                + "<td>" + rs.getString("clasificacion") + "</td>"
                                + "<td>" + rs.getString("descripcion") + "</td>"
                                + "<td>" + rs.getString("precio") + "</td>"
                                
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

    public static boolean eliminar(Platos plato) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from platos where id_plato= " + plato.getId_plato();
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
    public static boolean modificar(Platos plato) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "UPDATE platos set clasificacion='" + plato.getClasificacion()+ "',"
                    +"descripcion='" + plato.getDescripcion()+ "',"
                    + "precio='" + plato.getPrecio()+ "'"
                    + " where id_plato= " + plato.getId_plato();
          
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