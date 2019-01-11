package balloonsTowerDefence;

import java.util.concurrent.CopyOnWriteArrayList;

public class MonkeyTowerNinjaMonkey extends MonkeyTower {

	public MonkeyTowerNinjaMonkey(Floor startingFloor, CopyOnWriteArrayList<Balloon> balloons) {
		super(MonkeyTowerType.NinjaMonkey, startingFloor, balloons);
	}

	@Override
	public void shoot(Balloon target) {
		super.setAngle(super.getAngle() + 270);
		super.darts.add(new DartNinjaStar(super.type.dartType, super.Target, super.getX(), super.getY(), 32, 32));
		super.acquireTarget();
	}
}
