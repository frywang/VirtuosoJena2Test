package virtuoso.sparql.itf;

import java.util.List;

import virtuoso.jena.my.test.VirtuosoSPARQLExample1;

public class TestIntf {
	/***
	 * ����������Ǹ�������
	 * ����ķ�����Ϊ��ʵ������һ����Ľ��������������������ΪsparqlSentence��ֵ���Ժ�ֻ�����������д���ѯ��䣬�����������ˣ����ˡ�
	 */
	static String sparqlSentence = "select ?x ?y where {?x rdfs:label ?y }";


	public static void main(String[] args) {
		VirtuosoSparql a = new VirtuosoSparql();
		//���⣿��������һ�����ԡ�
		
		List<String>list=a.query(sparqlSentence);
		for(String str:list){
			System.out.println(str);
//			�����ˣ���ʵ̫��л���ˣ�����������ô�á�������
		}
	}
}