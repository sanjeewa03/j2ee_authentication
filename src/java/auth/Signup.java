
package auth;

import java.io.IOException;
import java.io.PrintWriter;
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
        //if(request.getParameter("username")==null/*&&request.getParameter("fname")==null&&request.getParameter("lname")==null&&request.getParameter("password")==null*/){
          //response.sendRedirect("auth/registerForm.jsp");  
        //}
        //else{
            UserDBAccess udb = new UserDBAccess();
            User usr = new User();
            usr.setFname("sanjeewa");
            usr.setLname("Senarathne");
            usr.setPassword("apple");
            usr.setUsername("nuwa222n2");
            System.out.println(usr.getFname());
            udb.addUser(usr);
            
        //}
        
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
