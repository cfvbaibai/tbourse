package cfvbaibai.tbourse.account.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                identityType == user.identityType &&
                Objects.equals(identityNumber, user.identityNumber) &&
                Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identityType, identityNumber, birthDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("identityType=" + identityType)
                .add("identityNumber='" + identityNumber + "'")
                .add("birthDate=" + birthDate)
                .toString();
    }
}
