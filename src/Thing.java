
public class Thing {

    private String id;
    private String name;
    private String desc;
    private String zone;

    public Thing(String id, String name) {
        this.id = id;
        this.name = name;
        this.desc = "";
        this.zone = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Thing [id=" + id + ", name=" + name + ", desc=" + desc + ", zone=" + zone + "]";
    }

}