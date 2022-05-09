package cat.itb.mp9_apirest_jannoltecampos.model.serveis;

import cat.itb.mp9_apirest_jannoltecampos.model.repositoris.RepositoryUsuaris;
import cat.itb.mp9_apirest_jannoltecampos.model.users.Usuari;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiUser {
    private final RepositoryUsuaris repositoriUsuari;
    private final PasswordEncoder xifrat;

    public Usuari consultarPerUsername(String username) {
        return repositoriUsuari.findUsuariByUsername(username).orElse(null);
    }
    public Usuari crearNouUsuari(Usuari newUsuari){
        newUsuari.setPassword(xifrat.encode(newUsuari.getPassword()));
        repositoriUsuari.save(newUsuari);
        return newUsuari;
    }
    public List<Usuari> llistarUsuaris(){
        return repositoriUsuari.findAll();
    }
}
