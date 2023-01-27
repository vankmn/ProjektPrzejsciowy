package Server;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import jdk.jshell.Snippet.Status;

public class JShellResult implements ICalculate{

	@Override
	public double calculate(String expresion) {
		JShell js = JShell.create();
		List<SnippetEvent> events = js.eval(expresion);
		StringBuilder sb = new StringBuilder();
		
		for (SnippetEvent e : events) {
			if(e.value() !=null && e.status( )== Status.VALID) {
				sb.append(e.value());
			}
		}
		return Double.parseDouble(sb.toString());
	}
	
}
