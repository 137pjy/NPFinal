import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        int m = 15;
        int n = 3;
        ByteBuffer buf = ByteBuffer.allocate(m);
        for(int i=0;;i++){
            if(buf.remaining()<n) break;
            buf.putInt(2*i);
        }
        System.out.println(buf);
        buf.flip();
        System.out.println(buf);
        for(int i=0;;i++){
            if(buf.remaining()<n) break;
            System.out.println(buf.getInt());
        }
    }
}
