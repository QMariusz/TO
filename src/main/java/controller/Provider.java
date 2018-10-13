package controller;

import model.Currency;

import java.util.List;

public interface Provider {

    List<Currency> getData();
}
