
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;//to import ResultSet
public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfusername;
    JTextField tfname;
    JTextField tfques;
    JTextField tfpassword;
    JButton search;
    JButton retrieve;
    JButton back;
    JLabel lblques=new JLabel("Security question");
    JTextField tfans;
     ForgetPassword(){
    setBounds(350,200,850,380);
    getContentPane().setBackground(Color.WHITE);//takes whole frame 
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
    Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(600,70,200,200);
    add(image);
    JPanel p1=new JPanel();
    p1.setLayout(null);
    p1.setBounds(30,30,500,280);
    add(p1);
    JLabel lblusername=new JLabel("Username");
    lblusername.setBounds(40,20,100,25);
    lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lblusername);
    tfusername=new JTextField();
    tfusername.setBounds(220,20,150,25);
    tfusername.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfusername);
    search=new JButton("Search");
    search.setBackground(Color.PINK);
    search.setForeground(Color.WHITE);
    search.setBounds(380,20,100,25);
    search.addActionListener(this);
    p1.add(search);
        JLabel lblname=new JLabel("Name");
    lblname.setBounds(40,60,100,25);
    lblname.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lblname);
    tfname=new JTextField();
    tfname.setBounds(220,60,150,25);
    tfname.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfname);
    JLabel lblques=new JLabel("Security question");
    lblques.setBounds(40,100,150,25);
    lblques.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lblques);
    tfques=new JTextField();
    tfques.setBounds(220,100,150,25);
    tfques.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfques);
    JLabel lblans=new JLabel("Your answer");
    lblans.setBounds(40,140,150,25);
    lblans.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lblans);
    tfans=new JTextField();
    tfans.setBounds(220,140,150,25);
    tfans.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfans);
    retrieve=new JButton("Retrieve");
    retrieve.setBackground(Color.PINK);
    retrieve.setForeground(Color.WHITE);
    retrieve.setBounds(380,140,100,25);
    retrieve.addActionListener(this);
    p1.add(retrieve);
    JLabel lblpassword=new JLabel("Your Password");
    lblpassword.setBounds(40,180,150,25);
    lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
    p1.add(lblpassword);
    tfpassword=new JTextField();
    tfpassword.setBounds(220,180,150,25);
    tfpassword.setBorder(BorderFactory.createEmptyBorder());
    p1.add(tfpassword);
    back=new JButton("BACK");
    back.setBackground(Color.PINK);
    back.setForeground(Color.WHITE);
    back.setBounds(160,220,100,25);
    back.addActionListener(this);
    p1.add(back);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==search){
      try{ 
         String query="select * from account where username='"+tfusername.getText()+"'";
         Conn c=new Conn();
         ResultSet rs=c.s.executeQuery(query);// to fetch data from table
         while(rs.next()){
          tfname.setText(rs.getString("name"));
          tfques.setText(rs.getString("security"));
         }
      }  
      catch(Exception e){
          e.printStackTrace();
      }
     }
     else if(ae.getSource()==retrieve){
     try{
       String query="select * from account where answer='"+tfans.getText()+"' AND username='"+tfusername.getText()+"'";
         Conn c=new Conn();
         ResultSet rs=c.s.executeQuery(query);// to fetch data from table
         while(rs.next()){
          tfpassword.setText(rs.getString("password"));  
     }
     }
     catch(Exception e){
         e.printStackTrace();
     }
     }
     else{
         setVisible(false);
         new Login();
     }
     }
public static void main(String args[]){
    new ForgetPassword();
}
}
