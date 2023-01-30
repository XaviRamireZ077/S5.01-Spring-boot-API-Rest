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

    private String sucursalType;

    private List<String> ueCountries = List.of("Austria","Belgium","Bulgaria","Croatia","Cyprus","Czech Republic","Denmark","Estonia","Finland",
            "France","Germany","Greece","Hungary","Ireland","Italy","Latvia","Lithuania","Luxembourg","Malta","Netherlands"
            ,"Poland","Portugal","Romania","Slovakia","Slovenia","Spain","Sweden");


    public void setCountry(String country) {
        this.country = country;
        sucursalOrigin();
    }

    public void sucursalOrigin() {
        // check if country is already in the list of countries
        if (ueCountries.contains(country)) {
            sucursalType = "Ue sucursal";

        } else {
            sucursalType = "Non Ue sucursal";
        }
        setSucursalType(sucursalType);

    }



}




