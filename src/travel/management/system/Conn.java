package travel.management.system;
import java.sql.*;
public class Conn {
Connection c;
Statement s;
Conn(){
//5 steps of jdbc connectivity
//1-register the driver-mysql driver
//2=creating the connection string
//3-creating the statement
//4-executing my sql query
try{
 Class.forName("com.mysql.cj.jdbc.Driver") ; //name of driver-1
 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","@_Sanya04082003");//-2
 

 s=c.createStatement();
}
catch(Exception e){
e.printStackTrace();
}
}   
}
