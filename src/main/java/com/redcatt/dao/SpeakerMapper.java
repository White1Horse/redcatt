package com.redcatt.dao;

import com.redcatt.pojo.Speaker;

import java.util.List;

public interface SpeakerMapper {
    void speakerAdd(Speaker speaker, List<String> part);

    List<Speaker> speakerSelect(String speakerSN);
}
