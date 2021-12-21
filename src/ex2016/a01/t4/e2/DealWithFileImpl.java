package ex2016.a01.t4.e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealWithFileImpl implements DealWithFile {

	private BufferedReader bf;
	public DealWithFileImpl(final String fileName) {
		try {
			bf = new BufferedReader(new FileReader(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String read() {
		try {
			return bf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
	}


}
