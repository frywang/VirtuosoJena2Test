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
//ǿ�����еĲ�ѯ��д��x,�����ʺ�������
//	   ����xyz������Ϊһ�㶼�ǲ�ѯ1��3��ֵ����ʱ����д���ǲ�������������������еĲ�ѯ������ֻ���������
		while (results.hasNext()) {
			QuerySolution result = results.nextSolution();
		    RDFNode x = result.get("x");
		    RDFNode y = result.get("y");
		    RDFNode z = result.get("z");
		    
		    System.out.println( x + "  "+y+"  " +z);		    
		}
		ResultSetFormatter.asXMLString(results);
//Ҫ���Ͱ���xyz�ɣ��㿴���ܲ��ܰ�Nullȡ��������ʱ��ӿھͼ������еĲ�ѯ���ǲ�xyz���� null�ǲ鲻�����ݻ���ɶ�ģ�nullʵ������û������ݣ���Ϊ�����ѯ�����ֻ��x,����yz����Null
		//�᲻����ֲ�ѯ  xxx  xxz  xf ����������ᣬ���ֲ�ѯ��ʽ�ļ����ǲ�ĵ�һ��������x,�ڶ�����Y,...����z������ʱ�����ǣ������Ҽ���ֻ��ѯ�������ݣ���ѯ��ʽ����x,yz��ʾ��ѯ������
	}
}


//������������ݿ�Ľ��
