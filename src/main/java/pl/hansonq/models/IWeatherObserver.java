package pl.hansonq.models;

/**
 * Created by lukasz on 2017-09-23.
 */
public interface IWeatherObserver {
    void onWeatherUpdate(WeatherInfo info);
}
