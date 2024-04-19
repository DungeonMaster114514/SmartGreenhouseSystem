package com.ksamar.library.tools.weather;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {

    // API的URL，这里使用的是示例URL，实际使用时请替换为正确的API服务地址
    private static final String WEATHER_API_URL = "http://www.nmc.cn/rest/weather?stationid=";

    // OkHttpClient用于发送HTTP请求
    private final OkHttpClient client = new OkHttpClient();

    /**
     * 获取指定城市的天气信息。
     *
     * @param cityCode 城市代码
     * @return 天气信息的JSON对象
     * @throws IOException 如果网络请求失败
     */
    public JSONObject getWeatherInfo(String cityCode) throws IOException {
        // 构造完整的API请求URL
        String url = WEATHER_API_URL + cityCode;

        // 发送GET请求
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            // 确保请求成功
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 读取响应字符串
            String responseBody = response.body().string();

            // 使用JSONObject解析JSON格式的响应数据
            return new JSONObject(responseBody);
        }
    }

    //获取当前天气
    public static WeatherMsg getCurrentWeather(){
        WeatherService service = new WeatherService();
        WeatherMsg weatherMsg;
        try {
            JSONObject weatherInfo = service.getWeatherInfo("58607");
            JSONObject dataObject = weatherInfo.optJSONObject("data");
            JSONObject realObject = new JSONObject(dataObject.optString("real"));
            //当前station
            JSONObject stationObject = new JSONObject(realObject.optString("station"));

            //当前weather
            JSONObject weatherObject = new JSONObject(realObject.optString("weather"));

            //当前wind
            JSONObject windObject = new JSONObject(realObject.optString("wind"));

            //当前空气质量
            JSONObject airObject = new JSONObject(dataObject.optString("air"));

            //获取时间publish_time
            String publish_time = realObject.getString("publish_time");

            weatherMsg = new WeatherMsg(stationObject.getString("city"), weatherObject.getFloat("temperature"),
                    weatherObject.getString("info"), windObject.getString("direct") + " " + windObject.getString("power"), airObject.getString("text"), publish_time);
        } catch (IOException e) {
            weatherMsg = new WeatherMsg("信息获取失败",0,"信息获取失败","信息获取失败","信息获取失败","信息获取失败");
        }

        return weatherMsg;
    }

    public static List<WeatherMsgTiny> getWeatherList(){
        WeatherService service = new WeatherService();
        List<WeatherMsgTiny> list = new ArrayList<>();
        try {
            JSONObject weatherInfo = service.getWeatherInfo("58607");

            JSONObject dataObject = weatherInfo.optJSONObject("data");

            //获取今天与未来六天的天气
            JSONArray tempchartArray = new JSONArray(dataObject.optString("tempchart"));


            for (int i = 7 ; i <= 9 ; i++){
                JSONObject obj = new JSONObject(tempchartArray.get(i).toString());
                WeatherMsgTiny weatherMsgTiny = new WeatherMsgTiny(obj.getFloat("max_temp"),obj.getFloat("min_temp"),obj.getString("night_text"));
                list.add(weatherMsgTiny);
            }

        } catch (IOException e) {
        e.printStackTrace();
        }

        return list;
    }

    // 测试方法
    public static void main(String[] args) {
//        WeatherService service = new WeatherService();
//        try {
//             用实际的城市代码替换"cityCodeHere"
//            JSONObject weatherInfo = service.getWeatherInfo("58607");
//
//            System.out.println(weatherInfo.toString(4));
//
//            JSONObject dataObject = weatherInfo.optJSONObject("data");
//            if (dataObject != null){
//                JSONObject predictObject = new JSONObject(dataObject.optString("predict"));
//
//                //获取今天与未来六天的天气
//                JSONArray detailArray = new JSONArray(dataObject.optString("tempchart"));
//                System.out.println(detailArray.get(7));
//
//                JSONObject realObject = new JSONObject(dataObject.optString("real"));
//                System.out.println(realObject.toString(4));
//
//                //获取当前天气
//                JSONObject weatherObject = new JSONObject(realObject.optString("weather"));
//                System.out.println(weatherObject.toString(4));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

            System.out.println(WeatherService.getCurrentWeather());
//        for (WeatherMsgTiny weatherMsgTiny: getWeatherList()) {
//            System.out.println(weatherMsgTiny);
//        }
    }
}