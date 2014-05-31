package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import collection.Score;
import process.SearchMethod;
import java.util.List;
import java.util.ArrayList;

public final class SearchEngine_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"resource/css/style.css\"/>\n");
      out.write("        <title>Tìm kiếm</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"ajax.js\" ></script>\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.10.1.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        $(document).ready(function(){\n");
      out.write("            $('#ksimd img').hover(function(){\n");
      out.write("                var str = $(this).attr('data-tooltip');\n");
      out.write("                $('<p class=\"tooltip\"></p>').text(str).appendTo('body').fadeIn(600);\n");
      out.write("            }, function(){\n");
      out.write("                $('.tooltip').remove();\n");
      out.write("            }).mousemove(function(e){\n");
      out.write("                var x = e.pageX + 20;\n");
      out.write("                var y = e.pageY;\n");
      out.write("                $('.tooltip').css({top : y, left : x});\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"href\"><a href=\"SearchEngine.jsp\">|| Search</a>  ||  <a href=\"index.jsp\">  Insert data ||</a></div>\n");
      out.write("        <div id=\"sbox\" class=\"sform\">\n");
      out.write("            <div class=\"logoBKS\">BKS</div>\n");
      out.write("            <div>\n");
      out.write("                <form action=\"ImageTest\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                    <div>\n");
      out.write("\n");
      out.write("                        <input type=\"file\" name=\"file\" />\n");
      out.write("                        <select name=\"type\" >\n");
      out.write("                            <option value=\"1\">Hostogram</option>\n");
      out.write("                            <option value=\"2\">Avg color</option>\n");
      out.write("                        </select>\n");
      out.write("                        <input class=\"bts\" type=\"submit\" value=\"Seach\" style=\"background:url(resource/images/icon.png)\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"showr\">\n");
      out.write("                ");


                    List<Score> list = new ArrayList<Score>();
                    SearchMethod obj = new SearchMethod();
                    String nofi = (String) request.getAttribute("success");
                    if (nofi == "ok") {
                        String type = (String) request.getAttribute("type");
                        int i = Integer.parseInt(type);
                        long start = System.currentTimeMillis();
                        switch (i) {
                            case 1:
                                list = obj.Histogram();
                                break;
                            case 2:
                                list = obj.Avg();
                                break;
                            default:
                                break;
                        }
                        long end = System.currentTimeMillis();
                        long time = end - start;
                        out.print("Tìm kiếm được "+list.size()+"kết quả, trong "+time+"mini giây");
                
      out.write("\n");
      out.write("            </div><div id=\"ksimd\">\n");
      out.write("            ");

                if (list.size() > 0) {
                    for (Score emp:list) {

                        int k = emp.getId_photo();


            
      out.write("\n");
      out.write("            <img src=\"Image.jsp?id=");
      out.print(k);
      out.write("\" width=\"220\" height=\"150\"data-tooltip=\"");
      out.print(emp.getScore());
      out.write("\" class=\"img\"/>\n");
      out.write("            ");

                        }
                    }
                }
            
      out.write("\n");
      out.write("            \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
