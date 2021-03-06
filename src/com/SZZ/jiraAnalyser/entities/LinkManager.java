package  com.SZZ.jiraAnalyser.entities;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LucaPellegrini
 *
 * Class for the links management
 */
public class LinkManager {
	/**
	 * It return a list of Links.
	 * Each Link object of the list contains a Transiction, a Bug and a number (long)
	 * Confidence is calculated in the constructor
	 * @param ts
	 * @return
	 */
	public List<Link> getLinks(List<Transaction> ts, String projectName, PrintWriter writer) {
		int counter=ts.size();
		System.out.println("Missing "+counter +" commits");
		List<Link> links = new ArrayList<Link>(); 
		for(Transaction t : ts) {
			if (counter%100==0)
				System.out.println("Missing "+counter +" commits");
			for (long bugId : t.getBugIds()){
				Link l = new Link(t, bugId, projectName);
				links.add(l);
			}
			counter--;
		}
		return links;
	}

}
