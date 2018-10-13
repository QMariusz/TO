package controller;

import model.Currency;
import model.CurrencyList;

public class Calculate {

    private MyValidatorImpl validator;
    private CurrencyList currencyList;

    public double count() {
        return 0;
    }

    public Calculate(MyValidatorImpl validator, CurrencyList currencyList) {
        this.validator = validator;
        this.currencyList = currencyList;
    }

    public String count(String input, Object selectedItemLeft, Object selectedItemRight) {
        if (validator.validateInput(input)) {
            Currency leftCurrency = currencyList.getCurrencyByName(selectedItemLeft.toString());
            Currency rightCurrency = currencyList.getCurrencyByName(selectedItemRight.toString());
            double value = Double.parseDouble(input);
            double wynik = value * (rightCurrency.getMultiplier() / rightCurrency.getRate()) / (leftCurrency.getMultiplier() / leftCurrency.getRate());
            return String.format("%.2f", wynik);
        }
        return "Błąd";
    }
}
