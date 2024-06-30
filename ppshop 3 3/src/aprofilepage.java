import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aprofilepage implements ActionListener{


    JButton back, exit;
    JFrame box = new JFrame("pp shop");

    admin_user f;
    public aprofilepage(admin_user f){
        this.f = f;

        Dimension  size = new Dimension(720, 400);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setBackground(Color.PINK);

        back = new JButton("back");
        exit = new JButton("EXIT");

        JLabel text = new JLabel("information ");
        JLabel username = new JLabel("username :    "+ f.username);
        JLabel name = new JLabel("name :    "+ f.username);
        JLabel number = new JLabel("number : " + f.number);
        
        text.setBounds(320, 5, 300, 100);
        exit.setBounds(300, 340, 100, 20);
        username.setBounds(50, 60, 300, 100);
        name.setBounds(50, 135, 100, 20);
        number.setBounds(50, 170, 100, 20);
        back.setBounds(50, 330, 70, 20);
    
        box.add(text);
        box.add(exit);
        box.add(username);
        box.add(name);
        box.add(number);
        box.add(back);

        back.addActionListener(this);
        exit.addActionListener(this);

        box.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        box.setVisible(false);

        if(e.getSource() == back){
            new adminpage(f);
        }
        if(e.getSource() == exit){
            new loginpage();
        }
        
        
       
    }

    }
    

