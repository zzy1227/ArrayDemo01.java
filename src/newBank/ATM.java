package newBank;

import java.util.Scanner;
//ATM类
public class ATM {
    //有一个类操作数据的类
    private Data data= new Data();
    //ATM机里的数据
    private String userName;//用户账号唯一
    private String userPassword;//用户密码
    private double userMoney;//用户账户里的钱
    private double money;//变量，存，取，转账的钱
    private String user;//使用该台ATM机的用户全部信息

    //ATM界面
    public void show(){
        System.out.println("欢迎使用ATM机");
        //使用登录方法，输入账号和密码
        int number = login();
        //如果登陆成功
        if(number == 4)
            working();//ATM机办理业务
    }
    //登录方法
    private int login(){
        int number = 3;//用户输入次数
        while(number >0) {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入账号：");
            //输入账号
            String inUserName = input.nextLine();
            //输入密码
            System.out.println("请输入密码:");
            String inUserPassword = input.nextLine();
            String x = data.backUser(inUserName);
            //判断账户是否存在
            if(!x.equals("null")){
                user = x;//获取用户所有信息
                String[] str = user.split("\\*");//将用户信息分割
                userName = str[0];//用户名
                userName = str[1];//用户密码
                userMoney = Double.parseDouble(str[2]);//用户余额
                    // 密码正确
                if(userPassword.equals(inUserPassword)){
                    System.out.println("登陆成功");
                    number = 4;//次数变为4
                    break;
                }
            }
            number --;//次数减一
            System.out.println("账号或密码输入错误...");
            System.out.println("您还有"+number+"次机会");
        }
        return number;//是否登录成功
    }

    //功能页面
    private void functionShow(){
        System.out.println("****************");
        System.out.println("\t欢迎使用ATM机");
        System.out.println("1,账户余额查询\n2,存钱\n3，取钱\n4,转账\n5,修改用户密码\n");
        System.out.println("*****************");
    }

    //用户要进行的操作
    private void working(){
        String index;//业务序号
        do{
            functionShow();//调用功能界面
            System.out.println("请输入要办理的业务序号：");
            Scanner input = new Scanner(System.in);
            index = input.nextLine();
            switch(index){
                case"1":
                    look();
                    break;
                case"2":
                    saveMoney();
                    break;
                case"3":
                    getMoney();
                    break;
                case "4":
                    giveMoney();
                    break;
                case "5":
                    changePassword();
                    break;
                case "6":
                    System.out.println("欢迎下次光临！");
                    user = changeUser(userName,userPassword,userMoney);
                    data.saveData(user,true);//用户退出后保存用户信息
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入.....");
            }
        }while(!index.equals("6"));
    }

    //是否继续某项操作
    private boolean isContinue(){
        System.out.println("继续办理该项业务：请输入Y/y");
        System.out.println("返回上一级：请输入N/n");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if(str.equalsIgnoreCase("Y"))
            return true;
        else
            return false;
    }

    //存钱，取钱，转账公用
    private void howMuch(String str){
        System.out.println("欢迎办理"+str+"业务。。。。。");
        System.out.println("请输入金额(只能是整数且是100的倍数，最多10000):");
        Scanner input = new Scanner(System.in);
        Double money = input.nextDouble();
        if(money%10 != 0){
            System.out.println("您的输入有误！");
            this.money = 0;
        }
        else
            this.money = money;
    }

    //查询实现
    private void look(){
        System.out.println("用户余额为："+userMoney);
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //存钱实现
    private void saveMoney(){
        howMuch("存钱");
        if(money !=0) {//如果存钱正确
            userMoney = userMoney + money;//存上
            System.out.println("已存入");
            look();//显示余额
        }
        if(isContinue())
            saveMoney();
    }

    //判断余额是否充足
    private boolean isEnough(){
        if(money <= userMoney){
            userMoney = userMoney - money;
            return true;
        }
        else{
            System.out.println("您的余额不足！");
            return false;
        }
    }

    //取钱实现
    private void getMoney(){
        howMuch("取钱");
        //如果取的钱正确且转账账户余额够
        if(money != 0 && isEnough()){
            look();
            System.out.println("请收好您的钱");
        }
        if(isContinue())
            getMoney();
    }

    //转账实现
    private void giveMoney(){
        //只判断用户账户是否存在
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要转账账号：");
        //输入账号
        String inUserName = input.nextLine();
        String str = data.backUser(inUserName);
        //如果该账户存在
        if(!str.equals("null")){
            String antherUser = str;//获取被转账账户信息
            String[] str1 = antherUser.split("\\*");//分割
            Double x = Double.parseDouble(str1[2]);//获取被转账账户余额
            howMuch("转账");
            //如果转的钱正确且如果转账账户余额够
            if (money != 0&& isEnough()){
                x = x + money;
                antherUser = changeUser(str1[0],str1[1],x);//改变被转账账户信息
                data.saveData(antherUser,false);//将用户信息传给Data类保存被转账账户信息
                System.out.println("转账成功");
                look();
            }
        }
        else
            System.out.println("被转账账户不存在....");
        if(isContinue())
            giveMoney();
    }

    //修改密码实现
    private void changePassword(){
        System.out.println("请输入新密码：");
        Scanner input = new Scanner(System.in);
        userPassword = input.nextLine();
        System.out.println("修改密码成功！");
    }

    //办理业务后修改用户信息
    private String changeUser(String n,String w,Double d){
        String str = n + "*" + w + "*" + d;
        return str;
    }
}
