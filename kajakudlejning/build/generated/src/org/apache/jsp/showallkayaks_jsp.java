package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import control.Kayak;

public final class showallkayaks_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Book A Kayak</title>\n");
      out.write("        <style>\n");
      out.write("            html, body {\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                font: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            nav {\n");
      out.write("                position: relative;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 2px solid lightblue;\n");
      out.write("                /*margin-left: 10px;*/\n");
      out.write("                /*right: 0px;*/\n");
      out.write("                background-color: aliceblue;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            \n");
      out.write("            table, tr, td, th {\n");
      out.write("                border-top: 1px solid lightgrey;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("            }\n");
      out.write("            tr:nth-child(2n-1){\n");
      out.write("                background: lightblue;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                Du er ");
      out.print( session.getAttribute("username") );
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <a href=\"#\" >Log ud</a>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        \n");
      out.write("        <section>\n");
      out.write("            <h1>Available Kayaks:</h1>\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <tr> \n");
      out.write("                        <th>Name</th> <th>Model</th> <th>Description</th> <th>Year</th> <th>Colour</th> <th>Length</th> <th>Date</th> <th>Book Now</th>  \n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
 List<Kayak> kayaks = (List<Kayak>) session.getAttribute("kayaks"); 
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 for(Kayak kayak : kayaks){
                        out.println("<form method='POST'>" 
                                + "<tr><td>" + kayak.getName() 
                                + "</td><td>" + kayak.getModel()
                                + "</td><td>" + kayak.getDescription()
                                + "</td><td>" + kayak.getYear()
                                + "</td><td>" + kayak.getColor()
                                + "</td><td>" + kayak.getLength()
                                + "</td><td> <input <input type='date' name='date' min='2016-12-31'> </td>" 
                                +  "<td> <input type='submit' value='Book kayak' /></td>" 
                                + "</tr>"
                                + "</form>" );
                    }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </section>\n");
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
