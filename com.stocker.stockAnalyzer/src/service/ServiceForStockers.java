package service;

import java.util.List;

import utilities.searchOperation;
import utilities.sort;

public class ServiceForStockers {

	
	public void getStockPriceInOrder(String sortOrder, double[] stockPrice) {
		// TODO Auto-generated method stub
		int stockPriceArraySize=stockPrice.length;
		sort.sortArray(stockPrice, 0, stockPriceArraySize-1);
		
		if(sortOrder.equalsIgnoreCase("Ascending"))
		{
			System.out.println("Stock prices in ascending order are :");
			for(int i=0;i<stockPriceArraySize;i++)
				System.out.print(stockPrice[i]+" ");
		}
		else
		{
			System.out.println("Stock prices in descending order are :");
			for(int i=stockPriceArraySize-1;i>-1;i--)
				System.out.print(stockPrice[i]+" ");
			
		}
		
		System.out.println();
	}

	public void stocksPriceRise(boolean stockStateToday[],int stockStateSize) {
		// TODO Auto-generated method stub
		
		int count=0;
		for(int i=0;i<stockStateSize;i++)
		{
			if(stockStateToday[i]==true)
				count++;
		}
		System.out.println("Total no of companies whose stock price rose today : "+count);
	}

	public void stockPriceDecline(boolean stockStateToday[],int stockStateSize) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0;i<stockStateSize;i++)
		{
			if(stockStateToday[i]==false)
				count++;
		}
		System.out.println("Total no of companies whose stock price declined today : "+count);
		
	}

	public void isStockAvailable(double[] stockPrice, double stockPriceToSearch) {
		
		
		// TODO Auto-generated method stub
		getStockPriceInOrder("Ascending", stockPrice);
		if(searchOperation.isAvailable(stockPrice,stockPriceToSearch))
			System.out.println("Stock of value "+stockPriceToSearch+" is present");
		else
			System.out.println("Value not found");
	}

	
}
