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

public class markConverterServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Mark Converter";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
   
    int point;
    double mark = Double.parseDouble(request.getParameter("markTextBox"));
    String grade;
    //String[] checkBox = request.getParameterValues("markCheckBox");
    if (mark < 60)
    {
        grade = "F";
        point = 0;
    }
    
    else if (mark < 70)
    {
        grade = "D";
        point = 1;
    }
    
    else if (mark<80)
    {
        grade = "C";
        point = 2;
    }
    
    else if (mark<90)
    {
        grade = "B";
        point = 3;
    }
    
    else 
    {
        grade = "A";
        point = 4;
    }
   out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY STYLE=\"background-image: url(Bground4.jpg);\">\n" +
                "<H1 ALIGN=\"CENTER\" STYLE=\"color:yellow\">" + title + "</H1>\n" +
                "<br><TABLE BORDER=1 ALIGN=CENTER>\n" +
                "<TR ALIGN=CENTER><TD ALIGN=RIGHT>" + "<H2 STYLE=\"color:yellow\"> Mark" 
                     + "<TD><H2 STYLE=\"color:yellow\">" + mark);
   
    if ("yes".equals(request.getParameter("gradeCheckBox")))
    {
        out.println( "<TR ALIGN=CENTER><TD ALIGN=RIGHT>" + "<H2 STYLE=\"color:yellow\"> Grade " 
                     + "<TD><H2 STYLE=\"color:yellow\">" + grade);
    }
    if ("Yes".equals(request.getParameter("pointCheckBox")))
    {
        out.println( "<TR ALIGN=CENTER><TD ALIGN=RIGHT>" + "<H2 STYLE=\"color:yellow\"> Point " 
                     + "<TD><H2 STYLE=\"color:yellow\">" + point);
    }
   
   out.println("</H2></BODY></HTML>");
  }
}
