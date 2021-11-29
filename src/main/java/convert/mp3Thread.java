package convert;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class mp3Thread implements Runnable {

  Thread t = new Thread(this);

  private static String mp3Path;
  private static String fileName;
  private static String mp3ConvertPath;
  public mp3Thread(String mp3Path,String mp3ConvertPath,String fileName) {
	  mp3Thread.mp3ConvertPath = mp3ConvertPath;
	  mp3Thread.mp3Path = mp3Path;
	  mp3Thread.fileName = fileName;
  }
  //private static Path mp4Tomp3Path = FileSystems.getDefault().getPath(mp3Path);

  @Override
  public void run() {
    try {
      Convert.convertSingleFile(mp3Path, mp3ConvertPath, ".mp3",fileName);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    }
  }

  public void start() {
    t.start();
  }
}