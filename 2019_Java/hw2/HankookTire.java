//package example07_10;
// Tire Ŭ������ �ڽ� Ŭ���� HankookTire
public class HankookTire extends Tire{
	//�ʵ�
	
	//������(�ڽİ�ü ������)
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);//�θ� ��ü �����ڸ� ȣ����. => �θ�ü���� �����Ѵ�.
	}
	
	//�޼ҵ� 
	@Override
	public boolean roll() { //�θ�ü�� �޼ҵ� roll()�� ��������.
		++accumulatedRotation;
		age=maxRotation-accumulatedRotation;
		if(accumulatedRotation<maxRotation) { //��ũ �ȳ�.
			System.out.println(location+"�� ��ġ�� �ѱ� Ÿ�̾��� ���� ����:"+age);
			return true;
		}
		else { // �ѱ� Ÿ�̾� ��ũ��.
			System.out.println("**** "+location+"�� ��ġ�� �ѱ�Ÿ�̾� ��ũ��. ****");		
			return false;
		}
	}
}
