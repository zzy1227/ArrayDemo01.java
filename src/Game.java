class Game {
    static class Player{
        private static final Object 初始生命值 = 999;
        String PlayerName;//主角名称
        int OriginalLifePoint;//主角的初始生命值
        int AttackPower;//主角的攻击力
        public void tell(){
            System.out.println("名称："+PlayerName+","初始生命值："+OriginalLifePoint+","攻击力："+AttackPower);
        }
    }
    static class Monster{
        private static final Object 初始生命值 = 998;
        String MonsterName;//怪兽名称
        int OriginalLifePoint;//怪兽的初始生命值
        int AtkPower;//怪兽的攻击力
        public void tell(){
            System.out.println("名称："+MonsterName+","初始生命值："+OriginalLifePoint+","攻击力："+AtkPower);
        }
    }
}interface A{
public class Player{
    public static void main(String args[]){
        Game.Player player = new Game.Player();//声明并实例化对象
        player.PlayerName = "超人";//为PlayerName属性赋值
        player.OriginalLifePoint = 999;//为OriginalLifePoint属性赋值
        player.AttackPower = 345;//为AtkPower属性赋值
    }
}
public class Monster{
    public static void main(String args[]){
        Game.Monster mon = new Game.Monster();//声明并实例化对象
        mon.MonsterName = "灭霸";//为MonsterName属性赋值
        mon.OriginalLifePoint = 998;//为OriginalLifePoint属性赋值
        mon.AtkPower = 789;//为AtkPower属性赋值
        }
    }
}



