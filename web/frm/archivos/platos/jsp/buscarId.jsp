
<%@page import="paris2019.controladores.PlatosControlador"%>
<%@page import="paris2019.modelos.Platos"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    int id_plato = 0;
    if (request.getParameter("id_plato") != "") {
        id_plato = Integer.parseInt(request.getParameter("id_plato"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    
    Platos plato = new Platos();
    plato.setId_plato(id_plato);
    plato = PlatosControlador.buscarId(plato);
    if (plato.getId_plato() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    
    obj.put("id_plato", plato.getId_plato());
    obj.put("clasificacion", plato.getClasificacion());
    obj.put("descripcion", plato.getDescripcion());
    obj.put("precio", plato.getPrecio());
  

        System.out.println("clasificacion " + plato.getClasificacion());

        out.print(obj);
        out.flush();
%>

