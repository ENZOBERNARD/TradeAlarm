package com.me.tradalarm.alarm;


import com.me.tradalarm.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private UserService userService;



    @PostMapping("/alarm")
    public Alarm addAlarm(@RequestBody Alarm alarm) {
        return alarmService.saveAlarm(alarm);
    }

    @PostMapping("/alarms")
    public List<Alarm> addAlarms(@RequestBody List<Alarm> alarms) {
        return alarmService.saveAlarms(alarms);
    }

    @GetMapping("/alarm")
    public List<Alarm> findAllAlarms() {
        return alarmService.getAlarms();
    }

    @GetMapping("/alarm/{id}")
    public Alarm findAlarmById(@PathVariable int id) {
        return alarmService.getAlarmById(id);
    }

    @PutMapping("/alarm")
    public Alarm updateAlarm(@RequestBody Alarm alarm) {
        return alarmService.updateAlarm(alarm);
    }

    @DeleteMapping("/alarm/{id}")
    public String deleteAlarm(@PathVariable int id) {
        return alarmService.deleteAlarm(id);
    }

    @PutMapping("/alarm/{alarmId}/user/{userId}")
    Alarm assignUserToAlarm(
            @PathVariable Long alarmId,
            @PathVariable Long userId
    ) {
        return alarmService.assignUserToAlarm(alarmId,userId);
    }

    @GetMapping("/alarms/check")
    public String checkAlarms(){
        return alarmService.checkIfRing();
    }


}


