import java.util.*;

public class Main {
    public static void main(String[] args) {
        Character player = new Character("ohyama4z", 20, 3);
        Character enemy = new Character("スライム", 15, 2);

        Scanner sc = new Scanner(System.in);
        int input;
        Random rand = new Random();

        System.out.println(player.name + "は" + enemy.name + "に遭遇した!!");
        while(true) {
            System.out.println("行動を選択してください");
            System.out.println("1: こうげき");
            System.out.println("2: まほう");
            System.out.println("3: かいふく");
            System.out.print("input: ");
            input = sc.nextInt();

            act(player,enemy,input);

            if (enemy.curHitPoint <= 0) {
               System.out.println(enemy.name + "に勝利した!!!");
               return;
            }

            System.out.println(player.name+ "のHP: " + player.curHitPoint + "/" + player.maxHitPoint);
            System.out.println(enemy.name+ "のHP: " + enemy.curHitPoint + "/" + enemy.maxHitPoint + "\n");

            act(enemy, player, rand.nextInt(3) + 1);

            if (player.curHitPoint <= 0) {
                System.out.println(enemy.name + "に敗北した...");
                return;
            }

            System.out.println(player.name+ "のHP: " + player.curHitPoint + "/" + player.maxHitPoint);
            System.out.println(enemy.name+ "のHP: " + enemy.curHitPoint + "/" + enemy.maxHitPoint + "\n");
            System.out.println("------------------------------");
        }
    }

    public static void act(Character character, Character target,int index) {
        if(index == 1) {
            character.attack(target);
        } else if(index == 2) {
            character.magic(target);
        } else if(index == 3) {
            character.heal();
        } else {
            character.uniqueAction();
        }
    }
}

class Character {
    public final String name;
    private final int attackPoint;
    public final int maxHitPoint;
    public int curHitPoint;
    Random rand = new Random();

    public Character(String name, int hitPoint, int attackPoint) {
        this.name = name;
        this.maxHitPoint = hitPoint;
        this.curHitPoint = hitPoint;
        this.attackPoint = attackPoint;
    }

    public void attack(Character attackedCharacter) {
        System.out.println(this.name+ "は" + attackedCharacter.name + "に襲いかかった!");
        attackedCharacter.damaged(this.attackPoint);
    }

    public void magic(Character attackedCharacter) {
        System.out.println(this.name + "は" + attackedCharacter.name + "に魔法を使った!");
        // attackPointの0~2倍の値
        int magicDamage = rand.nextInt(3) * this.attackPoint;
        if (magicDamage > 0) {
            attackedCharacter.damaged(magicDamage);
            return;
        }

        System.out.println("しかし当たらなかった!");
    }

    public void heal() {
        int healPoint = Math.min(this.maxHitPoint-this.curHitPoint, this.maxHitPoint / 5);
        this.curHitPoint += healPoint;

        if (healPoint > 0) {
            System.out.println(this.name + "は" + healPoint + "のHPを回復した!");
            return;
        }

        System.out.println(this.name + "はHPを回復しようとしたが、すでにHPは満タンだった");
    }

    private void damaged(int damage) {
        this.curHitPoint -= damage;
        System.out.println(this.name + "は" + damage + "のダメージを受けた!");
    }

    public void uniqueAction() {
        String[] message = new String[5];
        message[0] = this.name + "は逃げ出そうとした、しかし失敗した!";
        message[1] = this.name + "は選択肢に示されていない行動を取ろうとしたが、「システムの仕様」がそれを阻止した!";
        message[2] = this.name + "は今日の晩飯のことを考え、ただ呆然と立ち尽くした!";
        message[3] = this.name + "はクツの中に入った小石が気になり、戦闘に集中できない!";
        message[4] = this.name + "はガスの元栓を締め忘れたかもしれない、という不安に襲われている...";

        System.out.println(message[rand.nextInt(5)]);
    }
}
