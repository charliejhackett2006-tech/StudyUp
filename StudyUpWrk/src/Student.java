import java.util.ArrayList;

public class Student {
	private String name;
	private String email;
	private String course;
	
	public Student(String name, String email, String course) {
		this.name= name;
		this.email= email;
		this.course=  course;
		
		private ArrayList<String> modules = new ArrayList<>();
	}
	
	public String getName() {return name;}
	public String getEmail() {return email;}
	public String getCourse() {return course;}
	
	public ArrayList<String> getModules() { return modules; }

	public void addModule(String module) {
	    modules.add(module);
	}

	public boolean removeModule(String module) {
	    return modules.remove(module);
	}
	
	public String getProfileText() {
		return "Name: "+name+"\nEmail:"+email+"\nCourse:"+course;
	
	}
    @Override
    public String toString() {
    	return name+"("+email+")";
    }
    

}
