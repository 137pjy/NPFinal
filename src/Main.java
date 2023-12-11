import java.nio.ByteBuffer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
            ByteBuffer buf = ByteBuffer.allocate(12);
            buf.put((byte)101);
            System.out.println(buf);
            buf.flip();
            System.out.println(buf);
            buf.limit(8);
            int a = buf.getInt();
            System.out.println(a);
            System.out.println(buf);
            buf.put((byte)11);
            int b = buf.getShort();
            System.out.println(buf);
            ByteBuffer buf2=buf.slice();
            System.out.println(buf.remaining());
            buf2.put((byte)512);

    }
}