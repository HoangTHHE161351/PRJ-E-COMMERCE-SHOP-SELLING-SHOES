package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Cart;
import modelAdmin.Product;
import java.util.ArrayList;
import dal.ProductDAO;
import model.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Ananas</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/bootstrap4/bootstrap.min.css\">\r\n");
      out.write("        <link href=\"plugins/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.carousel.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/owl.theme.default.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"plugins/OwlCarousel2-2.2.1/animate.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/main_styles.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/responsive.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"super_container\">\r\n");
      out.write("\r\n");
      out.write("            <!-- Header -->\r\n");
      out.write("\r\n");
      out.write("            <header class=\"header trans_300\">\r\n");
      out.write("                <!-- Top Navigation -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"top_nav\">\r\n");
      out.write("                    <div class=\"container\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-md-6 \">\r\n");
      out.write("                                <div class=\"top_nav_left\">Free shipping với đơn hàng trên 800k</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-md-6 text-right\">\r\n");
      out.write("                                <div class=\"top_nav_right\">\r\n");
      out.write("                                    <ul class=\"top_nav_menu\">\r\n");
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
      out.write("                                                    <input type=\"text\" placeholder=\"Search\" name=\"search\" class=\"search-form__input\" style=\"\"/>\r\n");
      out.write("                                                    <button type=\"submit\" style=\"border: none\" ><i class=\"fa fa-search\" aria-hidden=\"true\"></i></button>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </form></li>\r\n");
      out.write("                                        <!--<li><a href=\"#\"><i class=\"fa fa-user\" aria-hidden=\"true\"></i></a></li>-->\r\n");
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
      out.write("            <div class=\"hamburger_menu\">\r\n");
      out.write("                <div class=\"hamburger_close\"><i class=\"fa fa-times\" aria-hidden=\"true\"></i></div>\r\n");
      out.write("                <div class=\"hamburger_menu_content text-right\">\r\n");
      out.write("                    <ul class=\"menu_top_nav\">\r\n");
      out.write("                        <li class=\"menu_item has-children\">\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                My Account\r\n");
      out.write("                                <i class=\"fa fa-angle-down\"></i>\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <ul class=\"menu_selection\">\r\n");
      out.write("                                <li><a href=\"login.jsp\"><i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>  Sign In</a></li>\r\n");
      out.write("                                <li><a href=\"register.jsp\"><i class=\"fa fa-user-plus\" aria-hidden=\"true\"></i>  Register</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"menu_item\"><a href=\"index\">home</a></li>\r\n");
      out.write("                        <li class=\"menu_item\"><a href=\"product\">shop</a></li>\r\n");
      out.write("                        <li class=\"menu_item\"><a href=\"contact\">contact</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Slider -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"main_slider\" style=\"background-image:url(images/slider_1.jpg)\">\r\n");
      out.write("                <div class=\"container fill_height\">\r\n");
      out.write("                    <div class=\"row align-items-center fill_height\">\r\n");
      out.write("                        <div class=\"col\">\r\n");
      out.write("                            <div class=\"main_slider_content\">\r\n");
      out.write("                                <h6>Spring / Summer Collection 2017</h6>\r\n");
      out.write("                                <h1>Get up to 30% Off New Arrivals</h1>\r\n");
      out.write("                                <div class=\"red_button shop_now_button\"><a href=\"product\">shop now</a></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Banner -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"banner\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-4\">\r\n");
      out.write("                            <div class=\"banner_item align-items-center\" style=\"background-image:url(images/banner_1.jpg)\">\r\n");
      out.write("                                <div class=\"banner_category\">\r\n");
      out.write("                                    <a href=\"#\">Cho Nữ</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-4\">\r\n");
      out.write("                            <div class=\"banner_item align-items-center\" style=\"background-image:url(images/banner_2.jpg)\">\r\n");
      out.write("                                <div class=\"banner_category\">\r\n");
      out.write("                                    <a href=\"#\">Phụ kiện</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-4\">\r\n");
      out.write("                            <div class=\"banner_item align-items-center\" style=\"background-image:url(images/banner_3.jpg)\">\r\n");
      out.write("                                <div class=\"banner_category\">\r\n");
      out.write("                                    <a href=\"#\">Cho Nam</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- New Arrivals -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"new_arrivals\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col text-center\">\r\n");
      out.write("                            <div class=\"section_title new_arrivals_title\">\r\n");
      out.write("                                <h2>New Arrivals</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row align-items-center\">\r\n");
      out.write("                        <div class=\"col text-center\">\r\n");
      out.write("                            <div class=\"new_arrivals_sorting\">\r\n");
      out.write("                                <ul class=\"arrivals_grid_sorting clearfix button-group filters-button-group\">\r\n");
      out.write("                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked\" data-filter=\"*\">all</li>\r\n");
      out.write("                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center\" data-filter=\".women\">women's</li>\r\n");
      out.write("                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center\" data-filter=\".accessories\">accessories</li>\r\n");
      out.write("                                    <li class=\"grid_sorting_button button d-flex flex-column justify-content-center align-items-center\" data-filter=\".men\">men's</li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col\">\r\n");
      out.write("                            <div class=\"product-grid\" data-isotope='{ \"itemSelector\": \".product-item\", \"layoutMode\": \"fitRows\" }'>\r\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Deal of the week -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"deal_ofthe_week\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row align-items-center\">\r\n");
      out.write("                        <div class=\"col-lg-6\">\r\n");
      out.write("                            <div class=\"deal_ofthe_week_img\">\r\n");
      out.write("                                <img src=\"images/deal_ofthe_week.png\" alt=\"\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-6 text-right deal_ofthe_week_col\">\r\n");
      out.write("                            <div class=\"deal_ofthe_week_content d-flex flex-column align-items-center float-right\">\r\n");
      out.write("                                <div class=\"section_title\">\r\n");
      out.write("                                    <h2>Deal Of The Week</h2>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <ul class=\"timer\">\r\n");
      out.write("                                    <li class=\"d-inline-flex flex-column justify-content-center align-items-center\">\r\n");
      out.write("                                        <div id=\"day\" class=\"timer_num\">03</div>\r\n");
      out.write("                                        <div class=\"timer_unit\">Day</div>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li class=\"d-inline-flex flex-column justify-content-center align-items-center\">\r\n");
      out.write("                                        <div id=\"hour\" class=\"timer_num\">15</div>\r\n");
      out.write("                                        <div class=\"timer_unit\">Hours</div>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li class=\"d-inline-flex flex-column justify-content-center align-items-center\">\r\n");
      out.write("                                        <div id=\"minute\" class=\"timer_num\">45</div>\r\n");
      out.write("                                        <div class=\"timer_unit\">Mins</div>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    <li class=\"d-inline-flex flex-column justify-content-center align-items-center\">\r\n");
      out.write("                                        <div id=\"second\" class=\"timer_num\">23</div>\r\n");
      out.write("                                        <div class=\"timer_unit\">Sec</div>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                                <div class=\"red_button deal_ofthe_week_button\"><a href=\"product\">shop now</a></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Best Sellers -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"best_sellers\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col text-center\">\r\n");
      out.write("                            <div class=\"section_title new_arrivals_title\">\r\n");
      out.write("                                <h2>Best Sellers</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col\">\r\n");
      out.write("                            <div class=\"product_slider_container\">\r\n");
      out.write("                                <div class=\"owl-carousel owl-theme product_slider\">\r\n");
      out.write("\r\n");
      out.write("                                    <!-- Slide 1 -->\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <!-- Slider Navigation -->\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column\">\r\n");
      out.write("                                    <i class=\"fa fa-chevron-left\" aria-hidden=\"true\"></i>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column\">\r\n");
      out.write("                                    <i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i>\r\n");
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
      out.write("            <!-- Blogs -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"blogs\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col text-center\">\r\n");
      out.write("                            <div class=\"section_title\">\r\n");
      out.write("                                <h2>Latest Blogs</h2>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row blogs_container\">\r\n");
      out.write("                        <div class=\"col-lg-4 blog_item_col\">\r\n");
      out.write("                            <div class=\"blog_item\">\r\n");
      out.write("                                <div class=\"blog_background\" style=\"background-image:url(images/blog_1.jpg)\"></div>\r\n");
      out.write("                                <div class=\"blog_content d-flex flex-column align-items-center justify-content-center text-center\">\r\n");
      out.write("                                    <h4 class=\"blog_title\">Here are the trends I see coming this fall</h4>\r\n");
      out.write("                                    <span class=\"blog_meta\">by admin | dec 01, 2017</span>\r\n");
      out.write("                                    <a class=\"blog_more\" href=\"#\">Read more</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-4 blog_item_col\">\r\n");
      out.write("                            <div class=\"blog_item\">\r\n");
      out.write("                                <div class=\"blog_background\" style=\"background-image:url(images/blog_2.jpg)\"></div>\r\n");
      out.write("                                <div class=\"blog_content d-flex flex-column align-items-center justify-content-center text-center\">\r\n");
      out.write("                                    <h4 class=\"blog_title\">Here are the trends I see coming this fall</h4>\r\n");
      out.write("                                    <span class=\"blog_meta\">by admin | dec 01, 2017</span>\r\n");
      out.write("                                    <a class=\"blog_more\" href=\"#\">Read more</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-lg-4 blog_item_col\">\r\n");
      out.write("                            <div class=\"blog_item\">\r\n");
      out.write("                                <div class=\"blog_background\" style=\"background-image:url(images/blog_3.jpg)\"></div>\r\n");
      out.write("                                <div class=\"blog_content d-flex flex-column align-items-center justify-content-center text-center\">\r\n");
      out.write("                                    <h4 class=\"blog_title\">Here are the trends I see coming this fall</h4>\r\n");
      out.write("                                    <span class=\"blog_meta\">by admin | dec 01, 2017</span>\r\n");
      out.write("                                    <a class=\"blog_more\" href=\"#\">Read more</a>\r\n");
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
      out.write("                            <form action=\"post\">\r\n");
      out.write("                                <div class=\"newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center\">\r\n");
      out.write("                                    <input id=\"newsletter_email\" type=\"email\" placeholder=\"Your email\" required=\"required\" data-error=\"Valid email is required.\">\r\n");
      out.write("                                    <button id=\"newsletter_submit\" type=\"submit\" class=\"newsletter_submit_btn trans_300\" value=\"Submit\">subscribe</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
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
      out.write("                                    <li><a href=\"contact.html\">Contact us</a></li>\r\n");
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
      out.write("                                <!--<div class=\"cr\">Â©2018 All Rights Reserverd. This template is made with <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> by <a href=\"#\">Colorlib</a></div>-->\r\n");
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
      out.write("        <script src=\"js/custom.js\"></script>\r\n");
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
    _jspx_th_c_forEach_0.setVar("p");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${newArrival}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                  <div class=\"product-item women\">\r\n");
          out.write("                                    <div class=\"product product_filter\">\r\n");
          out.write("                                        <div class=\"product_image\">\r\n");
          out.write("                                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getImages()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                        <div class=\"favorite\"></div>\r\n");
          out.write("                                        <div class=\"product_bubble product_bubble_left product_bubble_green d-flex flex-column align-items-center\"><span>new</span></div>\r\n");
          out.write("                                        <div class=\"product_info\">\r\n");
          out.write("                                            <h6 class=\"product_name\"><a href=\"product-detail?productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProductCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProductName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h6>\r\n");
          out.write("                                            <div class=\"product_price\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                    <div class=\"red_button add_to_cart_button\"><a href=\"cart?productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${p.getProductCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">add to cart</a></div>\r\n");
          out.write("                                </div>  \r\n");
          out.write("                                ");
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
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("i");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.bestSeller}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                    <div class=\"owl-item product_slider_item\">\r\n");
          out.write("                                        <div class=\"product-item\">\r\n");
          out.write("                                            <div class=\"product discount\">\r\n");
          out.write("                                                <div class=\"product_image\">\r\n");
          out.write("                                                    <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getImages()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\">\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                                <div class=\"favorite favorite_left\"></div>\r\n");
          out.write("                                                <div class=\"product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center\"><span>-$20</span></div>\r\n");
          out.write("                                                <div class=\"product_info\">\r\n");
          out.write("                                                    <h6 class=\"product_name\"><a href=\"product-detail?productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProductCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProductName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h6>\r\n");
          out.write("                                                    <div class=\"product_price\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getPrice()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span></div>\r\n");
          out.write("                                                </div>\r\n");
          out.write("                                            </div>\r\n");
          out.write("                                        </div>\r\n");
          out.write("                                        <div class=\"red_button add_to_cart_button\"><a href=\"cart?productCode=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i.getProductCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">add to cart</a></div>\r\n");
          out.write("                                    </div>\r\n");
          out.write("                                    ");
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
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
