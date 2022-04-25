package cat.itb.mp9_apirest_jannoltecampos.model.serveis;

import cat.itb.mp9_apirest_jannoltecampos.model.entitats.FantasyCharacter;
import cat.itb.mp9_apirest_jannoltecampos.model.repositoris.RepositoriFantasyCharacters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiCharacters {
    private final RepositoriFantasyCharacters repositoriFantasyCharacters;
    public List<FantasyCharacter> listCharacters(){
        return repositoriFantasyCharacters.findAll();
    }
    public FantasyCharacter getCharacter(String name){
        return repositoriFantasyCharacters.findByName(name);
    }
    public List<FantasyCharacter> listCharactersByCharacterClass(String characterClass){
        return repositoriFantasyCharacters.findByCharacterClass(characterClass);
    }
    public long countCharactersByCharacterClass(String characterClass){
        return repositoriFantasyCharacters.countByCharacterClass(characterClass);
    }
    public long countCharacters(){
        return repositoriFantasyCharacters.count();
    }
    public FantasyCharacter getCharacterById(Integer id){
        return repositoriFantasyCharacters.findById(id).orElse(null);
    }
    public List<FantasyCharacter> listCharactersByAttackMoreThan(Long attack){
        return repositoriFantasyCharacters.findByAttackGreaterThan(attack);
    }
    public List<FantasyCharacter> listCharactersByDefenceMoreThan(Long defense){
        return repositoriFantasyCharacters.findByDefenceGreaterThan(defense);
    }
    public FantasyCharacter createCharacter(FantasyCharacter character){
        return repositoriFantasyCharacters.save(character);
    }
    public FantasyCharacter updateCharacter(FantasyCharacter character){
        FantasyCharacter aux = null;
        if(repositoriFantasyCharacters.existsById(character.getId())){
            aux = repositoriFantasyCharacters.save(character);
        }
        return aux;
    }
    public FantasyCharacter deleteCharacter(Integer id){
        FantasyCharacter res = repositoriFantasyCharacters.findById(id).orElse(null);
        if(res!=null) repositoriFantasyCharacters.deleteById(id);
        return res;
    }
}
