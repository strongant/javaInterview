package com.strongant.io.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class NIOTest {
	public static void main(String[] args) {
		Path path = Paths.get("src/main/java/com/strongant/io/nio/test.txt");
		try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){


			String currentLine = null;
			while((currentLine = reader.readLine()) != null){//while there is content on the current line
				System.out.println(currentLine); // print the current line
			}
		}catch(IOException ex){
			ex.printStackTrace(); //handle an exception here
		}
	}
}