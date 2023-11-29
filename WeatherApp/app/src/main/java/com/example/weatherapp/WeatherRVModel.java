package com.example.weatherapp;

public class WeatherRVModel {

    private String time;
    private String temprature;
    private String icon;
    private String windSpeed;

    public WeatherRVModel(String time, String temprature, String icon, String windSpeed) {
        this.time = time;
        this.temprature = temprature;
        this.icon = icon;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemprature() {
        return temprature;
    }

    public void setTemprature(String temprature) {
        this.temprature = temprature;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
