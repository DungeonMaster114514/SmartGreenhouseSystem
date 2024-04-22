package com.ksamar.library.controller;

import com.ksamar.library.entity.Dashdoard;
import com.ksamar.library.entity.ImageMsg;
import com.ksamar.library.tools.sql.SqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DashdoardController {
    public static List<Dashdoard> dashdoardMsg(){
        String selectUserSql = "SELECT `id`, temperature , humidity , lightIntensity, soilTemperature, updateTime FROM dashdoard ORDER BY updateTime DESC LIMIT 50;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Dashdoard> dashdoardMsg = new ArrayList<>();
        try {
            // 执行语句
            Connection connection = SqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(selectUserSql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                dashdoardMsg.add(new Dashdoard(resultSet.getInt("id"), resultSet.getString("temperature"), resultSet.getString("humidity"),
                        resultSet.getString("lightIntensity"),resultSet.getString("soilTemperature"),resultSet.getString("updateTime")));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return dashdoardMsg;
    }

    public static void DashdoardInsertMsg(String temperature ,String humidity ,String lightIntensity,String soilTemperature) {
        String insertSql = "INSERT INTO dashdoard (temperature , humidity , lightIntensity, soilTemperature) VALUES (?,?,?,?);";
        try (Connection connection = SqlConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, temperature);
            preparedStatement.setString(2, humidity);
            preparedStatement.setString(3, lightIntensity);
            preparedStatement.setString(4, soilTemperature);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into the database", e);
        }
    }
}

