import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class showusers implements ActionListener{


    JButton back;
    JFrame box = new JFrame("pp shop");
    admin_user f;
    ArrayList<JButton> cardd = new ArrayList<JButton>();
    ArrayList<normal_user> pdata = datas.get_nusers();

    public showusers(admin_user f){
        this.f = f;

        Dimension  size = new Dimension(750, 750);
        box.setSize(size);
        box.setLayout(null);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setBackground(Color.PINK);

        back = new JButton("back");
        JLabel text = new JLabel("name          number          card ");
        text.setBounds(20, 5, 300, 100);
        back.setBounds(50, 650, 70, 20);

        box.add(text);
        box.add(back);


        
        
        ArrayList<JPanel> panels = new ArrayList<JPanel>();

        int y = 80;
        for(normal_user p : pdata){
            JPanel newpanel = new JPanel();
            newpanel.setLayout(null);
            newpanel.setBackground(Color.GRAY);
            newpanel.setBounds(0, y, 720, 100);

            JButton addButton = new JButton("card");
            JLabel namelabel = new JLabel(p.username);
            JLabel pricelabel = new JLabel(p.number+"");

            addButton.setBackground(Color.GRAY);


            namelabel.setBounds(50, 0, 100, 100);
            pricelabel.setBounds(100, 0, 100, 100);
            addButton.setBounds(200, 0, 100, 100);

            addButton.addActionListener(this);

            newpanel.add(namelabel);
            newpanel.add(pricelabel);
            cardd.add(addButton);
            newpanel.add(cardd.get(cardd.size()-1));

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
       
        box.setVisible(false);

        for(int i = 0; i < cardd.size(); i++){
            if(e.getSource() == cardd.get(i)){
                box.setVisible(false);
                new hiscard(pdata.get(i), f);
            }
        }

        if(e.getSource() == back){
            new adminpage(f);
        }
        
       
    }
}