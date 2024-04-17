package com.ksamar.library.tools.dashdoard;

import com.ksamar.library.entity.Dashdoard;
import com.ksamar.library.tools.color.Colour;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class LineChart extends JPanel {
    private List<Double> dataPointsX;
    private List<Double> dataPointsY;
    private List<String> updateTime;
    private String describeText = "";
    private Color lineColor;
    private static final int PADDING = 24; // 定义边界间距
    private double maxY;
    private int yAxisInterval;

    public LineChart() {
        //设置Y轴最大值
        maxY = 150;
        yAxisInterval = 25; //y轴线的间隔
        // 添加一些示例数据点
        addDataPoints();
    }

    private void addDataPoints() {
        // 初始化数据点
        dataPointsX = new ArrayList<>();
        dataPointsY = new ArrayList<>();
        updateTime = new ArrayList<>();

        // 这里添加一些示例数据点
        for (int i = 0; i < 100; i++) {
            dataPointsX.add((double) i);
            // 确保 y 值不超过 maxY
            dataPointsY.add(Math.min(maxY, Math.cos(i)));
            updateTime.add("");
        }
    }

    public void addDataPointsTem(List<Dashdoard> dashdoardList) {
        // 初始化数据点
        dataPointsX = new ArrayList<>();
        dataPointsY = new ArrayList<>();

        // 这里添加一些示例数据点
        for (int i = 0; i < dashdoardList.size(); i++) {
            dataPointsX.add((double) i);
            // 确保 y 值不超过 150
            dataPointsY.add(Double.parseDouble(dashdoardList.get(i).getTemperature()));
        }

        setUpdateTime(dashdoardList);
    }

    //湿度
    public void addDataPointsHum(List<Dashdoard> dashdoardList) {
        // 初始化数据点
        dataPointsX = new ArrayList<>();
        dataPointsY = new ArrayList<>();

        // 这里添加一些示例数据点
        for (int i = 0; i < dashdoardList.size(); i++) {
            dataPointsX.add((double) i);
            dataPointsY.add(Double.parseDouble(dashdoardList.get(i).getHumidity()));
        }
        setUpdateTime(dashdoardList);
    }

    public void addDataPointsLight(List<Dashdoard> dashdoardList) {
        // 初始化数据点
        dataPointsX = new ArrayList<>();
        dataPointsY = new ArrayList<>();


        // 这里添加一些示例数据点
        for (int i = 0; i < dashdoardList.size(); i++) {
            dataPointsX.add((double) i);
            dataPointsY.add(Double.parseDouble(dashdoardList.get(i).getLightIntensity()));
        }
        setUpdateTime(dashdoardList);
    }

    public void addDataPointsSoilTem(List<Dashdoard> dashdoardList) {
        // 初始化数据点
        dataPointsX = new ArrayList<>();
        dataPointsY = new ArrayList<>();

        for (int i = 0; i < dashdoardList.size(); i++) {
            dataPointsX.add((double) i);
            dataPointsY.add(Double.parseDouble(dashdoardList.get(i).getSoilTemperature()));
        }
        setUpdateTime(dashdoardList);
    }

    public void setUpdateTime(List<Dashdoard> dashdoardList){
        updateTime = new ArrayList<>();

        for (Dashdoard dashdoard : dashdoardList) {
            updateTime.add(dashdoard.getUpdateTime());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 获取面板的宽度和高度
        int width = getWidth();
        int height = getHeight();

        // 设置画笔颜色和宽度
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));

        //绘制y坐标线
        g2.setColor(Colour.EBEBEB);
        int yAxisWidth = -(960/2) + 32 + 48; // Y 坐标轴线的宽度
        FontMetrics fm = g2.getFontMetrics();

        for (int i = 1; i < 6 ; i += 1) {
            int y = getHeight()/6 * i;
            g2.drawLine(PADDING - yAxisWidth, y, PADDING, y); // 绘制 y 坐标轴线
        }

        // 计算可用的绘图区域，减去边界间距
        int usableWidth = width - 2 * PADDING;
        int usableHeight = height - 2 * PADDING;

        // 绘制折线图
        int lastX = -1, lastY = -1;
        for (int i = 0; i < dataPointsX.size(); i++) {
            g2.setColor(lineColor);
            int x;
            int y;

            // 计算 x 坐标，从右往左绘制
            try {
                x = PADDING + usableWidth - (int) ((dataPointsX.get(i) - getMinX()) / (getMaxX() - getMinX()) * usableWidth);
                y = height - PADDING - (int) ((dataPointsY.get(i) - getMinY()) / (getMaxY() - getMinY()) * usableHeight);
            } catch (Exception e){
                System.out.println("更新过快");
                continue;
            }

            if (i == 0) {
                lastX = x;
                lastY = y;
            }
            g2.fillOval(x - 2, y - 2, 4, 4);
            if (i > 0) { // 从第二个点开始绘制线条
                g2.drawLine(lastX, lastY, x, y);
            }
            lastX = x;
            lastY = y;

            // 保存当前的变换状态
            AffineTransform originalTransform = g2.getTransform();

            //设置字体与颜色
            g2.setColor(Colour.F0F0F0);
            g2.setFont(new Font("微软雅黑", Font.PLAIN, 7));

            //绘制x轴时间
            if (updateTime.size() > i){
                String[] parts = updateTime.get(i).split("-");
                if (parts.length >= 3){
                    String s = parts[1] + "-" + parts[2];
                    if (s.charAt(0) == '0') {
                        s = s.substring(1); // 去除第一个字符
                    }
                    if ((i + 1) % 5 == 0) {
                        FontMetrics fontMetrics = getFontMetrics(g2.getFont()); // 获取字体度量
                        int labelWidth = fontMetrics.stringWidth(s);

                        // 设置旋转点
                        int centerX = x - labelWidth / 2 + 10;
                        int centerY = 200;

                        // 创建一个新的 AffineTransform 用于旋转
                        AffineTransform rotateTransform = AffineTransform.getRotateInstance(Math.toRadians(-20), centerX, centerY);
                        g2.transform(rotateTransform); // 应用旋转变换

                        g2.drawString(s, x - labelWidth / 2 + 3, 200 + 3); //+3是为了让时间显示偏右下
                    }
                }
            }

            // 恢复之前的变换状态
            g2.setTransform(originalTransform);
        }

        g2.setColor(Colour.F0F0F0);
        g2.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        for (int i = 1; i < 6 ; i += 1) {
            int y = getHeight()/6 * (6-i);

            // 绘制数值标签
            String value = String.valueOf(yAxisInterval * i);
            FontMetrics fontMetrics = getFontMetrics(g2.getFont()); // 获取字体度量
            int labelWidth = fontMetrics.stringWidth(String.valueOf(yAxisInterval * i));
            g2.drawString(value, PADDING - yAxisWidth - labelWidth + labelWidth, y + fm.getHeight() / 2 - 5);
        }

        //绘制描述
        g2.setColor(Color.DARK_GRAY);
        g2.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        g2.drawString(describeText, 8, 22);
    }

    private double getMinX() {
        return 0;
    }

    private double getMaxX() {
        return dataPointsX.size();
    }

    private double getMinY() {
        return 0;
    }

    private double getMaxY() {
        return maxY; // 获取 y 轴的最大值
    }


    public void setDescribeText(String describeText) {
        this.describeText = describeText;
    }

    public void setMaxY(double maxY){
        this.maxY = maxY; // 设置 y 轴的最大值
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void setyAxisInterval(int yAxisInterval) {
        this.yAxisInterval = yAxisInterval;
        System.out.println(yAxisInterval);
    }
}
