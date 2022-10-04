package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class page1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"page2.jsp?data='anh yeu em'&data2=100\"> link</a>\n");
      out.write("        ");

          String s=request.getParameter("result");          
        
      out.write("\n");
      out.write("        <p>");
      out.print( (s!=null)? s: "" );
      out.write("</p>\n");
      out.write("        <hr/>\n");
      out.write("        <form action='Servlet1' method=\"get\">\n");
      out.write("            <input type=\"text\" name=\"txtsearch\" value=\"");
      out.print( request.getParameter("keyword") );
      out.write("\"/>\n");
      out.write("            <input type=\"submit\" value='find'/>\n");
      out.write("        </form>\n");
      out.write("        <!-- cho nay de xuat ket qua sau khi find -->\n");
      out.write("        ");

           ArrayList<String> list=(ArrayList)request.getAttribute("foundlist");
           if(list!=null && list.size()>0){
        
      out.write("\n");
      out.write("        <table>\n");
      out.write("            ");
 for(String str: list) {
      out.write("\n");
      out.write("            <form action='Servlet2' method='post'>\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print( str );
      out.write("\" name=\"txt\"/>\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( str );
      out.write("</td>\n");
      out.write("                    <td><input type=\"submit\" value='remove'/></td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        ");

           }
           else
           {
               out.println("not found");
           }
        
      out.write("\n");
      out.write("        <a href=\"Servlet3\"> click vao day de doc cookie</a>\n");
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
