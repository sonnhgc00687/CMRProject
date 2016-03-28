package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addNewCMR_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "masterpages/header.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <form id=\"addCMRGroup\" action=\"AddCMR\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div id=\"tableCMRInfo\" class=\"panel panel-default\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"panel-heading\"><h3>COURSE MONITORING REPORT</h3></div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Table -->\r\n");
      out.write("                <div class=\"table-responsive\">          \r\n");
      out.write("                    <table class=\"table table-bordered\">\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Academic Session</td> <td><input class=\"form-control\" type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${courseId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"\" name=\"id\" maxlength=\"50\"/></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Course Title</td> <td><input class=\"form-control\" type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${courseTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" disabled=\"\" name=\"\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Course Leader</td> <td><input class=\"form-control\" type=\"text\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${courseLeader}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" disabled=\"\" name=\"\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Student count</td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"studentCount\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"tableStatisticalData\" class=\"panel panel-default\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Default panel contents -->\r\n");
      out.write("                <div class=\"panel-heading\">Statistical Data</div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Table -->\r\n");
      out.write("                <div class=\"table-responsive\">          \r\n");
      out.write("                    <table class=\"table table-bordered\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th>#</th> <th>CW1</th> <th>CW2</th> <th>CW3</th> <th>CW4</th> <th>EXAM</th> <th>OVERALL</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Mean</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mean1\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mean2\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mean3\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mean4\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mean5\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mean6\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Median</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"median1\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"median2\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"median3\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"median4\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"median5\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"median6\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Standard Deviation</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"sd1\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"sd2\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"sd3\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"sd4\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"sd5\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"sd6\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"tableGradeData\" class=\"panel panel-default\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"panel-heading\">Grade Distribution Data</div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Table -->\r\n");
      out.write("                <div class=\"table-responsive\">          \r\n");
      out.write("                    <table class=\"table table-bordered\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th>#</th> <th>0 ? 9</th> <th>10 - 19</th> <th>20 - 29</th> <th>30 - 39</th> <th>40 - 49</th> <th>50 - 59</th> <th>60 - 69</th> <th>70 - 79</th> <th>80 - 89</th> <th>90+</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>CW1</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_0\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_1\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_2\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_3\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_4\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_5\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_6\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_7\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_8\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_1_9\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>CW2</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_0\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_1\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_2\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_3\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_4\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_5\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_6\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_7\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_8\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_2_9\" min=\"0\" max=\"100\"/></td>                                                \r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>CW3</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_0\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_1\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_2\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_3\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_4\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_5\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_6\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_7\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_8\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_3_9\" min=\"0\" max=\"100\"/></td>                                                \r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>CW4</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_0\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_1\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_2\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_3\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_4\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_5\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_6\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_7\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_8\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_4_9\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>EXAM</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_0\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_1\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_2\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_3\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_4\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_5\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_6\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_7\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_8\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_5_9\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>OVERALL</td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_0\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_1\" min=\"0\" max=\"100\"/></td>\r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_2\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_3\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_4\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_5\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_6\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_7\" min=\"0\" max=\"100\"/></td> \r\n");
      out.write("                                <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_8\" min=\"0\" max=\"100\"/></td> <td><input class=\"form-control\" type=\"number\"  placeholder=\"\" name=\"mark_6_9\" min=\"0\" max=\"100\"/></td>                                                \r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Summit Report</button>\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "masterpages/footer.jsp", out, false);
      out.write('\r');
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
