package com.ksamar.library.tools.weather;

public class WeatherMsg {
    private String stationCity; //城市
    private float temperature; //温度
    private String info; //天气信息
    private String windDirect; //风向.
    private String air; // 空气质量.0
    private String updateTime; //信息获取时间

    public WeatherMsg(String stationCity, float temperature, String info, String windDirect, String air, String updateTime) {
        this.stationCity = stationCity;
        this.temperature = temperature;
        this.info = info;
        this.windDirect = windDirect;
        this.air = air;
        this.updateTime = updateTime;
    }

    public String getStationCity() {
        return stationCity;
    }

    public void setStationCity(String stationCity) {
        this.stationCity = stationCity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWindDirect() {
        return windDirect;
    }

    public void setWindDirect(String windDirect) {
        this.windDirect = windDirect;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    @Override
    public String toString() {
        return "WeatherMsg{" +
                "stationCity='" + stationCity + '\'' +
                ", temperature=" + temperature +
                ", info='" + info + '\'' +
                ", windDirect='" + windDirect + '\'' +
                ", air='" + air + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
