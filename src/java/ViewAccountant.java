
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class ViewAccountant extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = null;
        try {
            res.setContentType("text/html");
            out = res.getWriter();
          out.println("<!DOCTYPE html>");
	out.println("<html><head><title>Admin Panel</title>");
	out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
	out.println("<link rel='stylesheet' href='style.css'/>");
	out.println("</head><body><center>");
       
            HttpSession ms = req.getSession(false);
            if (ms.getAttribute("ses")!=null) {
              RequestDispatcher rd2=req.getRequestDispatcher("navadmin.html");
                rd2.include(req, res);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1", "root", "");
                PreparedStatement ps=con.prepareStatement("select * from accountant");
                ResultSet rs = ps.executeQuery();
                out.print("<table border ='1'style='border-collapse:collapse;width:100%'>");
                out.println("<tr><td>Name</td><td>Email</td><td>Address</td><td>Contact</td><td colspan='2'>Modify</td></tr>");
                
                while (rs.next()) {
                  out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td><a href='UpdateAccountant'>Edit</a></td><td><a href='DeletAccountant'>delete</a></tr>");  
                 
                }
                out.println("</table></center></body></html>");
            }
            else{
                 RequestDispatcher rd1=req.getRequestDispatcher("navhome.html");
        rd1.include(req, res);
                out.println("session time out");
                
          }
            out.println("</body></html>");
        } catch (Exception ex) {
           res.sendRedirect("loginerror2.html");
        }
    }
}
