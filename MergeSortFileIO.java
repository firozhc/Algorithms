import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.Date;


public class MergeSortFileIO {
	
	public static void main(String args[]) throws IOException
	{
		int [] arr= {25,3,12,0,-2,56,35,49,16,14,1};
		int [] a= {5,1,2,-2,4,4,23,12,34,3};
	
		//Readarraysort();
	
	
	
	
		System.out.printf("now: %s%n", LocalDateTime.now());
	
		
		String input = "Nov 3 1988";
		try {
		    DateTimeFormatter formatter =
		                      DateTimeFormatter.ofPattern("MMM d yyyy");
		    LocalDate date = LocalDate.parse(input, formatter);
		    System.out.printf("%s%n", date);
		}
		catch (DateTimeParseException exc) {
		    System.out.printf("%s is not parsable!%n", input);
		    throw exc;      // Rethrow the exception.
		}
		// 'date' has been successfully parsed
	
	
		String dateStart = "11/03/2014 09:29:58";
		String dateStop = "11/05/2014 10:33:43";

		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  

		Date d1 = null;
		Date d2 = null;
		try {
		    d1 = format.parse(dateStart);
		    d2 = format.parse(dateStop);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    

		
		
		System.out.println(d1.getTime());
		System.out.println(d2);
		// Get msec from each, and subtract.
		long diff = d2.getTime() - d1.getTime();
		long diffSeconds = (diff / 1000)%60;         
		long diffMinutes = (diff / (60 * 1000))%60;         
		long diffHours = (diff / (60 * 60 * 1000))%24;  
		long diffDays= (diff / (60 * 60 * 1000))/24; 
		
		
		System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
		System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
		System.out.println("Time in hours: " + diffHours + " hours."); 
        
		System.out.println("Time in days: " + diffDays + " days.");
	
	
	}
	
	
	static void Readarraysort() throws IOException
	{
	long startTime=System.currentTimeMillis();
		
		StringBuffer str = new StringBuffer();
		
		
		Reader input= new FileReader("c:\\Users\\Firoz\\Desktop\\input.txt");
				
		BufferedReader buff=new BufferedReader(input);
		
		String s="";
		
		s=buff.readLine();
		 
		String se="";
		
		Writer w= new FileWriter("c:\\Users\\Firoz\\Desktop\\output.txt",true);
		
		BufferedWriter b = new BufferedWriter(w);
		
		int j=0;
		
		
		int [] array;
		
		while(s!=null)	
		
		{
			se="";
			array = new int [word_count(s)];
			j=0;
			
			for(int i=0; i<s.length();i++)
			{
				while(i< s.length() && s.charAt(i)!=',')
				{
					se=se+s.charAt(i);
					i++;
				}
				
				if((i<s.length() && (s.charAt(i)==',')|| i==s.length()))
					{array[j]=Integer.parseInt(se);
				se="";
				j++; }
				
			}
			

			Mergesort(array);
			
			String c="";
			
			for(int i:array)
				{
				c= c+ Integer.toString(i);
				
				if(i!=array[array.length-1])
					c+=",";
				}
			b.write(c);
			b.flush();
			b.newLine();	
			
			
			
			s=buff.readLine();
		
		}
			
	
			
	long endTime=System.currentTimeMillis();
	
	System.out.println(startTime-endTime);
	}
	
	
	
	static int word_count(String S)
	{
		int count=0;
		
		for(int i=0;i<S.length();i++)
			if(S.charAt(i)==',')
				count++;
		return ++count;
				
	}
	
	
	
	
	public static void merge(int []a, int[] left, int [] right)
	{
		int i=0,j=0,k=0;
		
		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
				{a[k]=left[i];
				k++; i++;
				}
			else
			{
				a[k]=right[j];
				k++; j++;
			}
		}
		
		while(i<left.length)
		{
			a[k]=left[i];
			k++;i++;
		}
		
		while(j<right.length)
		{
			a[k]=right[j];
			k++;j++;
		}
		
	}
	
	public static int [] Mergesort(int [] a)
	{
		if(a.length<2)
			return a ;
		
		int len =a.length;
		
		int llen=len/2;
		
		int rlen=len-llen;
		
		
		int [] left= new int[llen];
		int [] right= new int[rlen];
		
		 
		for(int i=0, j=0 ; i<len; i++)
			{ 
			if(i<llen)
				left[i]=a[i];  // fill left array
			
			else
				{right[j]=a[i];
					j++;
				}
			}
		
		Mergesort(left);
		Mergesort(right);
		merge(a,left,right);
		
		return a;
		
		
	}
	
	
	

}
