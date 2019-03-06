import java.util.Scanner;

public class UI {
	public UI() {
		
	}
	
	public String promptCommand() {
		System.out.println("1)G 顯示成績\n2)R 顯示排名\n3)W 更新配分\n"
							+ "4)E 離開選單 (exit)");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		return choice;
	}
	
	public String promptID(){
		System.out.println("輸入ID或 Q (結束使用)");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		return choice;
	}
	
	public void showFinishMsg(){
		System.out.println("結束了");
	}
	
	public void showWelcomeMsg(){
		//System.out.println("Welcome "+s.getName());
	}

}
