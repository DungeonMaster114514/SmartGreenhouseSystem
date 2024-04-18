package com.ksamar.library.views;

import com.ksamar.library.controller.DashdoardController;
import com.ksamar.library.entity.Book;
import com.ksamar.library.entity.Dashdoard;
import com.ksamar.library.tools.color.Colour;
import com.ksamar.library.tools.dashdoard.DataTransition;
import com.ksamar.library.tools.dashdoard.LineChart;
import com.ksamar.library.tools.dashdoard.Tick;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * 借阅图书面板
 * @author KSaMar
 * @version 1.0
 */
public class BorrowView extends JPanel {

    /**
     * 属性
     */
    private Tick tickLeft1;
    private Tick tickLeft2;
    private Tick tickRight1;
    private Tick tickRight2;
    private LineChart lineChartTem;
    private LineChart lineChartHum;
    private LineChart lineChartLight;
    private LineChart lineChartSoilTem;
    private String tickLeftValue;
    private String tickLeft2Value;
    private String tickRightValue;
    private String tickRight2Value;

    /**
     * 面板
     */
    private JPanel tickPanel = new JPanel();

    /**
     * SwingWorker线程
     */
    private SwingWorker<Void,Void> worker;
    private DataTransition dataTransitionLeft1 = new DataTransition();
    private DataTransition dataTransitionLeft2 = new DataTransition();
    private DataTransition dataTransitionRight1 = new DataTransition();
    private DataTransition dataTransitionRight2 = new DataTransition();

    /**
     * 仪表盘显示面板
     */
    public BorrowView() {
        //设置仪表盘
        // 左一仪表盘(温度)
        setLayout(null);
        tickLeft1 = new Tick();
        tickLeft1.setForeground(Colour.C3C8CE7);
        tickLeft1.setType(Tick.RING_240);
        tickLeft1.setDescribe("实时温度");
        tickLeft1.setFrom(0);
        tickLeft1.setTo(150);
        tickLeft1.setMajor(15);
        tickLeft1.setMinor(1.5);
        tickLeft1.setBounds(0,0,100,100);

        // 左二仪表盘(湿度)
        tickLeft2 = new Tick();
        tickLeft2.setForeground(Colour.C3C8CE7);
        tickLeft2.setType(Tick.RING_240);
        tickLeft2.setDescribe("实时湿度");
        tickLeft2.setFrom(0);
        tickLeft2.setTo(200);
        tickLeft2.setMajor(20);
        tickLeft2.setMinor(2.0);

        // 右一仪表盘(光照强度)
        tickRight1 = new Tick();
        tickRight1.setForeground(Colour.C3C8CE7);
        tickRight1.setType(Tick.RING_240);
        tickRight1.setDescribe("实时光照强度");
        tickRight1.setFrom(0);
        tickRight1.setTo(2500);
        tickRight1.setMajor(500);
        tickRight1.setMinor(25);

        // 右二仪表盘(土壤湿度)
        tickRight2 = new Tick();
        tickRight2.setForeground(Colour.C3C8CE7);
        tickRight2.setType(Tick.RING_240);
        tickRight2.setDescribe("实时土壤湿度");
        tickRight2.setTo(4000);
        tickRight2.setMajor(800);
        tickRight2.setMinor(40);

        //仪表盘面板
        tickPanel.setBackground(Color.white);
        tickPanel.setBounds(0, 0, 960, 300);
        tickPanel.add(tickLeft1);
        tickPanel.add(tickLeft2);
        tickPanel.add(tickRight1);
        tickPanel.add(tickRight2);

        //温度折线图
        lineChartTem = new LineChart();
        lineChartTem.setBackground(Colour.FAFAFA);
        lineChartTem.setMaxY(150);
        lineChartTem.setyAxisInterval(150/6);
        lineChartTem.setBounds(16,300,960/2 - 16 * 2,210);
        lineChartTem.setDescribeText("温度折线图");
        lineChartTem.setLineColor(Colour.C5AB556);

        //光照强度
        lineChartLight = new LineChart();
        lineChartLight.setBackground(Colour.FAFAFA);
        lineChartLight.setMaxY(2500);
        lineChartLight.setyAxisInterval(2500/6);
        lineChartLight.setBounds(16 * 2 + (960/2 - 16 * 2),300,960/2 - 16 * 2,210);
        lineChartLight.setDescribeText("光照强度折线图");
        lineChartLight.setLineColor(Colour.CFAA64B);

        //湿度折线图
        lineChartHum = new LineChart();
        lineChartHum.setBackground(Colour.FAFAFA);
        lineChartHum.setMaxY(200);
        lineChartHum.setyAxisInterval(200/6);
        lineChartHum.setBounds(16,300 + 210 + 24,960/2 - 16 * 2,210);
        lineChartHum.setDescribeText("湿度折线图");
        lineChartHum.setLineColor(Colour.C3C8CE7);

        //土壤湿度
        lineChartSoilTem = new LineChart();
        lineChartSoilTem.setBackground(Colour.FAFAFA);
        lineChartSoilTem.setMaxY(4000);
        lineChartSoilTem.setyAxisInterval(4000/6);
        lineChartSoilTem.setBounds(16 * 2 + (960/2 - 16 * 2),300 + 210 + 24,960/2 - 16 * 2,210);
        lineChartSoilTem.setDescribeText("土壤湿度折线图");
        lineChartSoilTem.setLineColor(Colour.C5AB556);

        // 获取 仪表盘/折线图 数据
        dashdoardGet();

        // 创建SwingWorker线程,每隔一秒执行指定方法
         worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (!isCancelled()) {
                    // 每隔1秒执行指定方法
                    Thread.sleep(1000);
                    // 调用指定方法
                    doSomething();
                }
                return null;
            }
        };
        worker.execute();

        // 添加组件
//        add(borrowPanel);
        add(tickPanel);
        add(lineChartTem);
        add(lineChartLight);
        add(lineChartHum);
        add(lineChartSoilTem);

        // 面板设置
        setSize(960, 768);
        setBackground(Color.WHITE);
        setVisible(true);
        dashdoardRepaint();
    }

    /**
     * 设置仪表盘
     */
    private void setDashdoard(){
        //设置左一仪表盘数据
        tickLeft1.setValue(tickLeftValue);
        tickLeft1.setUnit("℃");

        //设置左二仪表盘数据
        tickLeft2.setValue(tickLeft2Value);
        tickLeft2.setUnit("%");

        //设置右一仪表盘数据
        tickRight1.setValue(tickRightValue);
        tickRight1.setUnit("Lux");

        //设置右二仪表盘数据
        tickRight2.setValue(tickRight2Value);
        tickRight2.setUnit("%");
    }

    /**
     * SwingWorker关闭
     */
    //关闭线程
    public void closeSwingWorker(){
        worker.cancel(true);
    }

    /**
     * 每0.05秒刷新面板线程并更新数据
     */
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    private void dashdoardRepaint(){
        new Thread(() -> {
            while (true) {
                repaint();
                dashdoardRefresh();
                try {
                    sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * SwingWorker每隔1秒执行的方法
     */
    private void doSomething(){
        dashdoardGet();
    }

    /**
     * 获取 仪表盘/折线图 数据
     */
    private void dashdoardGet(){
        //使老数据向新数据逐步变化
        List<Dashdoard> dashdoardList = DashdoardController.dashdoardMsg();
        Dashdoard dashdoard = dashdoardList.get(0);
        Dashdoard dashdoard_old;
        if (dashdoardList.size() > 1) {
            dashdoard_old = dashdoardList.get(1);
        }
        else {
            dashdoard_old = dashdoard;
        }

        dataTransitionLeft1.toNumber(Integer.parseInt(dashdoard_old.getTemperature()),Integer.parseInt(dashdoard.getTemperature()));
        dataTransitionLeft2.toNumber(Integer.parseInt(dashdoard_old.getHumidity()),Integer.parseInt(dashdoard.getHumidity()));
        dataTransitionRight1.toNumber(Integer.parseInt(dashdoard_old.getLightIntensity()),Integer.parseInt(dashdoard.getLightIntensity()));
        dataTransitionRight2.toNumber(Integer.parseInt(dashdoard_old.getSoilTemperature()),Integer.parseInt(dashdoard.getSoilTemperature()));

        //设置折线图数据
        lineChartTem.addDataPointsTem(dashdoardList);
        lineChartHum.addDataPointsHum(dashdoardList);
        lineChartLight.addDataPointsLight(dashdoardList);
        lineChartSoilTem.addDataPointsSoilTem(dashdoardList);
    }

    /**
     * 刷新仪表盘数据
     */
    private void dashdoardRefresh(){
        tickLeftValue = String.valueOf((int) dataTransitionLeft1.getCurrentValue());
        tickLeft2Value = String.valueOf((int) dataTransitionLeft2.getCurrentValue());
        tickRightValue = String.valueOf((int) dataTransitionRight1.getCurrentValue());
        tickRight2Value = String.valueOf((int) dataTransitionRight2.getCurrentValue());
        setDashdoard();
    }
}