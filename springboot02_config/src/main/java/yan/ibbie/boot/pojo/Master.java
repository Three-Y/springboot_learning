package yan.ibbie.boot.pojo;

public class Master {
    private String name;
    private Pet pet;

    public Master() {
    }

    public Master(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Master{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}
