//package example07_10;
// Tire 클래스의 자식 클래스: 금호타이어
public class KumhoTire extends Tire{
	// 필드
	// 생성자(자식객체의 생성자)
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation); //부모객체 생성자를 호출하여, 부모객체를 먼저 생성.
		//부모객체 생성을 마치면, 자식객체가 생성된다.
	}
	
	//메소드
	//부모 Tire로부터 물려받은 메소드 roll()을 오버라이딩(재정의)
	@Override
	public boolean roll() {
		++accumulatedRotation;
		age=maxRotation-accumulatedRotation;
		if(accumulatedRotation<maxRotation) {// 펑크 안남.
			System.out.println(location+"에 위치한 금호타이어의 현재 수명: "+age);
			return true;
		}
		else {// accumulatedRotation>=maxRotation : 펑크남.
			System.out.println("**** "+location+"에 위치한 금호타이어 펑크남. ****");
			return false;
		}
	}
}
