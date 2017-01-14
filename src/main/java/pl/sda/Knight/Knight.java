package pl.sda.Knight;

/**
 * Created by RENT on 2017-01-14.
 */
public class Knight {
    private Weapon weapon;

    public Knight() {
    }

    public Knight(Weapon weapon) {
        this.weapon = weapon;
    }

    public void fight(){
        System.out.println("Knight is fighting...");
        weapon.use();
    }

    public static void main(String[] args) {
        Weapon weapon = new Sword();
        Knight knight = new Knight(weapon);
        knight.fight();

        Knight knight1 = new Knight(new Axe());
        knight1.fight();

        Knight knight2 = new Knight(new Weapon() {
            @Override
            public void use() {
                System.out.println("Bashing using club");
            }
        });
        knight2.fight();

    }

}
