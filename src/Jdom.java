import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Jdom {

	public static void DOMtoConsole() {

		SAXBuilder builder = new SAXBuilder();

		Document readDoc;

		try {

			readDoc = builder.build(new File("./src/NewFile.xml"));
			Element root = readDoc.getRootElement();
			System.out.println("ROOT : " + readDoc.getRootElement());
			System.out.println(
					"\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ \n");

			for (Element e : root.getChildren("tarif")) {
				System.out.println("NAME : " + e.getChildText("name"));
				System.out.println("OPERATOR NAME :  " + e.getChildText("operatorName"));
				System.out.println("CALLPRICES  \n   {");
				for (Element e2 : e.getChildren("callPrices")) {
					System.out.println("      inside :  " + e2.getChildText("inside"));
					System.out.println("      outcide :  " + e2.getChildText("outcide"));
					System.out.println("      city :  " + e2.getChildText("city"));
					System.out.println("   }");
				}
				System.out.println("SMS :  " + e.getChildText("sms"));
				System.out.println("PARAMETRS  \n   {");
				for (Element e2 : e.getChildren("parametrs")) { 
					System.out.println("      favoriteNumbers :  " + e2.getChildText("favoriteNumbers"));
					System.out.println("      tarification :  " + e2.getChildText("tarification"));
					System.out.println("      conectionPrice :  " + e2.getChildText("conectionPrice"));
					System.out.println("   }");
				}

				System.out.println(
						"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
			}
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}

	}

}
