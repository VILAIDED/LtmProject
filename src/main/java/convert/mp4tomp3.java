package convert;

//import com.sun.org.apache.bcel.internal.Repository;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;

//import java.util.Scanner;
import java.io.File;

public class mp4tomp3{
    
// convert mp4 to mp3
public static void convertMp4ToMp3(File source, File output) {
    Encoder forMp3 = new Encoder();
    EncodingAttributes specificationsForMp3 = new EncodingAttributes();
    specificationsForMp3.setFormat("mp3");
    AudioAttributes audioForMp3 = new AudioAttributes();
    audioForMp3.setVolume(256);
    audioForMp3.setCodec("mp2");
    specificationsForMp3.setAudioAttributes(audioForMp3);

    try {
        forMp3.encode(source, output, specificationsForMp3);
    } catch (EncoderException ex) {
        ex.printStackTrace();
    }
}

}