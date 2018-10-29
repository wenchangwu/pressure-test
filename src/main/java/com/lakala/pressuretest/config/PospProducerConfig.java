package com.lakala.pressuretest.config;


import com.lakala.integration.kafka.autoconfigure.KafkaProducerProperties;
import com.lakala.integration.kafka.boot.KafkaProducerBuilder;
import com.lakala.integration.kafka.factory.KafkaProducerFactory;
import com.lakala.integration.kafka.template.KafkaProducerTemplate;
import com.lakala.msc.factory.MQProducerFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: dingo
 * Date: 18-8-20
 * Time: 下午3:55
 * Description:
 */
@Configuration
public class PospProducerConfig {


    @Bean("kafkaProducerPropertiesOne")
    @ConfigurationProperties("kafka.producer.posp")
    public KafkaProducerProperties kafkaProducerProperties() {
        return KafkaProducerBuilder.create().build();
    }

    @Bean("pospProducerFactoryBean")
    public MQProducerFactoryBean mqProducerFactoryBean() throws Exception {
        return new MQProducerFactoryBean(kafkaProducerProperties().getConfigFile(),
                kafkaProducerProperties().getTopic());
    }

    @Bean("pospProducerTemplate")
    public KafkaProducerTemplate kafkaProducerTemplate() throws Exception {
        return new KafkaProducerFactory(mqProducerFactoryBean().getObject());
    }
}