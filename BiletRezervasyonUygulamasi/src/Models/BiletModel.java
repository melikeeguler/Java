package Models;

//inheritence ve encapsulation
public class BiletModel extends UcusModel{
    private Integer id;
    private Integer userId;
    private Integer ucusId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getUcusId() {
        return ucusId;
    }

    public void setUcusId(Integer ucusId) {
        this.ucusId = ucusId;
    }
}
