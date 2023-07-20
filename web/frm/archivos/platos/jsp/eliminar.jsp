<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.PlatosControlador"%>
<%@page import="paris2019.modelos.Platos"%>
<%
    int id_plato = Integer.parseInt(request.getParameter("id_plato"));
    String tipo= "error";
    String mensaje= "Datos no eliminados";
    
Platos plato= new Platos();
plato.setId_plato(id_plato);
if(PlatosControlador.eliminar(plato)){
    tipo="success";
    mensaje= "Datos eliminados correctamente";
    
};
JSONObject obj= new JSONObject();
obj.put("tipo", tipo);
obj.put("mensaje", String.valueOf(mensaje));
out.print(obj);
out.flush();
System.out.print(String.valueOf(mensaje));
%>
