package controller;

public class MyValidatorImpl implements MyValidator {

    private double inputDouble;

    @Override
    public boolean validateInput(String input) {
        if (input.isEmpty()) {
            return false;
        }
        try {
            inputDouble = Double.parseDouble(input);
        } catch (Exception e) {
            return false;
        }
        return !(inputDouble < 0);
    }
}
