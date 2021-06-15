import java.util.Random;

public abstract class Unit
{
    private String name;
    private int health;
    private int attackScoreMin;
    private int attackScoreMax;
    private int defenceScoreMin;
    private int defenceScoreMax;

    public Unit(String name, int attackScoreMin, int attackScoreMax, int defenceScoreMin, int defenceScoreMax){
        this.health = 100;
        this.name = name;
        this.attackScoreMin = attackScoreMin;
        this.attackScoreMax = attackScoreMax;
        this.defenceScoreMin = defenceScoreMin;
        this.defenceScoreMax = defenceScoreMax;
    }

    public String Attack(Unit enemyUnit){
        int attackScore = new Random().nextInt((attackScoreMax + 1) - attackScoreMin) + attackScoreMin;
        int defenceScore = enemyUnit.Defend(attackScore);
        return this.name + " Unit Attack To " + enemyUnit.getName() + " Unit With " + attackScore + " Attack Score And " + enemyUnit.getName() + " Unit Defend With " + defenceScore + " Defence Score, New Health Of " + enemyUnit.getName() + " Unit is " + enemyUnit.getHealth();
    }

    public int Defend(int attackScore){
        int defenceScore = new Random().nextInt((defenceScoreMax + 1) - defenceScoreMin) + defenceScoreMin;
        int damage = attackScore - defenceScore;
        if(damage > 0){
            this.health -= damage;
            if(this.health < 0){
                this.health = 0;
            }
        }
        return defenceScore;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackScoreMin() {
        return attackScoreMin;
    }

    public int getAttackScoreMax() {
        return attackScoreMax;
    }

    public int getDefenceScoreMin() {
        return defenceScoreMin;
    }

    public int getDefenceScoreMax() {
        return defenceScoreMax;
    }
}
