package com.example.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @Author:LiuKangwei
 * @Date:2020/8/28 0:07
 * @Description:
 */
 class SimpleFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HIGHT=200;
    public SimpleFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HIGHT);
    }
}