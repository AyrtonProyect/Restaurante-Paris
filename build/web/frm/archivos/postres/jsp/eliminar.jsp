<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.PostresControlador"%>
<%@page import="paris2019.modelos.Postres"%>
<%
    int id_postre = Integer.parseInt(request.getParameter("id_postre"));
    String tipo= "error";
    String mensaje= "Datos no eliminados";
    
Postres postre= new Postres();
postre.setId_postre(id_postre);
if(PostresControlador.eliminar(postre)){
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
