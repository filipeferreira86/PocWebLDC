package br.com.gx2.func;

public class OSValidator {

	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static int sistema(){
		
		if (isWindows()) {
			return 0;
		} else if (isMac()) {
			return 1;
		} else if (isUnix()) {
			return 2;
		} else {
			return 3;
		}
	}

	private static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	private static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	private static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}


}