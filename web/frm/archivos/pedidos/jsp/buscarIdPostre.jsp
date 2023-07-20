
<%@page import="paris2019.controladores.PedidosControlador"%>
<%@page import="paris2019.modelos.Postres"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    int id_postre = 0;
    if (request.getParameter("id_postre") != "") {
        id_postre = Integer.parseInt(request.getParameter("id_postre"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    
    Postres postre = new Postres();
    postre.setId_postre(id_postre);
    postre = PedidosControlador.buscarIdPostre(postre);
    if (postre.getId_postre() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    
    obj.put("id_postre", postre.getId_postre());
    obj.put("clasificacion", postre.getClasificacion());
    obj.put("descripcion", postre.getDescripcion());
    obj.put("precio", postre.getPrecio());
  

        System.out.println("clasificacion " + postre.getClasificacion());

        out.print(obj);
        out.flush();
%>

