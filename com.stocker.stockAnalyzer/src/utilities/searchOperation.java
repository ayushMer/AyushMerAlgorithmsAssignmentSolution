package utilities;

public class searchOperation {

	public static boolean isAvailable(double[] stockPrice,
			double stockPriceToSearch) {
		// TODO Auto-generated method stub
		
		int l=0;
		int r=stockPrice.length-1;
		
		while(l<=r)
		{
		
	    int mid=l+(r-l)/2;
				
		if(stockPrice[mid]==stockPriceToSearch)
			return true;
		
		if(stockPrice[mid]>stockPriceToSearch)
			r=mid-1;
		else
			l=mid+1;
		}	
		
		return false;
	}

}
