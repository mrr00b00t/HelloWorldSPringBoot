package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @Autowired
    HelloService helloService;

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    String hello() {

        log.info("Retornando hello!.");

        return "Hello!";
    }

    @GetMapping("/hello/{nome}")
    @ResponseBody
    String helloNome(@PathVariable String nome) {

        log.info("Retornando hello! como o nome.");

        return String.format("Hello %s!", nome);
    }

    @GetMapping("/hello/{nome}/horario")
    @ResponseBody
    String helloNomeHorario(@PathVariable String nome) {
        String horario = helloService.getHorario();

        log.info("Retornando hello! como o nome e horário.");

        return String.format("Hello %s! Agora são %s, não esqueça!", nome, horario);
    }
}