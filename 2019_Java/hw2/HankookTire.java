//package example07_10;
// Tire 클래스의 자식 클래스 HankookTire
public class HankookTire extends Tire{
	//필드
	
	//생성자(자식객체 생성자)
	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);//부모 객체 생성자를 호출함. => 부모객체부터 생성한다.
	}
	
	//메소드 
	@Override
	public boolean roll() { //부모객체의 메소드 roll()을 재정의함.
		++accumulatedRotation;
		age=maxRotation-accumulatedRotation;
		if(accumulatedRotation<maxRotation) { //펑크 안남.
			System.out.println(location+"에 위치한 한국 타이어의 현재 수명:"+age);
			return true;
		}
		else { // 한국 타이어 펑크남.
			System.out.println("**** "+location+"에 위치한 한국타이어 펑크남. ****");		
			return false;
		}
	}
}
