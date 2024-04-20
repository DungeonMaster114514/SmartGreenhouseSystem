package com.ksamar.library.tools.image;

import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.GsonUtils;
import java.io.IOException;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.ksamar.library.controller.ImageController;
import com.ksamar.library.entity.ImageMsg;
import org.json.JSONException;
import org.json.JSONObject;
/**
* easydl物体检测
*/
public class EasydlObjectDetection {
	

    /**
    * 重要提示代码中所需工具类
    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
    * 下载
    */
    public static String easydlObjectDetection(String base64Image) {
        // 请求url
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/detection/strawberryDec";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", base64Image);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.3bbbc01680c13bc7cffed8b87e3560ff.2592000.1715428145.282335-60899602";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    public static BufferedImage drawDetectionResults(BufferedImage originalImage, JSONObject detectionResults) throws JSONException {
        Graphics2D graphics = originalImage.createGraphics();
        
     // 创建一个BasicStroke对象，设置边框粗细为4.0f
        Stroke stroke = new BasicStroke(6.0f); // 4.0f 是边框粗细
        graphics.setStroke(stroke);
        Font font = new Font("宋体", Font.BOLD, 30);
     // 设置绘制文本时的字体
        graphics.setFont(font);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // 假设检测结果中包含物体的边界框坐标
        for (int i = 0; i < detectionResults.getJSONArray("results").length(); i++) {
            JSONObject box = detectionResults.getJSONArray("results").getJSONObject(i).getJSONObject("location");
            JSONObject  resultObject = detectionResults.getJSONArray("results").getJSONObject(i);
            String objectName = resultObject.getString("name");
            double objectScore = resultObject.getDouble("score");
            String objectScoreStr = String.format("%.4f", objectScore); // 格式化为字符串，保留四位小数
             //根据objectName的值进行替换
            int x = box.getInt("left");
            int y = box.getInt("top");
            int width = box.getInt("width");
            int height = box.getInt("height");
         // 获取物体名称
            // 计算文本绘制的位置
            FontMetrics fm = graphics.getFontMetrics();
            int textWidth = fm.stringWidth(objectName);
            int textHeight = fm.getHeight();
            int textX = x + 5;
            int textY = y-5; // 文本底部与边界框顶部的距离
            switch (objectName) {
            case "flower":
                objectName = "花";
                graphics.setColor(Color.red); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 3);
                break;
            case "health":
                objectName = "健康";
                graphics.setColor(new Color(255, 192, 203)); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 4);
                break;
            case "ripe":
                objectName = "熟果";
                graphics.setColor(Color.orange); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 4);
                break;
            case "fruit":
                objectName = "果实";
                graphics.setColor(new Color(135, 206, 235)); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 4);
                break;
            case "fertilizer":
                objectName = "缺肥";
                graphics.setColor(new Color(255, 215, 0)); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 4);
                break;
            case "powdery":
                objectName = "白粉病";
                graphics.setColor(new Color(37, 147, 246)); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 4);
                break;
            case "acalcerosis":
                objectName = "缺钙";
                graphics.setColor(new Color(186, 84,76)); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 4);
                break;
            case "greyleaf":
                objectName = "叶斑病";
                graphics.setColor(new Color(64, 224, 208)); // 边界框颜色
                graphics.drawRect(x, y, width, height);
                graphics.fillRect(textX, textY - textHeight, textWidth + 90, textHeight + 4);
                break;
            // 保留原始objectName值的其他情况
            default:
                break;
        }
            graphics.setColor(Color.WHITE); // 文本颜色
            graphics.drawString(objectName, textX, textY);
            graphics.drawString(objectScoreStr, textX + 100, textY); // 假设分数文本紧接着名称文本
        }
            graphics.dispose(); // 释放资源
        return originalImage;
    }

    public static void getResultImg(String url,int id){
        String imagePath = url; // 图片的路径
        try {
            String base64Image = ImageToBase64Converter.encodeImageToBase64(imagePath);
            String result = EasydlObjectDetection.easydlObjectDetection(base64Image);
            // 解析API返回的JSON结果
            JSONObject detectionResults = new JSONObject(result);
            BufferedImage annotatedImage = drawDetectionResults(ImageIO.read(new File(imagePath)), detectionResults);
            // 保存带有边界框的图像
            ImageIO.write(annotatedImage, "jpg", new File("D:\\BaiduNetdiskDownload\\data\\valid\\detection\\train4_0300_detected.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //在数据库设置状态为检测后
        ImageController.imageAlterMsg(id);
    }

    public static void main(String[] args) throws JSONException {
        List<ImageMsg> imageList = ImageController.imageGetMsg();
        ImageMsg msg = imageList.get(5);
    	 String imagePath = msg.getUrl(); // 图片的路径
    	 try {
    	        String base64Image = ImageToBase64Converter.encodeImageToBase64(imagePath);
    	        String result = EasydlObjectDetection.easydlObjectDetection(base64Image);
    	        // 解析API返回的JSON结果
                JSONObject detectionResults = new JSONObject(result);
                BufferedImage annotatedImage = drawDetectionResults(ImageIO.read(new File(imagePath)), detectionResults);
                // 保存带有边界框的图像
                ImageIO.write(annotatedImage, "jpg", new File("D:\\BaiduNetdiskDownload\\data\\valid\\detection\\train4_0300_detected.jpg"));   
    	 } catch (IOException e) {
    	        e.printStackTrace();
         }
    }
}