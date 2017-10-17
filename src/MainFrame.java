import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private JTextField jTextField=new JTextField();
    private JButton jbtns[]=new JButton[9];
    private JPanel jPanel=new JPanel(new GridLayout(3,3));
    private Container cp;
    private LoginFrame loginFrame;

    public MainFrame(LoginFrame login){
        loginFrame=login;
        init();
    }
    private void init(){
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        this.setBounds(100,100,500,600);
        cp.add(jTextField,BorderLayout.NORTH);
        cp.add(jPanel,BorderLayout.CENTER);
        jTextField.setEditable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        for(int i=0;i<9;i++){
            jbtns[i]=new JButton(Integer.toString(i));
            jPanel.add(jbtns[i]);
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton=(JButton)e.getSource();
                    jTextField.setText(jTextField.getText()+tmpButton.getText());
                }
            });
        }
    }
}
