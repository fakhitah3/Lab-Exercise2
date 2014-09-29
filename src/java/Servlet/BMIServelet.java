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

public class BMIServelet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Your Body Mass Index";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
   double weight, height;
   weight = Double.parseDouble(request.getParameter("weightTextBox"));
   height = Double.parseDouble(request.getParameter("heightTextBox"));
   double bmi = weight / (height*height);
   String status;
   if (bmi < 18.5)
        status = "Underweight";
       
   else if (bmi < 24.5)
        status = "Normal Weight";
   
   else if (bmi < 29.9)
        status = "Overweight";
   
   else 
        status = "Obesity";
   
   out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY STYLE=\"background-image: url(BMI%20Background.jpg);\">"+
                "<H2 ALIGN=\"CENTER\" STYLE=\"color:green\">" + title + "</H2>\n" +
                "<TABLE BORDER=1 ALIGN=CENTER>\n" + 
                "<TR ALIGN=CENTER><TD ALIGN=RIGHT></B>Your Weight</B>:\n<TD> "
                + request.getParameter("weightTextBox") + " (Kg)\n" +
                "<TR ALIGN=CENTER><TD ALIGN=RIGHT></B>Your Height</B>:\n<TD>"
                + request.getParameter("heightTextBox") + " (m)\n" +
                "<TR ALIGN=CENTER><TD ALIGN=RIGHT></B>Your Body Mass Index :</B>\n<TD>");
   out.printf("%.2f", bmi);
   out.println("\n" + "<TR ALIGN=CENTER><TD ALIGN=RIGHT></B>Status </B>: \n<TD>"
                + status + "\n" + "</BODY></HTML>");
  }
}
