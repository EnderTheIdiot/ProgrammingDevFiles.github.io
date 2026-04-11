public class GenericObjectT2 {
    String ObjectName;
    int ObjectData1;
    int ObjectData2;

    public GenericObjectT2(String name, int data1, int data2) {
        this.ObjectName = name;
        this.ObjectData1 = data1;
        this.ObjectData2 = data2;
    }

    public String getName() {
        return ObjectName;
    }

    public int getData1() {
        return ObjectData1;
    }

    public int getData2() {
        return ObjectData2;
    }
}
