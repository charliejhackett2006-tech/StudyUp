
public class Student {
	private String name;
	private String email;
	private String course;
	
	public Student(String name, String email, String course) {
		this.name= name;
		this.email= email;
		this.course=  course;
	}
	
	public String getName() {return name;}
	public String getEmail() {return email;}
	public String getCourse() {return course;}
	
	public String getProfileText() {
		return "Name: "+name+"\nEmail:"+email+"\nCourse:"+course;
	
	}
    @Override
    public String toString() {
    	return name+"("+email+")";
    }
    

}
