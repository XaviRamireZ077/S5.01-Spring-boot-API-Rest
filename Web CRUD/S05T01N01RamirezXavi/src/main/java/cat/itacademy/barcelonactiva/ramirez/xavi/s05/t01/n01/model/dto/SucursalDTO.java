package cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.dto;

import lombok.*;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class SucursalDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    private String name;
    private String country;
    private String sucursaltype;

    private List<String> uEcountries = List.of("Alemania", "Belgica", "Croacia", "España", "Francia", "Irlanda",
            "Letonia", "Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
            "Polonia", "Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria", "Italia",
            "Lituania", "Portugal", "Rumania");


    //List<String> paisosUe2 = Arrays.asList("España");

    public void setCountry(String country) {
        this.country = country;
        sucursalUE();
    }

    public void sucursalUE() {
        boolean found = false;
        int i = 0;

        while (i < uEcountries.size() && !found) {
            if (country.equalsIgnoreCase(uEcountries.get(i))) {
                sucursaltype = "Dentro de la UE";
                found = true;
            }
            i++;
        }
        if (!found) {
            sucursaltype = "Fuera de la UE";
        }
        setSucursaltype(sucursaltype);
    }



}




