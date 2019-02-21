package my.hackerrank;

/**
 * Given a time in 12 -hour AM/PM format, convert it to military (24-hour) time.
 * 
 * Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour
 * clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour
 * clock.
 */

public class MilitaryTime {

	static String timeConversion(String s) {
		String[] timeArr = s.split(":");
		String secStr = timeArr[2];
		timeArr[2] = secStr.substring(0, 2);
		String meridiumStr = secStr.substring(2, timeArr.length + 1);
		System.out.println(meridiumStr);
		// String militaryTime = timeArr[0] + ":" + timeArr[1] + ":" +
		// timeArr[2];
		if ("PM".equals(meridiumStr)) {
			if (!"12".equals(timeArr[0])) {
				Integer milHour = Integer.valueOf(timeArr[0]) + 12;
				timeArr[0] = milHour.toString();
			}
		} else if ("AM".equals(meridiumStr)) {
			if ("12".equals(timeArr[0])) {
				timeArr[0] = "00";
			}
		}
		return timeArr[0] + ":" + timeArr[1] + ":" + timeArr[2];
	}

	public static void main(String[] args) {
		System.out.println(timeConversion("12:15:10PM"));
	}

}
