package com.ksamar.library.views;

import com.ksamar.library.tools.border.Borders;
import com.ksamar.library.tools.color.Colour;
import com.ksamar.library.tools.font.Fonts;
import com.ksamar.library.tools.image.Images;
import com.ksamar.library.tools.popupmenu.Menu;
import com.ksamar.library.tools.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
/**
 * 管理员窗体
 * @author KSaMar
 * @version 1.0
 */
public class AdminView extends JFrame {

    /**
     * 文字
     */
    private String titleText = "智慧大棚系统";
    private String subTitleText = "主页";
    private String homeText = "病虫害检测";
    private String borrowText = "数据监测";
    private String overtimeText = "主页";
    private String userText = "用户管理";
    private String systemText = "系统管理";

    /**
     * 标签
     */
    private JLabel titleLabel = new JLabel();
    private JLabel subTitleLabel = new JLabel();
    private JLabel homeIconLabel = new JLabel();
    private JLabel homeTextLabel = new JLabel();
    private JLabel bookIconLabel = new JLabel();
    private JLabel bookTextLabel = new JLabel();
    private JLabel borrowIconLabel = new JLabel();
    private JLabel borrowTextLabel = new JLabel();
    private JLabel returnIconLabel = new JLabel();
    private JLabel returnTextLabel = new JLabel();
    private JLabel overtimeIconLabel = new JLabel();
    private JLabel overtimeTextLabel = new JLabel();
    private JLabel userIconLabel = new JLabel();
    private JLabel userTextLabel = new JLabel();
    private JLabel systemIconLabel = new JLabel();
    private JLabel systemTextLabel = new JLabel();

    /**
     * 按钮
     */
    private JButton hideButton = new JButton();
    private JButton closeButton = new JButton();
    private JButton homeButton = new JButton();
    private JButton borrowButton = new JButton();
    private JButton overtimeButton = new JButton();
    private JButton userButton = new JButton();
    private JButton systemButton = new JButton();

    /**
     * 面板
     */
    private JPanel navPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JPanel viewPanel = new JPanel();
    private HomeView homeView = new HomeView();
    private BorrowView borrowView = new BorrowView();
    private OvertimeView overtimeView = new OvertimeView();
    private UserView userView = new UserView();
    private SystemView systemView = new SystemView();

    /**
     * 布局
     */
    CardLayout cardLayout;

    /**
     * 管理员窗体
     */
    public AdminView() {

        // 副标题
        subTitleLabel.setText(subTitleText);
        subTitleLabel.setBounds(8, 0, 240, 32);
        subTitleLabel.setFont(Fonts.subTitle);

        // 最小化按钮
        hideButton.setIcon(Images.hideButtonIcon);
        hideButton.setRolloverIcon(Images.hideButtonHoverIcon);
        hideButton.setBounds(906, 6, 20, 20);
        hideButton.setOpaque(false);
        hideButton.setContentAreaFilled(false);
        hideButton.setFocusPainted(false);
        hideButton.setBorder(null);
        hideButton.addActionListener(e -> setState(Frame.ICONIFIED));

        // 关闭按钮
        closeButton.setIcon(Images.closeButtonIcon);
        closeButton.setRolloverIcon(Images.closeButtonHoverIcon);
        closeButton.setBounds(934, 6, 20, 20);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setBorder(null);
        closeButton.addActionListener(e -> System.exit(0));

        // 顶部栏
        topPanel.setLayout(null);
        topPanel.setBounds(240, 0,960, 32);
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(Borders.topPanelBorder);
        topPanel.add(subTitleLabel);
        topPanel.add(hideButton);
        topPanel.add(closeButton);

        // 标题
        titleLabel.setText(titleText);
        titleLabel.setBounds(0, 24, 240, 30);
        titleLabel.setFont(Fonts.title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 主页按钮
        overtimeButton.setLayout(null);
        overtimeButton.setBounds(0, 80, 240, 48);
        overtimeButton.setForeground(Color.white);
        overtimeButton.setFont(Fonts.menuButton);
        overtimeButton.setBackground(Color.WHITE);
        overtimeButton.setFocusPainted(false);
        overtimeButton.setBorder(null);
        overtimeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        overtimeButton.addFocusListener(addFocus(overtimeButton));
        overtimeIconLabel.setIcon(Images.overtimeFocusIcon);
        overtimeIconLabel.setBounds(16,0, 48, 48);
        overtimeTextLabel.setText(overtimeText);
        overtimeTextLabel.setFont(Fonts.menuButton);
        overtimeTextLabel.setForeground(Colour.C3C8CE7);
        overtimeTextLabel.setBounds(72, 0, 160, 48);
        overtimeButton.add(overtimeIconLabel);
        overtimeButton.add(overtimeTextLabel);

        //y差56

        // 数据监测按钮
        borrowButton.setLayout(null);
        borrowButton.setBounds(0, 192 - 56, 240, 48);
        borrowButton.setForeground(Color.WHITE);
        borrowButton.setFont(Fonts.menuButton);
        borrowButton.setBackground(Colour.C3C8CE7);
        borrowButton.setFocusPainted(false);
        borrowButton.setBorder(null);
        borrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        borrowButton.addFocusListener(addFocus(borrowButton));
        borrowIconLabel.setIcon(Images.borrowIcon);
        borrowIconLabel.setBounds(16,0, 48, 48);
        borrowTextLabel.setText(borrowText);
        borrowTextLabel.setFont(Fonts.menuButton);
        borrowTextLabel.setForeground(Color.WHITE);
        borrowTextLabel.setBounds(72, 0, 160, 48);
        borrowButton.add(borrowIconLabel);
        borrowButton.add(borrowTextLabel);

        // 病虫害检测按钮
        homeButton.setLayout(null);
        homeButton.setBounds(0, 304 - 56 * 2, 240, 48);
        homeButton.setForeground(Colour.C3C8CE7);
        homeButton.setFont(Fonts.menuButton);
        homeButton.setBackground(Colour.C3C8CE7);
        homeButton.setFocusPainted(false);
        homeButton.setBorder(null);
        homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        homeButton.addFocusListener(addFocus(homeButton));
        homeIconLabel.setIcon(Images.homeIcon);
        homeIconLabel.setBounds(16,0, 48, 48);
        homeTextLabel.setText(homeText);
        homeTextLabel.setFont(Fonts.menuButton);
        homeTextLabel.setForeground(Color.WHITE);
        homeTextLabel.setBounds(72, 0, 160, 48);
        homeButton.add(homeIconLabel);
        homeButton.add(homeTextLabel);

        // 用户管理按钮
        userButton.setLayout(null);
        userButton.setBounds(0, 360 - 56 * 2, 240, 48);
        userButton.setForeground(Color.WHITE);
        userButton.setFont(Fonts.menuButton);
        userButton.setBackground(Colour.C3C8CE7);
        userButton.setFocusPainted(false);
        userButton.setBorder(null);
        userButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        userButton.addFocusListener(addFocus(userButton));
        userIconLabel.setIcon(Images.userIcon);
        userIconLabel.setBounds(16,0, 48, 48);
        userTextLabel.setText(userText);
        userTextLabel.setFont(Fonts.menuButton);
        userTextLabel.setForeground(Color.WHITE);
        userTextLabel.setBounds(72, 0, 160, 48);
        userButton.add(userIconLabel);
        userButton.add(userTextLabel);

        // 系统管理按钮
        systemButton.setLayout(null);
        systemButton.setBounds(0, 416 - 56 * 2, 240, 48);
        systemButton.setForeground(Color.WHITE);
        systemButton.setFont(Fonts.menuButton);
        systemButton.setBackground(Colour.C3C8CE7);
        systemButton.setFocusPainted(false);
        systemButton.setBorder(null);
        systemButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        systemButton.addFocusListener(addFocus(systemButton));
        systemIconLabel.setIcon(Images.systemIcon);
        systemIconLabel.setBounds(16,0, 48, 48);
        systemTextLabel.setText(systemText);
        systemTextLabel.setFont(Fonts.menuButton);
        systemTextLabel.setForeground(Color.WHITE);
        systemTextLabel.setBounds(72, 0, 160, 48);
        systemButton.add(systemIconLabel);
        systemButton.add(systemTextLabel);

        // 导航面板
        navPanel.setLayout(null);
        navPanel.setBounds(0, 0, 240, 800);
        navPanel.setBackground(Colour.C3C8CE7);
        navPanel.add(titleLabel);
        navPanel.add(homeButton);
        navPanel.add(borrowButton);
        navPanel.add(overtimeButton);
        navPanel.add(userButton);
        navPanel.add(systemButton);

        // 视图面板
        viewPanel.setBounds(240, 32, 960, 768);
        viewPanel.setBackground(Color.PINK);
        viewPanel.setLayout(new CardLayout());
        viewPanel.add(overtimeView, overtimeText);
        viewPanel.add(borrowView, borrowText);
        viewPanel.add(homeView, homeText);
        viewPanel.add(userView, userText);
        viewPanel.add(systemView, systemText);

        // 视图设置
        cardLayout = (CardLayout) (viewPanel.getLayout());

        // 添加组件
        add(navPanel);
        add(topPanel);
        add(viewPanel);

        // 窗体设置
        setTitle("智慧大棚系统-管理员");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setLayout(null);
        setFocusable(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setIconImage(Images.systemImage);
        View.setMoveFrame(this);

        // 添加任务栏图标
        try {
            Menu.setIcon(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSubTitleText(JButton button){
        subTitleText = ((JLabel) button.getComponent(1)).getText();
    }

    /**
     * 菜单按钮事件
     * @param button 菜单按钮
     * @return FocusListener
     */
    public FocusListener addFocus(JButton button) {
        return new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                button.setBackground(Color.WHITE);
                JLabel icon = (JLabel) button.getComponent(0);
                JLabel label = (JLabel) button.getComponent(1);
                String labelText = label.getText();
                label.setForeground(Colour.C3C8CE7);

                // 切换按钮样式
                switch (labelText) {
                    case "主页":
                        icon.setIcon(Images.overtimeFocusIcon);
                        break;
                    case "数据监测":
                        icon.setIcon(Images.borrowFocusIcon);
                        break;
                    case "病虫害检测":
                        icon.setIcon(Images.homeFocusIcon);
                        homeView.init();
                        break;
                    case "用户管理":
                        icon.setIcon(Images.userFocusIcon);
                        break;
                    case "系统管理":
                        icon.setIcon(Images.systemFocusIcon);
                        break;
                    default:
                        break;
                }

                // 设置副标题
                subTitleLabel.setText(labelText);
                // 判断第一次点击的是否是病虫害检测按钮
                if (!labelText.equals(overtimeText)) {
                    overtimeView.setVisible(false);
                    overtimeIconLabel.setIcon(Images.overtimeIcon);
                    overtimeButton.setBackground(Colour.C3C8CE7);
                    overtimeTextLabel.setForeground(Color.WHITE);
                }

                // 切换面板
                cardLayout.show(viewPanel, labelText);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JLabel icon = (JLabel) button.getComponent(0);
                JLabel label = (JLabel) button.getComponent(1);
                String labelText = label.getText();
                button.setBackground(Colour.C3C8CE7);
                label.setForeground(Color.WHITE);

                // 切换按钮样式
                switch (labelText) {
                    case "主页":
                        icon.setIcon(Images.overtimeIcon);
                        break;
                    case "数据监测":
                        icon.setIcon(Images.borrowIcon);
                        break;
                    case "病虫害检测":
                        icon.setIcon(Images.homeIcon);
                        break;
                    case "用户管理":
                        icon.setIcon(Images.userIcon);
                        break;
                    case "系统管理":
                        icon.setIcon(Images.systemIcon);
                        break;
                    default:
                        break;
                }
            }
        };
    }
}
