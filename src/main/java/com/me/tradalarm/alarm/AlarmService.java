package com.me.tradalarm.alarm;

import com.me.tradalarm.binance.BinanceService;
import com.me.tradalarm.mail.EmailSenderService;
import com.me.tradalarm.user.User;
import com.me.tradalarm.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AlarmService {

    @Autowired
    AlarmRepository alarmRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BinanceService binanceService;

    @Autowired
    EmailSenderService emailSenderService;

    public Alarm saveAlarm(Alarm alarm){
        return alarmRepository.save(alarm);
    }

    public List<Alarm> saveAlarms(List<Alarm> alarms){
        return alarmRepository.saveAll(alarms);
    }

    public List<Alarm> getAlarms() {
        return alarmRepository.findAll();
    }

    public Alarm getAlarmById(long id) {
        return alarmRepository.findById(id).orElse(null);
    }

    public String deleteAlarm(long id) {
        alarmRepository.deleteById(id);
        return "Alarm removed !! " + id;
    }

    public Alarm updateAlarm(Alarm alarm) {
        Alarm existingAlarm = alarmRepository.findById(alarm.getId()).orElse(null);
        existingAlarm.setInferieur(alarm.isInferieur());
        existingAlarm.setSymbole1(alarm.getSymbole1());
        existingAlarm.setSymbole2(alarm.getSymbole2());
        existingAlarm.setValeur(alarm.getValeur());
        return alarmRepository.save(existingAlarm);
    }

    public Alarm assignUserToAlarm(long alarmId, long userId) {
        Alarm alarm = alarmRepository.findById(alarmId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        alarm.setOwner(user);
        return alarmRepository.save(alarm);
    }

    public String checkIfRing(){
        System.out.println("checking...");
        var alarms = alarmRepository.findAllByOnFalse();
        alarms.forEach(a -> {
            var currentPrice = binanceService.getPrice(a.getSymbole1(),a.getSymbole2());
            if(a.isInferieur() ? currentPrice.compareTo(a.getValeur()) < 0 : currentPrice.compareTo(a.getValeur()) > 0){
                emailSenderService.sendSimpleEmail("enzobernard6231012@gmail.com",
                        emailSenderService.buildSubject(a.getSymbole1(),a.getSymbole2(),a.getValeur().toString(),a.isInferieur()),
                        emailSenderService.buildSubject(a.getSymbole1(),a.getSymbole2(),a.getValeur().toString(),a.isInferieur()));
                a.setOn(true);
                alarmRepository.save(a);
            }
        });
        System.out.println("check done");
        return "It's checked";
    }
}
