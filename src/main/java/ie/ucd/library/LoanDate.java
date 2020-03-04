package ie.ucd.library;

import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
}