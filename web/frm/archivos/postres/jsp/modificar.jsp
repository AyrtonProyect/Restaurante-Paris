

<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.PostresControlador"%>
<%@page import="paris2019.modelos.Postres"%>
<%@page contentType="text/html pageEncoding=UTF-8"%>

<%
    int id_postre = Integer.parseInt(request.getParameter("id_postre"));
    String clasificacion = request.getParameter("clasificacion");
    String descripcion = request.getParameter("descripcion");
    int precio= Integer.parseInt(request.getParameter("precio"));
    
    String tipo="error";
  
        Postres postre= new Postres();
        postre.setId_postre(id_postre);
        postre.setClasificacion(clasificacion);
        postre.setDescripcion(descripcion);
        postre.setPrecio(precio);
      
        String mensaje = "Datos no Modificados";
        if (PostresControlador.modificar(postre)) {
            tipo = "success";
            mensaje = "Datos modificados correctamente";
        };

        JSONObject obj = new JSONObject();
        obj.put("tipo", tipo);
        obj.put("mensaje", mensaje);
        System.out.print(mensaje);
    out.print(obj);
    out.flush();
    %>
    