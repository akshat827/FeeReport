import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class DueStudent extends HttpServlet{
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
             out.println("</head><body>");
             out.println("<center><table border='1'style='border-collapse:collapse;width:100%'>");
              Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","12345");
               PreparedStatement st=con.prepareStatement("select * from student_info");
               ResultSet rs=st.executeQuery();
               out.println("<tr><td>id</td><td>Name</td><td>Email</td><td>Sex</td><td>Course</td><td>Fees</td><td>Paid</td><td>Dues</td><td>Adress</td><td>Contact</td><td colspan='2'>Modify</td></tr>");
               while(rs.next()){
                   int a = Integer.parseInt( rs.getString(8));
                   if(a!=0){
                  out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td><a href='EditStudent'>Edit</a></td><td><a href='DeleteStudent'>Delete</a></td></tr>");
                   }
                   }
                   
               out.println("</center></table>");
               out.println("</body></html>");
             
         }else{
             out.println("session timeout");
         }
        }catch(Exception ex){
            res.sendRedirect("loginerro2.html");
        }
    }
    
}
