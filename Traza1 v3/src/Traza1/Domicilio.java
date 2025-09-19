package Traza1;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Domicilio {
    private String calle;
    private int numero;
    private int cp;
    private Localidad localidad;
}
