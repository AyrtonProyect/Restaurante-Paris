package paris2019.controladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import paris2019.modelos.Postres;

import paris2019.utiles.Conexion;
import paris2019.utiles.Utileria;
public class PostresControlador {
    public static boolean agregar(Postres postre) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into postres(clasificacion,"
                    + "descripcion,precio)"
                    + "values('" + postre.getClasificacion()+ "','"
                    + postre.getDescripcion() + "','"
                    + postre.getPrecio()  + "')";
                   
                    
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
   
    
    //se agrega postrecontrolador
 public static Postres buscarId(Postres postre) {
        if (Conexion.conectar()) {
                String sql= "select * from postres where id_postre= '"+ postre.getId_postre()+"'";
             
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    postre.setId_postre(rs.getInt("id_postre"));
                      postre.setClasificacion(rs.getString("clasificacion"));
                    postre.setDescripcion(rs.getString("descripcion"));
                  
                    postre.setPrecio(rs.getInt("precio"));
                  
                    
                } else {
                    postre.setId_postre(0);
                    postre.setClasificacion("");
                    postre.setDescripcion("");
                   
                    postre.setPrecio(0);
   
                }
               
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return postre;
    }
 ///////////////////////////////////////////////////////////////////////////////
 public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utileria.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from postres where upper (clasificacion) like '%" 
                        + nombre.toUpperCase()+ "%'"
                        + " order by id_postre offset " + offset + " limit " + Utileria.REGISTROS_PAGINA;
                System.out.println("------->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_postre") + "</td>"
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

    public static boolean eliminar(Postres postre) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from postres where id_postre= " + postre.getId_postre();
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
    public static boolean modificar(Postres postre) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "UPDATE postres set clasificacion='" + postre.getClasificacion()+ "',"
                    +"descripcion='" + postre.getDescripcion()+ "',"
                    + "precio='" + postre.getPrecio()+ "'"
                    + " where id_postre= " + postre.getId_postre();
          
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