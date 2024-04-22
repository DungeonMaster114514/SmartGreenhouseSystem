package com.ksamar.library.controller;

import com.ksamar.library.entity.ImageMsg;
import com.ksamar.library.tools.sql.SqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageController {
    public static List<ImageMsg> imageGetMsg(){
        String selectUserSql = "SELECT `id`, url , description, add_time FROM image WHERE state = 1";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<ImageMsg> imageMsg = new ArrayList<>();
        try {
            // 执行语句
            Connection connection = SqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(selectUserSql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                imageMsg.add(new ImageMsg(resultSet.getInt("id"), resultSet.getString("url"), resultSet.getString("description"),resultSet.getString("add_time")));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("List<ImageMsg>获取失败");
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
        return imageMsg;
    }

    public static void imageInsertMsg(String url, String description) {
        String insertSql = "INSERT INTO image (url, description) VALUES (?,?);";
        try (Connection connection = SqlConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, url);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting data into the database", e);
        }
    }
    public static void imageAlterMsg(int id){
        String sql = "UPDATE image SET state = 0 Where id =" + id;
        PreparedStatement preparedStatement = null;
        int num;
        try {
            // 执行语句
            Connection connection = SqlConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            num = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            System.out.println("image成功更改" + num + "行");
        } catch (SQLException e) {
            System.out.println("image更改失败");
        }
    }
}
