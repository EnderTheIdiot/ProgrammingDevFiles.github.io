public class GenericObjectT1 {
    String ObjectName;
    int ObjectData;

    public GenericObjectT1(String name, int data) {
        this.ObjectName = name;
        this.ObjectData = data;
    }

    public String getName() {
        return ObjectName;
    }

    public int getData() {
        return ObjectData;
    }
}
