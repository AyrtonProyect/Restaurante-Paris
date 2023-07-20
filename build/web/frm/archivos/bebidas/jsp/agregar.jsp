
<%@page import="paris2019.modelos.Bebidas"%>
<%@page import="paris2019.controladores.BebidasControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    
    String clasificacion= request.getParameter("clasificacion");
    String descripcion= request.getParameter("descripcion");
    int precio= Integer.parseInt(request.getParameter("precio"));
   
  
    
    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Bebidas bebida=new Bebidas();
    
    bebida.setClasificacion(clasificacion);
    bebida.setDescripcion(descripcion);  
  
    bebida.setPrecio(precio);
 


    if(BebidasControlador.agregar(bebida)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    %>

