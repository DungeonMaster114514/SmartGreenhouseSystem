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


    /**
     * 标签
     */
    private JLabel currentTemperatureTextLabel = new JLabel();
    private JLabel currentWeatherTextLabel = new JLabel();
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
        WeatherMsg weatherMsg = WeatherService.getCurrentWeather();
        //当前温度标签
        currentTemperatureTextLabel.setText((int) weatherMsg.getTemperature() + "°");
        currentTemperatureTextLabel.setBounds(16 + 90 + 16,96 - 10, 150, 50);
        currentTemperatureTextLabel.setFont(Fonts.weatherTem);
        currentTemperatureTextLabel.setForeground(Color.white);

        //当前天气标签
        currentWeatherTextLabel.setText(weatherMsg.getInfo());
        currentWeatherTextLabel.setBounds(16 + 90 + 16,96 - 10 + 60, 150, 50);
        currentWeatherTextLabel.setFont(Fonts.weather);
        currentWeatherTextLabel.setForeground(Color.white);

        //天气图标
        ImageIcon imageIcon = Images.weatherIcon;
        weatherIcon.setIcon(imageIcon);
        weatherIcon.setBounds(16,96, 90, 90);

        //天气背景图
        ImageIcon imageBgIcon = Images.weatherBgIcon;
        weatherBgIcon.setIcon(imageBgIcon);
        weatherBgIcon.setHorizontalAlignment(JLabel.CENTER);
        weatherBgIcon.setVerticalAlignment(JLabel.CENTER);
        weatherBgIcon.add(currentTemperatureTextLabel);
        weatherBgIcon.add(currentWeatherTextLabel);
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
