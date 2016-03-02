package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addNewCourseDemo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Course Monitoring Report</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.css\">\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"index.html\" method=\"post\">\n");
      out.write("      \n");
      out.write("        <h1>Sign Up</h1>\n");
      out.write("        \n");
      out.write("        <fieldset>\n");
      out.write("          <legend><span class=\"number\">1</span>Your basic info</legend>\n");
      out.write("          <label for=\"name\">Academic Session:</label>\n");
      out.write("          <input type=\"text\" id=\"name\" name=\"academic_session\">\n");
      out.write("          \n");
      out.write("          <label for=\"code\">Course Code and Title:</label>\n");
      out.write("          <input type=\"text\" id=\"mail\" name=\"code_title\">\n");
      out.write("          \n");
      out.write("          <label for=\"leader\">Course Leader:</label>\n");
      out.write("          <input type=\"text\" id=\"password\" name=\"course_leader\">\n");
      out.write("          \n");
      out.write("          <label for=\"name\">Student Count:</label>\n");
      out.write("          <input type=\"text\" id=\"name\" name=\"user_name\">\n");
      out.write("          \n");
      out.write("        </fieldset>\n");
      out.write("        \n");
      out.write("        <fieldset>\n");
      out.write("          <legend><span class=\"number\">2</span>Your profile</legend>\n");
      out.write("          <label for=\"bio\">Biography:</label>\n");
      out.write("          <textarea id=\"bio\" name=\"user_bio\"></textarea>\n");
      out.write("        </fieldset>\n");
      out.write("        <fieldset>\n");
      out.write("        <label for=\"job\">Job Role:</label>\n");
      out.write("        <select id=\"job\" name=\"user_job\">\n");
      out.write("          <optgroup label=\"Web\">\n");
      out.write("            <option value=\"frontend_developer\">Front-End Developer</option>\n");
      out.write("            <option value=\"php_developor\">PHP Developer</option>\n");
      out.write("            <option value=\"python_developer\">Python Developer</option>\n");
      out.write("            <option value=\"rails_developer\"> Rails Developer</option>\n");
      out.write("            <option value=\"web_designer\">Web Designer</option>\n");
      out.write("            <option value=\"WordPress_developer\">WordPress Developer</option>\n");
      out.write("          </optgroup>\n");
      out.write("          <optgroup label=\"Mobile\">\n");
      out.write("            <option value=\"Android_developer\">Androild Developer</option>\n");
      out.write("            <option value=\"iOS_developer\">iOS Developer</option>\n");
      out.write("            <option value=\"mobile_designer\">Mobile Designer</option>\n");
      out.write("          </optgroup>\n");
      out.write("          <optgroup label=\"Business\">\n");
      out.write("            <option value=\"business_owner\">Business Owner</option>\n");
      out.write("            <option value=\"freelancer\">Freelancer</option>\n");
      out.write("          </optgroup>\n");
      out.write("          <optgroup label=\"Other\">\n");
      out.write("            <option value=\"secretary\">Secretary</option>\n");
      out.write("            <option value=\"maintenance\">Maintenance</option>\n");
      out.write("          </optgroup>\n");
      out.write("        </select>\n");
      out.write("        \n");
      out.write("          <label>Interests:</label>\n");
      out.write("          <input type=\"checkbox\" id=\"development\" value=\"interest_development\" name=\"user_interest\"><label class=\"light\" for=\"development\">Development</label><br>\n");
      out.write("            <input type=\"checkbox\" id=\"design\" value=\"interest_design\" name=\"user_interest\"><label class=\"light\" for=\"design\">Design</label><br>\n");
      out.write("          <input type=\"checkbox\" id=\"business\" value=\"interest_business\" name=\"user_interest\"><label class=\"light\" for=\"business\">Business</label>\n");
      out.write("        \n");
      out.write("        </fieldset>\n");
      out.write("        <button type=\"submit\">Sign Up</button>\n");
      out.write("      </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
