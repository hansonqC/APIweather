package pl.hansonq.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import pl.hansonq.models.WeatherModel;
import pl.hansonq.models.dao.WeatherDao;
import pl.hansonq.models.dao.impl.WeatherDaoImpl;
import pl.hansonq.models.services.WeatherService;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by lukasz on 2017-09-24.
 */
public class ChartController implements Initializable {

    private WeatherService weatherService = WeatherService.getService();

    @FXML
    BarChart chartTemp;
    @FXML
    ListView<String> listCities;

    private ObservableList<String> cityObservableList;

    private WeatherDao weatherDao= new WeatherDaoImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            cityObservableList = FXCollections.observableList(weatherDao.getCities());
            listCities.setItems(cityObservableList);

            listCities.getSelectionModel().selectedItemProperty().addListener(observable, oldValue, newValue)->generateChart(newValue);
    }

    private void generateChart(String cityname) {
        List<WeatherModel> weatheList = weatherDao.getAllWeatherData(cityname);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName(cityname);
        for(WeatherModel weatherModel : weatheList){
            series.getData().add(new XYChart.Data<>(weatherModel.getDate().toString(), weatherModel.getTemp()));
        }
            chartTemp.getData().clear();
                chartTemp.getData().add(series);
    }
}
