package edu.dgtic.dip.service;

import edu.dgtic.dip.exception.FormatException;
import edu.dgtic.dip.model.Message;

public interface Formatter {

	String format(Message message) throws FormatException;

}
