package com.mimibr.utils;

import java.text.StringCharacterIterator;

public class StringTasks {
	public static String cleanStringFixXSS(String string, String defaultvalue) {
		  StringBuilder result = new StringBuilder();
		  StringCharacterIterator iterator = new StringCharacterIterator(string == null ? defaultvalue : string);
		  char character = iterator.current();
		  while (character != StringCharacterIterator.DONE )
		  {
			  switch(character) {
				  case '<':
					  result.append("&lt;");
				    break;
				  case '>':
					  result.append("&gt;");
				    break;
				  case '\"':
					  result.append("&quot;");
				    break;
				  case '\'':
					  result.append("&#039;");
				    break;
				  case '\\':
					  result.append("&#092;");
				    break;
				  case '&':
					  result.append("&amp;");
				    break;
				  default:
					  result.append(character);
				}
		      character = iterator.next();
		  }
		  return result.toString();
	}
}
