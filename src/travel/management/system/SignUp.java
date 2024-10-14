
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;//to import action listener elements
import javax.swing.border.LineBorder;
public class SignUp extends JFrame implements ActionListener {
    JButton create,back;
    JTextField tfusername,tfname,tfpassword,tfans;
    Choice security;
   public SignUp(){
   setBounds(150,200,900,400);// setLayout must be null for setBounds to work upon
   getContentPane().setBackground(Color.WHITE);
   setLayout(null);
   JPanel p1=new JPanel();
   p1.setBackground(new Color(133,193,233));
   p1.setBounds(0,0,500,400);
   add(p1);//add panel in frame
   p1.setLayout(null);
   JLabel lblusername=new JLabel("Username");
     lblusername.setBounds(50,20,125,25);
     lblusername.setFont(new Font("SANS-SERIF",Font.BOLD,20));
     p1.add(lblusername);
    tfusername=new JTextField();
     tfusername.setBounds(190,20,180,25);
     tfusername.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfusername);
     JLabel lblname=new JLabel("Name");
     lblname.setBounds(50,80,125,25);
     lblname.setFont(new Font("SANS-SERIF",Font.BOLD,20));
     p1.add(lblname);
     tfname=new JTextField();
     tfname.setBounds(190,80,180,25);
     tfname.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfname);
     JLabel lblpassword=new JLabel("Password");
     lblpassword.setBounds(50,140,125,25);
     lblpassword.setFont(new Font("SANS-SERIF",Font.BOLD,20));
     p1.add(lblpassword);
     tfpassword=new JTextField();
     tfpassword.setBounds(190,140,180,25);
     tfpassword.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfpassword);
     JLabel lblsecurity=new JLabel("Security Question");
     lblsecurity.setBounds(50,200,125,25);
     lblsecurity.setFont(new Font("SANS-SERIF",Font.BOLD,20));
     p1.add(lblsecurity);
     //add drop down menu
     security=new Choice();//for dropdown list
     security.add("Your nickname");
     security.add("Your first school");
      security.add("Your name of class teacher");
      security.add("Your roll no.");
      security.setBounds(190,200,180,25);
      p1.add(security);
     JLabel lblans=new JLabel("Your Answer");
     lblans.setBounds(50,250,125,25);
     lblans.setFont(new Font("SANS-SERIF",Font.BOLD,20));
     p1.add(lblans);
     tfans=new JTextField();
     tfans.setBounds(190,250,180,25);
     tfans.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tfans);
     
     create=new JButton("CREATE");
     create.setBackground(new Color(133,193,233));
     create.setForeground(Color.BLACK );
     create.setFont(new Font("SANS-SERIF",Font.BOLD,20));
     create.setBounds(80,300,100,25);
     create.setBorder(new LineBorder(new Color(133,193,233)));
     create.addActionListener(this);
     p1.add(create);
     back=new JButton("BACK");
     back.setBackground(new Color(133,193,233) );
     back.setForeground(Color.BLACK );
     back.setFont(new Font("SANS-SERIF",Font.BOLD,20));
     back.setBounds(200,300,100,25);
    back.setBorder(new LineBorder(new Color(133,193,233)));
    back.addActionListener(this);
     p1.add(back);
      
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
     Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(580,50,250,200);
     add(image);
   setVisible(true);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void actionPerformed(ActionEvent ae){
   if(ae.getSource()==create){// to identify which button's action is being called
   String username=tfusername.getText();
//   String username = tfusername.getText();
System.out.println("Username: " + username);

   String name=tfname.getText();
   String password=tfpassword.getText(); 
   String question=security.getSelectedItem();// to get the selected itme from drop down list
   String answer=tfans.getText();
   String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
   try{
   Conn c=new Conn();
   c.s.executeUpdate(query);
   JOptionPane.showMessageDialog(null,"Account created successfully");
   setVisible(false);
   new Login();
   }
   catch(Exception e){
       e.printStackTrace();
   }
   }
   else if(ae.getSource()==back){
   setVisible(false);
   new Login();
   }
   }
public static void main(String args[]){
    new SignUp();
}   
}
