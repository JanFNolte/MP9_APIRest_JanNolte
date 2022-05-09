package cat.itb.mp9_apirest_jannoltecampos.model.repositoris;

import cat.itb.mp9_apirest_jannoltecampos.model.users.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryUsuaris extends JpaRepository<Usuari, Integer> {
    Optional<Usuari> findUsuariByUsername(String username);
}
