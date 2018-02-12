package virtuoso.jena.my.test;

import java.util.List;


public class BBB {
	/***
	 * ����������Ǹ�������
	 * ����ķ�����Ϊ��ʵ������һ����Ľ������������������ΪsparqlSentence��ֵ���Ժ�ֻ�����������д���ѯ��䣬�����������ˣ����ˡ�
	 */
	static String sparqlSentence = "select ?x ?y where {?x rdfs:label ?y }";


	public static void main(String[] args) {
		VirtuosoSPARQLExample1 a = new VirtuosoSPARQLExample1();
		//���⣿��������һ�����ԡ�
		
		List<String>list=a.query(sparqlSentence);
		for(String str:list){
			System.out.println(str);
//			�����ˣ���ʵ̫��л���ˣ�����������ô�á�������
		}
	}
}

