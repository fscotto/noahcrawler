package it.noah.crawler.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * Classe per la gestione dei file
 *
 * @author Fabio Scotto di Santolo
 * @since 22/12/2016
 */
public class FileUtils {

	public static int countBytes(String path) throws IOException {
		InputStream in = new FileInputStream(path);
		int total = 0;

		try {
			while (in.read() != -1) {
				total++;
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return total;
	}

	public static void translateByte(InputStream in, OutputStream out,
			String[] args) throws IOException {
		byte from = (byte) args[0].charAt(0);
		byte to = (byte) args[1].charAt(0);
		int b = 0;

		try {
			while ((b = in.read()) != -1) {
				out.write(b == from ? to : b);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public static int countSpace(String path) throws IOException {
		Reader in = new FileReader(path);
		int ch = 0;
		int spaces = 0;

		try {
			while ((ch = in.read()) != -1) {
				if (Character.isWhitespace((char) ch)) {
					spaces++;
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return spaces;
	}

	public static void copy(String src, String dest) throws IOException {
		File file = new File(src);
		File copy = new File(dest);
		InputStream in = new FileInputStream(file);
		OutputStream out = new FileOutputStream(copy);
		int c = 0;

		try {
			if (file.exists()) {
				while ((c = in.read()) != -1) {
					out.write(c);
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public static List<String> tokens(String path, String delimiter)
			throws IOException {
		File file = new File(path);
		InputStream in = new FileInputStream(file);
		PushbackInputStream pis = new PushbackInputStream(in);
		List<String> line = new ArrayList<String>();
		int c = 0;

		try {
			if (file.exists()) {
				while ((c = pis.read()) != -1) {
					String str = new String();
					pis.unread(c);
					while ((c = pis.read()) != '\n') {
						str += (char) c;
					}

					StringTokenizer token = new StringTokenizer(str, delimiter);

					while (token.hasMoreTokens()) {
						line.add(token.nextToken());
					}
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return line;
	}

	public static Properties getProperties(String path) throws IOException {
		Properties prop = new Properties();
		List<String> list = tokens(path, "=");
		int i = 0;

		while (i < list.size()) {
			prop.setProperty(list.get(i), list.get(i + 1));
			i = i + 2;
		}

		return prop;
	}

	public static String[] fileNameFilter(String dirPath) {
		File dir = new File(dirPath);
		return dir.list(new DirFilter());
	}

	public static void serialize(Object obj, String path) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);

		try {
			out.writeObject(obj);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T deserialize(String path, Class<T> type)
			throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(path);
		ObjectInputStream out = new ObjectInputStream(fileIn);
		T ret = null;

		try {
			ret = (T) out.readObject();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		return ret;
	}

}
