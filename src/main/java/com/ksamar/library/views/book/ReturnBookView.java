package com.ksamar.library.views.book;

import com.ksamar.library.tools.color.Colour;
import com.ksamar.library.tools.image.Images;
import com.ksamar.library.views.message.Message;

import java.util.Vector;

/**
 * 归还图书窗口
 * @author KSaMar
 * @version 1.0
 */
public class ReturnBookView extends Message {

    /**
     * 归还图书窗口
     */
    private static final ReturnBookView INSTANCE = new ReturnBookView();

    /**
     * 设置信息
     */
    public void setValue(Vector vector) {
        setVisible(true);
        setLocationRelativeTo(null);
        messageTextLabel.setText("确认归还 " + vector.get(1).toString() + " 图书吗？");
        confirmButton.setName(vector.get(0).toString());
    }

    /**
     * 获取归还图书窗口
     * @return 归还图书窗口
     */
    public static ReturnBookView getInstance() {
        return INSTANCE;
    }
}
