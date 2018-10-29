package com.lakala.pressuretest;

import com.alibaba.fastjson.JSON;
import com.lakala.integration.kafka.boot.KafkaData;
import com.lakala.integration.kafka.template.KafkaProducerTemplate;
import com.lakala.pressuretest.vo.MposTransVo;
import com.lakala.pressuretest.vo.PospTransVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PressureTestApplication.class)
public class PressureTestApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    @Qualifier("mposProducerTemplate")
    private KafkaProducerTemplate mposTemplate;


    @Autowired
    @Qualifier("pospProducerTemplate")
    private KafkaProducerTemplate pospTemplate;


    @Test
    public void testProduceMpos() {
        String request = "{\"createTime\":\"20181026143204\",\"tradeDate\":\"20181026\",\"sid\":\"8CC1DF78F3F14123A4F687949FC354F6\",\"sysref\":\"102650000040\",\"termid\":\"CBC4A4BF00000645\",\"busId\":\"18Y\",\"userId\":\"4400088994\",\"posemc\":\"1\",\"createDate\":\"20181026\",\"pan\":\"6225258803944362\"}";
        MposTransVo vo = JSON.parseObject(request, MposTransVo.class);
        KafkaData tempKafkaData = new KafkaData(request, "JSON", null);
        mposTemplate.send(UUID.randomUUID().toString(), tempKafkaData);
    }


    /**
     *
     */

    @Test
    public void testProducePosp() {
        PospTransVo vo = new PospTransVo();
        //LOG_NO  = "18"+MposTransVo.getSysref()
        vo.setLOG_NO("18102650000040");
        vo.setMERCID("merId");
        vo.setTERMID("47754183");
        vo.setTXNTIM("txntim");
        vo.setTXNAMT("txnamt");
        vo.setCRDFLG("crdflg");
        vo.setTXN_TYP("typ");
        vo.setCardappTypeId("appType");
        vo.setTXN_STS("txnsts");
        String request=JSON.toJSONString(vo);
        KafkaData tempKafkaData = new KafkaData(request, "JSON", null);
        pospTemplate.send(UUID.randomUUID().toString(), tempKafkaData);
    }

}
