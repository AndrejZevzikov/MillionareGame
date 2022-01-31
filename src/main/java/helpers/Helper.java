package helpers;

public abstract class Helper {

    private boolean isActive;
    private String name;

    public Helper() {
        this.isActive = true;
        this.name = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    @Override
    public String toString() {
        return name;
    }
}
