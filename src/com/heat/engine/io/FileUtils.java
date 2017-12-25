package com.heat.engine.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import com.heat.engine.Engine;
import com.heat.engine.game.Game;

public class FileUtils {

	/**
	 * Removes all of the ".temp" files from the
	 * %APPDATA%/Local/Temp/heat_engine folder <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-02-19
	 * 
	 */
	public static void clearTemps() {
		clearTemps(System.getProperty("java.io.tmpdir") + Engine.ID);
	}

	/**
	 * Removes all of the ".temp" files from the specified path. <br>
	 * Warning, this is recursive and will remove .temp files from every child
	 * folder <br>
	 * it can find. So be careful when using this. <br>
	 * 
	 * @author Pontus Wirsching
	 * @since 2016-02-19
	 * 
	 */
	public static void clearTemps(String path) {
		try {
			File tempPath = new File(path);
			if (!tempPath.exists()) {
				tempPath.mkdirs();
			}

			File[] files = tempPath.listFiles();

			for (File f : files) {

				// If file is a directory, scan that and remove it's files.
				if (f.isDirectory())
					clearTemps(f.getAbsolutePath());

				// If file is a .temp file, remove it.
				if (f.getName().endsWith(".temp")) {
					
					if (Game.getDebug() >= Game.DEBUG_DETAILED)
					System.out.println("[HEAT ENGINE] [IO] (DEBUG) Removing file: " + f.getName());
					
					
					// Remove file
					Files.delete(f.toPath());
					
					
					// As the file should be removed by this point, if it isn't, we got an error.
					if (f.exists())
						System.err.println("[HEAT ENGINE] [IO] Error removing file: " + f.getName());
				}
			}

		} catch (Exception e) {
			System.err.println("[Heat Engine] [IO] Could not clear temp dir.");
			e.printStackTrace();
		}

	}

	public static File getLocal(String path) {

		InputStream initialStream;
		File targetFile = null;
		try {
			initialStream = FileUtils.class.getResourceAsStream("/" + path);

			byte[] buffer = new byte[initialStream.available()];

			initialStream.read(buffer);

			// Create temp folder if it doesn't exist.
			File tempPath = new File(System.getProperty("java.io.tmpdir") + Engine.ID);
			if (!tempPath.exists()) {
				tempPath.mkdirs();
			}

			// Get file name.
			String[] pathSplitted = path.split("/");
			String fileName = pathSplitted[pathSplitted.length - 1];

			targetFile = new File(tempPath.getAbsolutePath() + File.separator + fileName + ".temp");
			OutputStream outStream = new FileOutputStream(targetFile);
			outStream.write(buffer);
			outStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return targetFile;

		// URL url = FileUtils.class.getResource("/" + path);
		// File file = null;
		// try {
		// file = new File(url.toURI());
		// } catch (URISyntaxException e) {
		// e.printStackTrace();
		// }
		// return file;
	}

}
