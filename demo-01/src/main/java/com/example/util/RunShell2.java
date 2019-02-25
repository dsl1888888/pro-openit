package com.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunShell2 {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
//	            reader = new BufferedReader(new InputStreamReader(System.in));
//	            System.out.println("������IP:");
//	            String ip = reader.readLine();

			String bashCommand = "";
//	            String bashCommand = "sh "+ "/usr/local/java/jdk1.8.0_121/lib/stopffmpeg.sh" + " ffmpeg " + ip;
//	            String bashCommand = "chmod 777 " + "/usr/local/java/jdk1.8.0_121/lib/stopffmpeg.sh" ;
//	            String bashCommand = "kill -9" + ip;
			System.out.println(bashCommand);
			Runtime runtime = Runtime.getRuntime();
			Process pro = runtime.exec(bashCommand);
			int status = pro.waitFor();
			if (status != 0) {
				System.out.println("Failed to call shell's command ");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringBuffer strbr = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				strbr.append(line).append("\n");
			}

			String result = strbr.toString();
			System.out.println(result);

		} catch (IOException ec) {
			ec.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}

	public static void aaaaaaaaaa(String filename) {
		try {

			String bashCommand = "sh " + filename;

			System.out.println(bashCommand);
			Runtime runtime = Runtime.getRuntime();
			Process pro = runtime.exec(bashCommand);
			int status = pro.waitFor();
			if (status != 0) {
				System.out.println("Failed to call shell's command ");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringBuffer strbr = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				strbr.append(line).append("\n");
			}

			String result = strbr.toString();
			System.out.println(result);

		} catch (IOException ec) {
			ec.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}

	public static void chmod755(String filename) {
		try {

			String bashCommand = "chmod 755 " + filename;

			System.out.println(bashCommand);
			Runtime runtime = Runtime.getRuntime();
			Process pro = runtime.exec(bashCommand);
			int status = pro.waitFor();
			if (status != 0) {
				System.out.println("Failed to call shell's command ");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringBuffer strbr = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				strbr.append(line).append("\n");
			}

			String result = strbr.toString();
			System.out.println(result);

		} catch (IOException ec) {
			ec.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}

	public static void restart() {
		try {

			String bashCommand = "service iptables restart";
//	            String bashCommand = "kill -9" + ip;

			System.out.println(bashCommand);
			Runtime runtime = Runtime.getRuntime();
			Process pro = runtime.exec(bashCommand);
			int status = pro.waitFor();
			if (status != 0) {
				System.out.println("Failed to call shell's command ");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringBuffer strbr = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				strbr.append(line).append("\n");
			}

			String result = strbr.toString();
			System.out.println(result);

		} catch (IOException ec) {
			ec.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}

	public static void save() {
		try {

			String bashCommand = "service iptables save ";

			System.out.println(bashCommand);
			Runtime runtime = Runtime.getRuntime();
			Process pro = runtime.exec(bashCommand);
			int status = pro.waitFor();
			if (status != 0) {
				System.out.println("Failed to call shell's command ");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringBuffer strbr = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				strbr.append(line).append("\n");
			}

			String result = strbr.toString();
			System.out.println(result);

		} catch (IOException ec) {
			ec.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}

//	iptables -I INPUT 4 -s  112.97.59.76 -p tcp -m state --state NEW -m tcp --dport 22221 -j ACCEPT
//	iptables -I INPUT 4 -s  112.97.59.76 -p udp -m state --state NEW -m udp --dport 22221 -j ACCEPT

	public static void opentcpPort_IPTABLESL(String ip, String port) {
		try {
			String bashCommand = "iptables -I INPUT 4 -s  " + ip + " -p tcp -m state --state NEW -m tcp --dport " + port
					+ " -j ACCEPT";

			System.out.println(bashCommand);
			Runtime runtime = Runtime.getRuntime();
			Process pro = runtime.exec(bashCommand);
			int status = pro.waitFor();
			if (status != 0) {
				System.out.println("Failed to call shell's command ");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringBuffer strbr = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				strbr.append(line).append("\n");
			}

			String result = strbr.toString();
			System.out.println(result);

		} catch (IOException ec) {
			ec.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}

	public static void openudpPort_IPTABLESL(String ip, String port) {
		try {
			String bashCommand = "iptables -I INPUT 4 -s  " + ip + " -p udp -m state --state NEW -m udp --dport " + port
					+ " -j ACCEPT";
			System.out.println(bashCommand);
			Runtime runtime = Runtime.getRuntime();
			Process pro = runtime.exec(bashCommand);
			int status = pro.waitFor();
			if (status != 0) {
				System.out.println("Failed to call shell's command ");
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			StringBuffer strbr = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				strbr.append(line).append("\n");
			}

			String result = strbr.toString();
			System.out.println(result);

		} catch (IOException ec) {
			ec.printStackTrace();
		} catch (InterruptedException ex) {
			ex.printStackTrace();

		}
	}
}
