import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddStudent extends HttpServlet{
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out=null;
        try{
            res.setContentType("text/html");
            out=res.getWriter();
            String n=req.getParameter("name");
            String e=req.getParameter("email");
            String s=req.getParameter("sex");
            String co=req.getParameter("course");
            String f=req.getParameter("fee");
            String p=req.getParameter("paid");
            String d=req.getParameter("due");
            String ad=req.getParameter("address");
            String cn=req.getParameter("contact");
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Accountant login</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            HttpSession hs=req.getSession(false);
            if(hs.getAttribute("set")!=null){
            
            RequestDispatcher rd=req.getRequestDispatcher("navaccountant.html");
            rd.include(req, res);
           
               Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","12345");
               Statement st=con.createStatement();
             
               
               st.executeUpdate("insert into student_info (name,email,sex,course,fee,paid,due,address,contact)values('"+n+"','"+e+"','"+s+"','"+co+"',"+f+","
                      +p+","+d+",'"+ad+"','"+cn+"')");
               
             out.print("<h3 style='color:green '>Student Added Sucessfully </h3>");
            RequestDispatcher rd1=req.getRequestDispatcher("accountanthome.html");
            rd1.include(req, res);
            }else{
              out.println("session time out");
                  
            RequestDispatcher rd=req.getRequestDispatcher("navaccountant.html");
            rd.include(req, res);
            out.println("</body></html>");
            }
        }
        catch(Exception ex){
            res.sendRedirect("loginerror2.html");
        }
    }
}
