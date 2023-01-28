package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDTO;

import java.util.List;

public interface FlorService {


    List<FlorDTO> getAllFlowers();
    void saveFlower(FlorEntity florEntity);
    FlorEntity getFlowerById(long id);
    void deleteFlowersById(long id);

}


