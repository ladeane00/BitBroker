package com.LADLAB.LADLAB;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FinancePanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	//text fields
	JTextField bitcoinAmount = new JTextField();
	JTextField ethereumAmount = new JTextField();
	JTextField rippleAmount = new JTextField();
	
	//buttons
	JButton bitcoinAdd = new JButton("Deposit");
	JButton ethereumAdd = new JButton("Deposit");
	JButton rippleAdd = new JButton("Deposit");
	
	JButton bitcoinTake = new JButton("Withdraw");
	JButton ethereumTake = new JButton("Withdraw");
	JButton rippleTake = new JButton("Withdraw");
	
	//JLabels
	JLabel bitcoinTitle = new JLabel("Bitcoin");
	JLabel ethereumTitle = new JLabel("Ethereum");
	JLabel rippleTitle = new JLabel("Ripple");
	
	JLabel bitcoinAmAdd = new JLabel("Amount Bought/Sold");
	JLabel ethereumAmAdd = new JLabel("Amount Bought/Sold");
	JLabel rippleAmAdd = new JLabel("Amount Bought/Sold");
	
	JLabel bitcoinAmTitle = new JLabel("Amount");
	JLabel ethereumAmTitle = new JLabel("Amount");
	JLabel rippleAmTitle = new JLabel("Amount");
	
	JLabel bitcoinBalTitle = new JLabel("Balance");
	JLabel ethereumBalTitle = new JLabel("Balance");
	JLabel rippleBalTitle = new JLabel("Balance");
	
	JLabel bitcoinAm = new JLabel("" + Math.round(CryptoIndex.bitcoinBal * 100) / 100.0 + " B");
	JLabel ethereumAm = new JLabel("" + Math.round(CryptoIndex.ethereumBal * 100) / 100.0 + " E");
	JLabel rippleAm = new JLabel("" + Math.round(CryptoIndex.rippleBal * 100) / 100.0 + " R");
	
	JLabel bitcoinMoney = new JLabel("$" + Math.round(CryptoIndex.bitcoinMoneyBal * 100) / 100.0);
	JLabel ethereumMoney = new JLabel("$" + Math.round(CryptoIndex.ethereumMoneyBal * 100) / 100.0);
	JLabel rippleMoney = new JLabel("$" + Math.round(CryptoIndex.rippleMoneyBal * 100) / 100.0);
	
	JLabel financeTitle = new JLabel("Finance Book");
	
	//PASSWORD CHANGE STUFF *******
	//button
	JButton enter = new JButton("Enter");
				
	//label
	JLabel enterPass = new JLabel("Change Password");
			
	//text field
	JTextField passwordField = new JTextField();
	
	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public FinancePanel() {
		setBackground(new Color(250, 228, 180));
		setLayout(null);
		
		
		Font font = new Font("Times New Roman", Font.BOLD, 24);
		//@SuppressWarnings("rawtypes")
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		//labels
		
		//adding other stuff
		//titles
		bitcoinTitle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		add(bitcoinTitle);
		bitcoinTitle.setBounds(30, 170, 100, 100);
		
		ethereumTitle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		add(ethereumTitle);
		ethereumTitle.setBounds(15, 270, 170, 100);
		
		rippleTitle.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		add(rippleTitle);
		rippleTitle.setBounds(33, 370, 100, 100);
		
		//*********BITCOIN*************
		//labels
		add(bitcoinAmTitle);
		bitcoinAmTitle.setBounds(165, 150, 100, 100);
		bitcoinAmTitle.setFont(font.deriveFont(attributes));
		add(bitcoinBalTitle);
		bitcoinBalTitle.setBounds(280, 150, 100, 100);
		bitcoinBalTitle.setFont(font.deriveFont(attributes));
		add(bitcoinAmAdd);
		bitcoinAmAdd.setBounds(405, 150, 150, 100);
		
		bitcoinAm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(bitcoinAm);
		bitcoinAm.setBounds(163, 210, 150, 40);
		
		bitcoinMoney.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(bitcoinMoney);
		bitcoinMoney.setBounds(280, 210, 150, 40);
				
		//buttons
		add(bitcoinAdd);
		bitcoinAdd.setBounds(535, 200, 100, 30);
		add(bitcoinTake);
		bitcoinTake.setBounds(645, 200, 100, 30);
		
		//text fields
		add(bitcoinAmount);
		bitcoinAmount.setBounds(410, 212, 110, 22);
		bitcoinAmount.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                bitcoinAmount.setText("");
            }
        });

		
		//*********ETHEREUM***********
		//labels
		add(ethereumAmTitle);
		ethereumAmTitle.setBounds(165, 250, 100, 100);
		ethereumAmTitle.setFont(font.deriveFont(attributes));
		add(ethereumBalTitle);
		ethereumBalTitle.setBounds(280, 250, 100, 100);
		ethereumBalTitle.setFont(font.deriveFont(attributes));
		add(ethereumAmAdd);
		ethereumAmAdd.setBounds(405, 250, 150, 100);
				
		ethereumAm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(ethereumAm);
		ethereumAm.setBounds(163, 320, 150, 22);
		
		ethereumMoney.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(ethereumMoney);
		ethereumMoney.setBounds(280, 310, 150, 40);
						
		//buttons
		add(ethereumAdd);
		ethereumAdd.setBounds(535, 300, 100, 30);
		add(ethereumTake);
		ethereumTake.setBounds(645, 300, 100, 30);
				
		//text fields
		add(ethereumAmount);
		ethereumAmount.setBounds(410, 312, 110, 22);
		ethereumAmount.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                ethereumAmount.setText("");
            }
        });
		
		//********RIPPLE*******************
		//labels
		add(rippleAmTitle);
		rippleAmTitle.setBounds(165, 350, 100, 100);
		rippleAmTitle.setFont(font.deriveFont(attributes));
		add(rippleBalTitle);
		rippleBalTitle.setBounds(280, 350, 100, 100);
		rippleBalTitle.setFont(font.deriveFont(attributes));
		add(rippleAmAdd);
		rippleAmAdd.setBounds(405, 350, 150, 100);
				
		rippleAm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(rippleAm);
		rippleAm.setBounds(163, 420, 150, 22);
		
		rippleMoney.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(rippleMoney);
		rippleMoney.setBounds(280, 410, 150, 40);
						
		//buttons
		add(rippleAdd);
		rippleAdd.setBounds(535, 400, 100, 30);
		add(rippleTake);
		rippleTake.setBounds(645, 400, 100, 30);
				
		//text fields
		add(rippleAmount);
		rippleAmount.setBounds(410, 412, 110, 22);		
		rippleAmount.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                rippleAmount.setText("");
            }
        });
		
		
		//SEPERATE TITLE**********
		financeTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		financeTitle.setBounds(320, 40, 300, 100);
		add(financeTitle);
		
		bitcoinAdd.addMouseListener(this);
		bitcoinTake.addMouseListener(this);
		ethereumAdd.addMouseListener(this);
		ethereumTake.addMouseListener(this);
		rippleAdd.addMouseListener(this);
		rippleTake.addMouseListener(this);
		enter.addMouseListener(this);
		
		//File Reading
		try {
		    FileReader reader = new FileReader("res/info.txt");
		    BufferedReader bufferedReader = new BufferedReader(reader);
		 
		    String line;
		 
		    while ((line = bufferedReader.readLine()) != null) {
		           if (line.contains("BitcoinBal: ")) {
		        	   	CryptoIndex.bitcoinBal = Double.parseDouble(line.substring(12));
		            }
		           if (line.contains("EthereumBal: ")) {
		            	CryptoIndex.ethereumBal = Double.parseDouble(line.substring(13));
		            }
		           if (line.contains("RippleBal: ")) {
		            	CryptoIndex.rippleBal = Double.parseDouble(line.substring(11));
		            }
		           if (line.contains("Password: ")) {
		        	   CryptoIndex.password = line.substring(10);
		           }
		                System.out.println(line);
		            }
		            	reader.close();
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }	
		
		//PASSWORD STUFF********************
		add(enter);
		enter.setBounds(740, 40, 100, 30);
		add(enterPass);
		enterPass.setBounds(606, 20, 150, 30);
		add(passwordField);
		passwordField.setBounds(582, 44, 160, 22);
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.setColor(Color.BLACK);
        g.drawRect(160, 180, 600, 70);
        g.setColor(new Color(210, 180, 180));
        g.fillRect(161, 181, 599, 69);   
        
        g.setColor(Color.BLACK);
        g.drawRect(160, 280, 600, 70);
        g.setColor(new Color(210, 180, 180));
        g.fillRect(161, 281, 599, 69);
        
        g.setColor(Color.BLACK);
        g.drawRect(160, 380, 600, 70);
        g.setColor(new Color(210, 180, 180));
        g.fillRect(161, 381, 599, 69);
        }
	
	public void tick() {
		bitcoinAm.setText("" + Math.round(CryptoIndex.bitcoinBal * 100) / 100.0 + " B");
		ethereumAm.setText("" + Math.round(CryptoIndex.ethereumBal * 100) / 100.0 + " E");
		rippleAm.setText("" + Math.round(CryptoIndex.rippleBal * 100) / 100.0 + " R");
		
		CryptoIndex.bitcoinMoneyBal = CryptoIndex.bitcoinBal * CryptoIndex.bitcoinPrice;
		CryptoIndex.ethereumMoneyBal = CryptoIndex.ethereumBal * CryptoIndex.ethereumPrice;
		CryptoIndex.rippleMoneyBal = CryptoIndex.rippleBal * CryptoIndex.ripplePrice;
		
		bitcoinMoney.setText("$" + Math.round(CryptoIndex.bitcoinMoneyBal * 100) / 100.0);
		ethereumMoney.setText("$" + Math.round(CryptoIndex.ethereumMoneyBal * 100) / 100.0);
		rippleMoney.setText("$" + Math.round(CryptoIndex.rippleMoneyBal * 100) / 100.0);
		repaint();
		
		//price setting
		try {
		    FileReader reader = new FileReader("res/bitInfo.txt");
		    BufferedReader bufferedReader = new BufferedReader(reader);
		 
		    String line;
		 
		    int i = 0;
		    //RETRIEVES DATA FROM BITCOIN INFO FILE
		    while ((line = bufferedReader.readLine()) != null) {
		           if (i == 28) {
		        	   	CryptoIndex.bitcoinPrice = Double.parseDouble(line.substring(29, 36));
		            } else if (i == 56) {
		        	   	CryptoIndex.ethereumPrice = Double.parseDouble(line.substring(29, 36));
		            } else if (i == 82) {
		        	   	CryptoIndex.ripplePrice = Double.parseDouble(line.substring(29, 36));
		        	   	break;
		        	   
		            }
		           i++;
		            }
		            	reader.close();
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		JButton currentButton = (JButton) e.getComponent();
		
		if (currentButton == bitcoinAdd) {
			CryptoIndex.bitcoinBal += Double.parseDouble(bitcoinAmount.getText());
		}
		if (currentButton == bitcoinTake) {
			CryptoIndex.bitcoinBal -= Double.parseDouble(bitcoinAmount.getText());
			if (CryptoIndex.bitcoinBal < 0) {
				CryptoIndex.bitcoinBal = 0;
			}
		}
		if (currentButton == ethereumAdd) {
			CryptoIndex.ethereumBal += Double.parseDouble(ethereumAmount.getText());
		}
		if (currentButton == ethereumTake) {
			CryptoIndex.ethereumBal -= Double.parseDouble(ethereumAmount.getText());
			if (CryptoIndex.ethereumBal < 0) {
				CryptoIndex.ethereumBal = 0;
			}
		}
		if (currentButton == rippleAdd) {
			CryptoIndex.rippleBal += Double.parseDouble(rippleAmount.getText());
		}
		if (currentButton == rippleTake) {
			CryptoIndex.rippleBal -= Double.parseDouble(rippleAmount.getText());
			if (CryptoIndex.rippleBal < 0) {
				CryptoIndex.rippleBal = 0;
			}
		}
		
		if (currentButton == rippleTake) {
			CryptoIndex.rippleBal -= Double.parseDouble(rippleAmount.getText());
			if (CryptoIndex.rippleBal < 0) {
				CryptoIndex.rippleBal = 0;
			}
		}
		
		if (currentButton == enter && !(passwordField.getText().equals(""))) {
			CryptoIndex.password = passwordField.getText();
			passwordField.setText("");
		}
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
