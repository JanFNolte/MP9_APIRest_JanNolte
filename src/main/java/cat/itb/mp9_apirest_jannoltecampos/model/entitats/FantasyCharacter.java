package cat.itb.mp9_apirest_jannoltecampos.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class FantasyCharacter {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String characterClass;
    private int attack;
    private int defence;
}
