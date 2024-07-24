package af.cmr.indyli.akdemia.business.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This utility class provides methods for working with dates.
 */
public final class DateUtils {

	/**
	 * Calculates the difference in days between two dates.
	 * 
	 * @param date1 The first date
	 * @param date2 The second date
	 * @return The difference in days between the two dates
	 */
	public static long calculateDateDifferenceInDays(Date date1, Date date2) {
		long diffInMillis = Math.abs(date2.getTime() - date1.getTime());
		return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
	}
}
