import java.util.Scanner;

public class UI {
	public UI() {
		
	}
	
	public String promptCommand() {
		System.out.println("1)G ��ܦ��Z\n2)R ��ܱƦW\n3)W ��s�t��\n"
							+ "4)E ���}��� (exit)");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		return choice;
	}
	
	public String promptID(){
		System.out.println("��JID�� Q (�����ϥ�)");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		return choice;
	}
	
	public void showFinishMsg(){
		System.out.println("�����F");
	}
	
	public void showWelcomeMsg(){
		//System.out.println("Welcome "+s.getName());
	}

}
