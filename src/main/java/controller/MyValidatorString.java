package controller;

public class MyValidatorString implements MyValidator {

    private double inputDouble;

    @Override
    public boolean validateInput(String input) {
        return input.isEmpty();
    }
}
