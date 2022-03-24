import org.jetbrains.annotations.Nullable;

import java.util.Scanner;

public class StartGame {
    public static char selectAction() {
        Scanner in = new Scanner(System.in);
        char action = in.next().charAt(0);
        while (action!='F' && action!='f'&& action!='E'&& action!='e'&& action!='P'&& action!='p'&& action!='Q'&& action!='q')
            action = in.next().charAt(0);
        return action;
    }

    public static @Nullable
    Bucket selectBucket(Bucket b1, Bucket b2, Bucket b3) {
        Scanner in = new Scanner(System.in);
        char c;
        c=in.next().charAt(0);
        if(c=='q'||c=='Q')
            return null;
        if(b1.getCapacity()==(c-'0'))
            return b1;
        else if(b2.getCapacity()==(c-'0'))
            return b2;
        else if(b3.getCapacity()==(c-'0'))
            return b3;
        else{
            System.out.println("没有这个水桶，请重新选择");
            return selectBucket(b1,b2,b3);
        }
    }

    public static void main(String[] args) {
        Bucket b1=new Bucket(8,0);
        Bucket b2=new Bucket(5,0);
        Bucket b3=new Bucket(3,0);
        Bucket select1;
        Bucket select2;
        int step=0;
        PrintBucket printbucket=new PrintBucket();
        printbucket.printStart();
        long startTime =  System.currentTimeMillis();
        while(b1.getAmount()!=4 && b2.getAmount()!=4 && b3.getAmount()!=4){
            //Scanner scan = new Scanner(System.in);
            printbucket.Printbucket(b1,b2,b3);
            printbucket.printCommand();
            char c1=selectAction();
            switch (c1) {
                case 'F':{
                    System.out.print("选一个桶 8,5,3 or Q（退出）:");
                    select1 = selectBucket(b1, b2, b3);
                    if (select1 == null){
                        System.out.println("谢谢！");
                        System.exit(0);
                    }
                    select1.fill();
                    step++;
                    break;
                }
                case 'E':{
                    System.out.print("选一个桶 8,5,3 or Q（退出）:");
                    select1 = selectBucket(b1, b2, b3);
                    if (select1 == null){
                        System.out.println("谢谢！");
                        System.exit(0);
                    }
                    select1.empty();
                    step++;
                    break;
                }
                case 'P':{
                    System.out.print("选一个桶 8,5,3 or Q（退出）:");
                    select1 = selectBucket(b1, b2, b3);
                    if (select1 == null){
                        System.out.println("谢谢！");
                        System.exit(0);
                    }
                    System.out.print("选一个倒入的桶:");
                    select2 = selectBucket(b1, b2, b3);
                    if (select2 == null){
                        System.out.println("谢谢！");
                        System.exit(0);
                    }
                    select1.pourTo(select2);
                    step++;
                    break;
                }
                case 'Q':{
                    System.out.println("谢谢！");
                    System.exit(0);
                }
            }
            System.out.println();
        }
        long endTime =  System.currentTimeMillis();
        System.out.println("你用"+step+"步完成了游戏！");
        System.out.println("你用"+(endTime-startTime)/1000+"s完成了游戏！");
    }
}
