import controller.Calculate;
import controller.MyValidatorImpl;
import controller.ProviderXML;
import model.CurrencyList;
import view.Interface;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        ProviderXML providerXML = new ProviderXML();
        CurrencyList currencyList = new CurrencyList(providerXML.getData());
        Calculate calculate = new Calculate(new MyValidatorImpl(), currencyList);
        SwingUtilities.invokeLater(() -> new Interface(calculate, providerXML.getData()));
    }
}
