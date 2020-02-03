
public class DiscreteDistribution {
	public static void main(String[] args)
	{
		int m = Integer.parseInt(args[0]);
		int [] a = new int[args.length];
		
		for (int i = 1; i < a.length; i++)
		{
			a[i] = Integer.parseInt(args[i]);
		}
			
		int [] s = new int[a.length];
		
		int r = 0;
		s[0] = 0;
		
		
		for (int i = 1; i < a.length; i++)
		{
			s[i] = s[i - 1] + a[i];
		}
				 
		
		for (int i = 0; i < m; i++)
		{
			r = (int) (Math.random() * s[(a.length - 1)]);
			
			for (int j = 1; j < a.length; j++)
			{
				if( s[ j - 1 ] <= r && r < s[ j ])
				{
					int interval = j;
					System.out.print(interval + " ");
				}
			}
			
		}
		
		
	}
}
