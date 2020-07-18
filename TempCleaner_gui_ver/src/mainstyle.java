import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class mainstyle extends JFrame {


    public mainstyle(){
        super("Tests");
        setLayout(new FlowLayout());
        JLabel l1 = new JLabel("Click to Button");
        add(l1);
        JButton btn1 = new JButton("Clear");
        add(btn1);
        mylistener ml = new mylistener();
        btn1.addActionListener(ml);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }


    public static void main(String args[]){
        new mainstyle();


    }

    public static void deletefolder(String path) {

        File folder = new File(path);
        try{
            if(folder.exists()){
                File[] folder_list = folder.listFiles();

                for(int i=0; i<folder_list.length; i++){
                    if(folder_list[i].isFile()){
                        folder_list[i].delete();
                    }else{
                        deletefolder(folder_list[i].getPath());
                    }
                    folder_list[i].delete();
                }
                folder.delete();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }



}
class mylistener implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn1 = (JButton)e.getSource();
        String path = "C:\\Users\\dksk4\\AppData\\Local\\Temp";
        mainstyle.deletefolder(path);

    }
}


