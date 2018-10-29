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
        String request = "{\"createTime\":\"20181029134511\",\"tradeDate\":\"20181029\",\"sid\":\"79178EAB4A3740058FC0F5BB7A3AE059\",\"sysref\":\"102900000132\",\"termid\":\"CBC4A4BF00000645\",\"busId\":\"18X\",\"userId\":\"4400088994\",\"posemc\":\"1\",\"createDate\":\"20181029\",\"pan\":\"6225258803944362\"}";
       /* MposTransVo vo = JSON.parseObject(request, MposTransVo.class);
        KafkaData tempKafkaData = new KafkaData(request, "JSON", null);*/
        mposTemplate.send(UUID.randomUUID().toString(), request);
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
        String s="{\"LOGDAT\":\"20181029\",\"TACC_DT\":\"\",\"CCKFLG\":\"0\",\"TTXNCD\":\"\",\"THDCHK\":\"0\",\"TXN_F13\":\"\",\"RTRCOD\":\"\",\"TXN_F12\":\"\",\"TXN_F11\":\"\",\"TXN_F10\":\"\",\"TXN_STS\":\"S\",\"TXN_F16\":\"\",\"TXN_F15\":\"|PI02804023033050C37363030303030303030333408085631363031303741\",\"END_FLG\":\"0\",\"TXN_F14\":\"\",\"TLOG_NO\":\"\",\"TERMID\":\"29996480\",\"MERTYP\":\"7011\",\"SYNFLG\":\"2\",\"CRDSQN\":\"001\",\"TXNTIM\":\"20181029134716\",\"CRD_NO\":\"6225258803944362\",\"PROCOD\":\"000000\",\"MERCID\":\"822910000011969\",\"POSCND\":\"00\",\"CRDFLG\":\"01\",\"CTXNTM\":\"134716\",\"FEE\":\"0\",\"TXN_F5\":\"79178EAB4A3740058FC0F5BB7A3AE059\",\"TXN_F6\":\"\",\"TLR_ID\":\"\",\"TXN_F7\":\"\",\"TXN_F8\":\"\",\"TXN_F1\":\"\",\"ACQRSV\":\"\",\"HACQCD\":\"\",\"AC_NO\":\"6225258803944362\",\"CRDNO1\":\"\",\"TXN_F2\":\"\",\"ACC_DT\":\"20181029\",\"CCYCOD\":\"156\",\"TXN_F3\":\"00000500030000000000001\",\"HLOG_NO\":\"\",\"TXN_F4\":\"00FF\",\"ACTTYP\":\"\",\"REFAMT\":\"0\",\"TXN_F9\":\"\",\"CTXNDT\":\"1029\",\"HSTFIL\":\"0\",\"TXN_TYP\":\"N\",\"EMVFLG\":\"1\",\"FRSP_CD\":\"000000\",\"STXN_CD\":\"012001\",\"OLOG_NO\":\"\",\"RTRSVR\":\"MUNIEFSA\",\"INSADR\":\"��Ҳû��������\",\"MERCTEL\":\"\",\"BATNO\":\"000002\",\"SREFNO\":\"102900000132\",\"TXNAMT\":\"000000000005500\",\"HSTDAT\":\"134550\",\"RSVDAT\":\"01000050\",\"CPSFIL\":\"0\",\"HRSP_CD\":\"\",\"SCPSCOD\":\"00\",\"ICLEN\":\"0\",\"TRMTYP\":\"6\",\"LOG_NO\":\"18102900000132\",\"TXNRSV3\":\"29034728\",\"HFORCD\":\"\",\"ICDAT\":\"9F260845B657674911E90D9F2701809F101307010103A02002010A0100000000003F1660819F3704D820F7B79F360201A69505008004E8009A031810299C01009F02060000000055005F2A02015682027C009F1A0201569F03060000000000009F33036040C89F34034203009F3501229F1E0839393034303039318408A0000003330101029F090200009F410400000000\",\"TXNRSV2\":\"\",\"BR_NO\":\"999999\",\"ACQCOD\":\"48222900\",\"TXNRSV1\":\"822290070111135\",\"ISSINO\":\"01020000\",\"CPSRSV\":\"\",\"TTXN_STS\":\"S\",\"ORNDAT\":\"0200\",\"HTXN_STS\":\"U\",\"TMSTIM\":\"1029134716\",\"TRSP_CD\":\"000000\",\"HISINO\":\"\",\"IDNO\":\"0|00\",\"BILLNO\":\"133068\",\"MSGID\":\"0200\",\"CSEQNO\":\"133068\",\"CPSDAT\":\"\",\"AUTCOD\":\"\",\"AGTORG\":\"CUPSMPOS\",\"FORCOD\":\"48220000\",\"NOD_NO\":\"CORE12\",\"INMOD\":\"052\"}";
        pospTemplate.send(UUID.randomUUID().toString(), s);
    }

}
