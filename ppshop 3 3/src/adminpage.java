import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class adminpage implements ActionListener{

    JPanel panel;
    JButton edit, users, profile, myp;
    JFrame box = new JFrame("pp shop");
    JTextArea search = new JTextArea();
    admin_user f;
    public adminpage(admin_user f){
        this.f = f;
        Dimension  size = new Dimension(720, 720);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setBackground(Color.PINK);
        panel = new JPanel();

       panel.setLayout(null);
       panel.setBackground(Color.PINK);

        edit = new JButton("add products");
        users = new JButton("users");
        profile = new JButton("profile");
        myp = new JButton("my products");


        JLabel text = new JLabel("Admin");
        JLabel srch = new JLabel("search box");
        
        panel.setBounds(0, 0, 720, 110);
        users.setBounds(20, 10, 80, 20);
        profile.setBounds(150, 10, 80, 20);
        edit.setBounds(20, 50, 110, 20);
        text.setBounds(320, 8, 300, 90);
        srch.setBounds(530, 7, 300, 90);
        search.setBounds(480, 60, 200, 20);
        myp.setBounds(150, 50, 110, 20);
        
        panel.add(users);
        panel.add(profile);
        panel.add(edit);
        panel.add(text);
        panel.add(srch);
        panel.add(search);
        panel.add(myp);
        box.add(panel);

        ArrayList<product> pdata = datas.allproducts();
        ArrayList<JPanel> panels = new ArrayList<JPanel>();

        int y = 120;
        for(product p : pdata){
            JPanel newpanel = new JPanel();
            newpanel.setLayout(null);
            newpanel.setBackground(Color.GRAY);
            newpanel.setBounds(0, y, 720, 100);

            JLabel namelabel = new JLabel(p.name);
            JLabel pricelabel = new JLabel(p.price+"");
            JLabel ratelabel = new JLabel("rate: "+ p.rate+"of 5 among"+p.number_of_rate+" review");
            namelabel.setBounds(50, 0, 720, 100);
            pricelabel.setBounds(100, 0, 720, 100);
            ratelabel.setBounds(200, 0, 720, 100);

            newpanel.add(namelabel);
            newpanel.add(pricelabel);
            newpanel.add(ratelabel);

            panels.add(newpanel);
            y += 120;
        }

        for(JPanel x : panels){
            box.add(x);
        }

        edit.addActionListener(this);
        users.addActionListener(this);
        profile.addActionListener(this);
        myp.addActionListener(this);
     

        box.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        box.setVisible(false);
        
        if(e.getSource()== edit){
            new editpage(f);
        }
        if(e.getSource() == profile){
            new aprofilepage(f);
        }
        if(e.getSource() == users){
            new showusers(f);
        }
        if(e.getSource() == myp){
            new mypage(f);
        }

        
    }
    

}
