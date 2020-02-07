/**
 * The Class ClockDemo.
 */
public class ClockDemo {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Create elapsed time with the default values of zeros for day, hour,
		// minute and second.
		Clock t1 = new Clock(); // Default constructor
		// sets hour to 23
		t1.setHour(23);
		// sets day to 1
		t1.setDay(1);
		// sets minute to 59
		t1.setMinute(59);
		// sets day to 16
		t1.setSecond(16);
		// prints: 1:23:59:16
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" + t1.getMinute() + ":" + t1.getSecond());
		// increments time t1 by 44 seconds:
		t1.increment(44);
		// prints: 2:0:0:0
		System.out.println(t1.getDay() + ":" + t1.getHour() +":" +t1.getMinute() + ":" + t1.getSecond());
		// prints the total elapsed time in seconds: 172,800
		System.out.printf("The elapsed time in seconds is: %d %n", t1.calculateTotalSeconds());
		// REPEAT SIMILAR TESTS FOR t2
		//Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
		Clock t2 = new Clock(3, 1, 4, 5);
		System.out.println(t2.getDay() + ":" + t2.getHour() +":" + t2.getMinute() + ":" + t2.getSecond());
		}

}
