package virtuoso.jena.my.test;

public class HelloWord {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str="HelloWord!";
        int a=0;
        int b=a+1;
        int result=0;
        
        for(int i=0;i<20;i++)
        {
            //Add��������
            result= Add(a,b);            
            
            System.out.println(str+" "+ result);
            
            a+=i;
            
        }
    }
    /**
     * �����÷���,����ʹ����static����Ϊ��̬����
     * @param x 
     * @param y
     * @return
     */
    private static int Add(int x,int y)
    {
        
        return x+y;
    }
}
