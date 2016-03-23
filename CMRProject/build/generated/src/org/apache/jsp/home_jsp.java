package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "masterpages/header.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("    <ul id=\"navigationTab\" class=\"nav nav-tabs\" role=\"tablist\">\r\n");
      out.write("        <li><a href=\"#\">\r\n");
      out.write("                Home <img src=\"img/ic_next.png\" width=\"20px\"/>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"reviewContainer\">\r\n");
      out.write("        <div class=\"row featurette\">\r\n");
      out.write("            <div class=\"col-md-3\">\r\n");
      out.write("                <img id=\"reviewAvarta\" src=\"img/review01.jpg\" class=\"img-circle img-responsive\" width=\"180px\" height=\"180px\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-9\">\r\n");
      out.write("                <h2 class=\"featurette-heading\">Hello! I am Tuan.<span class=\"text-muted\">See for yourself.</span></h2>\r\n");
      out.write("                <p class=\"lead\">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <hr class=\"featurette-divider\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row featurette\">\r\n");
      out.write("            <div class=\"col-md-9\">\r\n");
      out.write("                <h2 class=\"featurette-heading\">Hi! My name is Jaya.<span class=\"text-muted\">Checkmate.</span></h2>\r\n");
      out.write("                <p class=\"lead\">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-3\">\r\n");
      out.write("                <img id=\"reviewAvarta\" src=\"img/review02.jpg\" class=\"img-circle img-responsive\" width=\"180px\" height=\"180px\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <hr class=\"featurette-divider\">\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "masterpages/footer.jsp", out, false);
      out.write("               ");
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
