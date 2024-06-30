import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mypage implements ActionListener{


    JButton back;
    JFrame box = new JFrame("your cart");
    admin_user f;

    public mypage(admin_user f){
        this.f = f;

        this.f = f;
        Dimension  size = new Dimension(720, 720);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setBackground(Color.PINK);

        back = new JButton("back");

        ArrayList<product> pdata = datas.get_product(f);



        back.setBounds(50, 650, 70, 20);


        box.add(back);


        
        
        ArrayList<JPanel> panels = new ArrayList<JPanel>();




        int y = 80;
        for(product p : pdata){
            JPanel newpanel = new JPanel();
            newpanel.setLayout(null);
            newpanel.setBackground(Color.GRAY);
            newpanel.setBounds(0, y, 720, 100);

            JLabel namelabel = new JLabel(p.name);
            JLabel pricelabel = new JLabel(p.price+"");
            JLabel ratelabel = new JLabel("rate: "+ p.rate+"of 5 among"+p.number_of_rate+" review");
            namelabel.setBounds(0, 0, 720, 100);
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

        box.setVisible(true);



        back.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back){
            box.setVisible(false);
            new adminpage(f);
        }
        
       
    }
}