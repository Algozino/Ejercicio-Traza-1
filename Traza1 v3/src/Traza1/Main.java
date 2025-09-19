package Traza1;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Empresa> empresas = new HashSet<>();

        // Crear país
        Pais argentina = new Pais("Argentina", new HashSet<>());

        // Provincias
        Provincia bsas = new Provincia("Buenos Aires", argentina, new HashSet<>());
        Provincia cordoba = new Provincia("Córdoba", argentina, new HashSet<>());
        argentina.agregarProvincia(bsas);
        argentina.agregarProvincia(cordoba);

        // Localidades y domicilios
        Localidad caba = new Localidad("CABA", bsas);
        Localidad laPlata = new Localidad("La Plata", bsas);
        bsas.agregarLocalidad(caba);
        bsas.agregarLocalidad(laPlata);

        Domicilio domCaba = new Domicilio("Domicilio de CABA", 100, 1000, caba);
        Domicilio domLaPlata = new Domicilio("Domicilio de La Plata", 200, 1900, laPlata);

        Localidad cordobaCapital = new Localidad("Córdoba Capital", cordoba);
        Localidad villaCarlosPaz = new Localidad("Villa Carlos Paz", cordoba);
        cordoba.agregarLocalidad(cordobaCapital);
        cordoba.agregarLocalidad(villaCarlosPaz);

        Domicilio domCordobaCapital = new Domicilio("Domicilio de Córdoba", 300, 5000, cordobaCapital);
        Domicilio domVillaCarlosPaz = new Domicilio("Domicilio de Carlos Paz", 400, 5152, villaCarlosPaz);

        // Sucursales
        Sucursal suc1 = new Sucursal("Sucursal CABA", LocalTime.of(9,0), LocalTime.of(18,0), true, domCaba);
        Sucursal suc2 = new Sucursal("Sucursal La Plata", LocalTime.of(9,0), LocalTime.of(18,0), false, domLaPlata);
        Sucursal suc3 = new Sucursal("Sucursal Córdoba Capital", LocalTime.of(9,0), LocalTime.of(18,0), true, domCordobaCapital);
        Sucursal suc4 = new Sucursal("Sucursal Villa Carlos Paz", LocalTime.of(9,0), LocalTime.of(18,0), false, domVillaCarlosPaz);

        // Empresas
        Empresa emp1 = new Empresa(1, "Empresa 1", "Razon Social 1", 20304050, "logo1.png", new HashSet<>());
        emp1.agregarSucursal(suc1);
        emp1.agregarSucursal(suc2);

        Empresa emp2 = new Empresa(2, "Empresa 2", "Razon Social 2", 30405060, "logo2.png", new HashSet<>());
        emp2.agregarSucursal(suc3);
        emp2.agregarSucursal(suc4);

        empresas.add(emp1);
        empresas.add(emp2);

        // Mostrar todas las empresas
        System.out.println(" -  -  -  TODAS LAS EMPRESAS  -  -  -  ");
        empresas.forEach(System.out::println);

        // Buscar empresa por ID
        int idBuscar = 1;
        Optional<Empresa> encontrada = empresas.stream()
                .filter(e -> e.getId() == idBuscar)
                .findFirst();
        System.out.println("\nEmpresa con ID " + idBuscar + ": " + encontrada.orElse(null));

        // Buscar empresa por nombre
        String nombreBuscar = "Empresa 2";
        empresas.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombreBuscar))
                .findFirst()
                .ifPresent(e -> System.out.println("\nEmpresa encontrada por nombre: " + e));

        // Actualizar CUIT de empresa por ID
        encontrada.ifPresent(e -> e.setCuit(99999999));
        System.out.println("\nEmpresa actualizada: " + encontrada.orElse(null));

        // Eliminar empresa por ID
        empresas.removeIf(e -> e.getId() == 2);
        System.out.println("\nEmpresas después de eliminar ID 2:");
        empresas.forEach(System.out::println);
    }
}