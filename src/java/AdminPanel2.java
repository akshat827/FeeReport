import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class AdminPanel2 extends HttpServlet{
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
	
   
	if(ms.getAttribute("ses")!=null){
           
	 RequestDispatcher rd1=req.getRequestDispatcher("navadmin.html");
	 rd1.include(req,res);
          out.println("<h2 style='color:green;'>Accountant added Sucessfully</h2>");
         RequestDispatcher rd2=req.getRequestDispatcher("adminhome.html");
	 rd2.include(req,res);
	 
     out.println("</body></html>");
	}

    else{
    	
       res.sendRedirect("loginerror2.html");
      
	}
    
	


	
}catch(Exception ex){
	res.sendRedirect("loginerror2.html");
}
}
}