import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JdomMain {

	public static void main(String[] args) {

		readXML();
		System.out.println(
				"\n\n~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n");
		// Jdom.DOMtoConsole();

	}

	private static void readXML() {

		SAXBuilder builder = new SAXBuilder();

		Document readDoc;

		allTarifs at = new allTarifs();

		try {

			readDoc = builder.build(new File("./src/NewFile.xml"));
			Element root = readDoc.getRootElement();

			for (Element e : root.getChildren("tarif")) {

				tarifType t = new tarifType();

				t.name = e.getChildText("name");
				t.operatorName = e.getChildText("operatorName");
				t.payrol = Integer.parseInt(e.getChildText("payrol"));

				for (Element e2 : e.getChildren("callPrices")) {
					t.prices = new callPrices();
					t.prices.inside = Integer.parseInt(e2.getChildText("inside"));
					t.prices.outcide = Integer.parseInt(e2.getChildText("outcide"));
					t.prices.city = Integer.parseInt(e2.getChildText("city"));

				}

				t.sms = Integer.parseInt(e.getChildText("payrol"));

				for (Element e2 : e.getChildren("callPrices")) {
					t.parametrs = new Parametrs();
					//t.parametrs.favoriteNumbers = Integer.parseInt(e2.getChildText("favoriteNumbers"));
					//t.parametrs.tarification = Integer.parseInt(e2.getChildText("tarification"));
					//t.parametrs.conectionPrice = Integer.parseInt(e2.getChildText("conectionPrice"));

				}
				at.tarifs.add(t);

			}
			System.out.println(at.tarifs.size());
			System.out.println(at.tarifs.get(0).prices.city);
			System.out.println(at.tarifs.get(0).prices.inside);
			System.out.println(at.tarifs.get(0).prices.outcide);

		} catch (JDOMException |

				IOException e) {
			e.printStackTrace();
		}

	}

}
