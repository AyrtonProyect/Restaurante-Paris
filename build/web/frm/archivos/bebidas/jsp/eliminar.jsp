<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.BebidasControlador"%>
<%@page import="paris2019.modelos.Bebidas"%>
<%
    int id_bebida = Integer.parseInt(request.getParameter("id_bebida"));
    String tipo= "error";
    String mensaje= "Datos no eliminados";
    
Bebidas bebida= new Bebidas();
bebida.setId_bebida(id_bebida);
if(BebidasControlador.eliminar(bebida)){
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
