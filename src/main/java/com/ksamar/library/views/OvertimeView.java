package com.ksamar.library.views;

import com.ksamar.library.tools.color.Colour;
import com.ksamar.library.tools.font.Fonts;
import com.ksamar.library.tools.image.Images;
import com.ksamar.library.tools.weather.WeatherMsg;
import com.ksamar.library.tools.weather.WeatherService;

import javax.swing.*;
import java.awt.*;

/**
 * 超时查询面板
 * @author KSaMar
 * @version 1.0
 */
public class OvertimeView extends JPanel {

    /**
     * 属性
     */
    private WeatherMsg weatherMsg;

    /**
     * 标签
     */
    private JLabel currentTemperatureTextLabel = new JLabel();
    private JLabel currentWeatherTextLabel = new JLabel();
    private JLabel cityTextLabel = new JLabel();
    private JLabel windTextLabel = new JLabel();
    private JLabel airTextLabel = new JLabel();
    private JLabel weatherIcon = new JLabel();
    private JLabel weatherBgIcon = new JLabel();

    /**
     * 面板
     */
    private JScrollPane weatherPane = new JScrollPane();

    /**
     * 超时查询面板
     */
    public OvertimeView() {
        weatherMsg = WeatherService.getCurrentWeather();
        //城市标签
        cityTextLabel.setText(weatherMsg.getStationCity());
        cityTextLabel.setFont(Fonts.weatherSmall);
        cityTextLabel.setForeground(Color.white);
        cityTextLabel.setBounds(16,8, 150, 50);

        //风力标签
        windTextLabel.setText(weatherMsg.getWindDirect());
        windTextLabel.setFont(Fonts.weatherSmall);
        windTextLabel.setForeground(Color.white);
        FontMetrics metrics = windTextLabel.getFontMetrics(Fonts.weatherSmall);
        int stringWidth = metrics.stringWidth(weatherMsg.getWindDirect());  //计算文本宽度
        windTextLabel.setBounds(464 - 16 - stringWidth - 16,8, 250, 50);

        //当前温度标签
        currentTemperatureTextLabel.setText((int) weatherMsg.getTemperature() + "°");
        currentTemperatureTextLabel.setBounds(12 + 90 + 16,110 - 10, 150, 50);
        currentTemperatureTextLabel.setFont(Fonts.weatherTem);
        currentTemperatureTextLabel.setForeground(Color.white);

        //当前天气标签
        currentWeatherTextLabel.setText(weatherMsg.getInfo());
        currentWeatherTextLabel.setBounds(12 + 90 + 16,110 - 10 + 60, 150, 50);
        currentWeatherTextLabel.setFont(Fonts.weather);
        currentWeatherTextLabel.setForeground(Color.white);

        //空气质量标签
        String airText = "┃" + weatherMsg.getAir();
        airTextLabel.setText(airText);
        FontMetrics metricsAir = airTextLabel.getFontMetrics(Fonts.weather);
        int stringWidthAir = metricsAir.stringWidth(airText);  //计算文本宽度
        airTextLabel.setBounds(464 - 16 - stringWidthAir - 16,110 - 10 + 60, 150, 50);
        airTextLabel.setFont(Fonts.weather);
        if (airText.equals("┃优")){
            airTextLabel.setForeground(Colour.C5AB556);
        }
        else if (airText.equals("┃良")){
            airTextLabel.setForeground(Color.ORANGE);
        }
        else {
            airTextLabel.setForeground(Color.RED);
        }

        //天气图标
        ImageIcon imageIcon = Images.weatherIcon;
        weatherIcon.setIcon(imageIcon);
        weatherIcon.setBounds(16,110, 90, 90);

        //天气背景图
        ImageIcon imageBgIcon = Images.weatherBgIcon;
        weatherBgIcon.setIcon(imageBgIcon);
        weatherBgIcon.setHorizontalAlignment(JLabel.CENTER);
        weatherBgIcon.setVerticalAlignment(JLabel.CENTER);
        weatherBgIcon.add(currentTemperatureTextLabel);
        weatherBgIcon.add(currentWeatherTextLabel);
        weatherBgIcon.add(cityTextLabel);
        weatherBgIcon.add(windTextLabel);
        weatherBgIcon.add(airTextLabel);
        weatherBgIcon.add(weatherIcon);

        // 天气信息面版
        weatherPane.setBounds(16,42, 464 - 8, 684);
        weatherPane.setBackground(Colour.F0F0F0Plus);
        weatherPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        weatherPane.setViewportView(weatherBgIcon);
        weatherPane.getViewport().setBackground(Color.white);

        // 添加组件
        add(weatherPane);

        // 窗体设置
        setSize(960, 768);
        setLayout(null);
        setBackground(Color.white);
        setVisible(true);
    }
}
