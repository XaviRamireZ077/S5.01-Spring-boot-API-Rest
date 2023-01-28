package cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.ramirez.xavi.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface SucursalService {

    List<SucursalDTO> getAllSucursales();
    void saveSucursal(Sucursal sucursal);
    Sucursal getSucursalById(long id);
    void deleteSucursalById(long id);

}
