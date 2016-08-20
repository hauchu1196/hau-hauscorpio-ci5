package controllers.enemies;

import controllers.Colliable;
import controllers.CollisionPool;
import controllers.ExplosionController;
import controllers.SingleController;
import controllers.bombs.BombSubscriber;
import controllers.bombs.FreezeSubscriber;
import controllers.bombs.NotificationCenter;
import models.EnemyPlane;
import models.Explosion;
import models.GameSetting;
import utils.Utils;
import views.AnimationDrawer;
import views.GameDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class EnemyController extends SingleController implements Colliable, BombSubscriber, FreezeSubscriber {
    private FlyBehavior flyBehavior;
    private ShotBehavior shotBehavior;
    private FreezeBehavior freezeBehavior;
    private EnemyState enemyState;
    private static int FREEZE_PERIOD = 200;
    private static int maxHpOfTypeWhite = 2;
    private static int maxHpOfTypeYellow = 1;
    private int freezeCount;


    public EnemyState getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    public EnemyController(EnemyPlane gameObject, GameDrawer gameDrawer, FlyBehavior flyBehavior, ShotBehavior shotBehavior, FreezeBehavior freezeBehavior) {
        super(gameObject, gameDrawer);
        this.flyBehavior = flyBehavior;
        this.shotBehavior = shotBehavior;
        this.freezeBehavior = freezeBehavior;
        enemyState = EnemyState.NORMAL;

        CollisionPool.getInstance().add(this);
        NotificationCenter.getInstance().subscribe(this);
        NotificationCenter.getInstance().subscribeFreeze(this);
    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;
        switch (type) {
            case WHITE:
                enemyController = new EnemyController(
                        new EnemyPlane(x, y, maxHpOfTypeWhite),
                        new AnimationDrawer(
                                Utils.loadImages(
                                        "resources/enemy_plane_white_1.png",
                                        "resources/enemy_plane_white_2.png",
                                        "resources/enemy_plane_white_3.png"
                                )
                        ),
                        new FlyVerticalBehavior(),
                        new ShowFollowBehavior(),
                        new FreezeBehavior(FREEZE_PERIOD)
                );
                break;
            case YELLOW:
                enemyController = new EnemyController(
                        new EnemyPlane(x, y, maxHpOfTypeYellow),
                        new AnimationDrawer(
                                Utils.loadImages(
                                        "resources/enemy_plane_yellow_1.png",
                                        "resources/enemy_plane_yellow_2.png",
                                        "resources/enemy_plane_yellow_3.png"
                                )
                        ),
                        new FlyZigZacBehavior(),
                        new ShotStraightBehavior(),
                        new FreezeBehavior(FREEZE_PERIOD)
                );
                break;
        }
        return enemyController;
    }

    @Override
    public void run() {
        switch (this.enemyState) {
            case NORMAL:
                super.run();
                if (this.gameObject.getY() > GameSetting.getInstance().getScreenHeight()) {
                    this.gameObject.destroy();
                }
                if (flyBehavior != null) {
                    flyBehavior.doFly(this);
                }
                if (shotBehavior != null) {
                    shotBehavior.doShot(this);
                }
                break;
            case FREEZED:
                break;
        }

        if (freezeBehavior != null) {
            freezeBehavior.run(this);
        }
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    @Override
    public void onBombExplode(int x, int y) {
        this.destroy();
    }

    public void destroy() {
        gameObject.destroy();
        ExplosionController explosionController = new ExplosionController(
                new Explosion(gameObject.getX(), gameObject.getY()),
                new AnimationDrawer(
                        Utils.loadFromSprite("resources/explosion.png", true, 32, 32, 1),
                        true
                )
        );
        EnemyControllerManager.getInstance().add(explosionController);
    }

    @Override
    public void onFreeze(int x, int y) {
        enemyState = EnemyState.FREEZED;
    }
}
