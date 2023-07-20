
<%@page import="paris2019.controladores.PlatosControlador"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="org.json.simple.JSONObject"%>
<%
String clasificacion=request.getParameter("bclasificacion");
int pagina= Integer.parseInt(request.getParameter("bpagina"));

String mensaje=   "BUSQUEDA EXITOSA...!!!";
String contenido= PlatosControlador.buscarNombre(clasificacion, pagina);

JSONObject obj= new JSONObject();
obj.put("mensaje", mensaje);
obj.put("contenido", contenido);
 out. print(obj);
 out.flush();
 %>
