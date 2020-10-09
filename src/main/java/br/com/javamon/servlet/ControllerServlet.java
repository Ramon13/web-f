package br.com.javamon.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javamon.action.Action;
import br.com.javamon.service.ServiceFactory;

/**
 * This class handles with all request and send to specifics actions
 * @author Ramon (based on Carlos Tosin tutorial code. Softblue course.)
 * @version 1.0
 */
public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	/**
	 * Actions file. This file maps actions to classes
	 */
	private static Properties actions;
	
	/**
	 * This static block inits and load the actions object only one time in application
	 */
	static{
		try(InputStream inStream = ControllerServlet.class.getResourceAsStream("/action.properties")){
			actions = new Properties();
			actions.load(inStream);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	/**
	 * Handles with get and post requests.
	 * Identify and submits the request to specific action
	 * @param request the request object provides by container
	 * @param response the response object provides by container
	 * @throws ServletException wrap all lower exceptions and throw then as ServletException
	 */
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		String path = request.getServletPath();
		//get all after / and before .action
		path = path.substring(1, path.indexOf('.'));
		
		String actionClass = actions.getProperty(path);
		
		if(actionClass == null)
			throw new ServletException("The action '" + path + "' cannot be mapped.");
		
		try{
			Action action = (Action) Class.forName(actionClass).newInstance();
			action.setRequest(request);
			action.setResponse(response);
			action.setServiceFactory(ServiceFactory.getInstance());
			action.runAction();
			
		}catch(Exception e){
			throw new ServletException(e);
		}
	}
}
