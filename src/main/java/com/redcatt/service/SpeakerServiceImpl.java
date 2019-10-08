package com.redcatt.service;

import com.redcatt.dao.SpeakerMapper;
import com.redcatt.pojo.Speaker;
import com.redcatt.service.sercice.SpeakerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Resource
    SpeakerMapper speakerMapper;

    @Override
    @Transactional
    public void speakerAdd(Speaker speaker, List<String> part) {
        speakerMapper.speakerAdd(speaker, part);
    }

    @Override
    public List<Speaker> speakerSelect(String speakerSN) {
        return speakerMapper.speakerSelect(speakerSN);
    }
}
