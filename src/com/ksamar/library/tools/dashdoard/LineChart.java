package com.ksamar.library.tools.dashdoard;

import com.ksamar.library.entity.Dashdoard;
import com.ksamar.library.tools.color.Colour;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LineChart extends JPanel {
    private List<Double> dataPointsX;
    private List<Double> dataPointsY;
    private String describeText = "";
    private Color lineColor;
    private static final int PADDING = 24; // 定义边界间距
    private double maxY;
    private int yAxisInterval; //y轴线的间隔

    public LineChart() {
        //设置Y轴最大值
        maxY = 150;
        yAxisInterval = 25; // Y 坐标轴每隔 25 的间隔
        // 添加一些示例数据点
        addDataPoints();
    }

    private void addDataPoints() {
        // 初始化数据点
        dataPointsX = new ArrayList<>();
        dataPointsY = new ArrayList<>();

        // 这里添加一些示例数据点
        for (int i = 0; i < 100; i++) {
            dataPointsX.add((double) i);
            // 确保 y 值不超过 maxY
            dataPointsY.add(Math.min(maxY, Math.cos(i)));
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
    }

    //湿度
    public void addDataPointsHum(List<Dashdoard> dashdoardList) {
        // 初始化数据点
        dataPointsX = new ArrayList<>();
        dataPointsY = new ArrayList<>();

        // 这里添加一些示例数据点
        for (int i = 0; i < dashdoardList.size(); i++) {
            dataPointsX.add((double) i);
            // 确保 y 值不超过 150
            dataPointsY.add(Double.parseDouble(dashdoardList.get(i).getHumidity()));
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
        for (int i = yAxisInterval; i <= maxY - 1; i += yAxisInterval) {
            int y = height - PADDING - (int) ((i - getMinY()) / (getMaxY() - getMinY()) * (height - 2 * PADDING));
            g2.drawLine(PADDING, y, PADDING - yAxisWidth, y); // 绘制 y 坐标轴线
        }

        g2.setColor(lineColor);
        // 计算可用的绘图区域，减去边界间距
        int usableWidth = width - 2 * PADDING;
        int usableHeight = height - 2 * PADDING;

        // 绘制折线图
        int lastX = -1, lastY = -1;
        for (int i = 0; i < dataPointsX.size(); i++) {
            int x = PADDING + (int) ((dataPointsX.get(i) - getMinX()) / (getMaxX() - getMinX()) * usableWidth);
            int y = height - PADDING - (int) ((dataPointsY.get(i) - getMinY()) / (getMaxY() - getMinY()) * usableHeight);
            if (i == 0) {
                lastX = x;
                lastY = y;
            }
            g2.fillOval(x - 2 , y - 2 , 4, 4);
            g2.drawLine(lastX, lastY, x, y);
            lastX = x;
            lastY = y;
        }

        //绘制描述
        g2.setColor(Color.DARK_GRAY);
        g2.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        g2.drawString(describeText, 8, 24);
    }

    private double getMinX() {
        return dataPointsX.stream().min(Double::compareTo).orElse(0.0);
    }

    private double getMaxX() {
        return dataPointsX.stream().max(Double::compareTo).orElse(0.0);
    }

    private double getMinY() {
        return dataPointsY.stream().min(Double::compareTo).orElse(0.0);
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
    }
}
