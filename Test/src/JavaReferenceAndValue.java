
public class JavaReferenceAndValue
{
	public static void main(String[] args)
	{
		MedicalMachine M1 = new MedicalMachine();
		System.out.println("M1: " + M1.type + ", " + M1.riskRating + ", " + M1.name);

		MedicalMachine M2 = new MedicalMachine("�Ƿ�� ������");
		System.out.println("M2: " + M2.type + ", " + M2.riskRating + ", " + M2.name);

		MedicalMachine M3 = new MedicalMachine("4", "��������");
		System.out.println("M3: " + M3.type + ", " + M3.riskRating + ", " + M3.name);

		MedicalMachine M5 = new MedicalMachine(M1);
		M1.type = "define";
		M1.riskRating = "define";
		M1.name = "define";
		System.out.println("M5: " + M5.type + ", " + M5.riskRating + ", " + M5.name);
		System.out.println("M1: " + M1.type + ", " + M1.riskRating + ", " + M1.name + "��1");

		MedicalMachine M4 = M1;
		M4.name = "��ȸ�� ����ħ";
		System.out.println("M4: " + M4.type + ", " + M4.riskRating + ", " + M4.name);
		System.out.println("M1: " + M1.type + ", " + M1.riskRating + ", " + M1.name + "��2");

		System.out.println(M4.hashCode());
		System.out.println(M1.hashCode());
		System.out.println(M5.hashCode());
	}
	
	

}

class MedicalMachine
{
	String type;
	String riskRating;
	String name;

	public MedicalMachine()
	{
		this("����", "2���", "�¿�ħ��");
	}

	public MedicalMachine(String name)
	{
		this("����", "2���", name);
	}

	public MedicalMachine(String riskRating, String name)
	{
		this("����", riskRating, name);
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


