

<%@page import="org.json.simple.JSONObject"%>
<%@page import="paris2019.controladores.ProveedoresControlador"%>
<%@page import="paris2019.modelos.Proveedores"%>
<%@page contentType="text/html pageEncoding=UTF-8"%>

<%
    int id_prov = Integer.parseInt(request.getParameter("id_prov"));
    String nombre_prov = request.getParameter("nombre_prov");
    String ruc_prov = request.getParameter("ruc_prov");
    String descrip_prov= request.getParameter("descrip_prov");
    String direccion_prov = request.getParameter("direccion_prov");
     String correo_prov = request.getParameter("correo_prov");
    int telefono_prov= Integer.parseInt(request.getParameter("telefono_prov"));
   
    
    String tipo="error";
  
       Proveedores prov= new Proveedores();
        prov.setId_prov(id_prov);
        prov.setNombre_prov(nombre_prov);
        prov.setRuc_prov(ruc_prov);
        prov.setDescrip_prov(descrip_prov);
        prov.setDireccion_prov(direccion_prov);
        prov.setTelefono_prov(telefono_prov);
        prov.setCorreo_prov(correo_prov);
      
        String mensaje = "Datos no Modificados";
        if (ProveedoresControlador.modificar(prov)) {
            tipo = "success";
            mensaje = "Datos modificados correctamente";
        };

        JSONObject obj = new JSONObject();
        obj.put("tipo", tipo);
        obj.put("mensaje", mensaje);
        System.out.print(mensaje);
    out.print(obj);
    out.flush();
    %>
    