
package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    String username;
    Thread t;//used concept of thread to implement progress bar running
    JProgressBar bar;
    public void run(){
        try{
        for(int i=0;i<=101;i++){
           int max=bar.getMaximum();//to get maximum value
           int value=bar.getValue();//to get current value
           if(value<max){
               bar.setValue(bar.getValue()+1);//increment the bar
           }
           else{
               setVisible(false);//for value i=101 the window should close
               new Dashboard(username);
           }
           Thread.sleep(50);//
        }    
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel text=new JLabel("Travel and Tourism Management Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,25) );
        add(text);
        
         bar=new JProgressBar();//to show progress bar
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);//to diaplay number of progress
        add(bar);
        
        JLabel loading=new JLabel("Loading, please wait...");
        loading.setBounds(190, 140, 250, 30);
        loading.setForeground(Color.ORANGE);
        loading.setFont(new Font("Raleway",Font.BOLD,16) );
        add(loading);
        
         JLabel lblusername=new JLabel("Welcome "+username);
        lblusername.setBounds(50, 300, 600, 40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway",Font.BOLD,16) );
        add(lblusername);
        t.start();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public static void main(String args[]){
  new Loading("");  
}
}
