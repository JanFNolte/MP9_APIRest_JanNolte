package cat.itb.mp9_apirest_jannoltecampos.model.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServeiUser {
    private final RepositoryUsuaris;
    private final PasswordEncoder xifrat;

    public Usuari consultarPerUsername(String username) {
        return repositoriUsuari.findByUsername(username).orElse(null);
    }

}
