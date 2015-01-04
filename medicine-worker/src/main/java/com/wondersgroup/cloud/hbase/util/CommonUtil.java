package com.wondersgroup.cloud.hbase.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonUtil {
	public static String readDataFromConsole(String prompt) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			System.out.print(prompt);
			str = br.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
