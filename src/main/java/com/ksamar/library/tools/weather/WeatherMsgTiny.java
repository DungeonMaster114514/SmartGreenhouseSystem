package com.ksamar.library.tools.weather;

public class WeatherMsgTiny {
    private float max_temp;
    private float min_temp;
    private String info;

    public WeatherMsgTiny(float max_temp, float min_temp, String info) {
        this.max_temp = max_temp;
        this.min_temp = min_temp;
        this.info = info;
    }

    public float getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(float max_temp) {
        this.max_temp = max_temp;
    }

    public float getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(float min_temp) {
        this.min_temp = min_temp;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "WeatherMsgTiny{" +
                "max_temp=" + max_temp +
                ", min_temp=" + min_temp +
                ", info='" + info + '\'' +
                '}';
    }
}
