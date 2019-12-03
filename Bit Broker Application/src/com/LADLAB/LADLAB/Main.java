package com.LADLAB.LADLAB;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Main extends JFrame implements Runnable, MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	public static boolean running = false;
	
	//State
	//State currentState;
	int frames;
	
	Instant now;
	IO io = new IO("2ac0ae91-4003-41fe-82c9-e1e57b60d493");
	
	//home screen
	JPanel home = new JPanel();
	//opportunities
	OpportunitiesPanel ops = new OpportunitiesPanel();
	//markets
	MarketPanel markets = new MarketPanel();
	//finance book
	FinancePanel fBook = new FinancePanel();
	//about
	JPanel about = new JPanel();
	//password panel
	JPanel pass = new JPanel();
	//card layout
	JPanel cards = new JPanel(new CardLayout());
	
	JLabel BitBroker = new JLabel("BitBroker");
	
	//buttons
	JButton opsB = new JButton("Opportunities");	
	JButton marketsB = new JButton("Markets");
	JButton financeB = new JButton("Finance Book");
	JButton aboutB = new JButton("About");
	
	JButton backOps = new JButton("Back");
	JButton backMarkets = new JButton("Back");
	JButton backFinance = new JButton("Back");
	JButton backAbout = new JButton("Back");
	
	//PASSWORD STUFF******
	//button
	JButton enter = new JButton("Enter");
		
	//label
	JLabel enterPass = new JLabel("Enter Password");
		
	//text field
	JPasswordField passwordField = new JPasswordField();
	
	JButton backPass = new JButton("Back");
	//************************
	
	//images
	Image title;
	Image pointer;
	
	//labels
	JLabel bitBroker;
	JLabel pointerLabel;
	JLabel aboutLabel;
	JLabel description;
	
	String des = "Created by Lucas Deane, one of "
			+ "the most affluent and wise cryptocurrency "
			+ "investors in the world, the BitBroker application "
			+ "provides a platform whereby the user can view the "
			+ "three highest trading cryptocurrencies, keep track of "
			+ "their funds in each, and use its special opportunities "
			+ "page to see when to buy and sell. It is important to note "
			+ "that this program is for quick and small profits only.";
	
	public void init() {
		//jFrame settings
		setSize(850,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BitBroker");
		setResizable(false);
	    setVisible(true);
	    
	    //panel settings
	    home.setBackground(new Color(0, 50, 100));
	    //ops.setBackground(new Color(250, 228, 180));
	    //markets.setBackground(new Color(250, 228, 180));
	    //fBook.setBackground(new Color(250, 228, 180));
	    about.setBackground(new Color(250, 228, 180));
	    pass.setBackground(new Color(250, 228, 180));
	    getContentPane().add(cards);
	    home.setLayout(null);
	    //ops.setLayout(null);
	    //markets.setLayout(null);
	    //fBook.setLayout(null);
	    about.setLayout(null);
	    pass.setLayout(null);
	    
	    //State Initialization
	    //currentState = State.Home;
	    
	    //panel adding
	    cards.add(home, "home");
	    cards.add(ops, "ops");
	    cards.add(markets, "markets");
	    cards.add(fBook, "fBook");
	    cards.add(about, "about");
	    cards.add(pass);
	    
	    //button shit
	    opsB.setBounds(325, 340, 200, 50);
	    marketsB.setBounds(325, 420, 200, 50);
	    financeB.setBounds(325, 500, 200, 50);
	    aboutB.setBounds(325, 580, 200, 50);
	    
	    backOps.setBounds(10, 10, 170, 40);
	    backMarkets.setBounds(10, 10, 170, 40);
	    backFinance.setBounds(10, 10, 170, 40);
	    backAbout.setBounds(10, 10, 170, 40);
	    backPass.setBounds(10, 10, 170, 40);
	    
	    //**** PASSWORD PANEL**********************
	    pass.add(enter);
		enter.setBounds(420, 197, 100, 30);
		pass.add(enterPass);
		enterPass.setBounds(282, 170, 100, 30);
		pass.add(passwordField);
		passwordField.setBounds(250, 200, 160, 22);
	    //passwordField).setEchoChar('*');
		//******************************************
	    
	    //labels
	    try {
	    	title = ImageIO.read(new File("res/BitBrokerTitle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    try {
	    	pointer = ImageIO.read(new File("res/Pointer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    bitBroker = new JLabel(new ImageIcon(title));
	    bitBroker.setBounds(200, 50, 444, 300);
	    home.add(bitBroker);
	    
	    pointerLabel = new JLabel(new ImageIcon(pointer));
	    pointerLabel.setBounds(275, 345, 32, 32);
		home.add(pointerLabel);
		
		aboutLabel = new JLabel("About");
		aboutLabel.setBounds(352, 60, 300, 100);
		aboutLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		about.add(aboutLabel);
		
		description = new JLabel();
		description.setText("<html>"+ des +"</html>");
		description.setBounds(70, 70, 750, 400);
		description.setFont(new Font("Serif", Font.PLAIN, 25));
		about.add(description);
		
		about.repaint();

	    //adding buttons
	    home.add(opsB);
	    home.add(marketsB);
	    home.add(financeB);
	    home.add(aboutB);
	    
	    ops.add(backOps);
	    markets.add(backMarkets);
	    fBook.add(backFinance);
	    about.add(backAbout);
	    pass.add(backPass);
	    
	    opsB.addMouseListener(this);
	    marketsB.addMouseListener(this);
	    financeB.addMouseListener(this);
	    aboutB.addMouseListener(this);
	    
	    backOps.addMouseListener(this);
	    backMarkets.addMouseListener(this);
	    backFinance.addMouseListener(this);
	    backAbout.addMouseListener(this);
	    enter.addMouseListener(this);
	    backPass.addMouseListener(this);
	    
	    home.repaint();
	}
	
	public Main() {
		init();
	}

	@SuppressWarnings("deprecation")
	public void mouseClicked(MouseEvent e) {
		JButton currentButton = (JButton) e.getComponent();
		
		if (currentButton == opsB) {
			home.setVisible(false);
			ops.setVisible(true);
			//currentState = State.Opportunities;
		}
		
		if (currentButton == marketsB) {
			home.setVisible(false);
			markets.setVisible(true);
			//currentState = State.Opportunities;
		}
		
		if (currentButton == financeB) {
			home.setVisible(false);
			//fBook.setVisible(true);
			pass.setVisible(true);
			//currentState = State.Opportunities;
		}
		
		if (currentButton == aboutB) {
			home.setVisible(false);
			about.setVisible(true);
			//currentState = State.Opportunities;
		}
		
		//back buttons
		if (currentButton == backOps) {
			home.setVisible(true);
			ops.setVisible(false);
			//currentState = State.Opportunities;
		}
		
		if (currentButton == backMarkets) {
			home.setVisible(true);
			markets.setVisible(false);
			//currentState = State.Opportunities;
		}
		
		if (currentButton == backFinance) {
			home.setVisible(true);
			fBook.setVisible(false);
			//currentState = State.Opportunities;
		}
		
		if (currentButton == backAbout) {
			home.setVisible(true);
			about.setVisible(false);
			//currentState = State.Opportunities;
		}
		if (currentButton == backPass) {
			home.setVisible(true);
			pass.setVisible(false);
			//currentState = State.Opportunities;
		}
		if (currentButton == enter && passwordField.getText().equals(CryptoIndex.password)) {
			pass.setVisible(false);
			fBook.setVisible(true);
			passwordField.setText("");
			//currentState = State.Opportunities;
		}
	}

	@SuppressWarnings("deprecation")
	public void mousePressed(MouseEvent e) {
		JButton currentButton = (JButton) e.getComponent();
		
		if (currentButton == opsB) {
			home.setVisible(false);
			ops.setVisible(true);
			//currentState = State.Opportunities;
		}
		
		if (currentButton == marketsB) {
			home.setVisible(false);
			markets.setVisible(true);
			//currentState = State.Markets;
		}
		
		if (currentButton == financeB) {
			home.setVisible(false);
			//fBook.setVisible(true);
			pass.setVisible(true);
			//currentState = State.FinanceBook;
		}
		
		if (currentButton == aboutB) {
			home.setVisible(false);
			about.setVisible(true);
			//currentState = State.About;
		}
		
		//back buttons
		if (currentButton == backOps) {
			home.setVisible(true);
			ops.setVisible(false);
			pointerLabel.setBounds(275, 345, 32, 32);
			home.add(pointerLabel);
			home.repaint();
			//currentState = State.Home;
		}
		
		if (currentButton == backMarkets) {
			home.setVisible(true);
			markets.setVisible(false);
			pointerLabel.setBounds(275, 425, 32, 32);
			home.add(pointerLabel);
			home.repaint();
			//currentState = State.Home;
		}
		
		if (currentButton == backFinance) {
			home.setVisible(true);
			fBook.setVisible(false);
			pointerLabel.setBounds(275, 505, 32, 32);
			home.add(pointerLabel);
			home.repaint();
			//currentState = State.Home;
		}
		
		if (currentButton == backAbout) {
			home.setVisible(true);
			about.setVisible(false);
			pointerLabel.setBounds(275, 585, 32, 32);
			home.add(pointerLabel);
			home.repaint();
			//currentState = State.Home;
		}
		if (currentButton == backPass) {
			home.setVisible(true);
			pass.setVisible(false);
			//currentState = State.Opportunities;
		}
		if (currentButton == enter && passwordField.getText().equals(CryptoIndex.password)) {
			pass.setVisible(false);
			fBook.setVisible(true);
			passwordField.setText("");
			//currentState = State.Opportunities;
		}
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		JButton currentButton = (JButton) e.getComponent();
		
		if (currentButton == opsB) {
			pointerLabel.setBounds(275, 345, 32, 32);
			home.add(pointerLabel);
			home.repaint();
		}
		
		if (currentButton == marketsB) {
			pointerLabel.setBounds(275, 425, 32, 32);
			home.add(pointerLabel);
			home.repaint();
		}
		
		if (currentButton == financeB) {
			pointerLabel.setBounds(275, 505, 32, 32);
			home.add(pointerLabel);
			home.repaint();
		}
		
		if (currentButton == aboutB) {
			pointerLabel.setBounds(275, 585, 32, 32);
			home.add(pointerLabel);
			home.repaint();
		}
	}

	public void mouseExited(MouseEvent e) {
		JButton currentButton = (JButton) e.getComponent();
		
		if (currentButton == opsB) {
			home.remove(pointerLabel);
		}
		
		if (currentButton == marketsB) {
			home.remove(pointerLabel);
		}
		
		if (currentButton == financeB) {
			home.remove(pointerLabel);
		}
		
		if (currentButton == aboutB) {
			home.remove(pointerLabel);
		}
		
	}
	
	public static void clearTheFile(String filename) throws IOException {
        FileWriter fwOb = new FileWriter(filename, false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
		fwOb.close();
    }
	
	protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	try {
        		
        	FileWriter writer = new FileWriter("res/info.txt", true);
         
         	clearTheFile("res/info.txt");
         	writer.write("BitcoinBal: " + CryptoIndex.bitcoinBal);
         	writer.write("\r\n");   // write new line
         	writer.write("EthereumBal: " + CryptoIndex.ethereumBal);
         	writer.write("\r\n");  
         	writer.write("RippleBal: " + CryptoIndex.rippleBal);
         	writer.write("\r\n");
         	writer.write("Password: " + CryptoIndex.password);
         	writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
           System.exit(0);
        }
     }



	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
			tick();
			delta--;
			}
			paint();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
	}
	int i = 0;
	int j = 0;
	Instant start;
	public void tick() {
		now = Instant.now();
		if (Double.parseDouble(now.toString().substring(17, 19)) == 59.0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			start = Instant.now().plusSeconds(25200);
			
			if (j < 1) {
				System.out.println(start);
				markets.startTime = start.toString().substring(11, 16);
				markets.start.setText("Start Time: " + markets.startTime);
				j++;
			}
			System.out.println("minute!");
			io.HttpGet("", false);
			markets.tick(i);
			i++;
		}
		fBook.tick();
		ops.tick();
	}
	
	public void paint() {
		BufferStrategy buffer = getBufferStrategy();
		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}
	}
	
	
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	public synchronized void stop() {
		running = false;
		System.exit(0);
	}
	
	
	
	
	public static void main(String[] args) {
		new Main().start();
	}

}
