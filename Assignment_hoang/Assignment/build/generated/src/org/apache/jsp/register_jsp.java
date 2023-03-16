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
      out.write("        <title>Register Ananas</title>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/util.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main_styles.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"header trans_300\" style=\"position: relative;\">\n");
      out.write("\n");
      out.write("            <!-- Main Navigation -->\n");
      out.write("\n");
      out.write("            <div class=\"main_nav_container\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-12 text-right\">\n");
      out.write("                           <div class=\"logo_container\">\n");
      out.write("                               <a href=\"index.jsp\">ana<span>nas</span></a>\n");
      out.write("                            </div>\n");
      out.write("                            <nav class=\"navbar\">\n");
      out.write("                                <ul class=\"navbar_menu\">\n");
      out.write("                                    <li><a href=\"index.jsp\">home</a></li>\n");
      out.write("                                    <li><a href=\"product.jsp\">shop</a></li>\n");
      out.write("                                    <li><a href=\"contact.html\">contact</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                                <ul class=\"navbar_user\">\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-search\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("<!--                                    <li><a href=\"#\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                                    <li class=\"checkout\">\n");
      out.write("                                        <a href=\"#\">\n");
      out.write("                                            <i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i>\n");
      out.write("                                            <span id=\"checkout_items\" class=\"checkout_items\">2</span>\n");
      out.write("                                        </a>\n");
      out.write("                                    </li>-->\n");
      out.write("                                </ul>\n");
      out.write("                                <div class=\"hamburger_container\">\n");
      out.write("                                    <i class=\"fa fa-bars\" aria-hidden=\"true\"></i>\n");
      out.write("                                </div>\n");
      out.write("                            </nav>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <div class=\"limiter\">\n");
      out.write("            <div class=\"container-login100\" style=\"min-height: 100vh\">\n");
      out.write("                    <div class=\"wrap-login100\" style=\"padding: 105px 130px 23px 95px;width: 85%\">\n");
      out.write("\t\t\t\t<div class=\"login100-pic js-tilt\" data-tilt>\n");
      out.write("                                    <img style=\"padding-top: 45px\" src=\"images/img-01.png\" alt=\"IMG\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("                            <form class=\"login100-form validate-form\" action=\"./register\">\n");
      out.write("\t\t\t\t\t<span class=\"login100-form-title\">\n");
      out.write("\t\t\t\t\t\tRegister Form\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("                                ");

                                    if(request.getAttribute("error") != null){
                                        
      out.write("\n");
      out.write("                                        <div class=\"text-center txt2\">");
      out.print((String) request.getAttribute("error"));
      out.write("</div>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"Username is required\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"username\" placeholder=\"Username\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-user\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"Password is required\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"password\" name=\"password\" placeholder=\"Password\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-lock\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"Password is required\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"password\" name=\"repassword\" placeholder=\"Re-Password\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-lock\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"Valid email is required: ex@abc.xyz\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"email\" placeholder=\"Email\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-envelope\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("                                        <div class=\"wrap-input100 validate-input\" data-validate = \"Name is required\" style=\"display: flex;\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"firstName\" placeholder=\"First name\">\n");
      out.write("                                <div class=\"breadcrumb\" style=\"background-color: #ffffff\"></div>\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"lastName\" placeholder=\"Last name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Phone number is required\" style=\"\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"phoneNumber\" placeholder=\"Phone number\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Address is required\" style=\"\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"address\" placeholder=\"Address\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn\">\n");
      out.write("                                            <button type=\"submit\" class=\"login100-form-btn\">\n");
      out.write("\t\t\t\t\t\t\tRegister\n");
      out.write("\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"text-center p-t-136\">\n");
      out.write("\t\t\t\t\t\t<a class=\"txt2\" href=\"login.jsp\">\n");
      out.write("\t\t\t\t\t\t\tAlready have Account?\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-long-arrow-right m-l-5\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"vendor/bootstrap/js/popper.js\"></script>\n");
      out.write("\t<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"vendor/select2/select2.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"vendor/tilt/tilt.jquery.min.js\"></script>\n");
      out.write("\t<script >\n");
      out.write("\t\t$('.js-tilt').tilt({\n");
      out.write("\t\t\tscale: 1.1\n");
      out.write("\t\t})\n");
      out.write("\t</script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"js/main.js\"></script>\n");
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
