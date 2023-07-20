
<%@page import="paris2019.controladores.ClientesControlador"%>
<%@page import="paris2019.modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    
    String nombre_cliente= request.getParameter("nombre_cliente");
    String apellido_cliente= request.getParameter("apellido_cliente");
    String direccion_cliente= request.getParameter("direccion_cliente");
    int telefono_cliente= Integer.parseInt(request.getParameter("telefono_cliente"));
    int cedula_cliente= Integer.parseInt(request.getParameter("cedula_cliente"));
  
    
    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Clientes cliente= new Clientes();
  
    cliente.setNombre_cliente(nombre_cliente);
    cliente.setApellido_cliente(apellido_cliente);  
    cliente.setDireccion_cliente(direccion_cliente);
    cliente.setTelefono_cliente(telefono_cliente);
    cliente.setCedula_cliente(cedula_cliente);


    if(ClientesControlador.agregar(cliente)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    %>

