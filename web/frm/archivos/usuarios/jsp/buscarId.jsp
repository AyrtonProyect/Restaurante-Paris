
<%@page import="paris2019.controladores.UsuariosControlador"%>
<%@page import="paris2019.modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    int id_usuario = 0;
    if (request.getParameter("id_usuario") != "") {
        id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Usuarios usuario = new Usuarios();
    usuario.setId_usuario(id_usuario);
    usuario = UsuariosControlador.buscarId(usuario);
    if (usuario.getId_usuario() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    obj.put("id_usuario", usuario.getId_usuario());
    obj.put("nombre_usuario", usuario.getNombre_usuario());
    obj.put("password_usuario", usuario.getPassword_usuario());
    obj.put("login_usuario", usuario.getLogin_usuario());

    System.out.println("nombre-usuario " + usuario.getNombre_usuario());

    out.print(obj);
    out.flush();
%>

