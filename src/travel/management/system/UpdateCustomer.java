




package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCustomer extends JFrame implements ActionListener{
    JLabel lblusername;
    JLabel labelusername;
    JLabel labelname,lblcountry;
    JTextField tfnumber,tfcountry,tfphone,tfemail,tfaddress,tfid,tfgender;
    JComboBox comboid;// to create drop down list other than choice
    
    JButton add,back;
    JLabel lblname;
    UpdateCustomer(String username){
    setBounds(500,200,850,550);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);//getContentPane used to take full frame
    JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
    text.setFont(new Font("Tahoma",Font.PLAIN,20));
    text.setBounds(50,0,300,25);
    add(text);
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
//    comboid=new JComboBox(new String[]{"Passport","Adhar Card","Ration Card","Pan Card"});
//    comboid.setBounds(220,90,150,25);
//    comboid.setBackground(Color.WHITE);
//    add(comboid);
tfid=new JTextField();
    tfid.setBounds(220,90,150,25);
    tfid.setBackground(Color.WHITE);
    add(tfid);
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
    tfgender=new JTextField();
    tfgender.setBounds(220,210,150,25);
    add(tfgender);
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
    add=new JButton("Update");
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
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
    Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(400,100,450,300);
    add(image);
    try{
     Conn c=new Conn();
     ResultSet rs=c.s.executeQuery("select * from customer where username = '" + username + "'");
     while(rs.next()){
         labelusername.setText(rs.getString("username"));
         labelname.setText(rs.getString("name"));
         tfid.setText(rs.getString("id"));
         tfnumber.setText(rs.getString("number"));
         tfgender.setText(rs.getString("geneder"));
         tfcountry.setText(rs.getString("country"));
         tfaddress.setText(rs.getString("address"));
         tfphone.setText(rs.getString("phone"));
         tfemail.setText(rs.getString("email"));
        
         
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
        String id=tfid.getText();//returns a object so typecast
        String number=tfnumber.getText();
        String name=labelname.getText();
        String gender=tfgender.getText();
//        if(rmale.isSelected()){
//            gender="male";
//        }
//        else{
//            gender="female";
//        }
        String country=tfcountry.getText();
        String address=tfaddress.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        try{
        Conn c=new Conn();
        String query = "update  customer set username='"+username+"', id='" + id + "', number='" + number + "', name='" + name + "', geneder='" + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='" + email + "'" ;

        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
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
      new UpdateCustomer("Sanya");
  }
}
