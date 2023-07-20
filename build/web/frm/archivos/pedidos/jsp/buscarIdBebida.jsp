
<%@page import="paris2019.controladores.PedidosControlador"%>
<%@page import="paris2019.modelos.Bebidas"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    int id_bebida = 0;
    if (request.getParameter("id_bebida") != "") {
        id_bebida = Integer.parseInt(request.getParameter("id_bebida"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    
    Bebidas bebida = new Bebidas();
    bebida.setId_bebida(id_bebida);
    bebida = PedidosControlador.buscarIdBebida(bebida);
    if (bebida.getId_bebida() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    
    obj.put("id_bebida", bebida.getId_bebida());
    obj.put("clasificacion", bebida.getClasificacion());
    obj.put("descripcion", bebida.getDescripcion());
    obj.put("precio", bebida.getPrecio());
  

        System.out.println("clasificacion " + bebida.getClasificacion());

        out.print(obj);
        out.flush();
%>

