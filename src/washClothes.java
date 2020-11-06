public class washClothes {
    class Human{
        public Human(){
            System.out.println("人工放入要洗的衣服");
        }
    }
    class MobilePhone{
        public MobilePhone(){
            System.out.println("手机扫描二维码并付钱");
        }
    }
    class Washing{
        public Washing(){
            System.out.println("洗衣机开始洗衣服，洗衣完成");
        }
    }
}
abstract class inform{
    public inform(){
        System.out.println("洗衣机send message通知主人洗衣finished");
    }
}
class accept extends inform{
    public accept(){
        System.out.println("主人收到message,去取衣服");
    }
}
class AbstractwashClothes {
    public static void main(String args[]){
        accept accept=new accept();
    }
}