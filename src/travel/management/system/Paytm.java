package travel.management.system;
import java.awt.Desktop;
import java.net.URI;

public class Paytm {
    Paytm(){
    try {
            Desktop.getDesktop().browse(new URI("https://paytm.com/rent-payment"));
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    public static void main(String[] args) {
        new Paytm();
    }
}

