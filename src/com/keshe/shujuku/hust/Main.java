package com.keshe.shujuku.hust;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[])throws Exception{
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//一定要设置关闭

        loginFrame.setVisible(true);
    }
}
