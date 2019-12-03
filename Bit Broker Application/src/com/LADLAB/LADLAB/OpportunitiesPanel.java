package com.LADLAB.LADLAB;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpportunitiesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel bitcoinLabel = new JLabel("Bitcoin");
	JLabel ethereumLabel = new JLabel("Ethereum");
	JLabel rippleLabel = new JLabel("Ripple");
	
	JLabel sellLabel = new JLabel("Sell Opportunity?");
	JLabel buyLabel = new JLabel("Buy Opportunity?");
	JLabel sellLabel1 = new JLabel("Sell Opportunity?");
	JLabel buyLabel1 = new JLabel("Buy Opportunity?");
	JLabel sellLabel2 = new JLabel("Sell Opportunity?");
	JLabel buyLabel2 = new JLabel("Buy Opportunity?");
	
	boolean bitcoinBuy = false;
	boolean bitcoinSell = false;
	boolean ethereumBuy = false;
	boolean ethereumSell = false;
	boolean rippleBuy = false;
	boolean rippleSell = false;
	
	BlinkLabelGreen bBuy = new BlinkLabelGreen("BUY");
	BlinkLabelRed bSell = new BlinkLabelRed("SELL");
	BlinkLabelGreen eBuy = new BlinkLabelGreen("BUY");
	BlinkLabelRed eSell = new BlinkLabelRed("SELL");
	BlinkLabelGreen rBuy = new BlinkLabelGreen("BUY");
	BlinkLabelRed rSell = new BlinkLabelRed("SELL");
	
	
	@SuppressWarnings("unchecked")
	public OpportunitiesPanel() {
		setBackground(new Color(250, 228, 180));
		setLayout(null);
		
		Font font = new Font("Times New Roman", Font.PLAIN, 16);
		//@SuppressWarnings("rawtypes")
		@SuppressWarnings("rawtypes")
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		
		//adding labels
		bitcoinLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(bitcoinLabel);
		bitcoinLabel.setBounds(130, 100, 170, 80);
		
		ethereumLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(ethereumLabel);
		ethereumLabel.setBounds(576, 100, 170, 80);
		
		rippleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(rippleLabel);
		rippleLabel.setBounds(376, 410, 170, 80);
		
		//buy and sells
		add(buyLabel);
		buyLabel.setBounds(20, 140, 180, 100);
		buyLabel.setFont(font.deriveFont(attributes));
		
		add(sellLabel);
		sellLabel.setBounds(210, 140, 180, 100);
		sellLabel.setFont(font.deriveFont(attributes));
		
		add(buyLabel1);
		buyLabel1.setBounds(480, 140, 180, 100);
		buyLabel1.setFont(font.deriveFont(attributes));
		
		add(sellLabel1);
		sellLabel1.setBounds(680, 140, 180, 100);
		sellLabel1.setFont(font.deriveFont(attributes));
		
		add(buyLabel2);
		buyLabel2.setBounds(260, 450, 180, 100);
		buyLabel2.setFont(font.deriveFont(attributes));
		
		add(sellLabel2);
		sellLabel2.setBounds(460, 450, 180, 100);
		sellLabel2.setFont(font.deriveFont(attributes));
		
		//blinkers
		
		add(bBuy);
		bBuy.setBounds(30, 185, 200, 100);
		bBuy.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		add(bSell);
		bSell.setBounds(220, 185, 200, 100);
		bSell.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		add(eBuy);
		eBuy.setBounds(490, 185, 200, 100);
		eBuy.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		add(eSell);
		eSell.setBounds(680, 185, 200, 100);
		eSell.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		add(rBuy);
		rBuy.setBounds(270, 500, 200, 100);
		rBuy.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		add(rSell);
		rSell.setBounds(470, 500, 200, 100);
		rSell.setFont(new Font("Times New Roman", Font.BOLD, 40));
	}
	
	public void tick() {
		//updating bitcoin opportunities
		if (CryptoIndex.bitcoinValues.size() > 1) {
			if (CryptoIndex.bitcoinValues.get(CryptoIndex.bitcoinValues.size() - 1) - CryptoIndex.bitcoinValues.get(CryptoIndex.bitcoinValues.size() - 2) < -10.0) {
				bitcoinBuy = true;
			} else {
				bitcoinBuy = false;
			}
			if (CryptoIndex.bitcoinValues.get(CryptoIndex.bitcoinValues.size() - 1) - CryptoIndex.bitcoinValues.get(CryptoIndex.bitcoinValues.size() - 2) > 10.0) {
				bitcoinSell = true;
			} else {
				bitcoinSell = false;
			}
		}
		//updating ethereum opportunities
		if (CryptoIndex.ethereumValues.size() > 1) {
			if (CryptoIndex.ethereumValues.get(CryptoIndex.ethereumValues.size() - 1) - CryptoIndex.ethereumValues.get(CryptoIndex.ethereumValues.size() - 2) < -2.0) {
				ethereumBuy = true;
			} else {
				ethereumBuy = false;
			}
			if (CryptoIndex.ethereumValues.get(CryptoIndex.ethereumValues.size() - 1) - CryptoIndex.ethereumValues.get(CryptoIndex.ethereumValues.size() - 2) > 2.0) {
				ethereumSell = true;
			} else {
				ethereumSell = false;
			}
		}
		//updating ripple opportunities
		if (CryptoIndex.rippleValues.size() > 1) {
			if (CryptoIndex.rippleValues.get(CryptoIndex.rippleValues.size() - 1) - CryptoIndex.rippleValues.get(CryptoIndex.rippleValues.size() - 2) < -.04) {
				rippleBuy = true;
			} else {
				rippleBuy = false;
			}
			if (CryptoIndex.rippleValues.get(CryptoIndex.rippleValues.size() - 1) - CryptoIndex.rippleValues.get(CryptoIndex.rippleValues.size() - 2) > .04) {
				rippleSell = true;
			} else {
				rippleSell = false;
			}
		}
		
		
		
		bBuy.setVisible(bitcoinBuy);
		bSell.setVisible(bitcoinSell);
		eBuy.setVisible(ethereumBuy);
		eSell.setVisible(ethereumSell);
		rBuy.setVisible(rippleBuy);
		rSell.setVisible(rippleSell);
	}
	
	

}
