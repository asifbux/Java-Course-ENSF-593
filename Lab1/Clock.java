/**
 * The Class Clock.
 */
public class Clock {
	
	/** The day. */
	private int day;
	
	/** The hour. */
	private int hour;
	
	/** The minute. */
	private int minute;
	
	/** The second. */
	private int second;
	
/**
 * This is a default constructor.
 */
public Clock() {
	
	this(0,0,0,0);
	
}

/**
 * This constructor instantiates a new clock by calling the methods.
 *
 * @param day the day
 * @param hour the hour
 * @param minute the minute
 * @param second the second
 */
public Clock(int day, int hour, int minute, int second) {
	this.setDay(day);
	this.setHour(hour);
	this.setMinute(minute);
	this.setSecond(second);
	
}

/**
 * Gets the day.
 *
 * @return the day
 */
public int getDay() {
	return day;
}

/**
 * Gets the hour.
 *
 * @return the hour
 */
public int getHour() {
	return hour;
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
 * Gets the second.
 *
 * @return the second
 */
public int getSecond() {
	return second;
}

/**
 * Sets the day.
 *
 * @param day the new day
 */
public void setDay(int day) {
	if ( day >= 0)
		this.day = day;
	else {
		System.out.println("ERROR! Unacceptable value entered!");
		System.exit(0);
	}
}

/**
 * Sets the hour.
 *
 * @param hour the new hour
 */
public void setHour(int hour) {
	if (hour >= 0 && hour < 24)
		this.hour = hour;
	else {
		System.out.println("ERROR! Unacceptable value entered!");
		System.exit(0);
	}
}

/**
 * Sets the minute.
 *
 * @param minute the new minute
 */
public void setMinute(int minute) {
	if (minute >= 0 && minute <60)
		this.minute = minute;
	else {
		System.out.println("ERROR! Unacceptable value entered!");
		System.exit(0);
	}
}

/**
 * Sets the second.
 *
 * @param second the new second
 */
public void setSecond(int second) {
	if (second >= 0 && second <60)
		this.second = second;
	else {
		System.out.println("ERROR! Unacceptable value entered!");
		System.exit(0);
	}
}

/**
 * Increments the object by value of input second
 *
 * @param value the value in second 
 */
public void increment(int value) {
	int sec = value + second;
	second = sec % 60;
	int min = (sec/60) + minute;
	minute = min % 60;
	int hr = (min/60) + hour;
	hour = hr % 24;
	day = (hr/24) + day;
}

/**
 * Converts the time into total seconds.
 *
 * @return the int
 */
public int calculateTotalSeconds() {
	int totalSeconds = ((((day * 24) + hour) * 60) + minute) * 60 + second;
	return totalSeconds;
}
}
