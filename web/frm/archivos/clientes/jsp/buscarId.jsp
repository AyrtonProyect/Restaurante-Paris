
<%@page import="paris2019.controladores.ClientesControlador"%>
<%@page import="paris2019.modelos.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    int id_cliente = 0;
    if (request.getParameter("id_cliente") != "") {
        id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    
    Clientes cliente = new Clientes();
    cliente.setId_cliente(id_cliente);
    cliente = ClientesControlador.buscarId(cliente);
    if (cliente.getId_cliente() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    
    obj.put("id_cliente", cliente.getId_cliente());
    obj.put("nombre_cliente", cliente.getNombre_cliente());
    obj.put("apellido_cliente", cliente.getApellido_cliente());
    obj.put("direccion_cliente", cliente.getDireccion_cliente());
    obj.put("telefono_cliente", cliente.getTelefono_cliente());
    obj.put("cedula_cliente", cliente.getCedula_cliente());

        System.out.println("nombre_cliente " + cliente.getNombre_cliente());

        out.print(obj);
        out.flush();
%>

