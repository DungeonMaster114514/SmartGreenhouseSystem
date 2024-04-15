package com.ksamar.library.tools.dashdoard;

public class DataTransition {
    private Thread transitionThread;
    private float save;
    private float step = 0;
    private float currentValue = 0;

    public void toNumber(float oldValue,float newValue){
        if (save != newValue){
            if (transitionThread != null && transitionThread.isAlive()) {
                transitionThread.interrupt(); // 关闭上一次调用启动的线程
            }
            save = newValue;

            transitionThread = new Thread(() -> {
                step = (newValue - oldValue) / 100; // 将过渡分为100步
                currentValue = oldValue;

                for (int i = 0; i < 100; i++) {
                    currentValue += step;

                    try {
                        Thread.sleep(10); // 每步之间间隔0.01秒
                    } catch (InterruptedException e) {
                        System.out.println("线程被中断");
                        return;
                    }
                }
                currentValue = newValue;
            });

            transitionThread.start();
        }
    }

    public Thread getTransitionThread() {
        return transitionThread;
    }

    public float getStep() {
        return step;
    }

    public float getCurrentValue() {
        return currentValue;
    }
}
