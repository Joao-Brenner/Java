package controle;


public class ControleEnquanto {
    private int num;
            int sum;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        sum = sum + this.num;
       
    }

    public int getSum() {
        return sum;
    }
 
   
    
    
}