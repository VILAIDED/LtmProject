package convert;

import java.io.File;

import model.bo.UserFileBO;

public class Convert {
	  public static void convertSingleFile(String mediaPath,String convertedPath,String extension,String fileName) {
		  try {
			  File file = new File(mediaPath);
			  File destination = new File(convertedPath);
			  File target = new File(destination.getAbsoluteFile() + extension);
			  switch (extension) {
	          case ".mp3":
	            mp4tomp3.convertMp4ToMp3(file, target);
	            break;
	          default:
	            break;
	        }
			  System.out.println("Successfully Converted ");
			  UserFileBO uFileBO = new UserFileBO();
			  uFileBO.convertFile(fileName,convertedPath);
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
		  
	  }
  public static void assignPath(String mediaPath, String convertMediaPath, String extension) {
    try {
      File[] files = new File(mediaPath).listFiles();

      File destination = new File(convertMediaPath);

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + extension);

        switch (extension) {
          case ".mp3":
            mp4tomp3.convertMp4ToMp3(file, target);
            break;
          default:
            break;
        }
        System.out.println("Successfully Converted " + file.getName() + " to " + target.getName());

        // delete the original file
//        file.delete();
//        System.out.println("Deleted file " + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}