import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    public JButton jbtnGenerate = new JButton("Generate");
    public JButton jbtnExit = new JButton("Exit");
    public JPanel jpnc = new JPanel(new GridLayout(1,4,3,3));
    public JPanel jpnp = new JPanel(new GridLayout(1,4,3,3));
    Random rad = new Random();
    public JLabel data[] = new JLabel[6];

    private Container cp ;
    public MainFrame(){
        this.init();
    }
    public void init(){
        this.setBounds(80,60,600,200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpnp, BorderLayout.SOUTH);
        jpnp.add(jbtnGenerate);
        jpnp.add(jbtnExit);
        for(int i = 0; i < 6; i++){
            data[i] = new JLabel();
            data[i].setFont(new Font(null , Font.BOLD, 36));
            data[i].setOpaque(true);
            data[i].setBackground(new Color(0xCF566C));
            jpnc.add(data[i]);
            }
        jbtnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num[] = new int[6];
                int i = 0;
                boolean boo;
                while (i < 6){
                    boo = true;
                    num[i] = rad.nextInt(49);
                    for (int j = 0; j < i; j++){
                        if (num[i] == num[j]){
                            boo = false;
                        }
                    }
                    if (boo){
                        i++;
                    }
                }

                for (int j = 0; j < 6; j ++){
                    data[j].setText(Integer.toString(num[j]));
                }
            }
        });
        jbtnExit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

             System.exit(0);
         }
     });
    }
}
