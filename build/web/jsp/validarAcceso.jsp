

<%@page import="paris2019.modelos.Usuarios"%>
<%@page import="paris2019.controladores.UsuariosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nombre_usuario = request.getParameter("nombre_usuario");
    String password_usuario = request.getParameter("password_usuario");
    Usuarios usuario = new Usuarios();
    usuario.setNombre_usuario(nombre_usuario);
    usuario.setPassword_usuario(password_usuario);
    boolean acceso = UsuariosControlador.validarAcceso(usuario);
    JSONObject obj = new JSONObject();
    obj.put("acceso", String.valueOf(acceso));
    out.print(obj);
    out.flush();
%>
