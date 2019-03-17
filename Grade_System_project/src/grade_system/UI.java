package grade_system;
import java.util.Scanner;

public class UI {
	Scanner scanner = new Scanner(System.in);
	String ID = "";
	
	GradeSystems aGradeSystem = new GradeSystems("data/gradeInput.txt");
	// 962001044, ��v��, 87, 86 ,98 ,88 ,87
	// 962001051, ���§�, 81, 98 ,84 ,90 ,93
	
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
		System.out.println("1)G ��ܦ��Z\n"
						 + "2)R ��ܱƦW\n"
						 + "3)W ��s�t��\n"
						 + "4)E ���}��� (exit)");
		
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
				ce.CommandExceptions(); // ���O���~
				return false;
		}
	}
	
	public boolean promptID(){
		System.out.println("��JID�� Q (�����ϥ�)?");
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
		System.out.println("�����F");
	}
	
	public void showWelcomeMsg(String ID){
		String name = aGradeSystem.database.get(ID).getName() ;
		System.out.println("Welcome " + name);
	}
}
