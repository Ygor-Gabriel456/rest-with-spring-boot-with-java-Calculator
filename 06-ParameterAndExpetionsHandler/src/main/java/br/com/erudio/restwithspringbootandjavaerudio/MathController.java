package br.com.erudio.restwithspringbootandjavaerudio;

import br.com.erudio.restwithspringbootandjavaerudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public double sum(@PathVariable(value = "numberOne")String numberOne,
                      @PathVariable(value = "numberTwo")String numberTwo) throws RuntimeException {

        {
            if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please, Ygor set a numeric value!");
            }
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
        }
    }

    @GetMapping(value = "/sub/{numberOne}/{numberTwo}")
    public double sub(@PathVariable(value = "numberOne")String numberOne,
                      @PathVariable(value = "numberTwo")String numberTwo) throws RuntimeException {
        {
            if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new RuntimeException("Por favor, Milena insira um valor numérico!");
            }
            return convertToDouble(numberOne) - convertToDouble(numberTwo);
        }
    }

    @GetMapping(value = "/mult/{numberOne}/{numberTwo}")
    public double mult(@PathVariable(value = "numberOne")String numberOne,
                       @PathVariable(value = "numberTwo")String numberTwo) throws RuntimeException{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new RuntimeException("Por favor, Ygor insira um valor num");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @GetMapping(value = "/div/{numberOne}/{numberTwo}")
    public double div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo")String numberTwo) throws RuntimeException{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new RuntimeException("Insert a numeric value, Ashole!");
        }
        return convertToDouble(numberOne) /  convertToDouble(numberTwo);
    }



    private Double convertToDouble(String strNumber) throws  RuntimeException {
            if (strNumber == null) return 10D;
            String number = strNumber.replaceAll(",", ".");
            if (isNumeric(number)) return Double.parseDouble(number);
            return 1D;
        }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null)  return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
