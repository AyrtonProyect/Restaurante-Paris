/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paris2019.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import paris2019.modelos.Bebidas;
import paris2019.modelos.Clientes;
import paris2019.modelos.Pedidos;
import paris2019.modelos.Platos;
import paris2019.modelos.Postres;
import paris2019.utiles.Conexion;
import paris2019.utiles.Utileria;

/**
 *
 * @author Antony_99
 */
public class PedidosControlador {
     public static boolean id(Pedidos cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
          String sql= "SELECT MAX(nro_pedido)+1 AS ultimo FROM pedido";
                   try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    cliente.setNropedido(rs.getInt("ultimo"));
               
                    
                } else {
                    cliente.setNropedido(0);
                  
                }
               
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    
      public static boolean agregar(Pedidos cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into pedido(total,id_cli,"
                    + "ced_cli,fec_pedido)"
                    + "values('"+ cliente.getTotal() + "','"
                   
                    
                    + cliente.getId_cliente() + "','"
                   
                    + cliente.getCedula_cliente()+ "','"
                   
                    + cliente.getFecha()+ "')";
                   
                  
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
      public static String buscarNombrePedido(String nombre, int pagina) {
        int offset = (pagina - 1) * Utileria.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from pedido" ;
                System.out.println("------->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_cli") + "</td>"
                                + "<td>" + rs.getString("nro_pedido") + "</td>"
                                + "<td>" + rs.getString("fec_pedido") + "</td>"
                                + "<td>" + rs.getString("total") + "</td>"
                               
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
            public static Pedidos buscarIdPedido(Pedidos cliente) {
        if (Conexion.conectar()) {
                String sql= "select * from pedido where nro_pedido= '"+ cliente.getNropedido()+"'";
             
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    cliente.setId_cliente(rs.getInt("id_cliente"));
                    cliente.setNropedido(rs.getInt("nro_pedido"));
                    cliente.setTotal(rs.getInt("total"));
                    cliente.setFecha(rs.getString("fec_pedido"));
                    
                    cliente.setCedula_cliente(rs.getInt("cedula_cliente"));
                    
                } else {
                    cliente.setId_cliente(0);
                    cliente.setNropedido(0);
                    cliente.setFecha("");
                    cliente.setTotal(0);
                 
                    cliente.setCedula_cliente(0);
                }
               
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return cliente;
    }
      /////////////////////////////////////////////////////////////////////////
    
      public static Clientes buscarIdCliente(Clientes cliente) {
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
 public static String buscarNombreCliente(String nombre, int pagina) {
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
    ////////////////////////////////////////////////////////////////////////////
     public static Bebidas buscarIdBebida(Bebidas bebida) {
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
 public static String buscarNombreBebida(String nombre, int pagina) {
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
public static Postres buscarIdPostre(Postres postre) {
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
 public static String buscarNombrePostre(String nombre, int pagina) {
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
 public static Platos buscarIdPlato(Platos plato) {
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
 public static String buscarNombrePlato(String nombre, int pagina) {
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
 }
/////////////////////////////////////////////////////////////////////////////
