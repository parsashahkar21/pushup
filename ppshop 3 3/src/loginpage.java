import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class loginpage implements ActionListener{


    JButton button, button1;
    JFrame box;
    JTextArea input; 
    JTextArea input1; 
    static hashing console = new hashing();

    ArrayList<normal_user> nusers = datas.get_nusers();
    ArrayList<admin_user> ausers = datas.get_ausers();


    public loginpage(){
        box = new JFrame("pp shop");
        input = new JTextArea();
        input1 = new JTextArea();

        Dimension  size = new Dimension(720, 300);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Enter");
        button1 = new JButton("sign in");

        JLabel text = new JLabel("enter your username : ");
        JLabel text1 = new JLabel("enter your password : ");
        

        
        button.setBounds(300, 190, 80, 20);
        button1.setBounds(300, 230, 80, 20);
        text.setBounds(100, 10, 300, 100);
        text1.setBounds(100, 50, 300, 100);
        input.setBounds(300, 50, 100, 20);
        input1.setBounds(300, 90, 100, 20);
        
       
        box.add(button);
        box.add(button1);
        box.add(text1);
        box.add(text);
        box.add(input);
        box.add(input1);

        
        button.addActionListener(this);
        button1.addActionListener(this);
        

        box.setVisible(true);

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = input.getText();
        String hash1 = console.hash(input1.getText());

       
        box.setVisible(false);
        if(e.getSource() == button){
            for(normal_user f : nusers){
                System.out.println(name + " " + hash1);
                System.out.println(f.username + " " + f.passhash);
                if(name.equals(f.username) && hash1.equals(f.passhash)){
                    new normalpage(f);
                    return;
                }
            }
            for(admin_user f : ausers){
                if(name.equals(f.username) && hash1.equals(f.passhash)){
                    new adminpage(f);
                    return;
                }
            }

            new loginpage();

            return;
        }
        if(e.getSource() == button1){
            new signinpage();
        }
    }


}
    

