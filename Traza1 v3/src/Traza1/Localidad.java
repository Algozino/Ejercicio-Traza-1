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

public class Localidad {
    private String nombre;
    @ToString.Exclude //Se incluye para que la pila no se desborde al recorrer los atributos con referencias circulares
    private Provincia provincia;
}

