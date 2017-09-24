package pl.hansonq.models.dao;

import pl.hansonq.models.WeatherModel;

import java.util.List;

/**
 * Created by lukasz on 2017-09-24.
 */
public interface WeatherDao {
    void addWeather(WeatherModel model);
    List<WeatherModel>getAllWeatherData(String cityname);
    List<String> getCities();
}
