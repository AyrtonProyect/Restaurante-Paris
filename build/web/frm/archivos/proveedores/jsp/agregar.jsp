
<%@page import="paris2019.controladores.ProveedoresControlador"%>
<%@page import="paris2019.modelos.Proveedores"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
    
    String nombre_prov= request.getParameter("nombre_prov");
    String ruc_prov= request.getParameter("ruc_prov");
    String descrip_prov= request.getParameter("descrip_prov");
    String direccion_prov= request.getParameter("direccion_prov");
    String correo_prov= request.getParameter("correo_prov");
    int telefono_prov= Integer.parseInt(request.getParameter("telefono_prov"));

  
    
    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Proveedores prov= new Proveedores();
   
    prov.setNombre_prov(nombre_prov);
    prov.setRuc_prov(ruc_prov);  
    prov.setDescrip_prov(descrip_prov);  
    prov.setDireccion_prov(direccion_prov);
    prov.setTelefono_prov(telefono_prov);
    prov.setCorreo_prov(correo_prov);


    if(ProveedoresControlador.agregar(prov)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    %>

