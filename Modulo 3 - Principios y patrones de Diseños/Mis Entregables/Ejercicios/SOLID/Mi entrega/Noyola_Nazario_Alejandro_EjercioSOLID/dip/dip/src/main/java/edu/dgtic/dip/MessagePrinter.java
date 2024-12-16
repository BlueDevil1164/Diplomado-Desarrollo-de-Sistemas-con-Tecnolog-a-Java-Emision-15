package edu.dgtic.dip;

import edu.dgtic.dip.model.Message;
import edu.dgtic.dip.service.Formatter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {

	private Formatter formatter;

	public MessagePrinter(Formatter formatter) {
		this.formatter = formatter;
	}

	// Escribe un mensaje al archivo para el uso PrintWriter
	public void writeMessage(Message msg, String fileName, PrintWriter writer) throws IOException {
		writer.println(formatter.format(msg)); // Formats and writes message
		writer.flush();
	}

	// Sobrecarga el metodo para usar FileWriter y crear un PrintWriter de forma interna
	public void writeMessage(Message msg, String fileName) throws IOException {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			writeMessage(msg, fileName, writer);
		}
	}
}


