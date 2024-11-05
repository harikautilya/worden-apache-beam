package com.worden.common.book.pubsub;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.ReceivedMessage;
import com.worden.core.book.Book;

/**
 * We need to build ackid as well as part of the object. Hence a mapper is introduced instead of
 * using the jackson directly
 */
public class MessageMapper {

  private final static ObjectMapper objectMapper = new ObjectMapper();

  private MessageMapper() {

  }

  static Book parseMessaage(ReceivedMessage receivedMessage) {
    String jsondata = receivedMessage.getMessage().getData().toStringUtf8();

    Map<String, Object> values;
    try {
      values = objectMapper.readValue(jsondata, Map.class);
      return Book.builder()
          .ofAckId(receivedMessage.getAckId())
          .ofBookId(getLong("book_id", values))
          .ofBookUrl(getString("book_url", values))
          .build();

    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }

  private static Long getLong(String key, Map<String, Object> values) {
    if (values == null || !values.containsKey(key)) {
      return null;
    }
    Object value = values.get(key);
    if (value instanceof Number) {
      return ((Number) value).longValue();
    } else if (value instanceof String) {
      return Long.parseLong((String) value);
    }
    return null;
  }

  private static String getString(String key, Map<String, Object> values) {
    if (values == null || !values.containsKey(key)) {
      return null;
    }
    Object value = values.get(key);
    if (value instanceof String) {
      return (String) value;
    } else if (value != null) {
      return value.toString();
    }
    return null;
  }
}
