package czs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//下面是一个测试controller，模拟请求接口，发送消息，
@Controller
public class KafkaTestController {
    @Autowired
    private KfkaProducer producer;

    @RequestMapping("/testSendMsg")
    @ResponseBody
    public String testSendMsg() {
        producer.send();
        return "success";
    }

}
