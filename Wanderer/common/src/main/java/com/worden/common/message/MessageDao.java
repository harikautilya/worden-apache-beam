package com.worden.common.message;

import java.util.List;

import com.worden.core.message.AckMessage;

public interface MessageDao<P, T extends AckMessage<P>> {

  List<T> receivedMessages();

  void acknowledgeMessage(List<T> messages);
  
}
