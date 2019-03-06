import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		NoSuchIDExceptions ie = new NoSuchIDExceptions();
		NoSuchCommandExceptions ce = new NoSuchCommandExceptions();
		GradeSystems gs = new GradeSystems();
		UI ui = new UI();
		
		//	student information
		String filename = "D:/eclipse-workspace/grade_system/src/gradeInput.txt";
		List<Student> Userlist = new ArrayList<Student>();
		//Userlist.add(new Student("962001044", "­â©v§Ê", 87, 86 ,98 ,88 ,87));
		//Userlist.add(new Student("962001051", "§õ«Â§Ê", 81, 98 ,84 ,90 ,93));
		
		try {
			gs.loadData(filename,Userlist);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gs.LoadGrade(Userlist); // initialize students' score
		
	
		// start
		while(true){
			boolean pass = false;
			
			String user = ui.promptID(); // input id
			if(user.equals("Q")) // quit
				break;
			
			pass = gs.containID(user, Userlist); // check student exist or not
			if(pass==false) {
				ie.IDExceptions(); // ID¿ù»~
				continue;
			}
			
			while(true) {
				String choice = ui.promptCommand();
				if(choice.equals("E")) // exit
					break;
				
				switch(choice) {
					case"G":	
						gs.showGrade(user, Userlist);
						break;
					case"R":	
						//System.out.println("aGradeSystem showRank(ID)");
						gs.showRank(user, Userlist);
						break;
					case"W":
						gs.updateWeights();
						gs.LoadGrade(Userlist);
						break;
					default:	
						ce.CommandExceptions(); // «ü¥O¿ù»~
						break;
				}
			}
		}
		
		ui.showFinishMsg();	// end
	}

}
