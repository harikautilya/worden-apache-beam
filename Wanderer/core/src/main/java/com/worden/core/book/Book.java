package com.worden.core.book;

import com.worden.core.message.AckMessage;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder(setterPrefix = "of")
@EqualsAndHashCode(callSuper = true)
public class Book extends AckMessage<String> {

  private String bookUrl;
  private long bookId;
  private String ackId;

  @Override
  public boolean canAcknowledge() {
    return true;
  }
  @Override
  public boolean ack() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'ack'");
  }
  @Override
  public String getAcknowledment() {
    return ackId;
  }

 
};