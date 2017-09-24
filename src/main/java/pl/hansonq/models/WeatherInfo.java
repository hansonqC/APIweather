package pl.hansonq.models;

/**
 * Created by lukasz on 2017-09-23.
 */
public class WeatherInfo {
    private double temp;
    private int pressure;
    private int visibility;
    private int humidity;


    public WeatherInfo(double temp, int pressure, int visibility, int humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.visibility = visibility;
        this.humidity = humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;

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
