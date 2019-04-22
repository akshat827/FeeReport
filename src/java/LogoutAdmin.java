import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class LogoutAdmin extends HttpServlet {
    public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
       PrintWriter out=null;
       try{
           out=res.getWriter();
           res.setContentType("text/html");
           HttpSession ms=req.getSession(false);
            HttpSession hs=req.getSession(false);
           if(ms.getAttribute("ses")!=null){
              // ms.invalidate();
               hs.invalidate();
               res.sendRedirect("index.html");
           }else if(hs.getAttribute("set")!=null){
               hs.invalidate();
               res.sendRedirect("index.html");
               
           }
           else{
              res.sendRedirect("index.html");
           } 
           
           
           
           
       }catch(Exception ex){
          res.sendRedirect("loginerror2.html");
          
       }
    }
    
}

