package com.baedal.owner.adapter.out.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaSender {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public void sendMessage(String topic, String key, Object message) {
		kafkaTemplate.send(topic, key, message);
	}

}
