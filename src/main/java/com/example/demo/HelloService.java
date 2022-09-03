package com.example.demo;

import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component("horarioService")
public class HelloService {

    public String getHorario() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return ZonedDateTime.now(
                ZoneId.of("America/Sao_Paulo")
        ).format(formatter);
    }
}
