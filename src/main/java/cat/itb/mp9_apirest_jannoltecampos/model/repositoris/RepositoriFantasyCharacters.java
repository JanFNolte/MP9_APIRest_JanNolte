package cat.itb.mp9_apirest_jannoltecampos.model.repositoris;

import cat.itb.mp9_apirest_jannoltecampos.model.entitats.FantasyCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriFantasyCharacters extends JpaRepository<FantasyCharacter, String> {
    FantasyCharacter findByName(String name);
    List<FantasyCharacter> findByCharacterClass(String characterClass);
    long countByCharacterClass(String characterClass);
    List<FantasyCharacter> findByAttackGreaterThan(int attack);
    List<FantasyCharacter> findByDefenceGreaterThan(int defence);
}
