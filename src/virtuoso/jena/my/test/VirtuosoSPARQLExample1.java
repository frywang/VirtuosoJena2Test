package virtuoso.jena.my.test;

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


public class VirtuosoSPARQLExample1 {

	public List<String> query(String sql){
		List<String> list = new ArrayList<String>();
									
/* sign virtuoso server */
		VirtGraph set = new VirtGraph ("qieyinChild", "jdbc:virtuoso://192.168.1.112:1111", "dba", "dba");
		
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

public static void main(String[] args) {
//	/* sign virtuoso server */
//	VirtGraph set = new VirtGraph ("fruit", "jdbc:virtuoso://192.168.1.112:1111", "dba", "dba");
///*		Select data in virtuoso	*/
//  //  String sparqlSentence
//    /***
//     * "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +  sparqlSentence
//     * 现在是不是要把下面这个SQ作为参数来？在BBB类中有sparqlSentence的具体值，然后这个类调用后变成查询语句
//     */
//	String sparqlSentence = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
//			+ " +select ?x ?y where {?x rdfs:label ?y }";
//	  String s2 = "PREFIX  g:    <http://www.w3.org/2003/01/geo/wgs84_pos#>\n" +
//              "PREFIX  rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
//              "PREFIX  onto: <http://dbpedia.org/ontology/>\n" +
//              "\n" +
//              "SELECT  ?subject ?stadium ?lat ?long\n" +
//              "WHERE\n" +
//              "  { ?subject g:lat ?lat .\n" +
//              "    ?subject g:long ?long .\n" +
//              "    ?subject <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> onto:Stadium .\n" +
//              "    ?subject rdfs:label ?stadium\n" +
//              "    FILTER ( ( ( ( ( ?lat >= 52.4814 ) && ( ?lat <= 57.4814 ) ) && ( ?long >= -1.89358 ) ) && ( ?long <= 3.10642 ) ) && ( lang(?stadium) = \"en\" ) )\n" +
//              "  }\n" +
//              "LIMIT   5\n" +
//              "";
//	Query sparql = QueryFactory.create(s2);
///*			STEP 4			*/
//	VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
////没有分行
//	ResultSet results = vqe.execSelect();
//	String str = "";
//	while (results.hasNext()) {
//		QuerySolution result = results.nextSolution();
////	    RDFNode x = result.get("x");
////	    RDFNode y = result.get("y");
////	    RDFNode z = result.get("z");
//////	    str = graph + " { " + s + " " + p + " " + o + " . }";
//		
//		
//		ResultSetFormatter.out(System.out, results, sparql) ;
//}

}
}

