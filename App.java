import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class App{
	
	
	public App() throws IOException{
		boolean loginStatus;
		Facade facade = new Facade();
		loginStatus = facade.login();
		if (loginStatus) {
			facade.productOperation();
		}
	}
	

	public static void main(String[] args) throws IOException{
	
		new App();
	}

}
