package com.ron.javaFeatures;

import java.io.PrintStream;

public class Utils {

	private static final char SPACE = ' ';

	public static String print(Object o) {
		return print(true, o);
	}

	public static String print(boolean isOk, Object o) {
		String s = o == null ? "" : o.toString();
		PrintStream printStream = isOk ? System.out : System.err;
		printStream.println(s);
//		if (isOk) { System.out.println(s); } else { System.err.println(s); }
		return s;
	}

	public static String print(Object... objects) {
		return printObjects(true, SPACE, objects);
	}

	public static String printerr(Object... objects) {
		return printObjects(false, SPACE, objects);
	}

	public static String printObjects(boolean isOk, char delimiter, Object... objects) {
		StringBuilder sb = new StringBuilder();
		for (Object o : objects) {
			if (o != null) {
				if (sb.length() > 0) {
					sb.append(delimiter);
				}
				sb.append(o.toString());
			}
		}
		return print(isOk, sb);
	}
}
