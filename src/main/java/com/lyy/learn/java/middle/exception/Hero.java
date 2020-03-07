package com.lyy.learn.java.middle.exception;

/**
 * 自定义异常测试
 */
public class Hero {
    private String name;
    protected float hp;

    public String getName() {
        return name;
    }

    public void attackHero(Hero other) throws EnemyHeroIsDeadException {
        if (other.hp == 0) {
            throw new EnemyHeroIsDeadException(other.getName() + "已经挂了,不需要施放技能");
        }
    }

    public static void main(String[] args) {
        Hero garen = new Hero();
        garen.name = "盖伦";
        garen.hp = 616;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 0;

        try {
            garen.attackHero(teemo);
        } catch (EnemyHeroIsDeadException e) {
            System.out.println("异常的具体原因:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
