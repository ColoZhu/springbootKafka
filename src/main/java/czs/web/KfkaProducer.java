package czs.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class KfkaProducer {

    private static Logger logger = LoggerFactory.getLogger(KfkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        for(int i=0;i<5;i++){
           /* Message message = new Message();
            message.setId(System.currentTimeMillis());
            message.setMsg(UUID.randomUUID().toString()+ "---" +i);
            message.setSendTime(new Date());*/

           //String message=new Date().toString();
            String message="这个是测试kafka使用的message~hehehe";
            logger.info("发送消息 ----->>>>>  message = {}", gson.toJson(message));
            kafkaTemplate.send("hello", gson.toJson(message));
        }
    }


}
