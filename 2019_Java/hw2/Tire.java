//package example07_10;

// ��ȣŸ�̾�, �ѱ�Ÿ�̾��� �θ� ��ü
public class Tire {
	//�ʵ�
	public int maxRotation;			//Ÿ�̾� �ִ� ȸ���� 0���� �ʱ�ȭ
	public int accumulatedRotation; //Ÿ�̾� ���� ȸ���� 0���� �ʱ�ȭ
	public String location; 		//Ÿ�̾� ��ġ
	public int age; //Ÿ�̾��� ����
	
	//������: �ܺο���  location�� maxRotation���� �޾Ƽ� ��ü ����
	public Tire(String location, int maxRotation) 
	{
		this.location = location;
		this.maxRotation=maxRotation;
		//��ü ������..->Ÿ�̾� ���� : �ִ�ȸ������ �ʱ�ȭ.
		this.age=maxRotation; 
	}
	
	// Tire�� �޼ҵ�
	public boolean roll() {
		++accumulatedRotation;
		age=maxRotation-accumulatedRotation;
		if (accumulatedRotation<maxRotation) {
			System.out.println(location+" Ÿ�̾��� ����: "+age);
			return true;
		}
		else {// accumulatedRotation>=maxRotation :��ũ��.
			System.out.println("****"+location +"Ÿ�̾� ��ũ ��  ****");
			return false;
		}
	}
}
