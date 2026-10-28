package cl.duoc.demo_kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import cl.duoc.demo_kafka.config.KafkaConfig;

@Component
public class CobrosListener {
    private static final Logger log = LoggerFactory.getLogger(CobrosListener.class);

    @KafkaListener(topics = KafkaConfig.TOPIC, groupId = "cobros")
    public void cobrar(ConsumerRecord<String, String> record) {
        log.info("[LEE] grupo=cobros particion={} offset={} key={} valor={}",
                record.partition(), record.offset(), record.key(), record.value());
    }
}
