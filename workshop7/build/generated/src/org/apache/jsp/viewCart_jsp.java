package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sample.dto.Plant;
import sample.dao.PlantDao;
import java.util.Set;
import java.util.HashMap;

public final class viewCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("        <script src=\"scripts.js\"></script>\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("         <header>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <nav>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li> <a href=\"\"></a><img src=\"images/logo.jpg\"></li>\r\n");
      out.write("                    <li> <a href=\"\">Home</a></li>\r\n");
      out.write("                    <li> <a href=\"register.jsp\">Register</a></li>\r\n");
      out.write("                    <li> <a href=\"\">Login</a></li>\r\n");
      out.write("                    <li> <a href=\"mainController?action=viewcart\">view cart </a></li>\r\n");
      out.write("                    <li> <form action=\"mainController\">\r\n");
      out.write("                            <input type=\"text\" name=\"txtsearch\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.txtsearch}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            <select name=\"searchby\">\r\n");
      out.write("                                <option value=\"byname\"> by name</option>\r\n");
      out.write("                                <option value=\"bycate\"> by category</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                            <input type=\"submit\" value=\"search\" name=\"action\">\r\n");
      out.write("                        </form></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </header>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("        </header>\r\n");
      out.write("        ");

            String name = (String) session.getAttribute("name");
            if(name != null)
            {
        
      out.write("\r\n");
      out.write("        <h3>Welcome ");
      out.print( session.getAttribute("name") );
      out.write(" back </h3>\r\n");
      out.write("        <h3> <a href=\"mainController?action=logout\">Logout</a></h3>\r\n");
      out.write("        <h3> <a href=\"personalPage.jsp\">Personal page</a></h3>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("        <p style=\"color:red;\">\r\n");
      out.write("        ");
      out.print( (request.getAttribute("WARNING"))==null?"":(String)request.getAttribute("WARNING") );
      out.write("\r\n");
      out.write("        </p>\r\n");
      out.write("        <section>\r\n");
      out.write("            <table class=\"shopping\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Product id \r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Image\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        quantity\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>Price</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        action\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                HashMap<String,Integer> cart = (HashMap) session.getAttribute("cart");
                int totalMoney = 0;
                if(cart != null)
                {
                    Set<String> pids = cart.keySet();
                    for(String pid : pids)
                    {
                        int quantity = cart.get(pid);
                        Plant plant = PlantDao.getPlant(Integer.parseInt(pid));
                
      out.write("\r\n");
      out.write("                    <form action=\"mainController\" method=\"post\">\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print( pid );
      out.write("\" name=\"pid\">\r\n");
      out.write("                                <a href=\"getPlantServlet?pid=");
      out.print( pid);
      out.write('"');
      out.write('>');
      out.print( pid);
      out.write("</a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                             <td><img src=\"");
      out.print( plant.getImgpath() );
      out.write("\" style=\"width:10vw;\"></td>\r\n");
      out.write("                             <td><input type=\"number\" name=\"quantity\" value=\"");
      out.print( quantity );
      out.write("\"> </td>\r\n");
      out.write("                             <td>");
      out.print( plant.getPrice() );
      out.write(" </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <input type=\"submit\" value=\"update\" name=\"action\">\r\n");
      out.write("                                <input type=\"submit\" onclick=\"return warning()\"value=\"delete\" name=\"action\">\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </form>\r\n");
      out.write("                ");

                    totalMoney += quantity * plant.getPrice();
                    }
                }
                else
                {
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Your cart is empty\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                }
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Total money: ");
      out.print( totalMoney );
      out.write("\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </section>\r\n");
      out.write("    <setion>\r\n");
      out.write("        <form action=\"mainController\" method=\"post\">\r\n");
      out.write("            <input type=\"submit\" value=\"saveOrder\" name=\"action\" class=\"submitorder\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </setion>           \r\n");
      out.write("        <footer>\r\n");
      out.write("            ");
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
      out.write("        <footer>\n");
      out.write("            <p> Copyright &copy; 2021 <br>Made by Bui Thanh Tu SE151150 </p>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\r\n");
      out.write("        </footer>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
