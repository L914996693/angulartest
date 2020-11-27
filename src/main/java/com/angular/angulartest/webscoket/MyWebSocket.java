package com.angular.angulartest.webscoket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description: websocket简单入门。此类可以向个人发送消息。但是不适合向，因为这里无法适合业务。可以自行改造Map来控制
 * @Author: Gentle
 * @date 2018/9/5  18:43
 */

@Component
@ServerEndpoint(value = "/ws/myWebSocket")
@Slf4j
public class MyWebSocket {
    MyThread thread1=new MyThread();
    Thread thread=new Thread(thread1);
    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
    private  javax.websocket.Session session=null;

    /**
     * @ClassName: onOpen
     * @Description: 开启连接的操作
     */
    @OnOpen
    public void onOpen(Session session) throws IOException{
        this.session=session;
        webSocketSet.add(this);
        System.out.println(webSocketSet);
        //开启一个线程对数据库中的数据进行轮询
        thread.start();

    }

    /**
     * @ClassName: onClose
     * @Description: 连接关闭的操作
     */
    @OnClose
    public void onClose(){
        thread1.stopMe();
        webSocketSet.remove(this);
    }

    /**
     * @ClassName: onMessage
     * @Description: 给服务器发送消息告知数据库发生变化
     */
    @OnMessage
    public void onMessage(int count) {
        System.out.println("发生变化"+count);
        try {
            sendMessage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @ClassName: OnError
     * @Description: 出错的操作
     */
    @OnError
    public void onError(Throwable error){
        System.out.println(error);
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @throws IOException
     * 发送自定义信号，“1”表示告诉前台，数据库发生改变了，需要刷新
     */
    public void sendMessage() throws IOException{
        //群发消息
        for(MyWebSocket item: webSocketSet){
            item.session.getBasicRemote().sendText("1");
        }
    }

    /**
     * springboot内置tomcat的话，需要配一下这个。。如果没有这个对象，无法连接到websocket
     * 别问为什么。。很坑。。。
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        //这个对象说一下，貌似只有服务器是tomcat的时候才需要配置,具体我没有研究
        return new ServerEndpointExporter();
    }


}
