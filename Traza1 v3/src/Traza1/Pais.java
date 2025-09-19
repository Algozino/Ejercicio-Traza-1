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

public class Pais {
    private String nombre;
    private Set<Provincia> provincias = new HashSet<>();

    public void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
    }
}