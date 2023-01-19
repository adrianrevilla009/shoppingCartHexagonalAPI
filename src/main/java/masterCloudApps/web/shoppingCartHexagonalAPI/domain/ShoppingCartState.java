package masterCloudApps.web.shoppingCartHexagonalAPI.domain;

public enum ShoppingCartState {
    PENDING(1, "PENDING"),
    FINISHED(2, "FINISHED");

    private int id;
    private String name;

    ShoppingCartState(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
