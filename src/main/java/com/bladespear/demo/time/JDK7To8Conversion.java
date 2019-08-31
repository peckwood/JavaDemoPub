package com.bladespear.demo.time;

import org.threeten.bp.DateTimeUtils;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class JDK7To8Conversion {
    public static void main(String[] args) {

        Instant instant = Instant.now();
        Date date = new Date();
        Timestamp sqlTimestamp = new Timestamp(instant.toEpochMilli());

        //Instant to utilDate
        Date date1 = Date.from(instant);

        //utilDate to Instant
        Instant instant1 = date.toInstant();

        //sqlTimestamp to LocalDateTime
        //will use the systemDefault time zone, This may or may not be what you want.
        // you can convert to instant, then LocalDate with zoneId
        LocalDateTime localDateTime = sqlTimestamp.toLocalDateTime();
        org.threeten.bp.LocalDateTime localDateTime1 = DateTimeUtils.toLocalDateTime(sqlTimestamp);






        System.out.println(String.format("date: %s", date1));
        System.out.println(String.format("instant: %s", instant1));
    }
}
