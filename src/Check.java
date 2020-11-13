public class Check {
        public boolean validate(String name,
                                String password){
            if(name.equals("Xiaozhang")
                    &&password.equals("mldn")){
                return ture;
            }else{
                return false;
            }
        }
    }
class Operate{
    private String info[];
    public Operate(String info[]){
        this.info=info;
    }
}