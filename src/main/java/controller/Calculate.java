package controller;

import model.Currency;
import model.CurrencyList;
import validation.MyValidatorNumber;
import validation.MyValidatorString;

public class Calculate {

    private MyValidatorNumber validatorNumber;
    private MyValidatorString validatorString;
    private CurrencyList currencyList;

    public Calculate(CurrencyList currencyList) {
        this.validatorNumber = new MyValidatorNumber();
        this.validatorString = new MyValidatorString();
        this.currencyList = currencyList;
    }

    public String count(String input, Object selectedItemLeft, Object selectedItemRight) {
        if (validatorNumber.validateInput(input) && validatorNumber.validateInput(input)) {
            Currency leftCurrency = currencyList.getCurrencyByName(selectedItemLeft.toString());
            Currency rightCurrency = currencyList.getCurrencyByName(selectedItemRight.toString());
            double value = Double.parseDouble(input);
            double wynik = value * (rightCurrency.getMultiplier() / rightCurrency.getRate()) / (leftCurrency.getMultiplier() / leftCurrency.getRate());
            return String.format("%.2f", wynik);
        }
        return "Błąd";
    }
}
