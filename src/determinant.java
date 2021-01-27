public class determinant {
    public static void main (String[]args){
        int score[][];
        score=new int[2][2];
        score[0][0]=1;
        score[0][1]=2;
        score[1][0]=3;
        score[1][1]=4;
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}
