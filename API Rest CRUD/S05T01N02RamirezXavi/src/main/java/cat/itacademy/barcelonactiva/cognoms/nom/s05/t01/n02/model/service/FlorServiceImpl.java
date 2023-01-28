package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlorServiceImpl implements FlorService {

    @Autowired
    private FlorRepository florRepository;

    private FlorDTO convertEntityToDto(FlorEntity florEntity) {
        FlorDTO florDTO = new FlorDTO();
        florDTO.setId(florEntity.getId());
        florDTO.setName(florEntity.getName());
        florDTO.setCountry(florEntity.getCountry());
        return florDTO;
    }

    @Override
    public List<FlorDTO> getAllFlowers() {
        return florRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void saveFlower(FlorEntity florEntity) {
        this.florRepository.save(florEntity);

    }

    @Override
    public FlorEntity getFlowerById(long id) {
        Optional<FlorEntity> optional = florRepository.findById(id);
        FlorEntity florEntity = null;
        if (optional.isPresent()) {
            florEntity = optional.get();
        } else {
            throw new RuntimeException(" Flor not found for id :: " + id);
        }
        return florEntity;
    }

    @Override
    public void deleteFlowersById(long id) {

        this.florRepository.deleteById(id);

    }
}
