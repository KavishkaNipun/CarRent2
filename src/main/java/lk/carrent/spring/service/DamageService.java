package lk.carrent.spring.service;

import lk.carrent.spring.dto.DamageDTO;

import java.util.ArrayList;

public interface DamageService {
    void addDamage(DamageDTO dto);

    void deleteDamage(String id);

    DamageDTO searchDamage(String id);

    ArrayList<DamageDTO> getAllDamage();

    void updateDamage(DamageDTO dto);
}
