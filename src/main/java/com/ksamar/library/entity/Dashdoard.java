package com.ksamar.library.entity;

public class Dashdoard {
    private int id;
    private String temperature;
    private String humidity;
    private String lightIntensity;
    private String soilTemperature;
    private String updateTime;

    public Dashdoard(int id, String temperature, String humidity, String lightIntensity, String soilTemperature, String updateTime) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.lightIntensity = lightIntensity;
        this.soilTemperature = soilTemperature;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }


    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(String lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public String getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(String soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Dashdoard{" +
                "id=" + id +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", lightIntensity='" + lightIntensity + '\'' +
                ", soilTemperature='" + soilTemperature + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
