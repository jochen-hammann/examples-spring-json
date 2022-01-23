package com.example.spring.json.jsoncomponent.hello;

import com.example.spring.json.jsoncomponent.dto.MyDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class HelloController
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    // -------------------- [Public Fields] --------------------

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Private Construction / Destruction] --------------------

    // -------------------- [Public Construction / Destruction] --------------------

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    @GetMapping(path = "hello",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public MyDto get()
    {
        MyDto myDto = new MyDto();
        myDto.setName("My Name");
        myDto.setInstant(Instant.now());

        return myDto;
    }

    @PostMapping(path = "hello",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public MyDto post(@RequestBody MyDto myDto)
    {
        return myDto;
    }
}
