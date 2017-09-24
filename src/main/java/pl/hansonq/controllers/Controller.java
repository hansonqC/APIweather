package pl.hansonq.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import pl.hansonq.models.IWeatherObserver;
import pl.hansonq.models.WeatherInfo;
import pl.hansonq.models.dao.WeatherDao;
import pl.hansonq.models.dao.impl.WeatherDaoImpl;
import pl.hansonq.models.services.WeatherService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable,IWeatherObserver{


    private WeatherService weatherService = WeatherService.getService();

    @FXML
    Button buttonSend,buttonCharts;


    @FXML
    Label textWeather;

    @FXML
    TextField textCity;
  @FXML
  ProgressIndicator progressIndicator;
    private WeatherDao weatherDao=new WeatherDaoImpl();
    public void initialize(URL location, ResourceBundle resources) {
        progressIndicator.setVisible(false);
        textWeather.setVisible(false);
        weatherService.registerObserver(this);

        buttonSend.setOnMouseClicked(e -> {
            if(!textCity.getText().isEmpty()){
                progressIndicator.setVisible(true);
                textWeather.setVisible(false);
              weatherService.makeRequest(textCity.getText());

                textCity.clear();
            }

        });

        textCity.setOnKeyPressed((e ->{
            if(e.getCode()== KeyCode.ENTER){
                progressIndicator.setVisible(true);
                textWeather.setVisible(false);
                weatherService.makeRequest(textCity.getText());
                textCity.clear();
            }
        }));

                buttonCharts.setOnMouseClicked(e-> goToCharts());
    }

    private void goToCharts() {
        Stage stage = (Stage) buttonCharts.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("chartView.fxml"));
            stage.setScene(new Scene(root,600,400));
            stage.setTitle("Wykres temperatury");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onWeatherUpdate(WeatherInfo info) {

        textWeather.setText("Temp: " + info.getTemp() + " | Cisnienie: " + info.getPressure()+ "\n" +
                "Widoczność :"+info.getVisibility()+ " | Wilgotność : "+info.getHumidity());
        progressIndicator.setVisible(false);
        textWeather.setVisible(true);
        weatherDao.addWeather();
    }


}
