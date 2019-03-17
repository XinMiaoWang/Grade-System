package grade_system;
import java.util.Scanner;

public class UI {
	Scanner scanner = new Scanner(System.in);
	String ID = "";
	
	GradeSystems aGradeSystem = new GradeSystems("data/gradeInput.txt");
	// 962001044, 凌宗廷, 87, 86 ,98 ,88 ,87
	// 962001051, 李威廷, 81, 98 ,84 ,90 ,93
	
	public UI(){
		
		while(this.promptID()){
			if(aGradeSystem.containID(ID)) {
				this.showWelcomeMsg(ID);
				
				while(this.promptCommand());
			}
		}
		
		this.showFinishMsg();
	}

	
	public boolean promptCommand() {
		System.out.println("1)G 顯示成績\n"
						 + "2)R 顯示排名\n"
						 + "3)W 更新配分\n"
						 + "4)E 離開選單 (exit)");
		
		return commandLine();
	}
	
	public boolean commandLine() {
		String cmd = scanner.next();
		
		switch(cmd) {
			case"E":
				return false;
			case"G":	
				aGradeSystem.showGrade(ID);
				return true;
			case"R":	
				aGradeSystem.showRank(ID);
				return true;
			case"W":
				aGradeSystem.updateWeights();
				return true;
			default :
				//throw new NoSuchCommandExceptions(ID) ;
				NoSuchCommandExceptions ce = new NoSuchCommandExceptions();
				ce.CommandExceptions(); // 指令錯誤
				return false;
		}
	}
	
	public boolean promptID(){
		System.out.println("輸入ID或 Q (結束使用)?");
		ID = scanner.next();
		
		if(ID.equals("Q")) // quit
			return false;
		else if( !aGradeSystem.containID(ID) ) {
			//throw new NoSuchIDExceptions(ID) ;
			NoSuchIDExceptions ie = new NoSuchIDExceptions();
			ie.IDExceptions();
			return false;
		}
		
		return true;
	}
	
	public void showFinishMsg(){
		System.out.println("結束了");
	}
	
	public void showWelcomeMsg(String ID){
		String name = aGradeSystem.database.get(ID).getName() ;
		System.out.println("Welcome " + name);
	}
}
