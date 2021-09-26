package main;

import java.util.*;

import model.shareModel;
import service.ServiceForStockers;

public class Driver {

	static shareModel modelObj;
	static ServiceForStockers service;
	
	public static void main(String[] args) {
		
		modelObj=new shareModel();
		service=new ServiceForStockers();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the no of companies");
		int numberOfCompanies=sc.nextInt();
		
		double stockPrice[]=new double[numberOfCompanies];
		boolean stockStateToday[]=new boolean[numberOfCompanies];
		
		for(int i=0;i<numberOfCompanies;i++){
		
			System.out.println("Enter current stock price of the company "+(i+1));
			double currentStockPrice=sc.nextDouble();
			stockPrice[i]=currentStockPrice;
			
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			boolean stockState=sc.nextBoolean();	
			stockStateToday[i]=stockState;
			
		}
		
		modelObj.setSharePrice(stockPrice);
		modelObj.setShareStatus(stockStateToday);
		
		int choice=0;
		
		do{
			System.out.println();
			System.out.println("-----------------------------------------------");
			
			System.out.println("Enter the operation that you want to perform"+"\n"+
			"1. Display the companies stock prices in ascending order"+"\n"+
			"2. Display the companies stock prices in descending order"+"\n"+
			"3. Display the total no of companies for which stock prices rose today"+"\n"+
			"4. Display the total no of companies for which stock prices declined today"+"\n"+
			"5. Search a specific stock price"+"\n"+
			"6. press 0 to exit");
			
			System.out.println("-----------------------------------------------");
			choice=sc.nextInt();
			
			switch(choice)
			{
			
			case 1:
				service.getStockPriceInOrder("Ascending",stockPrice);
				break;
			
			case 2:
				service.getStockPriceInOrder("Descending",stockPrice);
				break;
			
			case 3:
				service.stocksPriceRise(stockStateToday, numberOfCompanies);
				break;
			
			case 4:
				service.stockPriceDecline(stockStateToday, numberOfCompanies);
				break;
			
			case 5:
				System.out.println("enter the key value");
				double stockPriceToSearch=sc.nextDouble();
				service.isStockAvailable(stockPrice,stockPriceToSearch);
				break;
			
			default: 
				if(choice!=0)
					System.out.println("Please select valid option from below available options.");
			}
			
		}while(choice!=0);
		
		System.out.println("Exited Successfully");
		
		sc.close();
	}
}
