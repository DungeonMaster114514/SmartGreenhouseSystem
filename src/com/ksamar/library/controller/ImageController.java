package com.ksamar.library.controller;

import com.ksamar.library.entity.ImageMsg;
import com.ksamar.library.tools.sql.SqlConnect;

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
            preparedStatement = SqlConnect.getConnection().prepareStatement(selectUserSql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                imageMsg.add(new ImageMsg(resultSet.getInt("id"), resultSet.getString("url"), resultSet.getString("description"),resultSet.getString("add_time")));
            }

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
        return imageMsg;
    }
}
