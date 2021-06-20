package lk.carrent.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {

    @Id
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private String nic;
}
