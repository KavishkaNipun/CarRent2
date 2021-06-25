package lk.carrent.spring.service.impl;

import lk.carrent.spring.dto.VehicleDTO;
import lk.carrent.spring.entity.Vehicle;
import lk.carrent.spring.exception.ValidateException;
import lk.carrent.spring.repo.VehicleRepo;
import lk.carrent.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;

//    @Override
//    public void addVehicle(VehicleDTO dto) {
//        if (vehicleRepo.existsById(dto.getVehicleID())) {
//            throw new ValidateException("Vehicle Already Exist");
//        }
//        vehicleRepo.save(mapper.map(dto, Vehicle.class));
    @Override
    public void addVehicle(VehicleDTO dto) {
        if (vehicleRepo.existsVehicleByVehicleID(dto.getVehicleID())) {
            throw new ValidateException("Vehicle Already Exist");
        }
        System.out.println("addVehicle(service) : "+dto);
        vehicleRepo.save(mapper.map(dto, Vehicle.class));
    }

    @Override
    public void deleteVehicle(String id) {
        if (!vehicleRepo.existsById(id)) {
            throw new ValidateException("No Vehicle for Delete..!");
        }
        vehicleRepo.deleteById(id);

        vehicleRepo.deleteById(id);
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if (vehicle.isPresent()) {
            return mapper.map(vehicle.get(), VehicleDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicle() {
        List<Vehicle> vehicle = vehicleRepo.findAll();
        return mapper.map(vehicle,new TypeToken<ArrayList<VehicleDTO>>(){}.getType());

    }

    @Override
    public ArrayList<VehicleDTO> SearchVehicleByBrand(String name) {
        List<Vehicle> all = vehicleRepo.searchVehicleByBrand(name);
        return mapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

            @Override
            public void updateVehicle (VehicleDTO dto){
                if (vehicleRepo.existsById(dto.getVehicleID())) {
                    vehicleRepo.save(mapper.map(dto, Vehicle.class));
                }
            }
        }