package com.me.tradalarm.alarm;

import com.me.tradalarm.alarm.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {

    public List<Alarm> findAllByOnFalse();
}