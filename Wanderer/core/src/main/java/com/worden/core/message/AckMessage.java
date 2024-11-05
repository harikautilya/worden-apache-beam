package com.worden.core.message;

public abstract class AckMessage<P> {

  public abstract boolean canAcknowledge();

  public abstract boolean ack();

  public abstract P getAcknowledment();

}
