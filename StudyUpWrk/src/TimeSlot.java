
public class TimeSlot {
	private String day;
	private int startHour;
	private int endHour;
	
	public TimeSlot(String day,int startHour,int endHour) {
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
	}
	public String getDay() {return day;}
	public int getStartHour() {return startHour;}
	public int getEndHour() {return endHour;}
	
	@Override
	public String toString() {
		return day+" "+startHour+":00 - "+endHour+":00";
	}
	

}
