package validation;

public class MyValidatorNumber implements MyValidator {

    private double inputDouble;

    @Override
    public boolean validateInput(String input) {
        try {
            inputDouble = Double.parseDouble(input);
        } catch (Exception e) {
            return false;
        }
        if(inputDouble<0){
            return false;
        }
        return (inputDouble*100 == Math.floor(inputDouble*100));
    }
}
