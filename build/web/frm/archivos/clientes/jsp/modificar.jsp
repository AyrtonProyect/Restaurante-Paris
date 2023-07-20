

<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.ClientesControlador"%>
<%@page import="paris2019.modelos.Clientes"%>
<%@page contentType="text/html pageEncoding=UTF-8"%>

<%
    int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
    String nombre_cliente = request.getParameter("nombre_cliente");
    String apellido_cliente = request.getParameter("apellido_cliente");
    String direccion_cliente = request.getParameter("direccion_cliente");
    int telefono_cliente= Integer.parseInt(request.getParameter("telefono_cliente"));
    int cedula_cliente= Integer.parseInt(request.getParameter("cedula_cliente"));
    
    String tipo="error";
  
        Clientes cliente= new Clientes();
        cliente.setId_cliente(id_cliente);
        cliente.setNombre_cliente(nombre_cliente);
        cliente.setApellido_cliente(apellido_cliente);
        cliente.setDireccion_cliente(direccion_cliente);
        cliente.setTelefono_cliente(telefono_cliente);
        cliente.setCedula_cliente(cedula_cliente);
      
        String mensaje = "Datos no Modificados";
        if (ClientesControlador.modificar(cliente)) {
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
    