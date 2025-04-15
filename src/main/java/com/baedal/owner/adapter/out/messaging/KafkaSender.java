package com.baedal.owner.adapter.out.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.baedal.owner.util.ObjectMapperUtil;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaSender {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topic, String key, Object message) {
		String json = ObjectMapperUtil.toJson(message);
		kafkaTemplate.send(topic, key, json);
	}

}
