package pl.hansonq.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import pl.hansonq.models.IWeatherObserver;
import pl.hansonq.models.WeatherInfo;
import pl.hansonq.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable,IWeatherObserver{


    private WeatherService weatherService = WeatherService.getService();

    @FXML
    Button buttonSend;


    @FXML
    Label textWeather;

    @FXML
    TextField textCity;
  @FXML
  ProgressIndicator progressIndicator;

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


    }

    @Override
    public void onWeatherUpdate(WeatherInfo info) {

        textWeather.setText("Temp: " + info.getTemp() + " | Cisnienie: " + info.getPressure()+ "\n" +
                "Widoczność :"+info.getVisibility()+ " | Wilgotność : "+info.getHumidity());
        progressIndicator.setVisible(false);
        textWeather.setVisible(true);
    }


}
