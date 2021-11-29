package convert;


public class config {
  private static String mp4Tomp3Path = "E:\\learning\\Workspace\\VideoConverter\\src";
//  private static String mp4TomkvPath = "E:\\Third Year\\First semester\\Integrative Programming\\Ass-02\\Java-Video-Converter-master\\Java-Video-Converter-master\\media\\mp4Tomkv";
//  private static String mp4ToflvPath = "E:\\Third Year\\First semester\\Integrative Programming\\Ass-02\\Java-Video-Converter-master\\Java-Video-Converter-master\\media\\mp4Toflv";
  private static String mp4Tomp3ConvertedPath = "C:\\Users\\ASUS\\Downloads\\y2mate";
//  private static String mp4TomkvConvertedPath = "E:\\Third Year\\First semester\\Integrative Programming\\Ass-02\\Java-Video-Converter-master\\Java-Video-Converter-master\\media-converted\\mp4Tomkv-converted";
//  private static String mp4ToflvConvertedPath = "E:\\Third Year\\First semester\\Integrative Programming\\Ass-02\\Java-Video-Converter-master\\Java-Video-Converter-master\\media-converted\\mp4Toflv-converted";

  public static String getMp4ToMp3Path() {
    return mp4Tomp3Path;
  }

//  public static String getMp4ToMkvPath() {
//    return mp4TomkvPath;
//  }

//  public static String getMp4ToFlvPath() {
//    return mp4ToflvPath;
//  }

  public static String getMp4ToMp3ConvertPath() {
    return mp4Tomp3ConvertedPath;
  }

//  public static String getMp4ToMkvConvertPath() {
//    return mp4TomkvConvertedPath;
//  }
//
//  public static String getMp4ToFlvConvertPath() {
//    return mp4ToflvConvertedPath;
//  }
}