package com.ksamar.library.tools.sensor;// 导入Eclipse Paho MQTT客户端库，用于MQTT通信
import org.eclipse.paho.client.mqttv3.*;



// 定义一个名为MqttImageReceiver的类，实现了MqttCallback接口
public class MqttImageReceiver implements MqttCallback {
    // 定义一个MqttClient类型的成员变量，用于MQTT通信
    private MqttClient client;

    //摄像机编号
    private int cameraNum = 0;

    // 构造函数，初始化MQTT客户端并连接到指定的代理
    public MqttImageReceiver(String broker) throws MqttException {
        // 创建一个新的MqttClient实例，使用提供的代理地址和客户端ID
        client = new MqttClient(broker,MqttClient.generateClientId());
        // 设置回调接口，当MQTT事件发生时，会调用这个接口的方法
        client.setCallback(this);
        // 创建MqttConnectOptions实例，设置连接选项
        MqttConnectOptions connOpts = new MqttConnectOptions();
        // 设置清除会话标志为true，表示每次断开连接后清除所有消息
        connOpts.setCleanSession(true);
        // 连接到MQTT代理
        client.connect(connOpts);
        // 订阅主题"sensor0_response", "cam0_response"，用于接收传感器和图像消息
        client.subscribe(new String[]{"sensor" + cameraNum + "_data", "camera" + cameraNum + "_data"});
    }

    // 实现MqttCallback接口的connectionLost方法，当连接丢失时被调用
    @Override
    public void connectionLost(Throwable throwable) {
        // 打印连接丢失的错误信息
        System.out.println("Connection lost: " + throwable.getMessage());
    }

    // 实现MqttCallback接口的messageArrived方法，当接收到新消息时被调用
    @Override
    public void messageArrived(String topic, org.eclipse.paho.client.mqttv3.MqttMessage message) throws Exception {
        // 打印接收到新消息的提示信息
        System.out.println("New message arrived on topic: " + topic);

        if (topic.equals("sensor" + cameraNum + "_data")){
            Main.get_Sensor_Data(message.toString());
        } else if (topic.equals("camera" + cameraNum + "_data")) {
            Main.get_Camera_Data(message,cameraNum);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

    public void setCameraNum(int cameraNum) {
        this.cameraNum = cameraNum;
        try {
            for (int i = 0; i <= 8; i++){
                client.unsubscribe(new String[]{"sensor" + i + "_data", "camera" + i + "_data"});
            }
            client.subscribe(new String[]{"sensor" + cameraNum + "_data", "camera" + cameraNum + "_data"});
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}