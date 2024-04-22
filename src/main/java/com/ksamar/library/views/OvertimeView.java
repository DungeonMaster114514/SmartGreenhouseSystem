package com.ksamar.library.views;

import com.ksamar.library.tools.color.Colour;
import com.ksamar.library.tools.font.Fonts;
import com.ksamar.library.tools.image.Images;
import com.ksamar.library.tools.sensor.MqttImageReceiver;
import com.ksamar.library.tools.weather.WeatherMsg;
import com.ksamar.library.tools.weather.WeatherMsgTiny;
import com.ksamar.library.tools.weather.WeatherService;
import org.eclipse.paho.client.mqttv3.MqttException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

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
    private List<WeatherMsgTiny> list;
    private MqttImageReceiver mqttImageReceiver;

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
    private JLabel videoImageIcon = new JLabel();
    private JLabel greenHouseMsg0 = new JLabel();
    private JLabel greenHouseMsg1 = new JLabel();
    private JLabel greenHouseMsg2 = new JLabel();
    private JLabel greenHouseMsg3 = new JLabel();
    private JLabel greenHouseMsg4 = new JLabel();
    private JLabel greenHouseMsg5 = new JLabel();
    private JLabel greenHouseMsg6 = new JLabel();
    private JLabel greenHouseMsg7 = new JLabel();
    private JLabel todayTextLabel = new JLabel();
    private JLabel tomorrowTextLabel = new JLabel();
    private JLabel afterTextLabel = new JLabel();
    private JLabel todayWeatherTextLabel = new JLabel();
    private JLabel tomorrowWeatherTextLabel = new JLabel();
    private JLabel afterWeatherTextLabel = new JLabel();
    private JLabel todayWeatherImageLabel = new JLabel();
    private JLabel tomorrowWeatherImageLabel = new JLabel();
    private JLabel afterWeatherImageLabel = new JLabel();

    /**
     * 面板
     */
    private JScrollPane weatherPane = new JScrollPane();
    private JPanel greenHousePane = new JPanel();

    /**
     * 下拉菜单
     */
    private JComboBox<String> ComboBox = new JComboBox<>();

    /**
     * 自动刷新线程
     */
    SwingWorker<Void,Void> swingWorker;

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

        // 大棚选项项栏
        ComboBox.setBounds(960 - 150 * 2 -16, 16, 150, 32);
        ComboBox.addItem("零号大棚监控");
        ComboBox.addItem("一号大棚监控");
        ComboBox.addItem("二号大棚监控");
        ComboBox.addItem("三号大棚监控");
        ComboBox.addItem("四号大棚监控");
        ComboBox.addItem("五号大棚监控");
        ComboBox.addItem("六号大棚监控");
        ComboBox.addItem("七号大棚监控");
        ComboBox.setBackground(Color.WHITE);
        ComboBox.setFont(Fonts.comboBox);
//        ComboBox.addActionListener(pageChange());

        //模拟视频播放图片
        ImageIcon imageIcon = Images.greenhouseIcon;
        videoImageIcon.setIcon(imageIcon);
        videoImageIcon.setBounds(460 + 32,42 + 16, 464 - 16, 326 - 16);

        //模拟警报
        greenHouseMsg0.setText("零号草莓种植大棚处于正常状态");
        greenHouseMsg1.setText("一号草莓种植大棚处于正常状态");
        greenHouseMsg2.setText("二号草莓种植大棚处于正常状态");
        greenHouseMsg3.setText("三号草莓种植大棚处于正常状态");
        greenHouseMsg4.setText("四号草莓种植大棚处于正常状态");
        greenHouseMsg5.setText("五号草莓种植大棚处于正常状态");
        greenHouseMsg6.setText("六号草莓种植大棚处于正常状态");
        greenHouseMsg7.setText("七号草莓种植大棚处于正常状态");
        greenHouseMsg0.setFont(Fonts.weather2);
        greenHouseMsg1.setFont(Fonts.weather2);
        greenHouseMsg2.setFont(Fonts.weather2);
        greenHouseMsg3.setFont(Fonts.weather2);
        greenHouseMsg4.setFont(Fonts.weather2);
        greenHouseMsg5.setFont(Fonts.weather2);
        greenHouseMsg6.setFont(Fonts.weather2);
        greenHouseMsg7.setFont(Fonts.weather2);
        greenHouseMsg0.setForeground(Color.black);
        greenHouseMsg1.setForeground(Color.black);
        greenHouseMsg2.setForeground(Color.black);
        greenHouseMsg3.setForeground(Color.black);
        greenHouseMsg4.setForeground(Color.black);
        greenHouseMsg5.setForeground(Color.black);
        greenHouseMsg6.setForeground(Color.black);
        greenHouseMsg7.setForeground(Color.black);
        int stringWidthGreenHouse = todayTextLabel.getFontMetrics(Fonts.weather2).stringWidth("零号草莓种植大棚处于正常状态");  //计算文本宽度
        greenHouseMsg0.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16, 340, 22);
        greenHouseMsg1.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16 * 2 + 22, 340, 22);
        greenHouseMsg2.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16 * 3 + 44, 340, 22);
        greenHouseMsg3.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16 * 4 + 66, 340, 22);
        greenHouseMsg4.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16 * 5 + 88, 340, 22);
        greenHouseMsg5.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16 * 6 + 110, 340, 22);
        greenHouseMsg6.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16 * 7 + 132, 340, 22);
        greenHouseMsg7.setBounds(16 + (464 - 42 - stringWidthGreenHouse)/2, 16 * 8 + 154, 340, 22);

        //大棚警报面板
        greenHousePane.setLayout(null);
        greenHousePane.setBounds(460 + 32,42 + 16 + 326, 464 - 16, 326);
        greenHousePane.setBackground(Colour.F0F0F0Plus);
        greenHousePane.add(greenHouseMsg0);
        greenHousePane.add(greenHouseMsg1);
        greenHousePane.add(greenHouseMsg2);
        greenHousePane.add(greenHouseMsg3);
        greenHousePane.add(greenHouseMsg4);
        greenHousePane.add(greenHouseMsg5);
        greenHousePane.add(greenHouseMsg6);
        greenHousePane.add(greenHouseMsg7);

        //天气图标
        imageIcon = Images.weatherIcon;
        weatherIcon.setIcon(imageIcon);
        weatherIcon.setBounds(16,110, 90, 90);

        list = WeatherService.getWeatherList();

//小组件1今天标签
        String todayString = "今天";
        todayTextLabel.setText(todayString);
        todayTextLabel.setFont(Fonts.weatherSmall);
        todayTextLabel.setForeground(Color.white);
        int stringWidthTool1 = todayTextLabel.getFontMetrics(Fonts.weatherSmall).stringWidth(todayString);  //计算文本宽度
        todayTextLabel.setBounds(16 + (139 - stringWidthTool1)/2, 350 + 30, 250, 50);

        //小组件1今天天气标签
        todayString = (int)list.get(0).getMin_temp() + "°/" + (int) list.get(0).getMax_temp() + "°";
        todayWeatherTextLabel.setText(todayString);
        todayWeatherTextLabel.setFont(Fonts.weather2);
        todayWeatherTextLabel.setForeground(Color.white);
        stringWidthTool1 = todayWeatherTextLabel.getFontMetrics(Fonts.weather2).stringWidth(todayString);  //计算文本宽度
        todayWeatherTextLabel.setBounds(16 + (139 - stringWidthTool1)/2, 350 + 109 * 2 + 30, 250, 50);

        //小组件1今天天气图标
        todayWeatherImageLabel.setIcon(Images.weatherSmallIcon);
        todayWeatherImageLabel.setBounds(16 + (139 - 60)/2,350 + 109 + 30 , 60, 60);

        //小组件2明天标签
        String tomorrowString = "明天";
        tomorrowTextLabel.setText(tomorrowString);
        tomorrowTextLabel.setFont(Fonts.weatherSmall);
        tomorrowTextLabel.setForeground(Color.white);
        int stringWidthTool2 = tomorrowTextLabel.getFontMetrics(Fonts.weatherSmall).stringWidth(tomorrowString);  //计算文本宽度
        tomorrowTextLabel.setBounds(16 + 139 + (139 - stringWidthTool2)/2, 350 + 30, 250, 50);

        //小组件2明天天气标签
        tomorrowString = (int)list.get(1).getMin_temp() + "°/" + (int) list.get(1).getMax_temp() + "°";
        tomorrowWeatherTextLabel.setText(tomorrowString);
        tomorrowWeatherTextLabel.setFont(Fonts.weather2);
        tomorrowWeatherTextLabel.setForeground(Color.white);
        stringWidthTool2 = tomorrowWeatherTextLabel.getFontMetrics(Fonts.weather2).stringWidth(tomorrowString);  //计算文本宽度
        tomorrowWeatherTextLabel.setBounds(16 + 139 + (139 - stringWidthTool2)/2, 350 + 109 * 2 + 30, 250, 50);

        //小组件2明天天气图标
        tomorrowWeatherImageLabel.setIcon(Images.weatherSmallIcon);
        tomorrowWeatherImageLabel.setBounds(16 + 139 + (139 - 60)/2,350 + 109 + 30 , 60, 60);

        //小组件3后天标签
        String afterString = "后天";
        afterTextLabel.setText(afterString);
        afterTextLabel.setFont(Fonts.weatherSmall);
        afterTextLabel.setForeground(Color.white);
        int stringWidthTool3 = afterTextLabel.getFontMetrics(Fonts.weatherSmall).stringWidth(afterString);  //计算文本宽度
        afterTextLabel.setBounds(16 + 139 * 2 + (139 - stringWidthTool3)/2, 350 + 30, 250, 50);

        //小组件3后天天气标签
        afterString = (int)list.get(2).getMin_temp() + "°/" + (int) list.get(2).getMax_temp() + "°";
        afterWeatherTextLabel.setText(afterString);
        afterWeatherTextLabel.setFont(Fonts.weather2);
        afterWeatherTextLabel.setForeground(Color.white);
        stringWidthTool3 = afterWeatherTextLabel.getFontMetrics(Fonts.weather2).stringWidth(afterString);  //计算文本宽度
        afterWeatherTextLabel.setBounds(16 + 139 * 2 + (139 - stringWidthTool3)/2, 350 + 109 * 2 + 30, 250, 50);

        //小组件3后天天气图标
        afterWeatherImageLabel.setIcon(Images.weatherSmallIcon);
        afterWeatherImageLabel.setBounds(16 + 139 * 2 + (139 - 60)/2,350 + 109 + 30 , 60, 60);

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
        weatherBgIcon.add(todayWeatherTextLabel);
        weatherBgIcon.add(tomorrowWeatherTextLabel);
        weatherBgIcon.add(afterWeatherTextLabel);
        weatherBgIcon.add(todayWeatherImageLabel);
        weatherBgIcon.add(tomorrowWeatherImageLabel);
        weatherBgIcon.add(afterWeatherImageLabel);
        weatherBgIcon.add(todayTextLabel);
        weatherBgIcon.add(tomorrowTextLabel);
        weatherBgIcon.add(afterTextLabel);
        weatherBgIcon.add(weatherIcon);

        // 天气信息面版
        weatherPane.setBounds(16,42, 464 - 8, 684);
        weatherPane.setBackground(Colour.F0F0F0Plus);
        weatherPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        weatherPane.setViewportView(weatherBgIcon);
        weatherPane.getViewport().setBackground(Color.white);

        // 添加组件
        add(weatherPane);
        add(ComboBox);
        add(greenHousePane);
        add(videoImageIcon);

        swingWorker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (!isCancelled()) {
                    // 每隔60秒执行指定方法
                    Thread.sleep(1000);
                    // 调用指定方法
                    toDoSomeThing();
                }
                return null;
            }
        };
        swingWorker.execute();

        //获取各种数据到mysql中
        try {
            // 创建MqttImageReceiver实例，连接到MQTT代理
            mqttImageReceiver = new MqttImageReceiver("tcp://192.168.1.100:1883");
            // 保持程序运行，以便接收消息
        } catch (MqttException e) {
            // 打印初始化MQTT客户端时的错误信息
            System.out.println("Error initializing MQTT client: " + e.getMessage());
            // 打印异常堆栈信息
            e.printStackTrace();
        }

        // 窗体设置
        setSize(960, 768);
        setLayout(null);
        setBackground(Color.white);
        setVisible(true);
    }

    private void toDoSomeThing(){
        weatherMsg = WeatherService.getCurrentWeather();
        list = WeatherService.getWeatherList();
        repaint();
    }

    /**
     * 下拉菜单事件
     * @return ActionListener
     */
    private ActionListener pageChange() {
        return e -> {
            // 获取组合框下标
            int index = ComboBox.getSelectedIndex();
            switch (index) {
                case 0:
                    mqttImageReceiver.setCameraNum(0);
                    System.out.println(index);
                    break;
                case 1:
                    mqttImageReceiver.setCameraNum(1);
                    System.out.println(index);
                    break;
                case 2:
                    mqttImageReceiver.setCameraNum(2);
                    System.out.println(index);
                    break;
                case 3:
                    mqttImageReceiver.setCameraNum(3);
                    System.out.println(index);
                    break;
                case 4:
                    mqttImageReceiver.setCameraNum(4);
                    System.out.println(index);
                    break;
                case 5:
                    mqttImageReceiver.setCameraNum(5);
                    System.out.println(index);
                    break;
                case 6:
                    mqttImageReceiver.setCameraNum(6);
                    System.out.println(index);
                    break;
                case 7:
                    mqttImageReceiver.setCameraNum(7);
                    System.out.println(index);
                    break;
                default:
                    break;
            }
        };
    }
}
