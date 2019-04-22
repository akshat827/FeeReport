import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class SearchStudent extends HttpServlet {
      public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out =null;
        try{
         res.setContentType("text/html");
         out=res.getWriter();
         HttpSession hs=req.getSession(false);
         String i=req.getParameter("rollno");
         
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>View Student</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
             RequestDispatcher rd=req.getRequestDispatcher("navaccountant.html");
             rd.include(req, res);
           if(hs.getAttribute("set")!=null){

         Class.forName("com.mysql.jdbc.Driver");
     	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","12345");
     	PreparedStatement st=con.prepareStatement("select * from student_info where id='"+i+"'");
        ResultSet rs=st.executeQuery();
          out.println("</head><body>");
          out.println("<center><table border='1'style='border-collapse:collapse;width:100%'>");
        while(rs.next()){
            out.println("<tr><th>Roll no :</th><td>"+rs.getString(1)+"</td></tr><tr><th>Name :</th><td>"+rs.getString(2)+"</td></tr><tr><th>Email :</th><td>"+rs.getString(3)+"</td></tr><tr><th>Sex :</th><td>"+rs.getString(4)+"</td></tr><tr><th>Course</th><td>"+rs.getString(5)+"</td></tr><tr><th>Fees :</th><td>"+rs.getString(6)+"</td></tr>");
            
        }
        out.println("</center></table>");
        out.println("</body></html>");
         }else{
             out.println("Session time out");
         }
            
        }catch(Exception ex){
           res.sendRedirect("loginerror2.html");
        }
    
      }
}
