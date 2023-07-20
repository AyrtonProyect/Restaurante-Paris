<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.ProveedoresControlador"%>
<%@page import="paris2019.modelos.Proveedores"%>
<%
    int id_prov = Integer.parseInt(request.getParameter("id_prov"));
    String tipo= "error";
    String mensaje= "Datos no eliminados";
    
Proveedores prov= new Proveedores();
prov.setId_prov(id_prov);
if(ProveedoresControlador.eliminar(prov)){
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
