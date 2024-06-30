import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class editpage implements ActionListener{


    JButton enter, back;
    JFrame box = new JFrame("pp shop");
    JTextArea price = new JTextArea();
    JTextArea name = new JTextArea();

    admin_user f;
    public editpage(admin_user f){
        this.f = f;

        Dimension  size = new Dimension(720, 400);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setBackground(Color.PINK);

        enter = new JButton(" enter");
        back = new JButton("back");

        JLabel pname = new JLabel("enter your product name : ");
        JLabel pprice = new JLabel("enter the price : ");
        
        enter.setBounds(400, 330, 120, 20);
        back.setBounds(200, 330, 120, 20);
        pname.setBounds(100, 10, 300, 100);
        pprice.setBounds(100, 60, 300, 100);
       
        name.setBounds(300, 50, 100, 20);
        price.setBounds(300, 100, 100, 20);
       
        
       
        
        box.add(enter);
        box.add(back);
        box.add(name);
        box.add(pname);
        box.add(price);
        box.add(pprice);

        back.addActionListener(this);
        enter.addActionListener(this);
     

        box.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        box.setVisible(false);

        if(e.getSource() == enter){
            datas.set_product(f, new product(name.getText(), Integer.parseInt(price.getText()), f.username));
            new adminpage(f);
        }
        if(e.getSource()== back){
            new adminpage(f);
        }

    }
}
    

