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
    private Integer id;
    private String name;
    private String characterClass;
    private Long attack;
    private Long defence;
}
