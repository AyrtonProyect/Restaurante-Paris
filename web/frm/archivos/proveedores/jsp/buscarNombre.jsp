
<%@page import="paris2019.controladores.ProveedoresControlador"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="org.json.simple.JSONObject"%>
<%
String nombre_prov=request.getParameter("bnombre_prov");
int pagina= Integer.parseInt(request.getParameter("bpagina"));

String mensaje=   "BUSQUEDA EXITOSA...!!!";
String contenido= ProveedoresControlador.buscarNombre(nombre_prov, pagina);

JSONObject obj= new JSONObject();
obj.put("mensaje", mensaje);
obj.put("contenido", contenido);
 out. print(obj);
 out.flush();
 %>
