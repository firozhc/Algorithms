public class LeastRecentPage {

public static int lruCountMiss( int max_cache_size, int[] pages)
{
	int miss_count=0;
	
	int[] cache = new int[max_cache_size];
	
	for(int i=0; i<pages.length; i++)
	{
		if(isFound(pages[i],cache)) //has to rotate but increment count only on miss
		   add_cache(pages[i],cache);
		else
			{
			add_cache(pages[i],cache);
			miss_count++;
			}
		
	}
	
	return  miss_count;
}


private static boolean isFound(int a, int[] arr)
{
	for(int i=0; i<arr.length; i++)
	{
		if(arr[i]==a)
			return true;
	}
	
	return false;
	
}



 private static void add_cache(int a, int [] cache)
 {
	
	 //rotate existing cache and add element at end
	 int i=0;
	 
	 for(; i<cache.length-1;i++)
	 {
		 cache[i]=cache[i+1];
	 }
	 
	 cache[i]=a;
	 
}
 
 public static void main(String args[])
 {
	 int sex[] = {2,3,1,3,2,1,4,3,2};
	// int sex[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0};
	 int size=2 ;
	 System.out.println(lruCountMiss(size,sex)); 
 }
 


	
}
