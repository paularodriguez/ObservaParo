package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLLoader {

	static String url = "https://www.sepe.es/contenido/estadisticas/datos_avance/xls/empleo/evolparoseries.xls";
	static String name = "evolparoseries.xls";
	
	static String url2 = "http://www.sepe.es/contenido/estadisticas/datos_avance/xls/empleo/parosexoedadprov.xls";
	static String name2 = "parosexoedadprov.xls";

	// Downloads folder
	static String folder = "documents/";

	public static void downloader() {
		// Create the destination directory
		File dir = new File(folder);

		if (!dir.exists())
			if (!dir.mkdir())
				return;

		File file = new File(folder + name);

		URLConnection conn;
		try {
			conn = new URL(url).openConnection();
			conn.connect();
			InputStream in = conn.getInputStream();
			OutputStream out = new FileOutputStream(file);

			int b = 0;
			while (b != -1) {
				b = in.read();
				if (b != -1)
					out.write(b);
			}

			out.close();
			in.close();

		} catch (MalformedURLException e) {
			System.out.println("URL: " + url + " not valid!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file2 = new File(folder + name2);
		
		try {
			conn = new URL(url2).openConnection();
			conn.connect();
			InputStream in = conn.getInputStream();
			OutputStream out = new FileOutputStream(file2);

			int b = 0;
			while (b != -1) {
				b = in.read();
				if (b != -1)
					out.write(b);
			}

			out.close();
			in.close();

		} catch (MalformedURLException e) {
			System.out.println("URL: " + url2 + " not valid!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println("\nempezando descarga: \n");
		// System.out.println(">> URL: " + url);
		// System.out.println(">> Nombre: " + name);
		// System.out.println(">> tamaño: " + conn.getContentLength() +
		// " bytes");

	}
}
