package Traza1;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Provincia {
    private String nombre;
    @ToString.Exclude //Se incluye para que la pila no se desborde al recorrer los atributos con referencias circulares
    private Pais pais;
    private Set<Localidad> localidades = new HashSet<>();

    public void agregarLocalidad(Localidad localidad) {
        localidades.add(localidad);
    }
}
