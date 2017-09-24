package pl.hansonq.models;

/**
 * Created by lukasz on 2017-09-23.
 */
public class WeatherInfo {
    private double temp;
    private int pressure;

    private int humidity;
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public WeatherInfo(double temp, int pressure, int humidity, String cityName) {
        this.temp = temp;
        this.pressure = pressure;

        this.humidity = humidity;
        this.cityName = cityName;
    }



    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;

    }

    public WeatherInfo(double temp, int pressure) {
        this.temp = temp;
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;

    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;

    }
}
