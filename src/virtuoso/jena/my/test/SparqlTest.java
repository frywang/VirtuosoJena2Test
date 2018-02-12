package virtuoso.jena.my.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  $Id: VirtuosoSPARQLExample1.java,v 1.4 2008/04/10 07:26:30 source Exp $
 *
 *  This file is part of the OpenLink Software Virtuoso Open-Source (VOS)
 *  project.
 *
 *  Copyright (C) 1998-2008 OpenLink Software
 *
 *  This project is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the
 *  Free Software Foundation; only version 2 of the License, dated June 1991.
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */

//package virtuoso.jena.driver;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
//import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;


import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

public class SparqlTest {

	/**
	 * Executes a SPARQL query against a virtuoso url and prints results.
	 * @throws IOException 
	 */
	public static void main(String[] args) {

/*			STEP 1			*/
		VirtGraph set = new VirtGraph ("fruit", "jdbc:virtuoso://192.168.1.112:1111", "dba", "dba");

/*			STEP 2			*/


/*			STEP 3			*/
/*		Select all data in virtuoso	*/
		Query sparql = QueryFactory.create("select distinct ?x where {[] a ?x} LIMIT 100");

/*			STEP 4			*/
		VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
//		 QueryExecution qExe =(QueryExecution)vqe;

//		QueryExecution qExe = QueryExecutionFactory.sparqlService("test", query);
		
		
		ResultSet results = vqe.execSelect();
//	    QuerySolution solution = (QuerySolution) results.next();
//        ResultSet results = qExe.execSelect();
//        ResultSetFormatter.out(System.out, results, query) ;
//强制所有的查询都写成x,才能适合我这样
//	   我用xyz，是因为一般都是查询1到3个值，当时这样写就是不考虑其他情况，让所有的查询输出最多只有三个结果
		while (results.hasNext()) {
			QuerySolution result = results.nextSolution();
		    RDFNode x = result.get("x");
		    RDFNode y = result.get("y");
		    RDFNode z = result.get("z");
		    
		    System.out.println( x + "  "+y+"  " +z);		    
		}
		ResultSetFormatter.asXMLString(results);
//要不就按照xyz吧，你看看能不能把Null取消掉，到时候接口就假设所有的查询都是查xyz来做 null是查不出数据还是啥的，null实际上是没这个数据，因为这个查询语句里只查x,所以yz都是Null
		//会不会出现查询  xxx  xxz  xf 的情况，不会，这种查询方式的假设是查的第一个数据是x,第二个是Y,...超过z的我暂时不考虑，就是我假设只查询三个数据，查询句式都用x,yz表示查询的数据
	}
}


//这个才是我数据库的结果
