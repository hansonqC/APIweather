package pl.hansonq.models.services;

import javafx.application.Platform;
import org.json.JSONObject;


import org.json.JSONObject;
import pl.hansonq.models.Config;
import pl.hansonq.models.IWeatherObserver;
import pl.hansonq.models.Utils;
import pl.hansonq.models.WeatherInfo;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lukasz on 2017-09-23.
 */
public class WeatherService {

    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getService() {
        return ourInstance;
    }

    private List<IWeatherObserver> observer = new ArrayList<>();
    private ExecutorService executorService;

    private WeatherService() {
        executorService = Executors.newSingleThreadExecutor();

    }

    public void makeRequest(String city) {
        Runnable runnable = () -> readJasonData(Utils.makeHttpRequest(Config.APP_BASE_URL + city + "&appid=" + Config.APP_ID),city);

        executorService.execute(runnable);
    }


    private void readJasonData(String json, String cityname) {
        JSONObject root = new JSONObject(json);
        JSONObject main = root.getJSONObject("main");


        int humidity = main.getInt("humidity");
        int pressure = main.getInt("pressure");
        double temp = main.getDouble("temp");
        System.out.println("Temperatura to " + temp);//+ visibility);

        observer.forEach(s -> {

            Platform.runLater(() -> s.onWeatherUpdate(new WeatherInfo(temp, pressure, humidity,cityname)));
        });


    }


    public void registerObserver(IWeatherObserver observer) {
        this.observer.add(observer);
    }


}


