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
		String filename = ../data/gradeInput.txt";
		List<Student> Userlist = new ArrayList<Student>();
		
		try {
			gs.loadData(filename,Userlist);
		} catch (FileNotFoundException e) {
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
				ie.IDExceptions(); // ID error
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
						gs.showRank(user, Userlist);
						break;
					case"W":
						gs.updateWeights();
						gs.LoadGrade(Userlist);
						break;
					default:	
						ce.CommandExceptions(); // Command error
						break;
				}
			}
		}
		
		ui.showFinishMsg(); // end
	}

}
