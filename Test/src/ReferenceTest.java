
public class ReferenceTest
{
	static ClassTemp temp = null;
	public static void main(String[] args)
	{
		
		int i = 0;
		for(i = 0; i < 10; i++)
		{
			
		}
		System.out.println(i);
		A();		
		System.out.println(temp);
		System.out.println("----------------------------------------");
		
		A(temp);
		System.out.println(temp);
	}
	
	
	public static void A()
	{
		System.out.println("A()");
		temp = new ClassTemp(100000);
		System.out.println(temp);
	}
	
	public static void A(ClassTemp temp)
	{
		System.out.println("A(ClassTemp temp)");
		System.out.println(temp);
		temp = new ClassTemp(1111);
		System.out.println(temp);
	}

	
}

class ClassTemp
{
	private int value;
	
	public ClassTemp(int value)
	{
		this.value = value;
		// TODO Auto-generated constructor stub
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}
	
	
	
}