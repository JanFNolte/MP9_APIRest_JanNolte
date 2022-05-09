package cat.itb.mp9_apirest_jannoltecampos.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariConsultaDTO {
    private String username;
    private String avatar;
    private String rol;
}
