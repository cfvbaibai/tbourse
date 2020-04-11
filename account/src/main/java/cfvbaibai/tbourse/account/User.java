package cfvbaibai.tbourse.account;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class User {
    private int id;
    private int identityType;
    private String identityNumber;
    private LocalDate birthDate;

    public User(int uuid, int identityType, String identityNumber, LocalDate birthDate) {
        this.id = uuid;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentityType() {
        return identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
