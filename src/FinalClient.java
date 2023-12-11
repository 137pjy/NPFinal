import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class FinalClient {
    public static int DEFAULT_PORT = 2022;

    public static void main(String[] args) {

        int port = DEFAULT_PORT;


        try {
            SocketAddress address = new InetSocketAddress("203.252.148.148", port);
            SocketChannel client = SocketChannel.open(address);

            if(client.isConnected())
                System.out.println("client conndected!");

            ByteBuffer buffer = ByteBuffer.allocate(100);



            buffer.putChar('2');
            buffer.putChar('0');
            buffer.putChar('2');
            buffer.putChar('0');
            buffer.putChar('1');
            buffer.putChar('2');
            buffer.putChar('7');
            buffer.putChar('0');
            buffer.putChar('8');
            buffer.flip();
            client.write(buffer);
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);



            while(client.read(buffer2) <= 0) {
                System.out.println(1);
            }

            System.out.println(buffer2);

            buffer2.flip();
            int cnt=0;
            while(buffer2.hasRemaining()){

                char char1= buffer2.getChar();
                System.out.println(char1);

                cnt++;
            }
            System.out.println(cnt);
            System.out.println(buffer2);
            buffer2.flip();
            System.out.println(buffer2);

            byte[] b = new byte[130];
            buffer2.get(b, 0, 130);
            String str = new String(b, "EUC-KR");
            System.out.println(str);

            buffer2.flip();
            byte[] firstStr = new byte[19];
            byte[] secondStr = new byte[31];
            buffer2.get(firstStr,0,19);
            String constr1=new String(firstStr,"EUC-KR");

            buffer2.position(99);
            buffer2.get(secondStr,0,31);
            String constr2=new String(secondStr,"EUC-KR");

            System.out.println(constr1+constr2);




            ByteBuffer numBuffer = ByteBuffer.allocate(80);
            byte[] numArr=new byte[80];
            for(int i=19;i<99;i++){
                numArr[i-19]=b[i];
            }
            numBuffer.put(numArr);
            numBuffer.flip();

            int[] intArr =  new int[10];
            float[] floatArr = new float[10];

            for(int i=0;i<5;i++){
                int firstInt = numBuffer.getInt();
                int secondInt = numBuffer.getInt();
                float firstFloat = numBuffer.getFloat();
                float secondFloat = numBuffer.getFloat();
                intArr[i*2]=firstInt;
                intArr[i*2+1]=secondInt;
                floatArr[i*2]=firstFloat;
                floatArr[i*2+1]=secondFloat;

//                System.out.println(firstInt);
//                System.out.println(secondInt);
//                System.out.println(firstFloat);
//                System.out.println(secondFloat);

            }

            int maxInt=intArr[0];
            float maxFloat=floatArr[0];

            for(int i=0;i<10;i++){
                if(maxInt<intArr[i])
                    maxInt=intArr[i];
                if(maxFloat<floatArr[i])
                    maxFloat=floatArr[i];
            }

            System.out.println("최대 : "+maxFloat);
            System.out.println("최대 : "+maxInt);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
