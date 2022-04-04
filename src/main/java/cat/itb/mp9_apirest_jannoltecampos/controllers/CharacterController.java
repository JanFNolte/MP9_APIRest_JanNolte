package cat.itb.mp9_apirest_jannoltecampos.controllers;


import cat.itb.mp9_apirest_jannoltecampos.model.entitats.FantasyCharacter;
import cat.itb.mp9_apirest_jannoltecampos.model.serveis.ServeiCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class CharacterController {
    private final ServeiCharacters serveiCharacters;

    @CrossOrigin(origins = "http://localhost:9001")
    @GetMapping("/fantasyCharacters")
    public List<FantasyCharacter> listFantasyCharacters(@RequestParam(value = "attack", required = false) int attack){
        if(attack == 0){
            return serveiCharacters.listCharacters();
        }
        else{
            return serveiCharacters.listCharactersByAttackMoreThan(attack);
        }
    }
}
