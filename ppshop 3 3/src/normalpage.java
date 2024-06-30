import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class normalpage implements ActionListener{

    JPanel panel;
    JButton profile, cart;
    JFrame box = new JFrame("pp shop");
    JTextArea search = new JTextArea();
    ArrayList<JPanel> panels = new ArrayList<JPanel>();
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    ArrayList<product> pdata = datas.allproducts();
   // ArrayList<JTextArea> rates = new ArrayList<>();


    normal_user f;

    public normalpage(normal_user f){
        this.f = f;
        Dimension  size = new Dimension(720, 720);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.gray);

        profile = new JButton(" profile");
        cart = new JButton("cart");

        JLabel text = new JLabel("products");
        JLabel srch = new JLabel("search box");
        
        panel.setBounds(0, 0, 720, 90);
        cart.setBounds(20, 20, 80, 20);
        profile.setBounds(20, 60, 80, 20);
        text.setBounds(320, 8, 300, 90);
        srch.setBounds(530, 7, 300, 90);
        search.setBounds(480, 60, 200, 20);
        
        panel.add(profile);
        panel.add(cart);
        panel.add(text);
        panel.add(srch);
        panel.add(search);
        box.add(panel);

        
        

        int y = 120;
        for(product p : pdata){
            JPanel newpanel = new JPanel();
            newpanel.setLayout(null);
            newpanel.setBackground(Color.GRAY);
            newpanel.setBounds(0, y, 720, 100);

            JButton addButton = new JButton("add to cart");
            JLabel namelabel = new JLabel(p.name);
            JLabel pricelabel = new JLabel(p.price+"");
            JLabel ratelabel = new JLabel("rate: "+ p.rate +" of 5 among "+p.number_of_rate+" review");

            addButton.setBackground(Color.GRAY);

            namelabel.setBounds(50, 0, 100, 100);
            pricelabel.setBounds(100, 0, 100, 100);
            ratelabel.setBounds(200, 0, 200, 100);
            addButton.setBounds(500, 0, 100, 100);

            addButton.addActionListener(this);

            newpanel.add(namelabel);
            newpanel.add(pricelabel);
            newpanel.add(ratelabel);
            buttons.add(addButton);
            newpanel.add(buttons.get(buttons.size()-1));
            

            panels.add(newpanel);
            y += 120;
        }

        for(JPanel x : panels){
            box.add(x);
        }

        profile.addActionListener(this);
        cart.addActionListener(this);
     

        box.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        

        for(int i = 0; i < buttons.size(); i++){
            if(e.getSource() == buttons.get(i)){
                datas.set_cart(f, pdata.get(i));
            }
        }
        if(e.getSource() == cart){
            box.setVisible(false);
            new cartpage(f);

        }
        
        if(e.getSource() == profile){
            box.setVisible(false);
            new nprofilepage(f);
        
        }

    }
}