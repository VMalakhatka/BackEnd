public class Disk {
    final static int MAX_SIZE_DISK=7;
    private int size;
    private String picture=" ";

    public Disk(int size) throws Exception {
        if (size> MAX_SIZE_DISK) {
            throw new Exception("Disk so match");
        }
        int blank=8-size;
        this.size = size+1;
        for (int i=0;i<blank-1;i++) picture+=" ";
        for (int i=0;i<this.size-1;i++) picture+= "▇▇";
        for (int i=0;i<blank;i++) picture+=  " ";
    }

    public int getSize() {
        return size;
    }

    public String getPicture() {
        return  new String(picture);
    }

    @Override
    public String toString() {
        return new String(picture);
    }
}
