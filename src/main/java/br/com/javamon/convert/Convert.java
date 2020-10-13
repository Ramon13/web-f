package br.com.javamon.convert;

/**
 * Super abstract class. Provides common factories to use in convert classes
 * 
 * @author Ramon
 * @version 1.0
 */
public abstract class Convert {

	private ConvertFactory convertFactory;

	public Convert() {
		this.convertFactory = ConvertFactory.getInstance();
	}

	public ConvertFactory getConvertFactory() {
		return convertFactory;
	}

	public void setConvertFactory(ConvertFactory convertFactory) {
		this.convertFactory = convertFactory;
	}

}
