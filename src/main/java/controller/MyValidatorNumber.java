package controller;

public class MyValidatorNumber implements MyValidator {

    private double inputDouble;

    @Override
    public boolean validateInput(String input) {
        try {
            inputDouble = Double.parseDouble(input);
        } catch (Exception e) {
            return false;
        }
        return !(inputDouble < 0);
    }
}
