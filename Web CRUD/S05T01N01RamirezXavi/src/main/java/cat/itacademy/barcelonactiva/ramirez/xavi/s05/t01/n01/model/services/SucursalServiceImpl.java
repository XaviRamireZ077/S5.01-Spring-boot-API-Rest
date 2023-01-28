package cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;


    private SucursalDTO convertEntityToDto(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setId(sucursal.getId());
        sucursalDTO.setName(sucursal.getName());
        sucursalDTO.setCountry(sucursal.getCountry());
        return sucursalDTO;
    }

        @Override
    public List<SucursalDTO> getAllSucursales() {
        return sucursalRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    @Override
    public void saveSucursal(Sucursal sucursal) {
        this.sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal getSucursalById(long id) {
        Optional< Sucursal > optional = sucursalRepository.findById(id);
        Sucursal sucursal;
        if (optional.isPresent()) {
            sucursal = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return sucursal;
    }

    @Override
    public void deleteSucursalById(long id) {
        this.sucursalRepository.deleteById(id);
    }
}
