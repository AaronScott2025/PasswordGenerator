package password;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
	Random r = new Random();
	Scanner input = new Scanner(System.in);
	private String password;
	
	
	
	
	public PasswordGenerator() {
		password = "";
	}
	
	public String Question() {
		System.out.println("Please type: 'easy' for a password that is easy to remember" + 
							"\n Please type: 'secure' for a password that is harder to crack");
		String userInput = input.nextLine();
		userInput = userInput.toLowerCase();
		
		if (userInput.contains("easy")) {
			password = easy();
		}
		else if (userInput.contains("secure")) {
			password = secure();
		}
		else {
			System.out.println("Invalid Input!");
			Question();
		}
		return password;
		
	}
	
	public String easy() {
		int x = 0;
		int z = 0;
		while(x < 2) {
			int y = r.nextInt(164833);
        try (BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"))) {
            String line = "";
            z = 0;
            while ((line = br.readLine()) != null) {
            	if (z == y) {
            		password = password + line;	
            	}
            	z++;
                
	}
             } catch (IOException e) {
                e.printStackTrace();
            }
        x++;
        
        }
		int i = 0;
		while(i < 3) {
			int h = r.nextInt(10);
			password = password + h;
			i++;
		}
		password = password.replaceAll(" ", "");
		return password;
        }
	
	
	public String secure() {
		int i = 0;
		while(i < 25) {
			int u = r.nextInt(2);
			if(u == 0) {
				char y = (char) (new Random().nextInt('Z' - 'A' + 1) + 'A');
				password = password + y;
			} else {
				int x = r.nextInt(10);
				password = password + x;
			}
			i++;
		}
		password = password.replaceAll(" ", "");
		return password;
	}
	}


