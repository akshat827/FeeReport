import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;

public class AddAccountantForm extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res){
    PrintWriter out=null;
    try{
        
    out=res.getWriter();
    res.setContentType("text/html");
     
    HttpSession ms=req.getSession(false);
	if(ms.getAttribute("ses")!=null){
   	out.println("<!DOCTYPE html>");
	out.println("<html><head><title>Admin Panel</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");
	out.println("</head><body>");
   

    RequestDispatcher rd1=req.getRequestDispatcher("navadmin.html");
    rd1.include(req,res);
    RequestDispatcher rd2=req.getRequestDispatcher("AddAccountantForm.html");
    rd2.include(req,res);
	 


	}
	else{
                  RequestDispatcher rd3=req.getRequestDispatcher("navhome.html");
    rd3.include(req,res);
	 out.println("session time out");
	}
   out.println("</body><html>");

    }catch(Exception ex){
    	out.println(ex);
    	   }


	}
}