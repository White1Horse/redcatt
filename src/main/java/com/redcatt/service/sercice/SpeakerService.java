package com.redcatt.service.sercice;

import com.redcatt.pojo.Speaker;

import java.util.List;

public interface SpeakerService {
    void speakerAdd(Speaker speaker, List<String> part);

    List<Speaker> speakerSelect(String speakerSN);
}
