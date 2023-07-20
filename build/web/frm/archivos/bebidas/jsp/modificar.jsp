

<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.BebidasControlador"%>
<%@page import="paris2019.modelos.Bebidas"%>
<%@page contentType="text/html pageEncoding=UTF-8"%>

<%
    int id_bebida = Integer.parseInt(request.getParameter("id_bebida"));
    String clasificacion = request.getParameter("clasificacion");
    String descripcion = request.getParameter("descripcion");
    int precio= Integer.parseInt(request.getParameter("precio"));
    
    String tipo="error";
  
        Bebidas bebida= new Bebidas();
        bebida.setId_bebida(id_bebida);
        bebida.setClasificacion(clasificacion);
        bebida.setDescripcion(descripcion);
        bebida.setPrecio(precio);
      
        String mensaje = "Datos no Modificados";
        if (BebidasControlador.modificar(bebida)) {
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
    