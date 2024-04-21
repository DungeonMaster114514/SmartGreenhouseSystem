//package com.ksamar.library.tools.video;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.ToggleButton;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//import java.io.File;
//
///**
// * @Author: ZhangHao
// * @Description: 音频、视频播放Demo
// * @Date: 2020/5/14 21:46
// * @Version: 1.0
// */
//public class MediaDemo extends Application{
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage){
//        // 音频或视频的路径
//        // 举例中的路径为工程根目录下的test.mp4
//        // 如果不能正常播放，则音频或视频文件可能损坏；或者有版权，需对应的播放器正常播放；或者录屏后重新尝试，避过版权问题
//        String url = new File(System.getProperty("C:/Users/Lenovo/Videos/Wolf Walkers/狼行者.mp4")).getAbsoluteFile().toURI().toString();
//        Media media = new Media(url);
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        // 设置音量：0.0 - 1.0
//        mediaPlayer.setVolume(0.5);
//        // 设置开始时间
//        mediaPlayer.setStartTime(Duration.seconds(1));
//        MediaView mView = new MediaView(mediaPlayer);
//        System.out.println(media.getSource());
//
//        VBox vBox = new VBox(3);
//        vBox.getChildren().add(mView);
//        vBox.setPrefWidth(580);
//        vBox.setPrefHeight(360);
//        mView.setFitWidth(vBox.getPrefWidth());
//        mView.setFitHeight(vBox.getPrefHeight() - 40);
//
//        int fontSize = 16;
//
//        ToggleGroup toggleGroup = new ToggleGroup();
//
//        ToggleButton playButton = new ToggleButton("播放");
//        playButton.setFont(new Font(fontSize));
//        playButton.setOnMouseClicked(event -> mediaPlayer.play());
//        playButton.setToggleGroup(toggleGroup);
//
//        ToggleButton suspendButton = new ToggleButton("暂停");
//        suspendButton.setFont(new Font(fontSize));
//        suspendButton.setOnMouseClicked(event -> mediaPlayer.pause());
//        suspendButton.setToggleGroup(toggleGroup);
//
//        ToggleButton continueButton = new ToggleButton("继续");
//        continueButton.setFont(new Font(fontSize));
//        continueButton.setOnMouseClicked(event -> mediaPlayer.play());
//        continueButton.setToggleGroup(toggleGroup);
//
//        ToggleButton closeButton = new ToggleButton("结束");
//        closeButton.setFont(new Font(fontSize));
//        closeButton.setOnMouseClicked(event -> mediaPlayer.stop());
//        closeButton.setToggleGroup(toggleGroup);
//
//        HBox hBox = new HBox(3);
//        hBox.getChildren().addAll(playButton, suspendButton, continueButton, closeButton);
//        vBox.getChildren().add(hBox);
//
//        Scene scene = new Scene(vBox,580,360);
//        primaryStage.setTitle("MediaDemo");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//}