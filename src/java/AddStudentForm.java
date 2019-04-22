import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddStudentForm extends HttpServlet{
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out=null;
        try{
            res.setContentType("text/html");
            out=res.getWriter();
            HttpSession hs=req.getSession(false);
            if(hs.getAttribute("set")!=null){
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Accountant login</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            RequestDispatcher rd=req.getRequestDispatcher("navaccountant.html");
            rd.include(req, res);
            RequestDispatcher rd1=req.getRequestDispatcher("AddStudentForm.html");
            rd1.include(req, res);
            }
            else{
                out.println("session time out");
            }
            
        }catch(Exception ex){
            res.sendRedirect("loginerror2.html");
            
        }
        
    }
    
}
