package br.com.mathUtilities;

public class Conversor {
	public static Double convertDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (!isNumeric(number))
			return 0D;
		return Double.parseDouble(number);
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		return strNumber.matches("[+-]?[0-9]*\\.?[0-9]+");
	}
}
