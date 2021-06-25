package lk.carrent.spring.service;

import lk.carrent.spring.dto.AdminDTO;
import java.util.ArrayList;


public interface AdminService {
    void addAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    AdminDTO searchAdmin(String id);

    ArrayList<AdminDTO> getAllAdmins();

    ArrayList<AdminDTO> SearchAdminsByName(String name);

    void updateAdmin(AdminDTO dto);
}
