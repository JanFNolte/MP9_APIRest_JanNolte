package cat.itb.mp9_apirest_jannoltecampos.model.serveis;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElMeuUserDetailsService implements UserDetailsService {
    private final ServeiUser serveiUserDetails;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return serveiUserDetails.consultarPerUsername(username);
    }
}
