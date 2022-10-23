package com.me.tradalarm.runner;

import com.me.tradalarm.alarm.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckRunnerService {

    @Autowired
    AlarmService alarmService;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        alarmService.checkIfRing();
    }
}
