
<%@page import="paris2019.controladores.PedidosControlador"%>
<%@page import="paris2019.modelos.Pedidos"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_cliente= Integer.parseInt(request.getParameter("id_cliente"));
    int cedula_cliente= Integer.parseInt(request.getParameter("cedula_cliente"));
   
    
    int total= Integer.parseInt(request.getParameter("total"));
  
     String fecha= request.getParameter("fecha");
  
    
  
    
    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Pedidos cliente= new Pedidos();
    cliente.setId_cliente(id_cliente);
    cliente.setCedula_cliente(cedula_cliente);
   
  
    cliente.setTotal(total);

    cliente.setFecha(fecha);

    if(PedidosControlador.agregar(cliente)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    %>

