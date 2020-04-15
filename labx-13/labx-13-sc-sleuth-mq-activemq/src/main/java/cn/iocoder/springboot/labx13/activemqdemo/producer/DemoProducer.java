package cn.iocoder.springboot.labx13.activemqdemo.producer;

import cn.iocoder.springboot.labx13.activemqdemo.message.DemoMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoProducer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    public void syncSend(Integer id) {
        // 创建 DemoMessage 消息
        DemoMessage message = new DemoMessage();
        message.setId(id);
        // 同步发送消息
        jmsTemplate.convertAndSend(DemoMessage.QUEUE, message);
    }

}
