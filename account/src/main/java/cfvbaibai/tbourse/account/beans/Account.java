package cfvbaibai.tbourse.account.beans;

@SuppressWarnings("unused")
public class Account {
    private Integer id;

    private int userId;
    private String name;

    public Account(Integer id, int userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
