package ie.ucd.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class LoanDate {
	public String getLoanDate() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime today = LocalDateTime.now();
		return dateFormat.format(today);
	}

	public String getReturnDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = calendar.getTime();
		return dateFormat.format(date);
	}

    public static String getDate(String date, int numOfDays) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currDate);
        calendar.add(Calendar.DAY_OF_YEAR, numOfDays);
        Date newDate = calendar.getTime();
        return dateFormat.format(newDate);
    }
}