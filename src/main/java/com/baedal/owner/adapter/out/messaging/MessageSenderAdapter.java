package com.baedal.owner.adapter.out.messaging;

import org.springframework.stereotype.Component;

import com.baedal.owner.application.command.AddStoreCommand;
import com.baedal.owner.application.port.out.MessageSenderPort;

import lombok.RequiredArgsConstructor;

// note. 이후 Topic 은 SecretKey 로 관리, Key/Value 는 암호화 고려해보면 좋을 것같습니다.
@Component
@RequiredArgsConstructor
public class MessageSenderAdapter implements MessageSenderPort {

  private final KafkaSender kafkaSender;

  @Override
  public void sendAddStore(Long ownerId, AddStoreCommand.Request req) {
    kafkaSender.sendMessage("store.addStore", ownerId.toString(), req);
  }
}
