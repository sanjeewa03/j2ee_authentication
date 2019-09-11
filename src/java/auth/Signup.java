
package auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserDBAccess;
import user.User;


public class Signup extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(request.getParameter("username"));
          
        
            UserDBAccess udb = new UserDBAccess();
            User usr = new User();
            usr.setFname(request.getParameter("fname"));
            usr.setLname(request.getParameter("lname"));
            usr.setPassword(request.getParameter("password"));
            usr.setUsername(request.getParameter("username"));
            System.out.println(usr.getFname());
            Boolean added=udb.addUser(usr);
            System.out.print("added :"+added);
            if(added){
                response.sendRedirect("logedIn/welcomePage.jsp");
            }
            else{
                response.sendRedirect("auth/registerForm.jsp?added=false");
            }
         
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
