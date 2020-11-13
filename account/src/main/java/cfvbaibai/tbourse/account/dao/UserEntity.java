package cfvbaibai.tbourse.account.dao;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int identityType;
    private String identityNumber;
    private LocalDate birthDate;

    protected UserEntity() {

    }

    public UserEntity(Integer id, int identityType, String identityNumber, LocalDate birthDate) {
        this.id = id;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public int getIdentityType() {
        return identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
