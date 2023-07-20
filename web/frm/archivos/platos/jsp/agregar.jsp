
<%@page import="paris2019.modelos.Platos"%>
<%@page import="paris2019.controladores.PlatosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
  
    String clasificacion= request.getParameter("clasificacion");
    String descripcion= request.getParameter("descripcion");
    int precio= Integer.parseInt(request.getParameter("precio"));
   
  
    
    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Platos plato=new Platos();
    
    plato.setClasificacion(clasificacion);
    plato.setDescripcion(descripcion);  
  
    plato.setPrecio(precio);
 


    if(PlatosControlador.agregar(plato)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    %>

