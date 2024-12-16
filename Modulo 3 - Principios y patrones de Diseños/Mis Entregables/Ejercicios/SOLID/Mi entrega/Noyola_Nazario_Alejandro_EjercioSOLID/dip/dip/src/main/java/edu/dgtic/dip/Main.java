package edu.dgtic.dip;

import edu.dgtic.dip.model.Message;
import edu.dgtic.dip.service.Formatter;
import edu.dgtic.dip.service.JSONFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		Message msg = new Message("This is a message again");

		Formatter formatter = new JSONFormatter();
		MessagePrinter printer = new MessagePrinter(formatter);

		// Usando PrintWriter creado externamente
		try (PrintWriter writer = new PrintWriter(new FileWriter("test_msg.txt"))) {
			printer.writeMessage(msg, "test_msg.txt", writer);
		}

		// O usando el método que internamente crea FileWriter y PrintWriter
		printer.writeMessage(msg, "test_msg.txt");
	}
}


