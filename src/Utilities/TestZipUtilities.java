package Utilities;

import java.io.IOException;

public class TestZipUtilities {

	public static void main(String args[]) throws IOException {

		// Compress a file to the given zip file name
		String zipfilename = "test3.zip";
		String filename1 =  "out.txt";

		ZipUtilities.getInstance().compressFile("ou1t.txt", "ou1t.zip");



	}
}
