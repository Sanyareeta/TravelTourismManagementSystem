
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login;
    JButton forgotpass;
    JButton signup;
    JTextField tfusername;
    JTextField tfpassword;
    Login(){
    setSize(900,400);
    setLocation(350,200); 
//    setVisible(true);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    JPanel p1=new JPanel();
   
    p1.setBackground(new Color(131,193,233));
    p1.setBounds(0,0,400,400);
//    p1.setLayout(null);
     add(p1);
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
     Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(100,100,200,200);
     p1.add(image);
//     setVisible(true);
     JPanel p2=new JPanel();
     p2.setLayout(null);
     p2.setBounds(400,30,450,300);
     add(p2);
     JLabel lblusername=new JLabel("Username");
     lblusername.setBounds(60,20,100,25);
     lblusername.setFont(new Font("SAN-SERIF",Font.PLAIN,20));
     p2.add(lblusername);
      tfusername=new JTextField();
     tfusername.setBounds(60,60,300,30);
     p2.add(tfusername);
     tfusername.setBorder(BorderFactory.createEmptyBorder());
     JLabel password=new JLabel("Password");
     password.setBounds(60,110,100,25);
     password.setFont(new Font("SAN-SERIF",Font.PLAIN,20));
     p2.add(password);
     tfpassword=new JTextField();
     tfpassword.setBounds(60,150,300,30);
     p2.add(tfpassword);
     tfpassword.setBorder(BorderFactory.createEmptyBorder());
     login=new JButton("Login");
     login.setBounds(30,200,100,30);
     login.setBackground(new Color(133,193,233));
     login.setForeground(Color.WHITE);
     login.setBorder(new LineBorder(new Color(133,193,233)));
     login.addActionListener(this);
     p2.add(login);
     signup=new JButton("Signup");
     signup.setBounds(160,200,100,30);
     signup.setBackground(new Color(133,193,233));
     signup.setForeground(Color.WHITE);
     signup.setBorder(new LineBorder(new Color(133,193,233)));
     signup.addActionListener(this);
     p2.add(signup);
     forgotpass=new JButton("Forgot Password");
     forgotpass.setBounds(300,200,130,30);
     forgotpass.setBackground(new Color(133,193,233));
     forgotpass.setForeground(Color.WHITE);
    forgotpass.setBorder(new LineBorder(new Color(133,193,233)));
    forgotpass.addActionListener(this);
     p2.add(forgotpass);
     JLabel text=new JLabel("Trouble in logging in ?");
     text.setBounds(160,260,200,30);
     text.setForeground(Color.RED);
     p2.add(text);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
        try{
        String username=tfusername.getText();
        String pass=tfpassword.getText();
        String query="select * from account where username='"+username+"' AND password ='"+pass+"'";
        Conn c=new Conn();//to get password and username for loading page
        ResultSet rs=c.s.executeQuery(query);//to take rows from given querypresent in sql.* package
        if(rs.next()){
            setVisible(false);
            new Loading(username);
        }
        else{
            JOptionPane.showMessageDialog(null,"Incorrect username or password");// if there is no row in resultset then show this dialog box
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()==signup){
        setVisible(false);   
        new SignUp();
        }
        else{
        setVisible(false);    
        new ForgetPassword();
        }
    }
public static void main(String args[]){
  new Login();
}   
}
