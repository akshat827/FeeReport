import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddAccountant extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{

     PrintWriter out=null;
     try{
     	res.setContentType("text/html");
     	out=res.getWriter();
        out.println("<!DOCTYPE html>");
	out.println("<html><head><title>Admin Panel</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");
	out.println("</head><body>");
         RequestDispatcher rd1=req.getRequestDispatcher("navhome.html");
    rd1.include(req,res);
        HttpSession ms=req.getSession(false);
        if(ms.getAttribute("ses")!=null){
     	String n=req.getParameter("name");
     	String p=req.getParameter("password");
     	String e=req.getParameter("email");
     	String a=req.getParameter("address");
     	String c=req.getParameter("contact");
     	Class.forName("com.mysql.jdbc.Driver");
     	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","");
     	Statement st=con.createStatement();
     	st.executeUpdate("insert into accountant values('"+n+"','"+e+"','"+p+"','"+a+"','"+c+"')");
        res.sendRedirect("AdminPanel2");
        }
        else{
            out.println("session time out");
        }
        out.println("</body></html>");
     }catch(Exception ex){
         res.sendRedirect("loginerror2.html");
          

     }



	}
}