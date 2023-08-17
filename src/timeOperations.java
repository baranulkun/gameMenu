import java.time.LocalDateTime;

public class timeOperations {
	//present time
	public String now() {
		LocalDateTime now = LocalDateTime.now();
		return now.getYear() + "." + now.getMonthValue() + "." + now.getDayOfMonth() + "." + now.getHour() + "."
				+ now.getMinute() + "." + now.getSecond();
	}
	
}
