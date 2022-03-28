package cat.itb.mp9_apirest_jannoltecampos.controllers;


import cat.itb.mp9_apirest_jannoltecampos.data.CharacterF;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CharacterController {
    private static final String template = "Character %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/character")
    public CharacterF character(@RequestParam(value="name", defaultValue = "Base") String name){
        return new CharacterF(counter.incrementAndGet(), String.format(template, name), randomNumber(), randomNumber());
    }
    private int randomNumber(){
        return (int) (Math.random() * ( 10 ));
    }
}
