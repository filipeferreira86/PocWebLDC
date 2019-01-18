package br.com.gx2.func;

public class OSValidator {

	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static int sistema(){
		
		System.out.println(OS);
		
		if (isWindows()) {
			return 0;
		} else if (isUnix()) {
			return 1;
		} else {
			return 2;
		}
	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}


}