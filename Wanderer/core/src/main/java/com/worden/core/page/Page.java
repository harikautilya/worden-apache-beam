package com.worden.core.page;

import java.util.Map;

import com.worden.core.extract.ExtractedText;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Page {

    private ExtractedText text;
    private Map<String, Integer> words;
}
