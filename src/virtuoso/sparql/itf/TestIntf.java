package virtuoso.sparql.itf;

import java.util.List;

import virtuoso.jena.my.test.VirtuosoSPARQLExample1;

public class TestIntf {
	/***
	 * 在这里调用那个方法？
	 * 下面的方法是为了实现另外一个类的结果，我现在是想在这里为sparqlSentence赋值，以后只用在这个类里写入查询语句，就能输出结果了，好了。
	 */
	static String sparqlSentence = "select ?x ?y where {?x rdfs:label ?y }";


	public static void main(String[] args) {
		VirtuosoSparql a = new VirtuosoSparql();
		//就这？？我运行一下试试。
		
		List<String>list=a.query(sparqlSentence);
		for(String str:list){
			System.out.println(str);
//			可以了，真实太感谢你了，让你折腾这么久。。。。
		}
	}
}