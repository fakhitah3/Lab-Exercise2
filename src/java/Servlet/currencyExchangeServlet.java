package Servlet;



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Simple servlet that reads three parameters from the
 *  form data.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class currencyExchangeServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Currency Exchange";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
   String currency = request.getParameter("desCurrencyRadio");
   double currencyExchange = 0;
   double vnd = Double.parseDouble(request.getParameter("vndTextBox"));
   
   if (null != currency)
        switch (currency) {
        case "EUR":
            currencyExchange =25170.38;
            break;
        case "JPY":
            currencyExchange = 151.38;
            break;
        case "USD":
            currencyExchange = 16452;
            break;
    }
   
   
   
   out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY STYLE=\"background-image: url(Bground2.jpg);\">\n" +
                "<H1 ALIGN=\"CENTER\" STYLE=\"color:white\">"+ title +"</H1>\n"
                +"<H2 ALIGN=\"CENTER\" STYLE=\"color:white\">" + vnd + " VND equals\n"); 
    out.printf("%.2f",vnd/currencyExchange);
    out.println(" " + currency + "</H2></BODY></HTML>");
   
   
  }
}
