/**
 * The Class Time.
 */
public class Time {
	
	/** The hour. */
	private int hour;
	
	/** The minute. */
	private int minute;
	
	/** The second. */
	private int second;
	
	/**
	 * Instantiates a new time object to zero values.
	 */
	public Time() {
		hour =0;
		minute =0;
		second =0;
	}
	
	/**
	 * Instantiates a new time using totalseconds.
	 *
	 * @param totalSeconds the total seconds
	 */
	public Time(int totalSeconds) {
		convertToTime(totalSeconds);
		
	}
	
	/**
	 * Convert to time.
	 *
	 * @param totalSeconds Converter to convert total seconds to Hr: Min: Sec format
	 */
	public void convertToTime(int totalSeconds) {
		
		hour = totalSeconds / 3600;
		minute = ((totalSeconds % 3600) / 60);
		second = ((totalSeconds % 3600) % 60);
	}
	
	/**
	 * Increments the time by a value in seconds.
	 *
	 * @param dt the dt
	 */
	public void increment(int dt) {
		int sec = dt + second;
		second = sec % 60;
		int min = (sec/60) + minute;
		minute = min % 60;
		hour = (min/60) + hour;
	}
	
	/**
	 * Total hours.
	 *
	 * @return the double
	 */
	public double totalHours() {
		double totalHours = hour + (minute/60.0) + (second/3600.0);
		return totalHours;
	}
	
// Getter & Setter Methods
	
	/**
 * Gets the hour.
 *
 * @return the hour
 */
public int getHour() {
		return hour;
	}
	
	/**
	 * Sets the hour.
	 *
	 * @param hour the new hour
	 */
	public void setHour(int hour) {
		if (hour >= 0)
			this.hour = hour;
		else {
			System.out.println("ERROR! Unacceptable value entered!");
			System.exit(0);
		}
	}
	
	/**
	 * Gets the minute.
	 *
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * Sets the minute.
	 *
	 * @param minute the new minute
	 */
	public void setMinute(int minute) {
		if (minute >= 0 && minute < 60)
			this.minute = minute;
		else {
			System.out.println("ERROR! Unacceptable value entered!");
			System.exit(0);
		}
	}
	
	/**
	 * Gets the second.
	 *
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}
	
	/**
	 * Sets the second.
	 *
	 * @param second the new second
	 */
	public void setSecond(int second) {
		if (second >= 0 && second < 60)
			this.second = second;
		else {
			System.out.println("ERROR! Unacceptable value entered!");
			System.exit(0);
		}
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String time = String.format("%d:%d:%d", this.hour, this.minute, this.second);
		return time;
	}
}
