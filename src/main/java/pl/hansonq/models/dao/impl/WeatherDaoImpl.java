package pl.hansonq.models.dao.impl;

import pl.hansonq.models.MysqlConnector;
import pl.hansonq.models.WeatherModel;
import pl.hansonq.models.dao.WeatherDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lukasz on 2017-09-24.
 */
public class WeatherDaoImpl implements WeatherDao{


    private MysqlConnector connector = MysqlConnector.getInstance();
    @Override
    public void addWeather(WeatherModel model) {
        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(
                    "INSERT INTO weather VALUES(?,?,?,?)"
            );

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, model.getCityname());
            preparedStatement.setFloat(3, model.getTemp());
            preparedStatement.setDate(4, model.getDate());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<WeatherModel> getAllWeatherData(String cityname) {
        return null;
    }

    @Override
    public List<String> getCities() {
        return null;
    }
}
