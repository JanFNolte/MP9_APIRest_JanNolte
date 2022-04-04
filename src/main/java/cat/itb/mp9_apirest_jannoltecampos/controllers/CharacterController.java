package cat.itb.mp9_apirest_jannoltecampos.controllers;


import cat.itb.mp9_apirest_jannoltecampos.model.entitats.FantasyCharacter;
import cat.itb.mp9_apirest_jannoltecampos.model.serveis.ServeiCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class CharacterController {
    private final ServeiCharacters serveiCharacters;

    @CrossOrigin(origins = "http://localhost:9001")
    @GetMapping("/fantasyCharacters")
    public ResponseEntity<?> listFantasyCharacters(@RequestParam(value = "attack", required = false) Long attack){
        if(attack == null){
            List<FantasyCharacter> list =serveiCharacters.listCharacters();
            if(list == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok(list);
        }
        else{
            List<FantasyCharacter> list = serveiCharacters.listCharactersByAttackMoreThan(attack);
            if(list == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok(list);
        }
    }
    @GetMapping("/fantasyCharacters/{id}")
    public ResponseEntity<?> searchFantasyCharacter(@PathVariable String id){
        FantasyCharacter item = serveiCharacters.getCharacterById(id);
        if(item == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(item);
    }
    @GetMapping("/fantasyCharacters/fantasyClass/{fantasyClass}")
    public ResponseEntity<?> listFantasyCharactersByClass(@PathVariable String fantasyClass){
        List<FantasyCharacter> list =  serveiCharacters.listCharactersByCharacterClass(fantasyClass);
        if(list == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(list);
    }
    @PostMapping("/fantasyCharacters")
    public ResponseEntity<?> createFantasyCharacter(@RequestBody FantasyCharacter newCharacter){
        FantasyCharacter res = serveiCharacters.createCharacter(newCharacter);
        return new ResponseEntity<FantasyCharacter>(res, HttpStatus.CREATED);
    }
    @DeleteMapping("/fantasyCharacters/{id}")
    public ResponseEntity<?> deleteFantasyCharacter(@PathVariable String id){
        FantasyCharacter res =serveiCharacters.deleteCharacter(id);
        return new ResponseEntity<FantasyCharacter>(res, HttpStatus.NO_CONTENT);
    }
    @PutMapping("/fantasyCharacters")
    public ResponseEntity<?> modifyFantasyCharacter(@RequestBody FantasyCharacter updatedCharacter){
        FantasyCharacter res = serveiCharacters.updateCharacter(updatedCharacter);
        return ResponseEntity.ok(res);
    }
}
