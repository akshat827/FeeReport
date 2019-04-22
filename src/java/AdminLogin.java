import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AdminLogin extends HttpServlet{
public void service (HttpServletRequest req,HttpServletResponse res){
	PrintWriter out=null;
	try{     String x;
		res.setContentType("text/html");
		out=res.getWriter();
		String e=req.getParameter("email");
		String p=req.getParameter("password");
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from admin where email='"+e+"' and password ='"+p+"'");
		if(rs.next()){
            HttpSession ms=req.getSession();
            x= ms.getId();
           ms.setAttribute("ses", x);
           ms.setMaxInactiveInterval(1*60);
	    res.sendRedirect("AdminPanel");
		}
		else{
			res.sendRedirect("loginerror.html");
		}

	}catch(Exception ex){
		out.println(ex);
	}
	

}
}