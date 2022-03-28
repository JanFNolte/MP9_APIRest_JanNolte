package cat.itb.mp9_apirest_jannoltecampos.data;

import lombok.Data;

@Data
public class CharacterF {
    private final long id;
    private final String content;
    private final int attack;
    private final int defence;

    public CharacterF(long id, String content, int attack, int defence) {
        this.id = id;
        this.content = content;
        this.attack = attack;
        this.defence = defence;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }
}
