package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class checkOut_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      out.write("        <title>Check out</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!--===============================================================================================-->\t\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\"/>\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\n");
      out.write("        <!--===============================================================================================-->\t\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/responsive.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/util.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main_styles.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main.css\">\n");
      out.write("\n");
      out.write("        <!--===============================================================================================-->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"super_container\">\n");
      out.write("\n");
      out.write("            <!-- Header -->\n");
      out.write("\n");
      out.write("            <header class=\"header trans_300\">\n");
      out.write("                <!-- Top Navigation -->\n");
      out.write("\n");
      out.write("                <div class=\"top_nav\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-6 \">\n");
      out.write("                                <div class=\"top_nav_left\">Free shipping với đơn hàng trên 800k</div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-6 text-right\">\n");
      out.write("                                <div class=\"top_nav_right\">\n");
      out.write("                                    <ul class=\"top_nav_menu\">\n");
      out.write("                                        ");
 if (session.getAttribute("account") == null) {
                                        
      out.write("\n");
      out.write("                                        <li class=\"language\"><a href=\"login.jsp\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>  Sign In</a></li>\n");
      out.write("                                        <li class=\"account\"><a href=\"register.jsp\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>  Register</a></li>\n");
      out.write("                                            ");

                                            } else {
                                                User u = (User) session.getAttribute("account");
                                            
      out.write("\n");
      out.write("                                        <li class=\"language\"><a href=\"updateUser\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i>  Xin chào, ");
      out.print(u.getFirstName());
      out.write("</a></li>\n");
      out.write("                                        <li class=\"account\"><a href=\"Logout\"><i class=\"fa fa-sign-out\" aria-hidden=\"true\"></i>  Log out</a></li>\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- Main Navigation -->\n");
      out.write("\n");
      out.write("                <div class=\"main_nav_container\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-12 text-right\">\n");
      out.write("                                <div class=\"logo_container\">\n");
      out.write("                                    <a href=\"index\">ana<span>nas</span></a>\n");
      out.write("                                </div>\n");
      out.write("                                <nav class=\"navbar\">\n");
      out.write("                                    <ul class=\"navbar_menu\">\n");
      out.write("                                        <li><a href=\"index\">home</a></li>\n");
      out.write("                                        <li><a href=\"product\">shop</a></li>\n");
      out.write("                                        <li><a href=\"contact\">contact</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <ul class=\"navbar_user\">\n");
      out.write("                                        <li><a href=\"#\"><i class=\"fa fa-search\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                                        <li><a href=\"#\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i></a></li>\n");
      out.write("                                        <li class=\"checkout\">\n");
      out.write("                                            <a href=\"checkOut\">\n");
      out.write("                                                <i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i>\n");
      out.write("                                                <span id=\"checkout_items\" class=\"checkout_items\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cart.getCart().size()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                                            </a>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                    <div class=\"hamburger_container\">\n");
      out.write("                                        <i class=\"fa fa-bars\" aria-hidden=\"true\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </header>\n");
      out.write("            <div class=\"fs_menu_overlay\"></div>\n");
      out.write("            <div class=\"hamburger_menu\">\n");
      out.write("                <div class=\"hamburger_close\"><i class=\"fa fa-times\" aria-hidden=\"true\"></i></div>\n");
      out.write("                <div class=\"hamburger_menu_content text-right\">\n");
      out.write("                    <ul class=\"menu_top_nav\">\n");
      out.write("                        <li class=\"menu_item has-children\">\n");
      out.write("                            <a href=\"#\">\n");
      out.write("                                My Account\n");
      out.write("                                <i class=\"fa fa-angle-down\"></i>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"menu_selection\">\n");
      out.write("                                <li><a href=\"login.jsp\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>  Sign In</a></li>\n");
      out.write("                                <li><a href=\"register.jsp\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>  Register</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"menu_item\"><a href=\"index\">home</a></li>\n");
      out.write("                        <li class=\"menu_item\"><a href=\"product\">shop</a></li>\n");
      out.write("                        <li class=\"menu_item\"><a href=\"contact\">contact</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
      out.write("\n");
      out.write("            <!--<div> Không có sản phẩm nào được chọn</div>-->                    \n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      out.write("    \n");
      out.write("            <form action=\"./order\">\n");
      out.write("                <div class=\"container-login100\">\n");
      out.write("                    <div class=\"wrap-login100\" style=\"width: 85%\">\n");
      out.write("                        <div class=\"login100-pic js-tilt\" data-tilt style=\"width: 60%\">\n");
      out.write("                            ");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            <h3> Total : <div>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div> VNĐ</h3>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"login100-form validate-form\" style=\"width: 35%\">\n");
      out.write("\n");
      out.write("                            <span class=\"login100-form-title\">\n");
      out.write("                                Check out\n");
      out.write("                            </span>\n");
      out.write("                            ");
 if (session.getAttribute("account") == null) {
                            
      out.write("\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Name is required\" style=\"display: flex;\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"firstName\" placeholder=\"First name\">\n");
      out.write("                                <div class=\"breadcrumb\" style=\"background-color: #ffffff\"></div>\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"lastName\" placeholder=\"Last name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Phone number is required\" style=\"display: flex;\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"phoneNumber\" placeholder=\"Phone number\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Address is required\" style=\"display: flex;\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"address\" placeholder=\"Address\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"container-login100-form-btn\">\n");
      out.write("                                <button type=\"submit\" class=\"login100-form-btn\">\n");
      out.write("                                    Check out\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"text-center p-t-136\">\n");
      out.write("                                <a class=\"txt2\" href=\"login.jsp\">\n");
      out.write("                                    Login to check out\n");
      out.write("                                    <i class=\"fa fa-long-arrow-right m-l-5\" aria-hidden=\"true\"></i>\n");
      out.write("                                </a>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                            } else {
                                User user = (User) session.getAttribute("account");
                            
      out.write("\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Name is required\" style=\"display: flex;\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"firstName\" placeholder=\"First name\" value=\"");
      out.print(user.getFirstName());
      out.write("\">\n");
      out.write("                                <div class=\"breadcrumb\" style=\"background-color: #ffffff\"></div>\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"lastName\" placeholder=\"Last name\" value=\"");
      out.print(user.getLastName());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Phone number is required\" style=\"display: flex;\">\n");
      out.write("                            <input class=\"input100\" type=\"text\" name=\"phoneNumber\" placeholder=\"Phone number\" value=\"");
      out.print(user.getPhoneNumber());
      out.write("\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"wrap-input100 validate-input\" data-validate = \"Address is required\" style=\"display: flex;\">\n");
      out.write("                                <input class=\"input100\" type=\"text\" name=\"address\" placeholder=\"Address\"value=\"");
      out.print(user.getAddress());
      out.write("\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"container-login100-form-btn\">\n");
      out.write("                                <button type=\"submit\" class=\"login100-form-btn\">\n");
      out.write("                                    Check out\n");
      out.write("                                </button>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                            <div class=\"text-center p-t-136\">\n");
      out.write("                                <a class=\"txt2\" href=\"index\">\n");
      out.write("                                    Continue shopping\n");
      out.write("                                    <i class=\"fa fa-long-arrow-right m-l-5\" aria-hidden=\"true\"></i>\n");
      out.write("                                </a>\n");
      out.write("                            </div> \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            ");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>                                            \n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("total");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${0}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("p");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cart.getCart()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\n");
          out.write("                                <div class=\"row\" style=\"display: flex; width: 100%\">\n");
          out.write("                                    <div class=\"product_image\" style=\"width: 100px\">\n");
          out.write("                                        <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProduct().getImages()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" style=\"width: 100px; height: 100px;margin-right: 10px; \">\n");
          out.write("                                    </div >\n");
          out.write("                                    <h5 class=\"product_name\" style=\"width: 30%;padding-left: 20px; \">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProduct().getProductName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h5>\n");
          out.write("                                    <div style=\"width: 10%\">\n");
          out.write("                                        <h6>Price</h6>\n");
          out.write("                                        <div class=\"product_price\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProduct().getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\n");
          out.write("                                    </div>\n");
          out.write("                                    <div style=\"width: 10%\">\n");
          out.write("                                        <h6> Size </h6>\n");
          out.write("                                        <input name=\"size\" type=\"text\"/>\n");
          out.write("                                    </div>\n");
          out.write("                                    <div style=\"width: 10%\">\n");
          out.write("                                        <h6>Quantity</h6>\n");
          out.write("                                        <button><a href=\"checkOut?quantity=tru&productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProduct().getProductCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">-</a></button><b class=\"\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getQuantity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</b><button><a href=\"checkOut?quantity=cong&productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProduct().getProductCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">+</a></button>\n");
          out.write("\n");
          out.write("                                    </div>\n");
          out.write("                                    ");
          if (_jspx_meth_c_set_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("\n");
          out.write("                                </div>\n");
          out.write("                                <div class=\"breadcrumb\"></div>\n");
          out.write("\n");
          out.write("                            ");
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

  private boolean _jspx_meth_c_set_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_set_1.setVar("total");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${total + p.getQuantity()*p.getProduct().getPrice()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }
}
