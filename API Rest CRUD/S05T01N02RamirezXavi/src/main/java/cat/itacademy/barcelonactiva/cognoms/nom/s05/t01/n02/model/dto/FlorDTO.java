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

    private List<String> ueCountries = List.of("Austria","Belgium","Bulgaria","Croatia","Cyprus","Czech Republic","Denmark","Estonia","Finland",
            "France","Germany","Greece","Hungary","Ireland","Italy","Latvia","Lithuania","Luxembourg","Malta","Netherlands"
            ,"Poland","Portugal","Romania","Slovakia","Slovenia","Spain","Sweden");


    public void setCountry(String country) {
        this.country = country;
        flowerOrigin();
    }

    public void flowerOrigin() {
        // check if country is already in the list of countries
        if (ueCountries.contains(country)) {
            flowerType = "Ue country";

        } else {
            flowerType = "Non Ue country";
        }
        setFlowerType(flowerType);

    }


}
