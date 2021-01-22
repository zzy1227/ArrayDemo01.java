public class ChengFaBiaoTest {
    public static void main (String[] args){
        for (int i=1;i<=9;i++){//控制行数
            for (int k=1;k<=i;k++){//控制每行的列数
                System.out.print(k+"*"+i+"="+(i*k)+"\t");
            }
            System.out.println();
        }
    }
}
