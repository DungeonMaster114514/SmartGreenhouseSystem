package com.ksamar.library.tools.sensor;

import com.ksamar.library.controller.DashdoardController;
import com.ksamar.library.controller.ImageController;
import com.ksamar.library.tools.image.Images;
import org.eclipse.paho.client.mqttv3.*;
import org.json.*;

// 导入Java的IO和NIO类，用于处理输入输出流和字节缓冲
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void get_Sensor_Data(String jsonString){
        // 假设我们有一个 JSON 字符串
//        String jsonString1 = "{'light':12.2, \"soil\":30}";
        // 创建一个 JSONObject 对象
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
            double light = jsonObject.optDouble("light");
            int soil = jsonObject.optInt("soil");
            JSONArray air =  jsonObject.getJSONArray("air");
            double air_temperature=air.optDouble(0);//JSONArray的第一个元素
            double air_humidity = air.optDouble(1);
            System.out.println(light+"  "+soil+"  "+ air_temperature+"  "+air_humidity);
            DashdoardController.DashdoardInsertMsg(String.valueOf((int)air_temperature),String.valueOf((int)air_humidity),String.valueOf((int)light), String.valueOf(soil));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public static void get_Camera_Data(org.eclipse.paho.client.mqttv3.MqttMessage message, int cameraNum) throws IOException {
        // 这部分代码需要配合OpenCV的Java界面库来实现图像显示

        ByteArrayInputStream bis = new ByteArrayInputStream(message.getPayload());
        BufferedImage bImage2 = ImageIO.read(bis);
        // 假设这是我们的时间戳
        long timestamp = System.currentTimeMillis();
        // 将时间戳转换为 Date 对象
        Date date = new Date(timestamp);
        // 创建 SimpleDateFormat 对象，并设置所需的日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        // 将 Date 对象格式化为字符串
        String formattedDate = dateFormat.format(date);

        String userDir = System.getProperty("user.dir");
        String url = userDir + "/src/main/java/com/ksamar/library/images_check/camera"+ cameraNum + "_" + formattedDate + ".jpg";
        ImageIO.write(bImage2,"jpg", new File(url) );
        ImageController.imageInsertMsg(url,"");
        System.out.println("image created");
    }
}