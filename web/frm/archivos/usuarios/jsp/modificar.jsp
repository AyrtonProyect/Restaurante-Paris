<%@page import="paris2019.controladores.UsuariosControlador"%>
<%@page import="paris2019.modelos.Usuarios"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    int id_usuario= Integer.parseInt(request.getParameter("id_usuario"));
    String nombre_usuario= request.getParameter("nombre_usuario");
    String password_usuario=request.getParameter("password_usuario");
    String login_usuario=request.getParameter("login_usuario");
String tipo = "error";

Usuarios usuario= new Usuarios();
usuario.setId_usuario(id_usuario);
usuario.setNombre_usuario(nombre_usuario);
usuario.setPassword_usuario(password_usuario);
usuario.setLogin_usuario(login_usuario);
String mensaje ="Datos no modificados.";
if(UsuariosControlador.modificar(usuario)){
    tipo="success";
    mensaje="Datos Modificados Correctamente.";
}
JSONObject obj=new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>