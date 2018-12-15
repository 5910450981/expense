package csku.application;

import csku.model.SpenderModel;
import csku.spender.Spender;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SpenderController {

    @FXML
    TableView<Spender> spenderView;
    @FXML
    TableColumn recordColumn, typeColumn, amountColumn, dateColumn;
    @FXML
    TextField recordText, amountText, typeText, dateText;
    @FXML
    Button incomeBtn, expenseBtn, editBtn, removeBtn;

    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.now();
    SpenderModel spender = new SpenderModel();

    Spender currentSpender;

    @FXML
    public void initialize(){
        dateText.setText(dateFormat.format(localDate));
        setScene();
        spenderView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                currentSpender = spenderView.getSelectionModel().getSelectedItem();
                recordText.setText(currentSpender.getRecord());
                amountText.setText(String.valueOf(currentSpender.getAmount()));
                typeText.setText(currentSpender.getType());
                dateText.setText(currentSpender.getDate());
            }
        });
    }

    @FXML
    public void incomeBtnHandler(){
        String record = recordText.getText();
        double amount = Double.parseDouble(amountText.getText());
        String date = dateText.getText();
        spender.addSpender(record, amount, date);
        setScene();
        clear();
    }

    @FXML
    public void expenseBtnHandler(){
        String record = recordText.getText();
        double amount = Double.parseDouble(amountText.getText());
        String date = dateText.getText();
        amount *= -1;
        spender.addSpender(record, amount, date);
        setScene();
        clear();
    }

    @FXML
    public void editBtnHandler(){
        String record = recordText.getText();
        double amount = Double.parseDouble(amountText.getText());
        String date = dateText.getText();
        if (typeText.getText().equals("Expense")) amount *= -1;
        spender.editSpender(currentSpender, record, amount, date);
        setScene();
        clear();
    }

    @FXML
    public void removeBtnHandler(){
        spender.remove(currentSpender);
        setScene();
        clear();
    }

    @FXML
    public void setScene(){
        recordColumn.setCellValueFactory(new PropertyValueFactory<>("record"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        spenderView.setItems(spender.show());
    }

    @FXML
    public void clear(){
        recordText.setText("");
        amountText.setText("");
        typeText.setText("");
        dateText.setText("");
    }

}
