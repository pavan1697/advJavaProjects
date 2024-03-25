package com.pavan.servlets;

public class Operations 
{
	StringBuffer sb=new StringBuffer();
	 StringBuffer even(int StartNum,int EndNum)
	{
		for(int i=StartNum;i<=EndNum;i++)
			if(i%2==0)
			{
				sb.append(i+" ");
			}
		return sb;
	}
	
	StringBuffer Odd(int StartNum,int EndNum)
	{
		for(int i=StartNum;i<=EndNum;i++)
			if(i%2!=0)
			{
				sb.append(i+" ");
			}
		return sb;
	}
	
	StringBuffer prime(int StartNum,int EndNum)
	{
		for(int i=StartNum;i<=EndNum;i++)
		{
			int j=2;
			boolean flag=false;
			while(j<=i/2)
			{
				if(i%j==0)
				{
					flag=true;
					break;
				}
				j++;
			}
			if(!flag)
				sb.append(i+" ");
		}
		return sb;
	}
	
	StringBuffer perfect(int StartNum,int EndNum)
	{
		for(int i=StartNum;i<=EndNum;i++)
		{	int sum=0;
			for(int j=1;j<i;j++)
			{
				if(i%j==0)
				sum+=j;	
			}
			if(sum==i)
				sb.append(i+" ");
		}
		return sb;
	}
	
	StringBuffer strong(int StartNum,int EndNum)
	{
		for(int i=StartNum;i<=EndNum;i++)
		{
			int j=i,sum=0;
			while (j > 0) 
			{
	            int rem = j % 10;
	            int factorial = 1;
	            for (int k = rem; k >= 1; k--)
	            {
	                factorial *= k;
	            }
	            sum += factorial;
	            j /= 10;
	        }
	        
	        if (sum == i)
	        	sb.append(i+" ");
		}
		return sb;
	}
	
	StringBuffer armstrong(int StartNum,int EndNum)
	{
		for(int i=StartNum;i<=EndNum;i++)
		{	int count=0;
			int j=i;
			while(j>0)
			{
				count++;
				j/=10;
			}
			int k=i,y=count,sum=0;
			while(k>0)
			{
				int rem=k%10;
				int prod=(int)Math.pow(rem, y);
				sum=sum+prod;
				k=k/10;
			}
			if(sum==i)
				sb.append(i+" ");
		}
		return sb;
	}
}
