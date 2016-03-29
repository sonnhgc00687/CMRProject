package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "masterpages/header.jsp", out, false);
      out.write("    \r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("    <ul id=\"navigationTab\" class=\"nav nav-tabs\" role=\"tablist\">\r\n");
      out.write("        <li><a href=\"#\">\r\n");
      out.write("                Home <img src=\"img/ic_next.png\" width=\"20px\"/>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li><a href=\"#\">\r\n");
      out.write("                Registration <img src=\"img/ic_next.png\" width=\"20px\"/>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("    <form id=\"addAccountGroup\" action=\"Register\" method=\"post\">\r\n");
      out.write("        <h3>New Account</h3>\r\n");
      out.write("        <input class=\"form-control\" type=\"text\" required=\"\" placeholder=\"Username\" name=\"username\" maxlength=\"50\"/>\r\n");
      out.write("        <input class=\"form-control\" type=\"password\" required=\"\" placeholder=\"Password\" name=\"password\" maxlength=\"50\"/>\r\n");
      out.write("        <input class=\"form-control\" type=\"password\" required=\"\" placeholder=\"Re-Password\" name=\"re_password\" maxlength=\"50\"/>\r\n");
      out.write("        <input class=\"form-control\" type=\"text\" required=\"\" placeholder=\"Full Name\" name=\"name\" maxlength=\"50\"/>\r\n");
      out.write("        <select class=\"form-control\" required=\"\" name=\"role\">\r\n");
      out.write("            <option value=\"\" disabled selected>Role</option>\r\n");
      out.write("            ");
      out.write("       \r\n");
      out.write("        </select>\r\n");
      out.write("        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Add Account</button>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "masterpages/footer.jsp", out, false);
      out.write("    \r\n");
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
