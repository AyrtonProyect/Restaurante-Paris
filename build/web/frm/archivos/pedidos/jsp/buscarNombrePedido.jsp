
<%@page import="paris2019.controladores.PedidosControlador"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="org.json.simple.JSONObject"%>
<%
String nombre_cliente=request.getParameter("bpedido");
int pagina= Integer.parseInt(request.getParameter("bpagina"));

String mensaje=   "BUSQUEDA EXITOSA...!!!";
String contenido= PedidosControlador.buscarNombrePedido(nombre_cliente, pagina);

JSONObject obj= new JSONObject();
obj.put("mensaje", mensaje);
obj.put("contenido", contenido);
 out. print(obj);
 out.flush();
 %>
