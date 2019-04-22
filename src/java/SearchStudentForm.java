import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class SearchStudentForm extends HttpServlet{
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out =null;
        try{
            res.setContentType("text/html");
         out=  res.getWriter();
         HttpSession hs=req.getSession(false);
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>View Student</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
         if(hs.getAttribute("set")!=null){
             RequestDispatcher rd=req.getRequestDispatcher("navaccountant.html");
             rd.include(req, res);
             RequestDispatcher rd2=req.getRequestDispatcher("SearchStudentForm.html");
             rd2.include(req, res);
             out.println("</head><body>");
             
               out.println("</center></table>");
               out.println("</body></html>");
             
         }else{
             out.println("session timeout");
         }
        }catch(Exception ex){
            res.sendRedirect("loginerror2.html");
            
        }
    }
    
}