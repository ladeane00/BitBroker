package com.LADLAB.LADLAB;

import java.time.Instant;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

//@SuppressWarnings("rawtypes")
public class CoinGraph {
	
	double[] x;
	double[] y;
	
	String[] xx;
	
	@SuppressWarnings("rawtypes")
	XChartPanel panel;
    XYChart chart;
    
    String name;
    
    IO io = new IO("2ac0ae91-4003-41fe-82c9-e1e57b60d493");
	
	//bitcoin data
	double[] bitXData = new double[15];
    double[] bitYData = new double[15];
    
    Instant now;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CoinGraph(String title, String xs, String ys, String name) {
		this.name = name;
		chart = QuickChart.getChart(title, xs, ys, name, bitXData, bitYData);
		panel = new XChartPanel(chart);
		chart.getStyler().setLegendVisible(false);
		CryptoIndex.setPrices();
		if (name.equals("bitcoin")) {
			chart.getStyler().setYAxisMax(Double.valueOf(CryptoIndex.bitcoinPrice + 15));
			chart.getStyler().setYAxisMin(Double.valueOf(CryptoIndex.bitcoinPrice - 15));
		}
		if (name.equals("ethereum")) {
			chart.getStyler().setYAxisMax(Double.valueOf(CryptoIndex.ethereumPrice + 2));
			chart.getStyler().setYAxisMin(Double.valueOf(CryptoIndex.ethereumPrice - 2));
		}
		if (name.equals("ripple")) {
			chart.getStyler().setYAxisMax(Double.valueOf(CryptoIndex.ripplePrice + .001));
			chart.getStyler().setYAxisMin(Double.valueOf(CryptoIndex.ripplePrice - .001));
		}
	}
	//updates the graphs (with newly retrieved information)
	//updates every second
	public void update(int i) { 
			if (chart.getTitle().equals("Bitcoin")) {
			if (i < 15) {
				bitXData[i] = i;
				bitYData[i] = CryptoIndex.bitcoinPrice;
			} else {
				for (int j = 0; j < bitXData.length - 1; j++) {
					bitXData[j] = bitXData[j + 1];
				}
				bitXData[bitXData.length - 1] = i;
				for (int j = 0; j < bitYData.length - 1; j++) {
					bitYData[j] = bitYData[j + 1];
				}
				bitYData[bitYData.length - 1] = CryptoIndex.bitcoinPrice;
			}
			CryptoIndex.bitcoinValues.add(CryptoIndex.bitcoinPrice);
			} 
			System.out.println(CryptoIndex.bitcoinValues);
			if (chart.getTitle().equals("Ethereum")) {
				if (i < 15) {
					bitXData[i] = i;
					bitYData[i] = CryptoIndex.ethereumPrice;
				} else {
					for (int j = 0; j < bitXData.length - 1; j++) {
						bitXData[j] = bitXData[j + 1];
					}
					bitXData[bitXData.length - 1] = i;
					for (int j = 0; j < bitYData.length - 1; j++) {
						bitYData[j] = bitYData[j + 1];
					}
					bitYData[bitYData.length - 1] = CryptoIndex.ethereumPrice;
					CryptoIndex.ethereumValues.add(bitYData[bitYData.length - 1]);
				}
				CryptoIndex.ethereumValues.add(CryptoIndex.ethereumPrice);
			} 
			if (chart.getTitle().equals("Ripple")) {
				if (i < 15) {
					bitXData[i] = i;
					bitYData[i] = CryptoIndex.ripplePrice;
				} else {
					for (int j = 0; j < bitXData.length - 1; j++) {
						bitXData[j] = bitXData[j + 1];
					}
					bitXData[bitXData.length - 1] = i;
					for (int j = 0; j < bitYData.length - 1; j++) {
						bitYData[j] = bitYData[j + 1];
					}
					bitYData[bitYData.length - 1] = CryptoIndex.ripplePrice;
					CryptoIndex.rippleValues.add(bitYData[bitYData.length - 1]);
				}
				CryptoIndex.rippleValues.add(CryptoIndex.ripplePrice);
			}
		if (i % 5 == 0 && chart.getTitle().equals("Bitcoin")) {
			chart.getStyler().setYAxisMax(Double.valueOf(CryptoIndex.bitcoinPrice + 15));
			chart.getStyler().setYAxisMin(Double.valueOf(CryptoIndex.bitcoinPrice - 15));
		}
		if (i % 5 == 0 && chart.getTitle().equals("Ethereum")) {
			chart.getStyler().setYAxisMax(Double.valueOf(CryptoIndex.ethereumPrice + 2));
			chart.getStyler().setYAxisMin(Double.valueOf(CryptoIndex.ethereumPrice - 2));
		}
		if (i % 5 == 0 && chart.getTitle().equals("Ripple")) {
			chart.getStyler().setYAxisMax(Double.valueOf(CryptoIndex.ripplePrice + .001));
			chart.getStyler().setYAxisMin(Double.valueOf(CryptoIndex.ripplePrice - .001));
		}
		
		chart.updateXYSeries(name, bitXData, bitYData, null);
		panel.repaint();
	}
	
	

}
