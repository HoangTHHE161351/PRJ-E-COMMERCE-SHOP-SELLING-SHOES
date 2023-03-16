package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_step_end_begin;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_step_end_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_forEach_var_step_end_begin.release();
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Ananas Product</title>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"description\" content=\"Colo Shop Template\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap4/bootstrap.min.css\">\r\n");
      out.write("        <link href=\"plugins/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.carousel.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.theme.default.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/animate.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/jquery-ui-1.12.1.custom/jquery-ui.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/categories_styles.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/categories_responsive.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"super_container\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Header -->\r\n");
      out.write("\r\n");
      out.write("            <header class=\"header trans_300\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Top Navigation -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"top_nav\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6\">\r\n");
      out.write("                                <div class=\"top_nav_left\">Free shipping với đơn hàng trên 800k</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6 text-right\">\r\n");
      out.write("                                <div class=\"top_nav_right\">\r\n");
      out.write("                                    <ul class=\"top_nav_menu\">\r\n");
      out.write("\r\n");
      out.write("                                        ");
 if (session.getAttribute("account") == null) {
                                        
      out.write("\r\n");
      out.write("                                        <li class=\"language\"><a href=\"login.jsp\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>  Sign In</a></li>\r\n");
      out.write("                                        <li class=\"account\"><a href=\"register.jsp\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>  Register</a></li>\r\n");
      out.write("                                            ");

                                            } else {
                                                User u = (User) session.getAttribute("account");
                                            
      out.write("\r\n");
      out.write("                                        <li class=\"language\"><a href=\"updateUser\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i>  Xin chào, ");
      out.print(u.getFirstName());
      out.write("</a></li>\r\n");
      out.write("                                        <li class=\"account\"><a href=\"Logout\"><i class=\"fa fa-sign-out\" aria-hidden=\"true\"></i>  Log out</a></li>\r\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Main Navigation -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"main_nav_container\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-lg-12 text-right\">\r\n");
      out.write("                                <div class=\"logo_container\">\r\n");
      out.write("                                    <a href=\"index\">ana<span>nas</span></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <nav class=\"navbar\">\r\n");
      out.write("                                    <ul class=\"navbar_menu\">\r\n");
      out.write("                                        <li><a href=\"index\">home</a></li>\r\n");
      out.write("                                        <li><a href=\"product\">shop</a></li>\r\n");
      out.write("                                        <li><a href=\"contact\">contact</a></li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                    <ul class=\"navbar_user\">\r\n");
      out.write("                                        <li><form action=\"search\">\r\n");
      out.write("                                                <div class=\"search-form\" style=\"\">\r\n");
      out.write("                                                    <i class=\"fas fa-search\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                                    \r\n");
      out.write("                                                    <!--<input type=\"text\" placeholder=\"Search\" name=\"search\" class=\"search-form__input\" style=\"\"/>-->\r\n");
      out.write("                                                    <!--<button type=\"submit\">search</button>-->\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </li>\r\n");
      out.write("<!--                                        <li><a href=\"#\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i></a></li>-->\r\n");
      out.write("                                        <li class=\"checkout\">\r\n");
      out.write("                                            <a href=\"checkOut\">\r\n");
      out.write("                                                <i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                                <span id=\"checkout_items\" class=\"checkout_items\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cart.getCart().size()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                                            </a>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                    <div class=\"hamburger_container\">\r\n");
      out.write("                                        <i class=\"fa fa-bars\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </nav>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </header>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"fs_menu_overlay\"></div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Hamburger Menu -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"hamburger_menu\">\r\n");
      out.write("                <div class=\"hamburger_close\"><i class=\"fa fa-times\" aria-hidden=\"true\"></i></div>\r\n");
      out.write("                <div class=\"hamburger_menu_content text-right\">\r\n");
      out.write("                    <ul class=\"menu_top_nav\">\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"menu_item has-children\">\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                My Account\r\n");
      out.write("                                <i class=\"fa fa-angle-down\"></i>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <ul class=\"menu_selection\">\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>Sign In</a></li>\r\n");
      out.write("                                <li><a href=\"#\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>Register</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"menu_item\"><a href=\"index\">home</a></li>\r\n");
      out.write("                        <li class=\"menu_item\"><a href=\"product\">shop</a></li>\r\n");
      out.write("                        <li class=\"menu_item\"><a href=\"contact\">contact</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container product_section_container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col product_section clearfix\">\r\n");
      out.write("                        <div class=\"sidebar\" style=\"margin-top: 20px\">\r\n");
      out.write("                            <div class=\"sidebar_section\">\r\n");
      out.write("                                <div class=\"sidebar_title\">\r\n");
      out.write("                                    <h5>Product Category</h5>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <ul class=\"sidebar_categories\">\r\n");
      out.write("                                    <li><a href=\"category?categoryId=1\">Giày</a></li>\r\n");
      out.write("                                    <li><a href=\"category?categoryId=2\">Nửa trên</a></li>\r\n");
      out.write("                                    <li><a href=\"category?categoryId=3\">Phụ kiện</a></li>\r\n");
      out.write("                                    <li><ul class=\"sidebar_categories\">Collection\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("<!--                             Price Range Filtering \r\n");
      out.write("                            <div class=\"sidebar_section\">\r\n");
      out.write("                                <div class=\"sidebar_title\">\r\n");
      out.write("                                    <h5>Filter by Price</h5>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    <input type=\"text\" id=\"amount\" readonly style=\"border:0; color:#f6931f; font-weight:bold;\">\r\n");
      out.write("                                </p>\r\n");
      out.write("                                <div id=\"slider-range\"></div>\r\n");
      out.write("                                <div class=\"filter_button\"><span>filter</span></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                             Sizes \r\n");
      out.write("                            <div class=\"sidebar_section\">\r\n");
      out.write("                                <div class=\"sidebar_title\">\r\n");
      out.write("                                    <h5>Sizes</h5>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <ul class=\"checkboxes\">\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>S</span></li>\r\n");
      out.write("                                    <li class=\"active\"><i class=\"fa fa-square\" aria-hidden=\"true\"></i><span>M</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>L</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>XL</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>XXL</span></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>-->\r\n");
      out.write("\r\n");
      out.write("                            <!-- Color -->\r\n");
      out.write("<!--                            <div class=\"sidebar_section\">\r\n");
      out.write("                                <div class=\"sidebar_title\">\r\n");
      out.write("                                    <h5>Color</h5>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <ul class=\"checkboxes\">\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>Black</span></li>\r\n");
      out.write("                                    <li class=\"active\"><i class=\"fa fa-square\" aria-hidden=\"true\"></i><span>Pink</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>White</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>Blue</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>Orange</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>White</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>Blue</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>Orange</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>White</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>Blue</span></li>\r\n");
      out.write("                                    <li><i class=\"fa fa-square-o\" aria-hidden=\"true\"></i><span>Orange</span></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <div class=\"show_more\">\r\n");
      out.write("                                    <span><span>+</span>Show More</span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>-->\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- Main Content -->\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"main_content\" style=\"margin-top: 20px\">\r\n");
      out.write("\r\n");
      out.write("                            <!-- Products -->\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"products_iso\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col\">\r\n");
      out.write("\r\n");
      out.write("                                        <!-- Product Sorting -->\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"product_sorting_container product_sorting_container_top\">\r\n");
      out.write("                                            <ul class=\"product_sorting\">\r\n");
      out.write("                                                <li>\r\n");
      out.write("                                                    <span class=\"type_sorting_text\">Default Sorting</span>\r\n");
      out.write("                                                    <i class=\"fa fa-angle-down\"></i>\r\n");
      out.write("                                                    <ul class=\"sorting_type\">\r\n");
      out.write("                                                        <li class=\"type_sorting_btn\" data-isotope-option='{ \"sortBy\": \"original-order\" }'><span>Default Sorting</span></li>\r\n");
      out.write("                                                        <li class=\"type_sorting_btn\" data-isotope-option='{ \"sortBy\": \"price\" }'><span>Price</span></li>\r\n");
      out.write("                                                        <li class=\"type_sorting_btn\" data-isotope-option='{ \"sortBy\": \"name\" }'><span>Product Name</span></li>\r\n");
      out.write("                                                    </ul>\r\n");
      out.write("                                                </li>\r\n");
      out.write("                                                <li>\r\n");
      out.write("                                                    <span>Show</span>\r\n");
      out.write("                                                    <span class=\"num_sorting_text\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numProduct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                                                    <i class=\"fa fa-angle-down\"></i>\r\n");
      out.write("                                                    <ul class=\"sorting_num\">\r\n");
      out.write("                                                        <li class=\"num_sorting_btn\"><span><a href=\"product?numProduct=6\">6</a></span></li>\r\n");
      out.write("                                                        <li class=\"num_sorting_btn\"><span><a href=\"product?numProduct=12\">12</a></span></li>\r\n");
      out.write("                                                        <li class=\"num_sorting_btn\"><span><a href=\"product?numProduct=24\">24</a></span></li>\r\n");
      out.write("                                                    </ul>\r\n");
      out.write("                                                </li>\r\n");
      out.write("                                            </ul>\r\n");
      out.write("                                            <div class=\"pages d-flex flex-row align-items-center\">\r\n");
      out.write("                                                <div class=\"page_current\">\r\n");
      out.write("                                                    <span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                                                    <ul class=\"page_selection\">\r\n");
      out.write("                                                        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                                    </ul>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"page_total\"><span>of</span> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("                                                <div id=\"next_page\" class=\"page_next\"><a href=\"#\"><i class=\"fa fa-long-arrow-right\" aria-hidden=\"true\"></i></a></div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <!-- Product Grid -->\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"product-grid\">\r\n");
      out.write("\r\n");
      out.write("                                            <!-- Product 1 -->\r\n");
      out.write("                                            ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Benefit -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"benefit\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row benefit_row\">\r\n");
      out.write("                        <div class=\"col-lg-3 benefit_col\">\r\n");
      out.write("                            <div class=\"benefit_item d-flex flex-row align-items-center\">\r\n");
      out.write("                                <div class=\"benefit_icon\"><i class=\"fa fa-truck\" aria-hidden=\"true\"></i></div>\r\n");
      out.write("                                <div class=\"benefit_content\">\r\n");
      out.write("                                    <h6>free shipping</h6>\r\n");
      out.write("                                    <p>Suffered Alteration in Some Form</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-3 benefit_col\">\r\n");
      out.write("                            <div class=\"benefit_item d-flex flex-row align-items-center\">\r\n");
      out.write("                                <div class=\"benefit_icon\"><i class=\"fa fa-money\" aria-hidden=\"true\"></i></div>\r\n");
      out.write("                                <div class=\"benefit_content\">\r\n");
      out.write("                                    <h6>cach on delivery</h6>\r\n");
      out.write("                                    <p>The Internet Tend To Repeat</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-3 benefit_col\">\r\n");
      out.write("                            <div class=\"benefit_item d-flex flex-row align-items-center\">\r\n");
      out.write("                                <div class=\"benefit_icon\"><i class=\"fa fa-undo\" aria-hidden=\"true\"></i></div>\r\n");
      out.write("                                <div class=\"benefit_content\">\r\n");
      out.write("                                    <h6>45 days return</h6>\r\n");
      out.write("                                    <p>Making it Look Like Readable</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-3 benefit_col\">\r\n");
      out.write("                            <div class=\"benefit_item d-flex flex-row align-items-center\">\r\n");
      out.write("                                <div class=\"benefit_icon\"><i class=\"fa fa-clock-o\" aria-hidden=\"true\"></i></div>\r\n");
      out.write("                                <div class=\"benefit_content\">\r\n");
      out.write("                                    <h6>opening all week</h6>\r\n");
      out.write("                                    <p>8AM - 09PM</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Newsletter -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"newsletter\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"newsletter_text d-flex flex-column justify-content-center align-items-lg-start align-items-md-center text-center\">\r\n");
      out.write("                                <h4>Newsletter</h4>\r\n");
      out.write("                                <p>Subscribe to our newsletter and get 20% off your first purchase</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center\">\r\n");
      out.write("                                <input id=\"newsletter_email\" type=\"email\" placeholder=\"Your email\" required=\"required\" data-error=\"Valid email is required.\">\r\n");
      out.write("                                <button id=\"newsletter_submit\" type=\"submit\" class=\"newsletter_submit_btn trans_300\" value=\"Submit\">subscribe</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Footer -->\r\n");
      out.write("\r\n");
      out.write("            <footer class=\"footer\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center\">\r\n");
      out.write("                                <ul class=\"footer_nav\">\r\n");
      out.write("                                    <li><a href=\"#\">Blog</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">FAQs</a></li>\r\n");
      out.write("                                    <li><a href=\"contact.jsp\">Contact us</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center\">\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-facebook\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-twitter\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-instagram\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-skype\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                    <li><a href=\"#\"><i class=\"fa fa-pinterest\" aria-hidden=\"true\"></i></a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-lg-12\">\r\n");
      out.write("                            <div class=\"footer_nav_container\">\r\n");
      out.write("                                <!--\t\t\t\t\t\t<div class=\"cr\">Â©2018 All Rights Reserverd. Template by <a href=\"#\">Colorlib</a></div>-->\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </footer>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("        <script src=\"styles/bootstrap4/popper.js\"></script>\r\n");
      out.write("        <script src=\"styles/bootstrap4/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"plugins/Isotope/isotope.pkgd.min.js\"></script>\r\n");
      out.write("        <script src=\"plugins/OwlCarousel2-2.2.1/owl.carousel.js\"></script>\r\n");
      out.write("        <script src=\"plugins/easing/easing.js\"></script>\r\n");
      out.write("        <script src=\"plugins/jquery-ui-1.12.1.custom/jquery-ui.js\"></script>\r\n");
      out.write("        <script src=\"js/categories_custom.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("c");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${collectionList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                <li>&emsp;&emsp;<a href=\"category?collectionId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.getCollectionName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\r\n");
          out.write("                                            ");
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

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_step_end_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setBegin(1);
    _jspx_th_c_forEach_1.setEnd(((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numPage}", java.lang.Integer.class, (PageContext)_jspx_page_context, null)).intValue());
    _jspx_th_c_forEach_1.setStep(1);
    _jspx_th_c_forEach_1.setVar("t");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                            <li><a href=\"product?numProduct=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${numProduct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&start=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(t-1)*numProduct}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&end=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(t*numProduct > size)?size:(t*numProduct)}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("</a></li>\r\n");
          out.write("                                                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_step_end_begin.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${t}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("p");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${productList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                                <div class=\"product-item\">\r\n");
          out.write("                                                    <div class=\"product discount product_filter\">\r\n");
          out.write("                                                        <div class=\"product_image\">\r\n");
          out.write("                                                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getImages()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                        <div class=\"favorite favorite_right\"></div>\r\n");
          out.write("                                                        <!--<div class=\"product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center\"><span>-$20</span></div>-->\r\n");
          out.write("                                                        <div class=\"product_info\">\r\n");
          out.write("                                                            <h6 class=\"product_name\"><a href=\"single.html\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProductName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h6>\r\n");
          out.write("                                                            <div class=\"product_price\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("                                                        </div>\r\n");
          out.write("                                                    </div>\r\n");
          out.write("                                                    <div class=\"red_button add_to_cart_button\"><a href=\"cart?productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProductCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">add to cart</a></div>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
