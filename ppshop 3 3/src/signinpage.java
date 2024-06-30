import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class signinpage implements ActionListener{


    JButton admin, normal;
    JFrame box = new JFrame("pp shop");
    JTextArea userInp = new JTextArea();
    JTextArea passInp = new JTextArea();
    JTextArea pass2Inp = new JTextArea();
    JTextArea num = new JTextArea();

    datas data = new datas();
    
    ArrayList<normal_user> nusers = datas.get_nusers();
    ArrayList<admin_user> ausers = datas.get_ausers();



    public signinpage(){

        Dimension  size = new Dimension(720, 400);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        admin = new JButton("Admin user");
        normal = new JButton("Normal user");

        JLabel userTxt = new JLabel("enter your username : ");
        JLabel number = new JLabel("enter your number : ");
        JLabel passTxt = new JLabel("enter your password : ");
        JLabel pass2Txt = new JLabel("password again : ");
        

        
        normal.setBounds(400, 330, 120, 20);
        admin.setBounds(200, 330, 120, 20);
        userTxt.setBounds(100, 10, 300, 100);
        number.setBounds(100, 60, 300, 100);
        passTxt.setBounds(100, 150, 200, 20);
        pass2Txt.setBounds(100, 160, 300, 100);
        userInp.setBounds(300, 50, 100, 20);
        num.setBounds(300, 100, 100, 20);
        passInp.setBounds(300, 150, 100, 20);
        pass2Inp.setBounds(300, 200, 100, 20);
       
        
        
       
        
        box.add(normal);
        box.add(admin);
        box.add(userTxt);
        box.add(pass2Txt);
        box.add(passTxt);
        box.add(userInp);
        box.add(pass2Inp);
        box.add(passInp);
        box.add(num);
        box.add(number);

        normal.addActionListener(this);
        admin.addActionListener(this);
     

        box.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        box.setVisible(false);
        hashing console = new hashing();
        if(e.getSource()== normal){

            for(normal_user f : nusers){
                if(f.username == userInp.getText()){
                    new signinpage();
                    return;
                }
            }

            if(pass2Inp.getText().equals( passInp.getText() )){
                datas.set_nusers(new normal_user(userInp.getText(), console.hash(passInp.getText()), num.getText()));
                new loginpage();
            }
            else{
                new signinpage();
            }

            return;
        }

        if(e.getSource()== admin){

            for(admin_user f : ausers){
                if(f.username == userInp.getText()){
                    new signinpage();
                    return;
                }
            }

            if(pass2Inp.getText().equals( passInp.getText() )){
                datas.set_ausers(new admin_user(userInp.getText(), console.hash(passInp.getText()), num.getText()));
                new loginpage();
            }
            else{
                new signinpage();
            }
            return;
        }
        
    }
    

}

    

