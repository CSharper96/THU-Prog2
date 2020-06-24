package HornyMerk.prog2.exercises.set11.currencyconverter;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class CurrencyConverterCtrl implements Initializable
{
    @FXML
    private ComboBox<Currency> cbFrom;

    @FXML
    private ComboBox<Currency> cbTo;

    @FXML
    private TextField tfAmount;

    @FXML
    private TextField tfResult;

    private final static DoubleStringConverter DOUBLE_STRING_CONVERTER = new DoubleStringConverter();

    private final static DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#0.000");

    private final ObservableList<Currency> currencies = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        currencies.addAll(Currency.values());
        cbFrom.setItems(currencies);
        cbTo.setItems(currencies);
        cbFrom.getSelectionModel().selectFirst();
        cbTo.getSelectionModel().selectLast();
    }

    public void convertAction()
    {
        Currency inputCurrency = cbFrom.getValue();
        Currency outputCurrency = cbTo.getValue();
        double inputValue;
        if(!tfAmount.getText().equals("") && isNumeric(tfAmount.getText()))
        {
            inputValue = DOUBLE_STRING_CONVERTER.fromString(tfAmount.getText());
            double inputValueInDollars = inputValue * inputCurrency.getEuroConversionRate();
            double outputValue = inputValueInDollars / outputCurrency.getEuroConversionRate();
            tfResult.setText(CURRENCY_FORMAT.format(outputValue));
        }
    }

    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
