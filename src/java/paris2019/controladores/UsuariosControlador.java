/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paris2019.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import paris2019.modelos.Usuarios;
import paris2019.utiles.Conexion;
import paris2019.utiles.Utileria;

/**
 *
 * @author Antony_99
 */
public class UsuariosControlador {

    public static boolean agregar(Usuarios usuario) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into usuarios(nombre_usuario, password_usuario, login_usuario)"
                    + "values('" + usuario.getNombre_usuario() + "','"
                    //en esta linea se agrega el md5 para la encriptacion de la contraseña
                   + Utileria.md5(Utileria.quitarGuiones(usuario.getPassword_usuario())) + "','"
                
                    + usuario.getLogin_usuario() + "')";
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }

        }
        return valor;

    }
    //se agrega usuariocontrolador
    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utileria.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from usuarios where upper (nombre_usuario) like '%" + nombre.toUpperCase() + "%'"
                        + " order by id_usuario offset " + offset + " limit " + Utileria.REGISTROS_PAGINA;
                System.out.println("------->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_usuario") + "</td>"
                                + "<td>" + rs.getString("nombre_usuario") + "</td>"
                                + "<td>"  + "</td>"
                                + "<td>" + rs.getString("login_usuario") + "</td>"
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

    public static Usuarios buscarId(Usuarios usuario) {
        if (Conexion.conectar()) {
            String sql = "select * from usuarios where id_usuario='" + usuario.getId_usuario() + "'";
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                    usuario.setPassword_usuario(rs.getString("password_usuario"));
                    usuario.setLogin_usuario(rs.getString("login_usuario"));
                } else {
                    usuario.setId_usuario(0);
                    usuario.setNombre_usuario("");
                    usuario.setPassword_usuario("");
                    usuario.setLogin_usuario("");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return usuario;
    }

   
    public static boolean eliminar(Usuarios usuario) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from usuarios where id_usuario= " + usuario.getId_usuario();
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static boolean modificar(Usuarios usuario) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update usuarios set nombre_usuario='" + usuario.getNombre_usuario()
                    + "',password_usuario='" +  Utileria.md5(Utileria.quitarGuiones(usuario.getPassword_usuario()))
                    + "',login_usuario='" + usuario.getLogin_usuario()
                    + "' where id_usuario=" + usuario.getId_usuario();
            System.out.println(sql);
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
                System.out.println(sql);

            } catch (SQLException ex) {
                System.err.println("ErrorModificar:" + ex);
            }
        }
        return valor;
    }

    public static boolean validarAcceso(Usuarios usuario) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "select * from usuarios where nombre_usuario='"
                    + usuario.getNombre_usuario() + "'"
                    + " and password_usuario='"
                    + Utileria.md5(Utileria.quitarGuiones(usuario.getPassword_usuario())) + "'";
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    valor = true;
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e);
            }
        }
        return valor;
    }
}
