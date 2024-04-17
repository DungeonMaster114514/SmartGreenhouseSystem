package com.ksamar.library.tools.image;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * 图片
 * @author KSaMar
 * @version 1.0
 */
public class Images {
    /**
     * 图片地址
     */
    public static String url = "/com/ksamar/library/images/";

    /**
     * 图片声明
     */
    public static Image systemImage;
    public static Image closeButtonImage;
    public static ImageIcon closeButtonIcon;
    public static Image closeButtonHoverImage;
    public static ImageIcon closeButtonHoverIcon;
    public static Image hideButtonImage;
    public static ImageIcon hideButtonIcon;
    public static Image hideButtonHoverImage;
    public static ImageIcon hideButtonHoverIcon;
    public static ImageIcon homeIcon;
    public static ImageIcon homeFocusIcon;
    public static ImageIcon bookIcon;
    public static ImageIcon bookFocusIcon;
    public static ImageIcon borrowIcon;
    public static ImageIcon borrowFocusIcon;
    public static ImageIcon returnIcon;
    public static ImageIcon returnFocusIcon;
    public static ImageIcon overtimeIcon;
    public static ImageIcon overtimeFocusIcon;
    public static ImageIcon userIcon;
    public static ImageIcon userFocusIcon;
    public static ImageIcon systemIcon;
    public static ImageIcon systemFocusIcon;
    public static ImageIcon bookPaneIcon;
    public static ImageIcon borrowPaneIcon;
    public static ImageIcon overtimePaneIcon;
    public static ImageIcon timePaneIcon;
    public static ImageIcon errorIcon;
    public static ImageIcon successIcon;
    public static Image userImage;
    public static ImageIcon userImageIcon;
    public static Image arrowImage;
    public static Image arrowImageGreen;
    public static ImageIcon arrowIcon;
    public static ImageIcon arrowIconGreen;
    public static Image bgImage;
    public static Image weatherBgImage;
    public static ImageIcon weatherBgIcon;


    /**
     * 图片设置
     */
    static {

        systemImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "system.png"))).getImage();

        closeButtonImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "close_button.png"))).getImage();
        closeButtonIcon = new ImageIcon(closeButtonImage.getScaledInstance(20, 20 ,Image.SCALE_DEFAULT));

        closeButtonHoverImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "close_button_hover.png"))).getImage();
        closeButtonHoverIcon = new ImageIcon(closeButtonHoverImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        hideButtonImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "hide_button.png"))).getImage();
        hideButtonIcon = new ImageIcon(hideButtonImage.getScaledInstance(20, 20 ,Image.SCALE_DEFAULT));

        hideButtonHoverImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "hide_button_hover.png"))).getImage();
        hideButtonHoverIcon = new ImageIcon(hideButtonHoverImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT));

        homeIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "home.png")));
        homeFocusIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "home_focus.png")));

        bookIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "book.png")));
        bookFocusIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "book_focus.png")));

        borrowIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "borrow.png")));
        borrowFocusIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "borrow_focus.png")));

        returnIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "return.png")));
        returnFocusIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "return_focus.png")));

        overtimeIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "overtime.png")));
        overtimeFocusIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "overtime_focus.png")));

        userIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "user.png")));
        userFocusIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "user_focus.png")));

        systemIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "setting.png")));
        systemFocusIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "setting_focus.png")));

        bookPaneIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "book_pane.png")));
        borrowPaneIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "borrow_pane.png")));
        overtimePaneIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "overtime_pane.png")));
        timePaneIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "time_pane.png")));

        errorIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "error.png")));
        successIcon = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "success.png")));

        userImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "user_img.png"))).getImage();
        userImageIcon = new ImageIcon(userImage.getScaledInstance(150, 150 ,Image.SCALE_SMOOTH));

        arrowImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "right_arrow.png"))).getImage();
        arrowIcon = new ImageIcon(arrowImage.getScaledInstance(76, 85, Image.SCALE_SMOOTH));

        arrowImageGreen = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "right_arrow_green.png"))).getImage();
        arrowIconGreen = new ImageIcon(arrowImageGreen.getScaledInstance(76, 85, Image.SCALE_SMOOTH));

        weatherBgImage = new ImageIcon(Objects.requireNonNull(Images.class.getResource(url + "weather_bg.png"))).getImage();
        weatherBgIcon = new ImageIcon(weatherBgImage.getScaledInstance(464 - 16 * 2, 684 - 16 * 2 ,Image.SCALE_DEFAULT));
    }

    public static ImageIcon getImage(String url){
        //        不保存原始图片比例
        //        Image image = new ImageIcon(Objects.requireNonNull(url)).getImage();
        //        return new ImageIcon(image.getScaledInstance(456 -30, 425, Image.SCALE_DEFAULT));

        //        保存原始图片比例
        System.out.println(url);
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(url));
        Image image = originalIcon.getImage();
        int maxWidth = 456 - 30; // 最大宽度
        int maxHeight = 425; // 最大高度

        // 计算图片的原始宽高比
        double aspectRatio = (double) originalIcon.getIconWidth() / originalIcon.getIconHeight();

        // 根据比例计算新的宽度和高度
        int newWidth = maxWidth;
        int newHeight = (int) (maxWidth / aspectRatio);

        // 如果计算出的高度超过了最大允许的高度，则以高度为基准重新计算宽度
        if (newHeight > maxHeight) {
            newHeight = maxHeight;
            newWidth = (int) (maxHeight * aspectRatio);
        }

        // 获取缩放后的图像实例
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }
}
