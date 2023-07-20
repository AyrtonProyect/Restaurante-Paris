
<%@page import="paris2019.controladores.ProveedoresControlador"%>
<%@page import="paris2019.modelos.Proveedores"%>
<%@page import="org.json.simple.JSONObject"%>
<%
    int id_prov = 0;
    if (request.getParameter("id_prov") != "") {
        id_prov = Integer.parseInt(request.getParameter("id_prov"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    
    Proveedores prov = new Proveedores();
    prov.setId_prov(id_prov);
    prov = ProveedoresControlador.buscarId(prov);
    if (prov.getId_prov() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);
    
    obj.put("id_prov", prov.getId_prov());
    obj.put("nombre_prov", prov.getNombre_prov());
    obj.put("ruc_prov", prov.getRuc_prov());
    obj.put("descrip_prov", prov.getDescrip_prov());
    obj.put("direccion_prov", prov.getDireccion_prov());
    obj.put("telefono_prov", prov.getTelefono_prov());
    obj.put("correo_prov", prov.getCorreo_prov());

        System.out.println("nombre_prov " + prov.getNombre_prov());

        out.print(obj);
        out.flush();
%>

