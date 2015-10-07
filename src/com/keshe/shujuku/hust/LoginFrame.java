package com.keshe.shujuku.hust;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class LoginFrame extends JFrame implements ActionListener  {
	private JLabel selectLoginTypeLabel;
	private JRadioButton selectLoginTypeAdministratorButton;
	private JRadioButton selectLoginTypeCommonUserButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    
    public LoginFrame() {
        super();
        this.setSize(300,500);
        this.getContentPane().setLayout(null);//���ò��ֿ�����
        this.InitComponent();
    }
    
    private void InitComponent() {
    	if(selectLoginTypeLabel == null)
    	{
    		selectLoginTypeLabel = new JLabel();
            selectLoginTypeLabel.setBounds(34,80,200,18);
            selectLoginTypeLabel.setText("��ѡ���¼����:");
    	}
    	
    	if(selectLoginTypeAdministratorButton == null)
    	{
    		selectLoginTypeAdministratorButton = new JRadioButton();
    		selectLoginTypeAdministratorButton.setBounds(30,100,70,18);
    		selectLoginTypeAdministratorButton.setText("����Ա");
    	}
    	
    	if(selectLoginTypeCommonUserButton == null)
    	{
    		selectLoginTypeCommonUserButton = new JRadioButton();
    		selectLoginTypeCommonUserButton.setBounds(100,100,70,18);
    		selectLoginTypeCommonUserButton.setText("Ա��");
    	}
    	
    	if(userNameLabel == null)
    	{
    		userNameLabel = new JLabel();
    		userNameLabel.setBounds(30, 150, 50, 18);
    		userNameLabel.setText("�û���:");
    	}
    	
    	if(passwordLabel == null)
    	{
    		passwordLabel = new JLabel();
    		passwordLabel.setBounds(30, 200, 50, 18);
    		passwordLabel.setText("��    ��:");
    	}
        
    	if(userNameTextField == null)
    	{
    		userNameTextField = new JTextField();
    		userNameTextField.setBounds(80, 150, 100, 18);
    	}
    	
    	if(passwordTextField == null)
    	{
    		passwordTextField = new JPasswordField();
    		passwordTextField.setBounds(80, 200, 100, 18);
    	}
    	
    	if(loginButton == null)
    	{
    		loginButton = new JButton();
    		loginButton.setBounds(150, 250, 60, 20);
    		loginButton.setText("��¼");
    		loginButton.addActionListener(this);
    	}
    	
    	// ���쵥ѡ��
    	this.add(selectLoginTypeLabel,null);
    	this.add(selectLoginTypeAdministratorButton, null);
    	this.add(selectLoginTypeCommonUserButton, null);
    	this.add(userNameLabel, null);
    	this.add(passwordLabel, null);
    	this.add(userNameTextField, null);
    	this.add(passwordTextField, null);
    	this.add(loginButton, null);
    	
    	ButtonGroup group = new ButtonGroup();
        group.add(selectLoginTypeAdministratorButton);
        group.add(selectLoginTypeCommonUserButton);
        
        // ���õ�ѡ���ʼֵ
        selectLoginTypeCommonUserButton.setSelected(true);
    }
    
    // �¼�
    public void actionPerformed(ActionEvent e) {
    	String username = userNameTextField.getText();
    	String password = new String(passwordTextField.getPassword());
    	DBUtil util = new DBUtil();
    	if(util.doDBLogin() && util.doUserLogin(username, password)) {
    		MainFrame mainFrame = new MainFrame();
    		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//һ��Ҫ���ùر�
            mainFrame.setVisible(true);
    		this.dispose();
    	}
    	else {
    		JOptionPane.showConfirmDialog(null, "�˺������������", "�˺������������", JOptionPane.YES_NO_OPTION);
    	}
    }
}
