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

public class tuitionCalculationServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Tuition Calculation";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
   int aasCourse = Integer.parseInt(request.getParameter("aasTextBox"));
   int eslCourse = Integer.parseInt(request.getParameter("eslTextBox"));
   double discount = Integer.parseInt(request.getParameter("discountRateSelectBox"));
   double tuitionFee = (aasCourse*120)+(eslCourse*75);
   tuitionFee = tuitionFee - (discount/100*tuitionFee); 
   out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY STYLE=\"background-image: url(Bground3.jpg);\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" 
                + "<H2 ALIGN=\"CENTER\">" 
                + "Your tuition fee is :\n" );
   out.printf("%.2f",tuitionFee);
   out.println(" USD\n" + "</H2></BODY></HTML>");
   
   
  }
}
