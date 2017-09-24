package pl.hansonq.models.dao.impl;

import pl.hansonq.models.MysqlConnector;
import pl.hansonq.models.WeatherModel;
import pl.hansonq.models.dao.WeatherDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 2017-09-24.
 */
public class WeatherDaoImpl implements WeatherDao {


    private MysqlConnector connector = MysqlConnector.getInstance();

    @Override
    public void addWeather(WeatherModel model) {

        try (PreparedStatement preparedStatement = connector.getConnection().prepareStatement(  // try catch resources
                "INSERT INTO weather VALUES(?,?,?,?)"))

        {

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, model.getCityname());
            preparedStatement.setFloat(3, model.getTemp());
            preparedStatement.setDate(4, null);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<WeatherModel> getAllWeatherData(String cityname) {
        List<WeatherModel> cityList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connector.getConnection().prepareStatement(  // try catch resources
                "SELECT * FROM weather WHERE cityname = ?"))

        {


            preparedStatement.setString(1, cityname);
            ResultSet set = preparedStatement.executeQuery();

            while (set.next()) {
                cityList.add(new WeatherModel(set.getString("cityname"), set.getFloat("temp"), set.getDate("date")));

            }
            return cityList;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<String> getCities() {
        List<String> cityNames = new ArrayList<>();
        try (PreparedStatement preparedStatement = connector.getConnection().prepareStatement(  // try catch resources
                "SELECT DISTINCT cityname FROM weather "))

        {



            ResultSet set = preparedStatement.executeQuery();

            while (set.next()) {
               cityNames.add(set.getString("cityname"));

            }
            return cityNames;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
