package UI;

import service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by 15114 on 2018/4/21.
 */
public class MainUI {

    public MainUI() {
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setLocation(550, 300);

        JLabel jLabel = new JLabel("文件夹位置:");
        JTextField jTextField = new JTextField(30);
        JButton jButton = new JButton("确认");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = jTextField.getText();
                System.out.print(path);
                try {
                    new Service(path);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        jPanel1.setLayout(new FlowLayout());
        jPanel1.add(jLabel);
        jPanel1.add(jTextField);

        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel2.add(jButton);

        Box box = Box.createVerticalBox();
        box.add(jPanel1);
        box.add(jPanel2);

        frame.add(box);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        new MainUI();
    }
}
