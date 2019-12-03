package com.LADLAB.LADLAB;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarketPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//Labels
	JLabel bitcoinL = new JLabel("Bitcoin");
	JLabel rippleL = new JLabel("Ripple");
	JLabel ethereumL = new JLabel("Ethereum");
	
	JLabel marketTitle = new JLabel("Markets");
    
	public String startTime = "";
	
	JLabel start = new JLabel("Start Time: " + startTime);
	
    // Create Charts
    
    //Bitcoin test chart
    CoinGraph bitcoinChart = new CoinGraph("Bitcoin", "Time", "Price", "bitcoin");
    CoinGraph ethereumChart = new CoinGraph("Ethereum", "Time", "Price", "ethereum");
    CoinGraph rippleChart = new CoinGraph("Ripple", "Time", "Price", "ripple");
    
    public MarketPanel() {
		setBackground(new Color(250, 228, 180));
		setLayout(null);
		add(bitcoinChart.panel);
		bitcoinChart.panel.setBounds(30, 130, 350, 250);
		add(ethereumChart.panel);
		ethereumChart.panel.setBounds(470, 130, 350, 250);
		add(rippleChart.panel);
		rippleChart.panel.setBounds(230, 470, 350, 250);
		
		//labels
		bitcoinL.setBounds(150, 20, 150, 150);
		bitcoinL.setFont(new Font("Serif", Font.PLAIN, 20));
		rippleL.setBounds(375, 360, 150, 150);
		rippleL.setFont(new Font("Serif", Font.PLAIN, 20));
		ethereumL.setBounds(600, 20, 150, 150);
		ethereumL.setFont(new Font("Serif", Font.PLAIN, 20));
		add(bitcoinL);
		add(rippleL);
		add(ethereumL);
		
		marketTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		marketTitle.setBounds(340, 0, 320, 100);
		add(marketTitle);
		
		add(start);
		start.setBounds(300, 40, 300, 100);
		start.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	}
    
    public void tick(int i) {
    	bitcoinChart.update(i);
    	ethereumChart.update(i);
    	rippleChart.update(i);
    	start.repaint();
    }
    
}
	
