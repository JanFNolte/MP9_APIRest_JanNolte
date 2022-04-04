package cat.itb.mp9_apirest_jannoltecampos.controllers;


import cat.itb.mp9_apirest_jannoltecampos.model.entitats.FantasyCharacter;
import cat.itb.mp9_apirest_jannoltecampos.model.serveis.ServeiCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/fantasyCharacters/{id}")
    public FantasyCharacter searchFantasyCharacter(@PathVariable String id){
        return serveiCharacters.getCharacterById(id);
    }
    @GetMapping("/fantasyCharacters/fantasyClass/{fantasyClass}")
    public List<FantasyCharacter> listFantasyCharactersByClass(@PathVariable String fantasyClass){
        return serveiCharacters.listCharactersByCharacterClass(fantasyClass);
    }
    @PostMapping("/fantasyCharacters")
    public FantasyCharacter createFantasyCharacter(@RequestBody FantasyCharacter newCharacter){
        return serveiCharacters.createCharacter(newCharacter);
    }
    @DeleteMapping("/fantasyCharacters/{id}")
    public FantasyCharacter deleteFantasyCharacter(@PathVariable String id){
        return serveiCharacters.deleteCharacter(id);
    }
    @PutMapping("/fantasyCharacters")
    public FantasyCharacter modifyFantasyCharacter(@RequestBody FantasyCharacter updatedCharacter){
        return serveiCharacters.updateCharacter(updatedCharacter);
    }
}
