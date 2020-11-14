class students {
    private String name;
    private int ChineseScores=88;
    private int MathScores=99;
    private int EnglishScores=100;
    private int PhysicisScores=98;
    private int ChemistryScores=95;
    private int BiologyScores=96;

    public students() {
        System.out.println("输入学生姓名，查询成绩");
    }

    public students(String name, int ChineseScores, int MathScores, int EnglishScores, int PhysicisScores, int ChemistryScores, int BiologyScores) {
        this();
        this.name = name;
        this.ChineseScores = ChineseScores;
        this.MathScores = MathScores;
        this.EnglishScores = EnglishScores;
        this.PhysicisScores = PhysicisScores;
        this.ChemistryScores = ChemistryScores;
        this.BiologyScores = BiologyScores;
    }

    public String getInfo() {
        return "姓名：" + name + ",成绩：" + ChineseScores + EnglishScores + MathScores + PhysicisScores + ChemistryScores + BiologyScores;
    }
}
interface ThisStudents{
    class Outer{
        private String students="Lily";
        private String  bestSubject="English=100+";
        public String getInfo(){
            return this.students;
        }
        public void fun(){
            new Inner(this).print();
        }
    };
    class Inner{
        private Outer out=null;
        public Inner(Outer out){
            this.out=out;
        }
        public void print(){
            System.out.println(out.getInfo());
    }
    }
    public class InnerClassStudents{
        public static void main(String args[]){
            new Outer().fun();
        }
    }
}