package pl.hansonq.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import pl.hansonq.models.dao.WeatherDao;
import pl.hansonq.models.dao.impl.WeatherDaoImpl;
import pl.hansonq.models.services.WeatherService;

import javax.swing.text.html.ListView;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lukasz on 2017-09-24.
 */
public class ChartController implements Initializable {

    private WeatherService weatherService = WeatherService.getService();
    WeatherDao weatherDao = new WeatherDaoImpl();

    @FXML
    BarChart chartTemp;
    @FXML
    ListView listCities;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chartTemp.setCategoryGap(weatherDao.getAllWeatherData());
    }
}
