/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.36
 * Generated at: 2020-10-26 05:21:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>로그인 화면</title>\r\n");
      out.write("<!-- 로그인 css -->\r\n");
      out.write("<style>\r\n");
      out.write("table {\r\n");
      out.write("    border-collapse: collapse;\r\n");
      out.write("    border-spacing: 0;\r\n");
      out.write("}\r\n");
      out.write("    .wrapper { width:100%; height:80%; padding-top:5%; font-family: '돋움';}\r\n");
      out.write("    .main { }\r\n");
      out.write("    \r\n");
      out.write("    .login_box { width:300px; height:350px; padding: 40px; margin: 0 auto;   \r\n");
      out.write("                  border: 1px solid black;}\r\n");
      out.write("    .login_box .input_login { border-bottom: 2px solid gray; padding: 20px 0 9px 0;}\r\n");
      out.write("    .login_box .input_login input { width: 100%; color: gray; font-size: 15px; border:none; font-family:inherit;}\r\n");
      out.write("    .login_box .check { color: black; font-size: 14px; padding: 10px 0px 15px 0px; font-family: '돋움';}\r\n");
      out.write("    \r\n");
      out.write("    .login_box  .login input { width:100%; height:55px;  font-size:16px; \r\n");
      out.write("                               padding:17px 0 16px; border:0; cursor:pointer; font-family:'돋움';}\r\n");
      out.write("    \r\n");
      out.write("    .login_box .last { width:100%; margin-top:10px; border-top:1px solid gray; padding-top:20px;}\r\n");
      out.write("    .login_box .last .join { float:left;}\r\n");
      out.write("    .login_box .last .search { float:right;}\r\n");
      out.write("    .login_box .last .join a { color: gray;}\r\n");
      out.write("    .login_box .last .search a { color:gray;} \r\n");
      out.write("</style>\r\n");
      out.write("<!-- 로그인 스크립트 -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction login_ok(f) {\r\n");
      out.write("\t\tf.action = \"login_ok.do\";\r\n");
      out.write("\t\tf.submit();\r\n");
      out.write("\t\tif (document.getElementById(\"log_id\").value != document\r\n");
      out.write("\t\t\t\t.getElementById(\"hidden1\").value) {\r\n");
      out.write("\t\t\talert(\"아이디가 틀렸습니다.\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (document.getElementById(\"login_pw\").value != document\r\n");
      out.write("\t\t\t\t.getElementById(\"hidden2\").value) {\r\n");
      out.write("\t\t\talert(\"비밀번호가 틀렸습니다.\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction join_go() {\r\n");
      out.write("\t\tlocation.href = \"join.do\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction findidpw_go() {\r\n");
      out.write("\t\tlocation.href = \"findidpw.do\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../frame/header.jsp", out, false);
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 로그인창 -->\r\n");
      out.write(" <div class=\"wrapper\">\r\n");
      out.write(" \t<form action=\"\">\r\n");
      out.write("        <div class=\"main\">\r\n");
      out.write("            <div class=\"login_box\">\r\n");
      out.write("                <div class=\"input_login\">\r\n");
      out.write("                    <input type=\"text\" name=\"m_id\" placeholder=\"아이디을 입력하세요\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"input_login\">\r\n");
      out.write("                    <input type=\"password\" name=\"m_pw\" placeholder=\"비밀번호를 입력하세요\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"check\">\r\n");
      out.write("                    <label><input type=\"checkbox\">로그인 유지</label>\r\n");
      out.write("                    <input type=\"hidden\" >\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"login\">\r\n");
      out.write("                    <input type=\"button\" value=\"로그인\" onclick=\"login_ok(this.form)\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"last\">\r\n");
      out.write("               \t \t<input class=\"join\" type=\"button\" value=\"회원가입\" onclick=\"join_go(this.form)\">\r\n");
      out.write("                \t<input class=\"search\" type=\"button\" value=\"ID/PW 찾기\" onclick=\"findidpw_go(this.form)\">\r\n");
      out.write("                    <!-- <div class=\"join\"><a href=\"join_go(this.form)\">회원가입</a></div>\r\n");
      out.write("                    \t <div class=\"search\"><a href=\"findidpw_go(this.form)\">ID/PW 찾기</a></div> \r\n");
      out.write("                    -->\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../frame/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}