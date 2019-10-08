package com.redcatt.controller;

import com.redcatt.pojo.Speaker;
import com.redcatt.service.sercice.SpeakerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SpeakerController {
    @Resource
    SpeakerService speakerService;

    @RequestMapping("speakerAdd")
    public String speakerAdd(Speaker speaker, HttpServletRequest request, Model model) {
        try {
            String[] part1 = request.getParameterValues("part");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = dateFormat.format(new Date());
            speaker.setUserName((String) request.getSession().getAttribute("user"));
            speaker.setSpeakerDate(date);
            List<String> part = new ArrayList<>();
            for (String s : part1) {
                if (StringUtils.isNotBlank(s)) {
                    part.add(s);
                }
            }
            speakerService.speakerAdd(speaker, part);
        } catch (Exception e) {
            model.addAttribute("msg", "输入数据的数据有异常！");
            return "main";
        }
        model.addAttribute("msg", "录入成功！");
        return "main";
    }

    @RequestMapping("speakerSelect")
    public String speakerSelect(@RequestParam(value = "speakerSN", required = false) String speakerSN, Model model) {
        List<Speaker> speakerList = speakerService.speakerSelect(speakerSN);
        model.addAttribute("speakerList", speakerList);
        return "select";
    }
}
