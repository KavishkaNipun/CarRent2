package lk.carrent.spring.service;

import lk.carrent.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    void addDriver(DriverDTO dto);

    void deleteDriver(String id);

    DriverDTO searchDriver(String id);

    ArrayList<DriverDTO> getAllDriver();

    void updateDriver(DriverDTO dto);
}
