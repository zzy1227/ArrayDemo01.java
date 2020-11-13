import java.util.Scanner;
public class sisterzhangtao{
    public static void main(String[] args)
    {
        Scanner z=new Scanner(System.in);
        System.out.println("输入时间：");
        int a= 5.NextInt();
        if (a<0||a>=24){
            System.out.println("无法输出");
        }else{if (7>=a||a>=18){
            System.out.println("张涛姐姐该回复学妹了");
        }else{
            System.out.println("张涛姐姐该回复学弟了");
        }}
    }

    private static void NextInt() {
    }
}
