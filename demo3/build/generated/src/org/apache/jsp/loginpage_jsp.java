package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <h1>Login</h1>\n");
      out.write("        <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("            <p>email:<input type=\"text\" name=\"txtemail\"/></p>\n");
      out.write("            <p>password:<input type=\"password\" name=\"txtpassword\"/></p>\n");
      out.write("            <p><input type=\"checkbox\"/>save me</p>\n");
      out.write("            <p><input type=\"submit\" value=\"login\"/></p>\n");
      out.write("        </form>\n");
      out.write("       <p>");
      out.print(  (request.getAttribute("error")!=null) ?request.getAttribute("error"):""  );
      out.write("</p>\n");
      out.write("       <p>\n");
      out.write("           ");

             String s = (String)request.getAttribute("error");
             if(!s.isEmpty() && s != null)
             { 
                 out.println(s);
             }
           
      out.write("\n");
      out.write("       </p>\n");
      out.write("       ");

        String ss=(String)request.getAttribute("error");
       
      out.write("\n");
      out.write("       <p>");
      out.print(  (ss!=null)?ss:"" );
      out.write(" </p>\n");
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
