package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class assignCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css.css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if (request.getSession() == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-fixed-top navbar-inverse\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">CMR</a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"navbar\" class=\"collapse navbar-collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li><a href=\"Login\">Home</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"GetAllCourse\">Course</a></li>\n");
      out.write("                        <li><a href=\"#contact\">Contact</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a href=\"#\" id=\"btnAddDropdown\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                <img src=\"img/ic_plus.png\" width=\"25px\" height=\"25px\"/>\n");
      out.write("                                <span class=\"caret\"></span></a>\n");
      out.write("                            <ul class=\"dropdown-menu\" role=\"menu\">\n");
      out.write("                                <li class=\"active\">\n");
      out.write("                                    <form id=\"btnNewCourse\" action=\"GetAllUserAndFaculty\" method=\"post\">\n");
      out.write("                                        <button id=\"\" type=\"submit\">New Course</button>\n");
      out.write("                                    </form>\n");
      out.write("                                </li>\n");
      out.write("                                <li><form id=\"btnNewCourse\" action=\"AddCMR\" method=\"get\">\n");
      out.write("                                        <button id=\"\" type=\"submit\">New CMR</button>\n");
      out.write("                                    </form></li>\n");
      out.write("                                <li><a href=\"#\">Something else here</a></li>\n");
      out.write("                                <li class=\"divider\"></li>\n");
      out.write("                                <li><a href=\"#\">Separated link</a></li>\n");
      out.write("                                <li class=\"divider\"></li>\n");
      out.write("                                <li><a href=\"#\">One more separated link</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>     \n");
      out.write("                        <li class=\"active\"><a href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"row row-offcanvas row-offcanvas-right\">\n");
      out.write("\n");
      out.write("                <div class=\".col-md-6 .col-md-offset-4\">\n");
      out.write("                    <p class=\"pull-right visible-xs\">                       \n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary btn-xs\" data-toggle=\"offcanvas\">Toggle nav</button>\n");
      out.write("                    </p>\n");
      out.write("                    <div class=\"jumbotron\">\n");
      out.write("                        <h1>Welcome to FPT University!</h1>\n");
      out.write("                        <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <ul id=\"navigationTab\" class=\"nav nav-tabs\" role=\"tablist\">\n");
      out.write("                            <li><a href=\"#\">\n");
      out.write("                                    Home <img src=\"img/ic_next.png\" width=\"20px\"/>\n");
      out.write("                                </a></li>\n");
      out.write("                            <li><a href=\"#\">\n");
      out.write("                                    Course <img src=\"img/ic_next.png\" width=\"20px\"/>\n");
      out.write("                                </a></li><!--\n");
      out.write("                            <li><a href=\"#\">\n");
      out.write("                                    Messages <img src=\"img/ic_next.png\" width=\"20px\"/>\n");
      out.write("                                </a></li>-->\n");
      out.write("                        </ul>\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("\n");
      out.write("            <footer>\n");
      out.write("                <p>© 2015 Company, Inc.</p>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/docs.min.js\"></script>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${courseList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("c");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <div id=\"courseInfo\" class=\"col-xs-6 col-lg-4\">\n");
          out.write("                                <h3>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.courseTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h3>\n");
          out.write("                                <p>Start Date: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.courseStarted}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                <p>Finish Date: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.courseFinished}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                                <td></td>\n");
          out.write("                                <p><a class=\"btn btn-default\" href=\"AddCMR?&courseID=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" role=\"button\">Add CMR for this course</a></p>\n");
          out.write("                                <p><a class=\"btn btn-default\" href=\"#\" role=\"button\">View details »</a></p>\n");
          out.write("                            </div>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
