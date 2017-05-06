import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;

public class Testando {

	public static void main(String[] args) throws ParseException {
		Double d = parseDecimal("3900,0");
		System.out.println(d);
	}

	public static double parseDecimal(String input) throws ParseException {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		ParsePosition parsePosition = new ParsePosition(0);
		Number number = numberFormat.parse(input, parsePosition);

		if (parsePosition.getIndex() != input.length()) {
			throw new ParseException("Invalid input", parsePosition.getIndex());
		}

		return number.doubleValue();
	}
	
}
