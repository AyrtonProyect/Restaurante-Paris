
<%@page import="paris2019.controladores.ClientesControlador"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="org.json.simple.JSONObject"%>
<%
String nombre_cliente=request.getParameter("bnombre_cliente");
int pagina= Integer.parseInt(request.getParameter("bpagina"));

String mensaje=   "BUSQUEDA EXITOSA...!!!";
String contenido= ClientesControlador.buscarNombre(nombre_cliente, pagina);

JSONObject obj= new JSONObject();
obj.put("mensaje", mensaje);
obj.put("contenido", contenido);
 out. print(obj);
 out.flush();
 %>
