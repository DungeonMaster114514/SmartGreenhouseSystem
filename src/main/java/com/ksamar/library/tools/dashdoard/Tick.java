package com.ksamar.library.tools.dashdoard;

import com.ksamar.library.tools.color.Colour;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 刻度盘
 * @author xdoc
 */
public class Tick extends JPanel{
    private static final int VALUE_FONT_SIZE = 18;
    private double from = 0;
    private double to = 10;
    private String type = "line";
    private double major = 1; //设置小竖线间隙
    private double minor = 0.1; //设置大竖线间隙
    private String value = "";
    private String unit = "";
    private String describe = "仪表盘描述";

    public double getFrom() {
        return from;
    }

    public Tick() {
        this.setPreferredSize(new Dimension(220 + 5, 240));
        this.setBackground(Color.WHITE);
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getMajor() {
        return major;
    }

    public void setMajor(double major) {
        this.major = major;
    }

    public double getMinor() {
        return minor;
    }

    public void setMinor(double minor) {
        this.minor = minor;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    /**
     * 240度圆环
     */
    public static final String RING_240 = "ring240";

    /**
     * 圆盘
     */
    public static final String CIRCLE = "circle";

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void paintComponent(Graphics g) {
        double w = this.getWidth() - 10;
        double h = this.getHeight() + 10; //设置仪表盘在面板单元格中的位置，值越大位置越低
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.getBackground());
        g2.fillRect(0, 0, (int) w, (int) h);
        g2.setColor(this.getForeground());
        g2.setStroke(new BasicStroke(1));
        int fontSize = 14;
        g2.setFont(new Font(Font.SERIF, Font.PLAIN, fontSize));
        if (major <= 0) {
            major = to - from;
        }
        if (to > from) {
            if (type.startsWith("ring") || type.equals("circle")) {
                //设置表盘
                g2.setColor(Color.blue);

                double angle;
                double angleStart;
                if (type.equals("circle")) {
                    angle = 360;
                    angleStart = Math.PI / 2;
                } else {
                    angle = toDouble(type.substring(4));
                    angleStart = (180 + (angle - 180) / 2) / 180 * Math.PI;
                }
                double r = angle <= 180 ? Math.min(w / 2, h) : Math.min(w / 2, h / 2);
                double voff = angle <= 180 ? 0 : r;
                double dunit = (angle / 180 * Math.PI) / (to - from);

                //控制属性绘制间隙
                for (int i = 0; i <= (to - from) / major; i++) {
                    g2.draw(new Line2D.Double(Math.cos(angleStart - i * major * dunit) * r + w / 2, h - voff - Math.sin(angleStart - i * major * dunit) * r,
                            Math.cos(angleStart - i * major * dunit) * r * 0.75 + w / 2, h - voff - Math.sin(angleStart - i * major * dunit) * r * 0.75));
                    if (minor > 0 && i < (to - from) / major) {
                        for (int j = 1; j < major / minor; j++) {
                            if (i * major + j * minor < to - from) {
                                g2.draw(new Line2D.Double(Math.cos(angleStart - (i * major + j * minor) * dunit) * r + w / 2, h - voff - Math.sin(angleStart - (i * major + j * minor) * dunit) * r,
                                        Math.cos(angleStart - (i * major + j * minor) * dunit) * r * 0.875 + w / 2, h - voff - Math.sin(angleStart - (i * major + j * minor) * dunit) * r * 0.875));
                            }
                        }
                    }
                }

                //设置指针
                g2.setColor(Color.red);

                if (value.length() > 0) {
                    double val = toDouble(value);
                    GeneralPath p = new GeneralPath();
                    p.moveTo(Math.cos(angleStart - (val - from) * dunit) * r * 0.875 + w / 2, h - voff - Math.sin(angleStart - (val - from) * dunit) * r * 0.875);
                    p.lineTo(Math.cos(angleStart - (val - from) * dunit + Math.PI * 0.5) * 2 + w / 2, h - voff - Math.sin(angleStart - (val - from) * dunit + Math.PI * 0.5) * 2);
                    p.lineTo(Math.cos(angleStart - (val - from) * dunit - Math.PI * 0.5) * 2 + w / 2, h - voff - Math.sin(angleStart - (val - from) * dunit - Math.PI * 0.5) * 2);
                    p.closePath();
                    g2.fill(p);
                }
            }
        }

        //设置仪表盘字体颜色
        g2.setColor(Colour.C32A100);

        if (to > from) {
            if (major > 0) {
                if (type.startsWith("ring") || type.equals("circle")) {
                    double angle;
                    double angleStart;
                    if (type.equals("circle")) {
                        angle = 360;
                        angleStart = Math.PI / 2;
                    } else {
                        angle = toDouble(type.substring(4));
                        angleStart = (180 + (angle - 180) / 2) / 180 * Math.PI;
                    }
                    double r = angle <= 180 ? Math.min(w / 2, h) : Math.min(w / 2, h / 2);
                    double voff = angle <= 180 ? 0 : r;
                    double dunit = (angle / 180 * Math.PI) / (to - from);
                    int xoff = 0;
                    int yoff = 0;
                    double strAngle;
                    for (int i = type.equals("circle") ? 1 : 0; i <= (to - from) / major; i++) {
                        String str;
                        str = format(from + i * major);
                        strAngle = (angleStart - i * major * dunit + Math.PI * 2) % (Math.PI * 2);
                        xoff = 0;
                        yoff = 0;
                        if (strAngle >= 0 && strAngle < Math.PI * 0.25) {
                            xoff = (int) -getStrBounds(g2, str).getWidth();
                            yoff = fontSize / 2;
                            if (strAngle == 0 && angle == 180) {
                                yoff = 0;
                            }
                        } else if (near(strAngle, Math.PI * 0.5)) {
                            xoff = (int) -getStrBounds(g2, str).getWidth() / 2;
                            yoff = fontSize;
                        } else if (strAngle >= Math.PI * 0.25 && strAngle < Math.PI * 0.5) {
                            xoff = (int) -getStrBounds(g2, str).getWidth();
                            yoff = fontSize;
                        } else if (strAngle >= Math.PI * 0.5 && strAngle < Math.PI * 0.75) {
                            yoff = fontSize;
                        } else if (strAngle >= Math.PI * 0.75 && strAngle < Math.PI) {
                            yoff = fontSize / 2;
                        } else if (near(strAngle, Math.PI)) {
                            xoff = 1;
                            yoff = fontSize / 2;
                            if (angle == 180) {
                                yoff = 0;
                            }
                        } else if (strAngle >= Math.PI && strAngle < Math.PI * 1.25) {
                            yoff = fontSize / 4;
                        } else if (near(strAngle, Math.PI * 1.5)) {
                            xoff = (int) -getStrBounds(g2, str).getWidth() / 2;
                        } else if (strAngle >= Math.PI * 1.5 && strAngle < Math.PI * 2) {
                            xoff = (int) -getStrBounds(g2, str).getWidth();
                        }
                        g2.drawString(str, (int) (Math.cos(strAngle) * r * 0.75 + w / 2) + xoff, (int) (h - voff - Math.sin(strAngle) * r * 0.75) + yoff);
                    }
                    g2.setFont(new Font("", Font.BOLD, VALUE_FONT_SIZE));
                    if (value.length() > 0) {
                        voff = angle <= 180 ? 10 : r - fontSize / 2;
                        drawValue(g2, value + unit, (int) (w / 2 - getStrBounds(g2, value).getWidth() / 2), (int) (h - voff) + 30);
                        drawDescribe( g2, describe);
                    }
                }
            }
        }
    }

    private void drawValue(Graphics2D g2, String value, int x, int y) {
        g2.setFont(new Font(Font.SERIF, Font.BOLD, VALUE_FONT_SIZE));
        g2.drawString(value, x - 10, y);
    }

    //仪表盘描述
    public void drawDescribe(Graphics2D g2, String describe) {
        g2.setColor(Color.DARK_GRAY);
        g2.setFont(new Font(Font.SERIF, Font.BOLD, VALUE_FONT_SIZE));
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(describe)) / 2;
        g2.drawString(describe, x , 220);
    }

    private String format(double d) {
        if ((int) d == d) {
            return String.valueOf((int) d);
        } else {
            return String.valueOf(d);
        }
    }

    private double toDouble(String string) {
        try {
            return Double.valueOf(string);
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean near(double d1, double d2) {
        return Math.round(d1 * 1000000) == Math.round(d2 * 1000000);
    }

    private static Rectangle2D getStrBounds(Graphics2D g, String str) {
        Font f = g.getFont();
        Rectangle2D rect = f.getStringBounds(str, g.getFontRenderContext());
        if (rect.getHeight() < f.getSize()) {
            rect.setFrame(rect.getX(), rect.getY(), rect.getWidth(), f.getSize() + 1);
        }
        return rect;
    }
}