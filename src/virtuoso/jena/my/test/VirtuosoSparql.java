package virtuoso.jena.my.test;



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
import com.hp.hpl.jena.rdf.model.RDFNode;

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;



public class VirtuosoSparql {

	/**
	 * Executes a SPARQL query against a virtuoso url and prints results.
	 * @throws IOException 
	 */
	
	class SignQuery{
		
		
		public VirtGraph signIn(String graphName, String virtuosoServerAdress, String username, String password){
			
			VirtGraph set = new VirtGraph (graphName, virtuosoServerAdress, username, password);
			
			return set;
	    }
		
		
		public  String query(){
			
			String sparqlSentence;
			
			String sparqlQuestion = "" +
					  "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
					  sparqlSentence;
			
			 return sparqlQuestion;
	    }
		
		
		public void answer(){
			Query sparql = QueryFactory.create(sparqlQuestion);
			VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, set);
			ResultSet results = vqe.execSelect();
			while (results.hasNext()) {
				QuerySolution result = results.nextSolution();
			    RDFNode s = result.get("id");
			    RDFNode p = result.get("element");
			    System.out.println( s + "  " +p);		   
			    
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		VirtGraph set = new VirtGraph ("fruit", "jdbc:virtuoso://192.168.1.112:1111", "dba", "dba");
		
		
		
		
  
		}
		

	}
}
