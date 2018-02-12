package virtuoso.sparql.itf;



import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.RDFNode;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;


import java.util.ArrayList;
import java.util.List;


public class VirtuosoSparql {

	public List<String> query(String sql){
		List<String> list = new ArrayList<String>();
									
/* sign virtuoso server */
		VirtGraph set = new VirtGraph ("fruit", "jdbc:virtuoso://192.168.1.112:1111", "dba", "dba");
		
/*		Select data in virtuoso	*/
		
		Query sparql = QueryFactory.create("PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +sql);
/*			STEP 4			*/
		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);

		ResultSet results = vqe.execSelect();
		String str = "";
		while (results.hasNext()) {
			String sk="";
			QuerySolution result = results.nextSolution();
		    RDFNode x = result.get("x");
		    RDFNode y = result.get("y");
		    RDFNode z = result.get("z");
		   // str = graph + " { " + s + " " + p + " " + o + " . }";
			
			//ResultSetFormatter.out(System.out, results, sparql) ;
			if(x!=null){
				sk+=x+",";
			}
			if(y!=null){
				sk+=y+",";
			}
			if(z!=null){
				sk+=z;
			}
			
		   // str =  x + "  "+y+"  " +z ;
		    System.out.println(str);
		    list.add(sk);
		}
		
		return list;
	}
}


