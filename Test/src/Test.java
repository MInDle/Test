//import java.math.BigInteger;
//import java.util.Calendar;
//
//public class Test
//{
//	public static void main(String[] args)
//	{
//		final int GAP = 4;
//		final int MAX = 20;
//		int[][] array = {
//				{8, 02, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52, 12, 50, 77, 91, 8},
//				{49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 04, 56, 62, 00},
//				{81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 03, 49, 13, 36, 65},
//				{52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56, 71, 37, 02, 36, 91},
//				{22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
//				{24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
//				{32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
//				{67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
//				{24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
//				{21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95},
//				{78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16, 14, 9, 53, 56, 92},
//				{16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57},
//				{86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
//				{19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 04, 89, 55, 40},
//				{04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
//				{88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
//				{04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
//				{20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 04, 36, 16},
//				{20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 05, 54},
//				{01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 01, 89, 19, 67, 48}
//		};
//		
//		int max = 0;
//		
//		for(int i = 0; i <= (MAX - GAP) + 1; i++)
//		{
//			int mulVer = 1;
//			int mulHor = 1;
//			int mul = 1;
//			int count = 0;
//			for(int j = 0; j <= (MAX - GAP) + 1; j++)
//			{
//				if(count < GAP)
//				{
//					count++;
//					mulVer *= array[i][j];
//					mulHor *= array[j][i];
//					mul *= 
//				}
//				
//			}
//			
//		}
//		
//	}
//}

public class Test
{
//	public static void main(String[] args)
//	{
//		MedicalMachine M1 = new MedicalMachine();
//		System.out.println("M1: " + M1.type + ", " + M1.riskRating + ", " + M1.name);
//
//		MedicalMachine M2 = new MedicalMachine("의료용 진동기");
//		System.out.println("M2: " + M2.type + ", " + M2.riskRating + ", " + M2.name);
//
//		MedicalMachine M3 = new MedicalMachine("4", "제세동기");
//		System.out.println("M3: " + M3.type + ", " + M3.riskRating + ", " + M3.name);
//
//		MedicalMachine M5 = new MedicalMachine(M1);
//		M1.type = "define";
//		M1.riskRating = "define";
//		M1.name = "define";
//		System.out.println("M5: " + M5.type + ", " + M5.riskRating + ", " + M5.name);
//		System.out.println("M1: " + M1.type + ", " + M1.riskRating + ", " + M1.name + "★1");
//
//		MedicalMachine M4 = M1;
//		M4.name = "일회용 봉합침";
//		System.out.println("M4: " + M4.type + ", " + M4.riskRating + ", " + M4.name);
//		System.out.println("M1: " + M1.type + ", " + M1.riskRating + ", " + M1.name + "★2");
//		
//		System.out.println(M4.hashCode());
//		System.out.println(M1.hashCode());
//		System.out.println(M5.hashCode());
//	}
	public static void main(String[] args)
	{
		
	}
	
	public static void a()
	{
		
	}
}

class MedicalMachine
{
	String type;
	String riskRating;
	String name;

	public MedicalMachine()
	{
		this("수동", "2등급", "온열침대");
	}

	public MedicalMachine(String name)
	{
		this("수동", "2등급", name);
	}

	public MedicalMachine(String riskRating, String name)
	{
		this("수동", riskRating, name);
	}

	public MedicalMachine(String type, String riskRating, String name)
	{

		this.type = type;
		this.riskRating = riskRating;
		this.name = name;
	}

	public MedicalMachine(MedicalMachine mm)
	{
		this.type = mm.type;
		this.riskRating = mm.riskRating;
		this.name = mm.name;
	}
}
