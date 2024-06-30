import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class nprofilepage implements ActionListener{


    JButton change, exit, back;
    JFrame box = new JFrame("pp shop");
    JTextArea input = new JTextArea();
    JTextArea input1 = new JTextArea();
    normal_user f;
    public nprofilepage(normal_user f){
        this.f = f;

        Dimension  size = new Dimension(720, 400);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        change = new JButton("change info");
        exit = new JButton("EXIT");
        back = new JButton("back");

        JLabel text = new JLabel("information ");
        JLabel username = new JLabel("username :                " + f.username);
        JLabel name = new JLabel("name :                " + f.username);
        JLabel number = new JLabel("number :                " + f.number);

        
        text.setBackground(Color.BLUE);
        change.setBounds(300, 310, 100, 20);
        exit.setBounds(300, 340, 100, 20);
        text.setBounds(320, 5, 300, 100);
        username.setBounds(50, 60, 300, 100);
        name.setBounds(50, 130, 100, 20);
        number.setBounds(50, 170, 100, 20);
        back.setBounds(50, 330, 70, 20);
       
        //box.add(change);
        box.add(exit);
        box.add(text);
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
        if(e.getSource() == exit){
            System.out.println("--ewjkdowk");
            new loginpage();
        }
        if(e.getSource() == back) new normalpage(f);
    }

    }
    

