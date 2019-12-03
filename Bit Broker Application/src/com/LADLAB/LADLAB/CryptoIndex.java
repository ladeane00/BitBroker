package com.LADLAB.LADLAB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CryptoIndex {
	
	public static double bitcoinPrice = 0;
	public static double ethereumPrice = 0;
	public static double ripplePrice = 0;
	
	
	public static void setPrices() {
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
	
	//global values
	public static ArrayList<Double> bitcoinValues = new ArrayList<Double>();
	public static ArrayList<Double> ethereumValues = new ArrayList<Double>();
	public static ArrayList<Double> rippleValues = new ArrayList<Double>();
	
	public static double bitcoinBal = 0;
	public static double ethereumBal = 0;
	public static double rippleBal = 0;
	
	public static double bitcoinMoneyBal = bitcoinBal * bitcoinPrice;
	public static double ethereumMoneyBal = ethereumBal * ethereumPrice;
	public static double rippleMoneyBal = rippleBal * ripplePrice;
	
	public static String password = "password";

}
