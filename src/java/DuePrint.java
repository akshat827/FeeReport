import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 

import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Cell; 
import com.itextpdf.layout.element.Table;  

public class DuePrint extends HttpServlet{
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
        PrintWriter out =null;
         Document document = new Document();
        try{
       response.setContentType("application/pdf");
    PdfWriter.getInstance(document, response.getOutputStream());
    document.open();
         out=  res.getWriter();
         HttpSession hs=req.getSession(false);
          /*  out.println("<!DOCTYPE html>");
            out.println("<html><head><title>View Student</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            */
         if(hs.getAttribute("set")!=null){
         	/*
             RequestDispatcher rd=req.getRequestDispatcher("navaccountant.html");
             rd.include(req, res);
             out.println("</head><body>");
             out.println("<center><table border='1'style='border-collapse:collapse;width:100%'>");
             */
              Class.forName("com.mysql.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","12345");
               PreparedStatement st=con.prepareStatement("select * from student_info");
               ResultSet rs=st.executeQuery();
            Table table=new Table(9);
      table.addCell(new Cell().add("id")); 
      table.addCell(new Cell().add("name")); 
      table.addCell(new Cell().add("Email")); 
      table.addCell(new Cell().add("sex")); 
      table.addCell(new Cell().add("Fee")); 
      table.addCell(new Cell().add("Paid")); 
       table.addCell(new Cell().add("Due")); 
      table.addCell(new Cell().add("Address")); 
      table.addCell(new Cell().add("Contact")); 



               while(rs.next()){   out.print
                   int a = Integer.parseInt( rs.getString(8));
                   if(a!=0){
                    table.addCell(new Cell().add(rs.getString(10)));
                    table.addCell(new Cell().add(rs.getString(1))); 
                    table.addCell(new Cell().add(rs.getString(2)));
                    table.addCell(new Cell().add(rs.getString(3)));
                    table.addCell(new Cell().add(rs.getString(4)));
                    table.addCell(new Cell().add(rs.getString(5)));
                    table.addCell(new Cell().add(rs.getString(6)));
                    table.addCell(new Cell().add(rs.getString(7)));
                    table.addCell(new Cell().add(rs.getString(8)));
                    table.addCell(new Cell().add(rs.getString(9)));

                   }
                   }
                   document.add(table);
                   document.close();

                   
             //  out.println("</center></table>");
             //  out.println("</body></html>");
             
         }else{
             out.println("session timeout");
         }
        }catch(Exception ex){
            res.sendRedirect("loginerro2.html");
        }
    }
    
}
