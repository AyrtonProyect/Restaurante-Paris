
<%@page import="paris2019.controladores.PedidosControlador"%>
<%@page import="paris2019.modelos.Pedidos"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    int id_cliente = 0;
    if (request.getParameter("nro_pedido") != "") {
        id_cliente = Integer.parseInt(request.getParameter("nro_pedido"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    
    Pedidos cliente = new Pedidos();
    cliente.setNropedido(id_cliente);
    cliente = PedidosControlador.buscarIdPedido(cliente);
    if (cliente.getNropedido()!= 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    
    obj.put("nro_pedido", cliente.getNropedido());
    obj.put("id_cli", cliente.getId_cliente());
   
    obj.put("fecha", cliente.getFecha());
    obj.put("total", cliente.getTotal());
 
    obj.put("ced_cli", cliente.getCedula_cliente());


        out.print(obj);
        out.flush();
%>

