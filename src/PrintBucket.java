public class PrintBucket {
    public void printStart(){
        System.out.println("水桶游戏开始......");
        System.out.println("目标：使其中一个桶的水量是4升");
    }

    public void printRow(Bucket b, int height){
        if(b.getCapacity()<height){
            System.out.print("       ");
            return;
        }
        if(b.getAmount()<height){
            System.out.print(height+"|    |");
        }
        else {
            System.out.print(height+"|WW  |");
        }
    }

    public void Printbucket(Bucket b1, Bucket b2, Bucket b3){
        for(int i=8; i >= 1; i--){
            printRow(b1,i);
            printRow(b2,i);
            printRow(b3,i);
            System.out.println();
        }
        System.out.println(" +----+ +----+ +----+");
    }

    public void printCommand(){
        System.out.println("你可以：");
        System.out.println("（F）注满一个桶");
        System.out.println("（E）清空一个桶");
        System.out.println("（P）从一个桶向另一个桶倒水");
        System.out.println("（Q）退出");
        System.out.print(">");
    }
}
