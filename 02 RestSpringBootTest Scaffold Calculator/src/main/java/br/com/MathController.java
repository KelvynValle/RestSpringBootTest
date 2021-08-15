package br.com;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.exception.UnsuportedOperationException;
import br.com.mathUtilities.*;

@RestController
public class MathController {
	// operations
	// sum
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!Conversor.isNumeric(numberOne) || !Conversor.isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("One or more parameters are invalid.");
		}
		Double Sum = Conversor.convertDouble(numberOne) + Conversor.convertDouble(numberTwo);
		return Sum;
	}

	// minus
	@RequestMapping(value = "/minus/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double minus(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!Conversor.isNumeric(numberOne) || !Conversor.isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("One or more parameters are invalid.");
		}
		Double Minus = Conversor.convertDouble(numberOne) - Conversor.convertDouble(numberTwo);
		return Minus;
	}

	// multiplication
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!Conversor.isNumeric(numberOne) || !Conversor.isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("One or more parameters are invalid.");
		}
		Double Multiplication = Conversor.convertDouble(numberOne) * Conversor.convertDouble(numberTwo);
		return Multiplication;
	}

	// division
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!Conversor.isNumeric(numberOne) || !Conversor.isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("One or more parameters are invalid.");
		}
		Double Division = Conversor.convertDouble(numberOne) / Conversor.convertDouble(numberTwo);
		return Division;
	}

	// sqrt
	@RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
		if (!Conversor.isNumeric(numberOne)) {
			throw new UnsuportedOperationException("One or more parameters are invalid.");
		}
		Double Sqrt = Math.sqrt(Conversor.convertDouble(numberOne));
		return Sqrt;
	}

	// average
	@RequestMapping(value = "/average/{numberArray}", method = RequestMethod.GET)
	public Double average(@PathVariable("numberArray") String numberArray) throws Exception {
		String[] splited = numberArray.split("&");
		Double number = 0.0;
		for (int i = 0; i < splited.length; i++) {
			if (!Conversor.isNumeric(splited[i])) {
				throw new UnsuportedOperationException("One or more parameters are invalid.");
			} else {
				number += Conversor.convertDouble(splited[i]);
			}
		}
		return number / splited.length;
	}

}
