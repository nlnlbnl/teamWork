public class Bucket {
    private int capacity;       //水桶容量
    private int amount;         //水桶当前水量

    public Bucket(int capacity, int amount) {
        this.capacity = capacity;
        this.amount = amount;
    }

    public Bucket(){

    }

    public void fill(){
        this.amount = this.capacity;
    }

    public void empty(){
        this.amount = 0;
    }

    public void pourTo(Bucket other){
        int otherAmount;
        otherAmount = other.capacity - other.amount;
        if(otherAmount <= this.amount){
            other.fill();
            this.amount = this.amount - otherAmount;
        }
        else{
            this.empty();
            other.amount = this.amount + other.amount;
        }
    }

    public int getAmount(){
        return this.amount;
    }

    public int getCapacity(){
        return this.capacity;
    }
}
