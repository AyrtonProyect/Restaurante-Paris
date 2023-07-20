package org.apache.jsp.frm.archivos.clientes.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import paris2019.controladores.ClientesControlador;
import paris2019.modelos.Clientes;
import org.json.simple.JSONObject;
import java.sql.ResultSet;

public final class agregar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    int id_cliente= Integer.parseInt(request.getParameter("id_cliente"));
    String nombre_cliente= request.getParameter("nombre_cliente");
    String apellido_cliente= request.getParameter("apellido_cliente");
    String direccion_cliente= request.getParameter("direccion_cliente");
    int telefono_cliente= Integer.parseInt(request.getParameter("telefono_cliente"));
    int cedula_cliente= Integer.parseInt(request.getParameter("cedula_cliente"));
  
    
    String tipo = "error";
    String mensaje ="Datos no agregados.";
    
    Clientes cliente= new Clientes();
    cliente.setId_cliente(id_cliente);
    cliente.setNombre_cliente(nombre_cliente);
    cliente.setApellido_cliente(apellido_cliente);  
    cliente.setDireccion_cliente(direccion_cliente);
    cliente.setTelefono_cliente(telefono_cliente);
    cliente.setCedula_cliente(cedula_cliente);


    if(ClientesControlador.agregar(cliente)){
    tipo="success";
    mensaje="Datos agregados.";
    }
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
    
      out.write('\n');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
