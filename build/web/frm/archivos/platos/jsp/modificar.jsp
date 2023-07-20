

<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.PlatosControlador"%>
<%@page import="paris2019.modelos.Platos"%>
<%@page contentType="text/html pageEncoding=UTF-8"%>

<%
    int id_plato = Integer.parseInt(request.getParameter("id_plato"));
    String clasificacion = request.getParameter("clasificacion");
    String descripcion = request.getParameter("descripcion");
    int precio= Integer.parseInt(request.getParameter("precio"));
    
    String tipo="error";
  
        Platos plato= new Platos();
        plato.setId_plato(id_plato);
        plato.setClasificacion(clasificacion);
        plato.setDescripcion(descripcion);
        plato.setPrecio(precio);
      
        String mensaje = "Datos no Modificados";
        if (PlatosControlador.modificar(plato)) {
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
    