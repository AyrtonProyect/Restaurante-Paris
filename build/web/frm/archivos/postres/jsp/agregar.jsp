
<%@page import="paris2019.modelos.Postres"%>
<%@page import="paris2019.controladores.PostresControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
  
    String clasificacion= request.getParameter("clasificacion");
    String descripcion= request.getParameter("descripcion");
    int precio= Integer.parseInt(request.getParameter("precio"));
   
  
    
    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Postres postre=new Postres();
   
    postre.setClasificacion(clasificacion);
    postre.setDescripcion(descripcion);  
  
    postre.setPrecio(precio);
 


    if(PostresControlador.agregar(postre)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    %>

