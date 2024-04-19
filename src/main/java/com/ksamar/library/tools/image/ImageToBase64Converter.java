package com.ksamar.library.tools.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Base64;

public class ImageToBase64Converter {
    public static String encodeImageToBase64(String imagePath) throws IOException {
        // 读取图片文件
        BufferedImage image = ImageIO.read(new File(imagePath));
        // 将图片转换为Base64编码的字符串
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bos);
        byte[] bytes = bos.toByteArray();
        return Base64.getEncoder().encodeToString(bytes);
    }

}