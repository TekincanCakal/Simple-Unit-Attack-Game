import java.util.Random;
import java.util.Scanner;

public class Game
{
    private BlueUnit blueUnit;
    private RedUnit redUnit;

    public Game(){
        init();
    }

    public void init(){
        this.blueUnit = new BlueUnit();
        this.redUnit = new RedUnit();
    }

    public void start(){
        Random rnd = new Random();
        while (true){
            if(rnd.nextBoolean()){
                System.out.println(blueUnit.Attack(redUnit));
                if(redUnit.getHealth() <= 0){
                    System.out.println(blueUnit.getName() + " Unit Won");
                    break;
                }
            }
            else{
                System.out.println(redUnit.Attack(blueUnit));
                if(blueUnit.getHealth() <= 0){
                    System.out.println(redUnit.getName() + " Unit Won");
                    break;
                }
            }
        }
        askForRepeat();
    }

    public void askForRepeat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 For Reset The Game");
        int answer = scanner.nextInt();
        if(answer == 1){
            init();
            start();
        }
        else {
            System.exit(0);
        }
    }
}
