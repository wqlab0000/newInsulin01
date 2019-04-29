import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;
import java.util.Random;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.List;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JProgressBar;


public class InsulinPump extends JFrame {

    private JPanel contentPane;
    static JLabel lblNewLabel;
    static int selectedIndex = 0;
    static JLabel lblNewLabel_1;
    static JLabel lblNewLabel_2;
    static JLabel lblNewLabel_3;
    static JLabel lblNewLabel_4;
    static JProgressBar progressBar;
    static int left=300;
    static double realLeft=300.00;
    static boolean startFlag=false;
    static boolean threadFlag=true;
    static boolean eatFlag=false;
    JPanel panel;
    JButton btnNewButton_4;
    power p;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InsulinPump frame = new InsulinPump();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    //Initial
    public void init(){
        lblNewLabel_1.setVisible(false);
        lblNewLabel_2.setVisible(false);
        lblNewLabel_3.setVisible(false);
        lblNewLabel_4.setVisible(false);
        progressBar.setVisible(false);
    }
    public void resume(){
        lblNewLabel_1.setVisible(true);
        lblNewLabel_2.setVisible(true);
        lblNewLabel_3.setVisible(true);
        lblNewLabel_4.setVisible(true);
        progressBar.setVisible(true);
    }
    public InsulinPump() {
        setResizable(false);


        setTitle("Insulin Pump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 428, 198);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("▲");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
        btnNewButton.setBackground(SystemColor.text);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(286, 12, 43, 67);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("▼");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
        btnNewButton_1.setBackground(SystemColor.text);
        btnNewButton_1.setBounds(286, 91, 43, 69);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Eat");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(startFlag){
                    eatFlag=true;
            }
            }
        });
        btnNewButton_2.setBackground(new Color(127, 255, 212));
        btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 12));
        btnNewButton_2.setBounds(341, 12, 71, 67);
        contentPane.add(btnNewButton_2);

        btnNewButton_4 = new JButton("Start");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(startFlag==false){
                resume();
                startFlag=true;
                btnNewButton_4.setText("Stop");
                lblNewLabel_1.setText("InsulinLeft"+realLeft+"R");
                threadFlag=true;
                p = new power();
                p.start();
                }else{
                init();
                threadFlag=false;
                startFlag=false;
                btnNewButton_4.setText("Start");
                }
            }
        });
        btnNewButton_4.setBackground(new Color(255, 192, 203));
        btnNewButton_4.setFont(new Font("Dialog", Font.BOLD, 12));
        btnNewButton_4.setBounds(341, 91, 71, 68);
        contentPane.add(btnNewButton_4);

        panel = new JPanel();
        panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
        panel.setBackground(new Color(0, 255, 255));
        panel.setBounds(12, 12, 262, 148);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 262, 21);
        panel.add(lblNewLabel);

        //Insulin Pump working status
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(23, 27, 159, 21);
        panel.add(lblNewLabel_1);

        progressBar = new JProgressBar();
        progressBar.setMaximum(300);
        progressBar.setValue(300);
        progressBar.setForeground(Color.BLACK);
        progressBar.setBounds(23, 60, 216, 21);
        panel.add(progressBar);

        //Glucose:0Mg/dl
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(23, 105, 151, 15);
        panel.add(lblNewLabel_2);
        //Glucose
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(169, 105, 70, 15);
        panel.add(lblNewLabel_3);
        //Injection
        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBounds(169, 27, 70, 21);
        panel.add(lblNewLabel_4);
        init();
        CountTime ct = new CountTime();
        ct.start();

    }

}
class power extends Thread{
    Random r = new Random();
    DecimalFormat df = new DecimalFormat("0.00");
    String inputState;
    String bodyState;
    public void run(){
        while(InsulinPump.threadFlag){
        work();
        }
    }
    public void work(){
        int count;
        while(true){
        count=r.nextInt(150)+50;
        InsulinPump.lblNewLabel_2.setText("Glucose level:"+count+"Mg/dl");
        if(count<60){
            //Glucose low
            bodyState="low";
            inputState="Stop";
        }else if(count>160){
            //Glucose high
            bodyState="high";
            inputState="Bolus";
            InsulinPump.realLeft=InsulinPump.realLeft-1;
            InsulinPump.left--;
        }else{
            //Glucose ok
            bodyState="OK";
            inputState="Basal";
            InsulinPump.realLeft=InsulinPump.realLeft-0.5;
            InsulinPump.left--;
        }
        if(InsulinPump.eatFlag){
            bodyState="Eating";
            inputState="BolusPlus";
            InsulinPump.realLeft=InsulinPump.realLeft-1.5;
            InsulinPump.left=InsulinPump.left-3;
        }
        InsulinPump.lblNewLabel_3.setText(bodyState);
        InsulinPump.lblNewLabel_4.setText(inputState);
        InsulinPump.progressBar.setValue(InsulinPump.left);
        InsulinPump.lblNewLabel_1.setText("InsulinLeft"+df.format(InsulinPump.realLeft)+"R");
        if(InsulinPump.eatFlag){
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            InsulinPump.eatFlag=false;
        }else{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    }
}

class CountTime extends Thread{
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String LableString;
    public void run(){
        while(true){
            setTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void setTime(){
        LableString = " Battery:▂ ▃ ▄ ▅ ▆ "+"    "+df.format(new Date());
        InsulinPump.lblNewLabel.setText(LableString);
    }
  }
