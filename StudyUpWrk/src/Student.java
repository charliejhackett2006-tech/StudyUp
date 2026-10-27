import java.util.ArrayList;

public class Student {
	private String name;
	private String email;
	private String course;
	
	private ArrayList<String> modules = new ArrayList<>();
	private ArrayList<TimeSlot> availability = new ArrayList<>();
	
	public Student(String name, String email, String course) {
		this.name= name;
		this.email= email;
		this.course=  course;
		

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
	public void addSlot(TimeSlot slot) {
		availability.add(slot);
	}
	
	public String getProfileText() {
		String response = "Name: "+name+"\nEmail:"+email+"\nCourse:"+course+"\nModules: "+modules+"\nAvailability:";
		
		for (TimeSlot slot: availability) {
			response +="\n "+slot;
		}
		return response;
	}
	
    @Override
    public String toString() {
    	return name+"("+email+")";
    }
    

}
