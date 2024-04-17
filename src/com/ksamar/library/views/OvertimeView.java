package com.ksamar.library.views;

import com.ksamar.library.controller.book.BookController;
import com.ksamar.library.entity.Borrow;
import com.ksamar.library.tools.border.Borders;
import com.ksamar.library.tools.color.Colour;
import com.ksamar.library.tools.font.Fonts;
import com.ksamar.library.tools.image.Images;
import com.ksamar.library.tools.placeholder.Placeholder;
import com.ksamar.library.tools.table.LibraryTableModel;
import com.ksamar.library.views.book.ReturnBookView;
import com.ksamar.library.views.message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

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
    private JLabel weatherTextLabel = new JLabel();
    private JLabel weatherBgIcon = new JLabel();

    /**
     * 面板
     */
    private JScrollPane weatherPane = new JScrollPane();

    /**
     * 超时查询面板
     */
    public OvertimeView() {
        //天气背景图
        ImageIcon imageIcon = Images.weatherBgIcon;
        weatherBgIcon.setIcon(imageIcon);
        weatherBgIcon.setHorizontalAlignment(JLabel.CENTER);
        weatherBgIcon.setVerticalAlignment(JLabel.CENTER);

        // 天气信息面版
        weatherPane.setBounds(16,42, 464 - 8, 684);
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
