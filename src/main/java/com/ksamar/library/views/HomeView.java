package com.ksamar.library.views;

import com.ksamar.library.controller.ImageController;
import com.ksamar.library.controller.log.LogController;
import com.ksamar.library.entity.ImageMsg;
import com.ksamar.library.entity.Log;
import com.ksamar.library.tools.color.Colour;
import com.ksamar.library.tools.font.Fonts;
import com.ksamar.library.tools.image.EasydlObjectDetection;
import com.ksamar.library.tools.image.Images;
import com.ksamar.library.tools.table.LibraryTableModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * 仪表盘信息
 * @author KSaMar
 * @version 1.0
 */
public class HomeView extends JPanel {

    /**
     * 属性
     */
    private int bookCount = 0;
    private int borrowCount = 0;
    private int overtimeCount = 0;
    private int currentIndex = 0;
    private Date dateTime = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private List<ImageMsg> imageList;

    /**
     * 文字
     */
    private String logText = "操作日志";

    /**
     * 面板
     */
    private JPanel detectionPanel = new JPanel();
    private JPanel bookPanel = new JPanel();
    private JPanel borrowPanel = new JPanel();
    private JPanel overtimePanel = new JPanel();
    private JPanel timePanel = new JPanel();
    private JPanel logPanel = new JPanel();
    private JScrollPane logScrollPane = new JScrollPane();

    /**
     * 标签
     */
    private JLabel bookIconLabel = new JLabel();
    private JLabel bookTextLabel = new JLabel();
    private JLabel bookCountLabel = new JLabel();
    private JLabel borrowIconLabel = new JLabel();
    private JLabel imageTimeLabel = new JLabel();
    private JLabel borrowCountLabel = new JLabel();
    private JLabel overtimeCountLabel = new JLabel();
    private JLabel timeValueLabel = new JLabel();
    private JLabel logTextLabel = new JLabel();

    /**
     * 表格
     */
    private JTable logTextTabel;
    private String[] name = {"日期/时间", "名字", "信息"};
    private Object[][] tableDate = new Object[0][0];
    private LibraryTableModel tableModel = new LibraryTableModel(tableDate, name);

    /**
     * 按钮
     */
    private JButton detectionButton = new JButton(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 设置抗锯齿渲染
            Graphics2D g2d = (Graphics2D) g;

            Map<RenderingHints.Key, Object> map = new HashMap<>();
            map.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHints(map);

            // 绘制文字
            g2d.setColor(Color.white);
            g2d.setFont(Fonts.button);
            FontMetrics fontMetrics = g2d.getFontMetrics();
            int textWidth = fontMetrics.stringWidth("检测");
            int xText = (getWidth()-textWidth)/2 - 5 ; // 文字的x坐标
            int yText = getHeight() / 2 + fontMetrics.getAscent() / 2 - 2; // 文字的y坐标
            g2d.drawString("检测", xText, yText);
        }
    };
    private JButton nextButton = new JButton();
    private JButton previousButton = new JButton();

    /**
     * 仪表盘窗体
     */
    public HomeView() {

        // 初始化
        init();

        // 下一张图片按钮
        nextButton.setText("下一张");
        nextButton.setBounds(310, 381, 100, 32);
        nextButton.setHorizontalAlignment(SwingConstants.CENTER);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(Fonts.button);
        nextButton.setBackground(Colour.C3C8CE7);
        nextButton.setFocusPainted(false);
        nextButton.setBorder(null);
        nextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nextButton.addActionListener(e -> nextButtonEvent());

        // 上一张图片按钮
        previousButton.setText("上一张");
        previousButton.setBounds(16, 381, 100, 32);
        previousButton.setHorizontalAlignment(SwingConstants.CENTER);
        previousButton.setForeground(Color.WHITE);
        previousButton.setFont(Fonts.button);
        previousButton.setBackground(Colour.C3C8CE7);
        previousButton.setFocusPainted(false);
        previousButton.setBorder(null);
        previousButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        previousButton.addActionListener(e -> previousButtonEvent());

//        // 图书数量图标
//        bookIconLabel.setIcon(Images.bookPaneIcon);
//        bookIconLabel.setBounds(16, 36, 128, 128);

        //左面板显示未检测的图片
        //显示图片
        imageList = ImageController.imageGetMsg();
        ImageMsg msg = imageList.get(currentIndex);
        ImageIcon imageIcon = Images.getImage(msg.getUrl());
        bookIconLabel.setIcon(imageIcon);
        bookIconLabel.setBounds((456-30-imageIcon.getIconWidth())/2, 0, 456-30, 425);

        //图片获取时间标签
        imageTimeLabel.setText(msg.getAdd_time());
        imageTimeLabel.setBounds(144, 0, 274, 40);
        imageTimeLabel.setFont(Fonts.time);
        imageTimeLabel.setForeground(Colour.C5AB556);
        imageTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // 显示未检测图片面板
        bookPanel.setLayout(null);
        bookPanel.setBounds(16, 16, 456 -30, 425);//200
        bookPanel.setBackground(Colour.F0F0F0Plus);
        bookPanel.add(nextButton);
        bookPanel.add(imageTimeLabel);
        bookPanel.add(detectionButton);
        bookPanel.add(previousButton);
        bookPanel.add(bookIconLabel);
        bookPanel.add(bookTextLabel);
        bookPanel.add(bookCountLabel);

        //检测按钮
        ImageIcon icon = Images.arrowIcon;
        detectionButton.setIcon(icon);
        detectionButton.setBounds(0, 170, icon.getIconWidth(), icon.getIconHeight());
        detectionButton.setHorizontalAlignment(SwingConstants.CENTER);
        detectionButton.setFont(Fonts.button);
        detectionButton.setOpaque(false);
        detectionButton.setContentAreaFilled(false);
        detectionButton.setBorderPainted(false);
        detectionButton.setFocusPainted(false);
        detectionButton.setBorder(null);
        detectionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        detectionButton.addActionListener(e -> detectionImage());

        //检测面板
        detectionPanel.setLayout(null);
        detectionPanel.setBounds(456 - 10 , 16, 80, 425);//200
        detectionPanel.setBackground(Color.white);
        detectionPanel.add(detectionButton);

        // 借阅图书数量图标

        borrowIconLabel.setIcon(Images.borrowPaneIcon);
        borrowIconLabel.setBounds((456-20-imageIcon.getIconWidth())/2, 0 , 456-30, 425);

        // 显示检测后图片面板
        borrowPanel.setLayout(null);
        borrowPanel.setBounds(488 + 30,16 , 456 - 30, 425);
        borrowPanel.setBackground(Colour.F0F0F0Plus);
        borrowPanel.add(borrowIconLabel);

        // 日志信息文本
        logTextLabel.setText(logText);
        logTextLabel.setBounds(0, 0, 928, 32);
        logTextLabel.setFont(Fonts.subTitle);
        logTextLabel.setForeground(Color.BLACK);

        // 日志信息表格
        logTextTabel = new JTable(tableModel);
        logTextTabel.setRowHeight(32);
        logTextTabel.setBounds(0, 0, 928, 272);
        logTextTabel.getColumnModel().getColumn(0).setPreferredWidth(120);
        logTextTabel.getColumnModel().getColumn(1).setPreferredWidth(120);
        logTextTabel.getColumnModel().getColumn(2).setPreferredWidth(688);
        logTextTabel.getTableHeader().setReorderingAllowed(false);
        logTextTabel.getTableHeader().setResizingAllowed(false);

        // 日志信息面板
        logScrollPane.setViewportView(logTextTabel);
        logScrollPane.setBounds(0, 32, 928,272);

        // 日志面板
        logPanel.setLayout(null);
        logPanel.setBounds(16, 448, 928, 304);
        logPanel.setBackground(Color.WHITE);
        logPanel.add(logTextLabel);
        logPanel.add(logScrollPane);

        // 添加组件
        add(bookPanel);
        add(detectionPanel);
        add(borrowPanel);
        add(overtimePanel);
        add(timePanel);
        add(logPanel);

        // 窗体设置
        setSize(960, 768);
        setLayout(null);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    /**
     * 初始化
     */
    public void init() {
        // 面板初始化
        setTime();

        // 设置标签
        bookCountLabel.setText(String.valueOf(bookCount));
        borrowCountLabel.setText(String.valueOf(borrowCount));
        overtimeCountLabel.setText(String.valueOf(overtimeCount));

        // 添加日志信息
        tableModel.setDataVector(tableDate, name);
        List<Log> logMessage = LogController.getLogMessage();
        tableModel.addLogRow(logMessage);
    }

    /**
     * 时间设置
     */
    @SuppressWarnings("AlibabaAvoidManuallyCreateThread")
    public void setTime() {
        new Thread(() -> {
            while (true) {
                dateTime = new Date();
                timeValueLabel.setText(simpleDateFormat.format(dateTime));
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 按钮事件
     */
    public void nextButtonEvent(){
        nextImage();
    }

    public void previousButtonEvent(){
        previousImage();
    }

    //下一张图片
    public void nextImage(){
        recoverImage();
        imageList = ImageController.imageGetMsg();
        if (currentIndex >= imageList.size()){
            return;
        }
        if (currentIndex < imageList.size() - 1){
            currentIndex ++;
        }
        ImageMsg msg = imageList.get(currentIndex);
        ImageIcon imageIcon = Images.getImage(msg.getUrl());
        bookIconLabel.setIcon(imageIcon); //下一张图
        imageTimeLabel.setText(msg.getAdd_time()); //图的时间
        bookIconLabel.setBounds((456-30-imageIcon.getIconWidth())/2, 0, 456-30, 425);

        //使检测结果消失
        borrowIconLabel.setIcon(Images.borrowPaneIcon);
        borrowIconLabel.setBounds((456-20-imageIcon.getIconWidth())/2, 0 , 456-30, 425);
        bookPanel.repaint();
    }

    //上一张图片
    public void previousImage(){
        recoverImage();
        imageList = ImageController.imageGetMsg();
        if (currentIndex > 0){
            currentIndex --;
        }

        ImageMsg msg = imageList.get(currentIndex);
        ImageIcon imageIcon = Images.getImage(msg.getUrl());
        bookIconLabel.setIcon(imageIcon); //上一张图
        imageTimeLabel.setText(msg.getAdd_time()); //图的时间
        bookIconLabel.setBounds((456-30-imageIcon.getIconWidth())/2, 0, 456-30, 425);

        //使检测结果消失
        borrowIconLabel.setIcon(Images.borrowPaneIcon);
        borrowIconLabel.setBounds((456-20-imageIcon.getIconWidth())/2, 0 , 456-30, 425);
        bookPanel.repaint();
    }

    public void detectionImage(){
        ImageIcon icon = Images.arrowIconGreen;
        detectionButton.setIcon(icon);
        detectionButton.setBounds(0, 170, icon.getIconWidth(), icon.getIconHeight());

        //生成检测后图片
        String url = imageList.get(currentIndex).getUrl();
        EasydlObjectDetection.getResultImg(url,imageList.get(currentIndex).getId());

        //显示检测后的图片
        displayDetectionResult();

        //在数据库设置状态为检测后
        ImageController.imageAlterMsg(imageList.get(currentIndex).getId());
    }

    public void displayDetectionResult(){
        String url = "D:\\BaiduNetdiskDownload\\data\\valid\\detection\\train4_0300_detected" + imageList.get(currentIndex).getId() +".jpg";
        ImageIcon icon = Images.getImage(url);
        borrowIconLabel.setIcon(icon);
        borrowIconLabel.setBounds((456-20-icon.getIconWidth())/2, 0 , 456-30, 425);
    }

    //使检测按钮恢复原状
    public void recoverImage(){
        ImageIcon icon = Images.arrowIcon;
        detectionButton.setIcon(icon);
        detectionButton.setBounds(0, 170, icon.getIconWidth(), icon.getIconHeight());
    }
}
