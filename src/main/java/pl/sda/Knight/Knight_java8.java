package pl.sda.Knight;

/**
 * Created by RENT on 2017-01-14.
 */
public class Knight_java8 {
    private Weapon weapon;

    public Knight_java8() {
    }

    public Knight_java8(Weapon weapon) {
        this.weapon = weapon;
    }

    public void fight(){
        System.out.println("Knight is fighting...");
        weapon.use();
    }

    public static void main(String[] args) {
        Weapon weapon = new Sword();
        Knight_java8 knight = new Knight_java8(weapon);
        knight.fight();

        Knight_java8 knight1 = new Knight_java8(new Axe());
        knight1.fight();

        Knight_java8 knight2 = new Knight_java8(() -> System.out.println("Bashing using club"));
        knight2.fight();

    }

}
