
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails,viewPersonalDetails, updatePersonalDetails,viewHotels,bookHotels,viewBookedHotels,payments,notepad,calculator,deletePersonalDetails;
    
   Dashboard(String username){
//   setBounds(0,0,1600,1000);
this.username=username;
setExtendedState(JFrame.MAXIMIZED_BOTH);//will maximize the frame to full screen
setLayout(null);
JPanel p1=new JPanel();
p1.setLayout(null);
p1.setBackground(new Color(255,102,102));
p1.setBounds(0,0,1600,65);
add(p1);
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
Image i2=i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
ImageIcon i3=new ImageIcon(i2);
JLabel icon=new JLabel(i3);
icon.setBounds(5,0,70,70);
p1.add(icon);
JLabel heading =new JLabel("DASHBOARD");
heading.setForeground(new Color(51,0,0));
heading.setBounds(80,10,300,40);
heading.setFont(new Font("Tahoma",Font.BOLD,30));

p1.add(heading);
JPanel p2=new JPanel();
p2.setLayout(null);
p2.setBackground(new Color(255,102,102));
p2.setBounds(0,65,300,900);
add(p2);
addPersonalDetails=new JButton("Add Personal Details");
addPersonalDetails.setBounds(0,0,300,70);
addPersonalDetails.setBackground(new Color(255,102,102));
addPersonalDetails.setForeground(new Color(51,0,0));
addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
addPersonalDetails.setMargin(new Insets(0,0,0,60));// to align text written in button to left-insets(top,left,below,right)
addPersonalDetails.addActionListener(this);
p2.add(addPersonalDetails);
 updatePersonalDetails=new JButton("Update Personal Details");
updatePersonalDetails.setBounds(0,70,300,70);
updatePersonalDetails.setBackground(new Color(255,102,102));
updatePersonalDetails.setForeground(new Color(51,0,0));
updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
updatePersonalDetails.setMargin(new Insets(0,0,0,30));// to align text written in button to left-insets(top,left,below,right)
updatePersonalDetails.addActionListener(this);
p2.add(updatePersonalDetails);
viewPersonalDetails=new JButton("View Personal Details");
viewPersonalDetails.setBounds(0,140,300,70);
viewPersonalDetails.setBackground(new Color(255,102,102));
viewPersonalDetails.setForeground(new Color(51,0,0));
viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
viewPersonalDetails.setMargin(new Insets(0,0,0,55));// to align text written in button to left-insets(top,left,below,right)
viewPersonalDetails.addActionListener(this);
p2.add(viewPersonalDetails);
deletePersonalDetails=new JButton("Delete Personal Details");
deletePersonalDetails.setBounds(0,210,300,70);
deletePersonalDetails.setBackground(new Color(255,102,102));
deletePersonalDetails.setForeground(new Color(51,0,0));
deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
deletePersonalDetails.setMargin(new Insets(0,0,0,45));// to align text written in button to left-insets(top,left,below,right)
deletePersonalDetails.addActionListener(this);
p2.add(deletePersonalDetails);

viewHotels=new JButton("View Hotels");
viewHotels.setBounds(0,280,300,70);
viewHotels.setBackground(new Color(255,102,102));
viewHotels.setForeground(new Color(51,0,0));
viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
viewHotels.setMargin(new Insets(0,0,0,145));// to align text written in button to left-insets(top,left,below,right)
viewHotels.addActionListener(this);
p2.add(viewHotels);
 bookHotels=new JButton("Book Hotels");
bookHotels.setBounds(0,350,300,70);
bookHotels.setBackground(new Color(255,102,102));
bookHotels.setForeground(new Color(51,0,0));
bookHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
bookHotels.setMargin(new Insets(0,0,0,145));// to align text written in button to left-insets(top,left,below,right)
bookHotels.addActionListener(this);
p2.add(bookHotels);
viewBookedHotels=new JButton("View Booked Hotels");
viewBookedHotels.setBounds(0,420,300,70);
viewBookedHotels.setBackground(new Color(255,102,102));
viewBookedHotels.setForeground(new Color(51,0,0));
viewBookedHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
viewBookedHotels.setMargin(new Insets(0,0,0,75));// to align text written in button to left-insets(top,left,below,right)
viewBookedHotels.addActionListener(this);
p2.add(viewBookedHotels);

payments=new JButton("Payments");
payments.setBounds(0,490,300,70);
payments.setBackground(new Color(255,102,102));
payments.setForeground(new Color(51,0,0));
payments.setFont(new Font("Tahoma",Font.PLAIN,20));
payments.setMargin(new Insets(0,0,0,175));// to align text written in button to left-insets(top,left,below,right)
payments.addActionListener(this);
p2.add(payments);

calculator=new JButton("Calculator");
calculator.setBounds(0,560,300,70);
calculator.setBackground(new Color(255,102,102));
calculator.setForeground(new Color(51,0,0));
calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
calculator.setMargin(new Insets(0,0,0,175));// to align text written in button to left-insets(top,left,below,right)
calculator.addActionListener(this);
p2.add(calculator);
notepad=new JButton("Notepad");
notepad.setBounds(0,630,300,70);
notepad.setBackground(new Color(255,102,102));
notepad.setForeground(new Color(51,0,0));
notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
notepad.setMargin(new Insets(0,0,0,185));// to align text written in button to left-insets(top,left,below,right)
notepad.addActionListener(this);
p2.add(notepad);

ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
Image i5=i4.getImage().getScaledInstance(1600,1000,Image.SCALE_DEFAULT);
ImageIcon i6=new ImageIcon(i5);
JLabel image=new JLabel(i6);
image.setBounds(0,0,1600,1000);
add(image);
JLabel text=new JLabel("TRAVEL AND TOURISM MANAGEMENT SYSTEM");
text.setBounds(400,70,1000,70);
text.setForeground(Color.BLACK );
text.setFont(new Font("Raleway",Font.PLAIN,40));
image.add(text);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource()==viewPersonalDetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource()== updatePersonalDetails){
            new UpdateCustomer(username);
        }
        else if(ae.getSource()==viewHotels){
            new CheckHotels();
        }
        else if(ae.getSource()==bookHotels){
        new BookHotel(username);    
        }
        else if(ae.getSource()==viewBookedHotels){
        new ViewBookedHotel(username);    
        }
        else if(ae.getSource()==payments){
            new Payment();
        }
        else if(ae.getSource()==notepad){
             try{
            Runtime.getRuntime().exec("notepad.exe");//to execute a dekstop based application calculator we use this method
            }
            catch(Exception e){
             e.printStackTrace();   
            }
        }
        else if(ae.getSource()==calculator){
            try{
            Runtime.getRuntime().exec("calc.exe");//to execute a dekstop based application calculator we use this method
            }
            catch(Exception e){
             e.printStackTrace();   
            }
        }
        else if(ae.getSource()==deletePersonalDetails){
            new DeleteDetails(username);
        }
        else{
            setVisible(false);
        }
    }
public static void main(String args[]){
    new Dashboard(" ");
}   
}
