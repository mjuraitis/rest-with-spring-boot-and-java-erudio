package br.com.erudio.controller;

import br.com.erudio.customexception.UnsupportedMathOperationException;
import br.com.erudio.util.Util;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
      throws Exception {

        if (!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return Util.convertToDouble(numberOne) + Util.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {

        if (!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return Util.convertToDouble(numberOne) - Util.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {

        if (!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return Util.convertToDouble(numberOne) * Util.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {

        if (!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        if (Util.isNumeric(numberTwo) && Util.convertToDouble(numberTwo) == 0D) {
            throw new UnsupportedMathOperationException("Cannot divide by 0 (zero).");
        }

        return Util.convertToDouble(numberOne) / Util.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {

        if (!Util.isNumeric(numberOne) || !Util.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return (Util.convertToDouble(numberOne) + Util.convertToDouble(numberTwo)) / 2D;
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "number") String number)
            throws Exception {

        if (!Util.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return Math.sqrt(Util.convertToDouble(number));
    }
}
