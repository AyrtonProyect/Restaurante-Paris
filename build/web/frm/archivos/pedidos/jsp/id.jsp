
<%@page import="paris2019.controladores.PedidosControlador"%>
<%@page import="paris2019.modelos.Pedidos"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
 
    int nropedido= Integer.parseInt(request.getParameter("nropedido"));

    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Pedidos cliente= new Pedidos();
   
    cliente.setNropedido(nropedido);
 

    if(PedidosControlador.id(cliente)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    %>