//package example07_10;
// Tire Ŭ������ �ڽ� Ŭ����: ��ȣŸ�̾�
public class KumhoTire extends Tire{
	// �ʵ�
	// ������(�ڽİ�ü�� ������)
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation); //�θ�ü �����ڸ� ȣ���Ͽ�, �θ�ü�� ���� ����.
		//�θ�ü ������ ��ġ��, �ڽİ�ü�� �����ȴ�.
	}
	
	//�޼ҵ�
	//�θ� Tire�κ��� �������� �޼ҵ� roll()�� �������̵�(������)
	@Override
	public boolean roll() {
		++accumulatedRotation;
		age=maxRotation-accumulatedRotation;
		if(accumulatedRotation<maxRotation) {// ��ũ �ȳ�.
			System.out.println(location+"�� ��ġ�� ��ȣŸ�̾��� ���� ����: "+age);
			return true;
		}
		else {// accumulatedRotation>=maxRotation : ��ũ��.
			System.out.println("**** "+location+"�� ��ġ�� ��ȣŸ�̾� ��ũ��. ****");
			return false;
		}
	}
}
