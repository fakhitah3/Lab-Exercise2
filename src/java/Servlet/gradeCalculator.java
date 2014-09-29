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

public class gradeCalculator extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Grade Calculator";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
   
    int point;
    double midTerm = Double.parseDouble(request.getParameter("midTermTextBox"));
    double project = Double.parseDouble(request.getParameter("projectTextBox"));
    double finalExam = Double.parseDouble(request.getParameter("finalTextBox"));
    double average = (midTerm*30/100) + (project*30/100) + (finalExam*40/100);
    String grade, result;
    //String[] checkBox = request.getParameterValues("markCheckBox");
    double mark = average;
    if (average < 60) 
        result = "Fail";
    else 
        result = "Pass!";
    
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
                "<TABLE BORDER=1 ALIGN=CENTER>\n" + 
                "<TR ALIGN=CENTER><TD ALIGN=RIGHT>" 
                + "<H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\"> Average : </H2><TD><H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\">" );
   out.printf("%.1f", average);
   out.println("<TR ALIGN=CENTER><TD ALIGN=RIGHT>" + 
               "<H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\"> Grade : </H2><TD><H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\">" 
               + grade +"<TR ALIGN=CENTER><TD ALIGN=RIGHT>" + 
               "<H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\"> Point : </H2><TD><H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\">" 
               + point + "<TR ALIGN=CENTER><TD ALIGN=RIGHT>" + 
               "<H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\"> Result: </H2><TD><H2 ALIGN=\"CENTER\" STYLE=\"color:yellow\">" 
               + result + "</H2></BODY></HTML>");
  }
}
