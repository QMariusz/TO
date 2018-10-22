package validation;

public class MyValidatorString implements MyValidator {

    @Override
    public boolean validateInput(String input) {
        return input.isEmpty();
    }
}
