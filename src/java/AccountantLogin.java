import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AccountantLogin extends HttpServlet {
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out=null;
        try{
            res.setContentType("text/html");
            out=res.getWriter();
             String m;
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Accountant login</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            String e=req.getParameter("email");
            String p=req.getParameter("password");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","12345");
            Statement st=con.createStatement();
            
            ResultSet rs=st.executeQuery("select * from accountant where email='"+e+"'and password='"+p+"'");
            if(rs.next()){
                HttpSession hs=req.getSession();
                m=hs.getId();
                hs.setAttribute("set", m);
                res.sendRedirect("AccountantPanel");
               
            }else{
                out.println("plz login first");
            }
            
        }catch(Exception ex){
            res.sendRedirect("loginerror2.html");
        }
        
    }
    
}
