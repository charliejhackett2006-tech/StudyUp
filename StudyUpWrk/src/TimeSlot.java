
public class TimeSlot {
	private String day;
	private int startHour;
	private int endHour;
	
	public TimeSlot(String day,int startHour,int endHour) {
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
	
	}
	public boolean overlaps(TimeSlot other) {
		return day.equalsIgnoreCase(other.day) && startHour < other.endHour && other.startHour < endHour;
	}
	public String getDay() {return day;}
	public int getStartHour() {return startHour;}
	public int getEndHour() {return endHour;}
	
	@Override
	public String toString() {
		return day+" "+startHour+":00 - "+endHour+":00";
	}
	

}
