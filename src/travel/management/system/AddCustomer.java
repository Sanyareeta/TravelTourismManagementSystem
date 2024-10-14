
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddCustomer extends JFrame implements ActionListener{
    JLabel lblusername;
    JLabel labelusername;
    JLabel labelname,lblcountry;
    JTextField tfnumber,tfcountry,tfphone,tfemail,tfaddress;
    JComboBox comboid;// to create drop down list other than choice
    JRadioButton rmale,rfemale;//to create radio button
    JButton add,back;
    JLabel lblname;
    AddCustomer(String username){
    setBounds(450,200,850,550);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);//getContentPane used to take full frame
    lblusername=new JLabel("Username");
    lblusername.setBounds(30,50,150,25);
    add(lblusername);
    
    labelusername=new JLabel(username);
    labelusername.setBounds(220,50,150,25);
    add(labelusername);
//System.out.println(username);
    
    JLabel lblid=new JLabel("Id");
    lblid.setBounds(30,90,150,25);
    add(lblid);
    comboid=new JComboBox(new String[]{"Passport","Adhar Card","Ration Card","Pan Card"});
    comboid.setBounds(220,90,150,25);
    comboid.setBackground(Color.WHITE);
    add(comboid);
    JLabel lblnumber=new JLabel("Number");
    lblnumber.setBounds(30,130,150,25);
    add(lblnumber);
    tfnumber=new JTextField();
    tfnumber.setBounds(220,130,150,25);
    add(tfnumber);
    lblname=new JLabel("Name");
    lblname.setBounds(30,170,150,25);
    add(lblname);
    
    labelname=new JLabel();
    labelname.setBounds(220,170,150,25);
    add(labelname);
     JLabel lblgender=new JLabel("Gender");
    lblgender.setBounds(30,210,150,25);
    add(lblgender);
    rmale=new JRadioButton("Male");
    rmale.setBackground(Color.WHITE);
    rfemale=new JRadioButton("Female");
    rfemale.setBackground(Color.WHITE);
    rmale.setBounds(220,210,70,25);
    rfemale.setBounds(300,210,70,25);
    add(rmale);
    add(rfemale);
    ButtonGroup bg=new ButtonGroup();// to group radio buttons so that only one button gets selected at a time
    bg.add(rmale);
    bg.add(rfemale);
    lblcountry=new JLabel("Country");
    lblcountry.setBounds(30,250,150,25);
    add(lblcountry);
    tfcountry=new JTextField();
    tfcountry.setBounds(220,250,150,25);
    add(tfcountry);
    JLabel lbladdress=new JLabel("Address");
    lbladdress.setBounds(30,290,150,25);
    add(lbladdress);
    tfaddress=new JTextField();
    tfaddress.setBounds(220,290,150,25);
    add(tfaddress);
    JLabel lblphone=new JLabel("Phone");
    lblphone.setBounds(30,330,150,25);
    add(lblphone);
    tfphone=new JTextField();
    tfphone.setBounds(220,330,150,25);
    add(tfphone);
    JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(30,370,150,25);
    add(lblemail);
     tfemail=new JTextField();
    tfemail.setBounds(220,370,150,25);
    add(tfemail);
    add=new JButton("Add");
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    add.setBounds(70,430,100,25);
    add.addActionListener(this);
    add(add);
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(220,430,100,25);
    add(back);
    back.addActionListener(this);
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
    Image i2=i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(400,40,450,420);
    add(image);
    try{
     Conn c=new Conn();
     ResultSet rs=c.s.executeQuery("select * from account where username = '" + username + "'");
     while(rs.next()){
         labelusername.setText(rs.getString("username"));
         labelname.setText(rs.getString("name"));
     }
    }
    catch(Exception e){
    e.printStackTrace();   
    }
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==add){
        String username=labelusername.getText();
        String id=(String)comboid.getSelectedItem();//returns a object so typecast
        String number=tfnumber.getText();
        String name=labelname.getText();
        String gender=null;
        if(rmale.isSelected()){
            gender="male";
        }
        else{
            gender="female";
        }
        String country=tfcountry.getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        try{
        Conn c=new Conn();
        String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
        setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
    else{
        setVisible(false);
    }
    }
  public static void main(String args[]){
      new AddCustomer("");
  }
}
