public class Game {
    public static void main(String[] args){
//        Character yuusya = new Character("勇者", 100, 50);
        Character yuusya = Character.createYuusya();
        System.out.println(yuusya.myName);
        System.out.println(yuusya.attackPoint);
        yuusya.attack();
        yuusya.walk();
        yuusya.heal();

        Yuusya yuusya2 = new Yuusya("勇者2", 100, 100);
        yuusya2.walk();
        yuusya2.magic();

        Teki teki  = new Teki("スライム", 10000, 1);
        teki.callNakama();
    }
}

class Character {
    public String myName;
    private int hitPoint;
    public int attackPoint;
    public static String seibetu = "男性";

    Character(String name, int hp, int attack){
        this.myName = name;
        this.hitPoint = hp;
        this.attackPoint = attack;
    }
    public void attack(){ System.out.println(this.myName + "は敵を攻撃した"); }
    public void walk() {
        System.out.println(this.myName + "は歩いている");
    }

    public void heal() {
        System.out.println(this.myName + "はHPを5回復した");
        System.out.println("現在のHP:" + (this.hitPoint + 5));
    }

    public static Character createYuusya() {
        return new Character("勇者", 100, 10);
    }
}

class Yuusya extends Character {
    Yuusya(String name, int hp, int attack) {
        super(name, hp, attack);
    }
    public void magic() {
        System.out.println(this.myName + "は魔法を使った");
    }
}
class Teki extends Character{
    Teki (String name, int hp, int attack) { super(name, hp, attack);}
    public void callNakama() { System.out.println(this.myName + "は仲間を呼んだ");}
}
/*
クラス仕様書
- クラス名 Character
- データ: String型 名前、int型 体力、int型 攻撃力
- attack: "敵を攻撃した"と出力する
- walk: "[名前]は歩いている"と出力する

Yuusyaクラス
- Characterクラス + magic: "魔法を使った"と出力

Tekiクラス
- Characterクラス + callNakama: "[名前]は仲間をよんだ"と出力
*/
