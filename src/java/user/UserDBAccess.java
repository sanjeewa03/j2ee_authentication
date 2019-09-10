
package user;

import db.DBConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.User;
        
public class UserDBAccess {
    
    private Connection con;
    
    public UserDBAccess(){
        DBConnection connection = new DBConnection();
        this.con = connection.connect();
    }
    
    ResultSet getAllUsers(){
        try {
            Statement stm =this.con.createStatement();
            
            ResultSet rs = stm.executeQuery("SELECT * FROM users");
            return rs;
            } catch (SQLException ex) {
            Logger.getLogger(UserDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Boolean addUser(User user) {
        try {
            
            System.out.println(user.getFname());
            if(this.isExist(user)){
                System.out.println(" username taken");
                return false;
            }
            else{
            Statement stm = this.con.createStatement();
            String Q = "INSERT INTO users('username', 'fname', 'lname', 'password') VALUES ('"+user.getUsername()+"','"+user.getFname()+"','"+user.getLname()+"','"+user.getPassword()+"')";
            System.out.println(Q);
            Boolean rs = stm.execute("INSERT INTO `users` (`username`, `fname`, `lname`, `password`) VALUES ('"+user.getUsername()+"', '"+user.getFname()+"', '"+user.getLname()+"', '"+user.getPassword()+"')");
            System.out.println(rs);
            return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    Boolean isExist(User user) {
        try {
            
            System.out.println(user.getFname());
            Statement stm =this.con.createStatement();
            String Q = "SELECT username FROM users WHERE username = \""+user.getUsername()+"\"";
            System.out.println(Q);
            ResultSet rs =stm.executeQuery(Q);
            if(rs.next() ){
                System.out.println("is exist = true ");
                return true;
            }
            System.out.println("is exist = false ");
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    Boolean isExist(String username) {
        try {
            Statement stm =this.con.createStatement();
            Boolean rs =stm.execute("SELECT username FROM users WHERE EXISTS (users.username = "+username+")");
            
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UserDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    ResultSet getUser(String username) {
        try {
            Statement stm =this.con.createStatement();
            ResultSet rs =stm.executeQuery("SELECT username,password FROM users WHERE users.username = "+username+" LIMIT 1");
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UserDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Boolean Authenticate(String username, String password){
        try {
            if(this.isExist(username)){
                ResultSet rs = this.getUser(username);
                rs.getString(password);
                return true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(UserDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
