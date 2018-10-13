package model;

import java.util.List;

public class CurrencyList {

    private List<Currency> currencyList;

    public CurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public Currency getCurrencyByCode(String code) {
        for (Currency el : currencyList) {
            if (el.getCode().equals(code)) {
                return el;
            }
        }
        return null;
    }

    public Currency getCurrencyByName(String name) {
        for (Currency el : currencyList) {
            if (el.getName().equals(name)) {
                return el;
            }
        }
        return null;
    }
}
