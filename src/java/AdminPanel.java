import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class AdminPanel extends HttpServlet{
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
PrintWriter out=null;
try{
	out=res.getWriter();
	res.setContentType("text/html");
	out.println("<!DOCTYPE html>");
	out.println("<html><head><title>Admin Panel</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");
	out.println("</head><body>");
	HttpSession ms=req.getSession(false);
        String a=(String) ms.getAttribute("ses");
        
	if(ms.getAttribute("ses")!=null){
	 RequestDispatcher rd1=req.getRequestDispatcher("navadmin.html");
	 rd1.include(req,res);
       RequestDispatcher rd2=req.getRequestDispatcher("adminhome.html");
	 rd2.include(req,res);
	 

	}

    else{
    	res.sendRedirect("loginerror2.html");

      
	}
    
	out.println("</body></html>");


	
}catch(Exception ex){
	res.sendRedirect("loginerror2.html");
}
}
}