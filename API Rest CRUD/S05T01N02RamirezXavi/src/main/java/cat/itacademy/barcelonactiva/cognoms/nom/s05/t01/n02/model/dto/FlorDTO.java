package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto;

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
public class FlorDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    private String name;
    private String country;

    private String flowerType;

    private List<String> uEcountries = List.of("Alemania", "Belgica", "Croacia", "España", "Francia", "Irlanda",
            "Letonia", "Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
            "Polonia", "Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria", "Italia",
            "Lituania", "Portugal", "Rumania");



    //List<String> paisosUe2 = Arrays.asList("España");

    public void setCountry(String country) {
        this.country = country;
        florUE();
    }

    public void florUE() {
        boolean found = false;
        int i = 0;

        while (i < uEcountries.size() && !found) {
            if (country.equalsIgnoreCase(uEcountries.get(i))) {
                flowerType = "Dentro de la UE";
                found = true;
            }
            i++;
        }
        if (!found) {
            flowerType = "Fuera de la UE";
        }
        setFlowerType(flowerType);
    }




}
