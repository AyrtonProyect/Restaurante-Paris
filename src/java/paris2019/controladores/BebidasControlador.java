
package paris2019.controladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import paris2019.modelos.Bebidas;

import paris2019.utiles.Conexion;
import paris2019.utiles.Utileria;
public class BebidasControlador {
    public static boolean agregar(Bebidas bebida) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into bebidas(clasificacion,"
                    + "descripcion,precio)"
                    + "values('" + bebida.getClasificacion()+ "','"
                    + bebida.getDescripcion() + "','"
                    + bebida.getPrecio()  + "')";
                   
                    
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
   
    
    //se agrega bebidacontrolador
 public static Bebidas buscarId(Bebidas bebida) {
        if (Conexion.conectar()) {
                String sql= "select * from bebidas where id_bebida= '"+ bebida.getId_bebida()+"'";
             
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    bebida.setId_bebida(rs.getInt("id_bebida"));
                      bebida.setClasificacion(rs.getString("clasificacion"));
                    bebida.setDescripcion(rs.getString("descripcion"));
                  
                    bebida.setPrecio(rs.getInt("precio"));
                  
                    
                } else {
                    bebida.setId_bebida(0);
                    bebida.setClasificacion("");
                    bebida.setDescripcion("");
                   
                    bebida.setPrecio(0);
   
                }
               
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return bebida;
    }
 ///////////////////////////////////////////////////////////////////////////////
 public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utileria.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from bebidas where upper (clasificacion) like '%" 
                        + nombre.toUpperCase()+ "%'"
                        + " order by id_bebida offset " + offset + " limit " + Utileria.REGISTROS_PAGINA;
                System.out.println("------->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_bebida") + "</td>"
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

    public static boolean eliminar(Bebidas bebida) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from bebidas where id_bebida= " + bebida.getId_bebida();
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
    public static boolean modificar(Bebidas bebida) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "UPDATE bebidas set clasificacion='" + bebida.getClasificacion()+ "',"
                    +"descripcion='" + bebida.getDescripcion()+ "',"
                    + "precio='" + bebida.getPrecio()+ "'"
                    + " where id_bebida= " + bebida.getId_bebida();
          
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