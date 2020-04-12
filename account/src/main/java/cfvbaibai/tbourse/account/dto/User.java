package cfvbaibai.tbourse.account.dto;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class User {
    private int id;
    private int identityType;
    private String identityNumber;
    private LocalDate birthDate;

    protected User() {}

    public User(int id, int identityType, String identityNumber, LocalDate birthDate) {
        this.id = id;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
    }

    public int getId() {
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

    public void setId(int id) {
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
