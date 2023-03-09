package com.jspiders.serizationdeserlization.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jspiders.serizationdeserlization.object.User;



public class UserMain {
	public static void main(String[] args) {
		
		File file;
		FileInputStream fileInputStream;
		FileOutputStream fileOutputStream;
		
		file=new File("Object.txt");
		
		if (file.exists()) {
			System.out.println("file is already exist");
		}else {
			try {
				file.createNewFile();
				System.out.println("file is created");
				
			fileOutputStream=new FileOutputStream(file);
			fileInputStream=new FileInputStream(file);
			
			//serlization
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			User user=new User(1,"suraj","suraj@gmail.com");
			objectOutputStream.writeObject(user);
			objectOutputStream.close();
			
			//Deserilization
			
			ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
			try {
				User output=(User) objectInputStream.readObject();
				System.out.println(output);
				objectInputStream.close();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
	
	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
