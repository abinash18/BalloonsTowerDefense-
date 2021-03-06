/**
 * Abinash Singh 
 * Balloons Tower Defense MonkeyTowerType 
 */
package balloonsTowerDefence;

import static other.DrawInFrame.LoadTexture;
import static other.DrawInFrame.getTexture;

import org.newdawn.slick.opengl.Texture;

/**
 * This class outline the default variables for each monkey tower 
 */
public enum MonkeyTowerType {

	DartMonkey(new Texture[] { LoadTexture("DartMonkey") }, DartType.NormalDart, 10, 271, 1, 50, getTexture("dart_monkey_avatar_small")), 
	NinjaMonkey(new Texture[] { LoadTexture("NinjaMonkey") }, DartType.NinjaStar, 10, 271, 1, 200, getTexture("ninja_avatar_small")), 
	SuperMonkey(new Texture[] { getTexture("SuperMonkey") }, DartType.Lazer, 10, 271, 0.1f, 3000, getTexture("supermonkey_avatar_small")),
	IceMonkey(new Texture[] { getTexture("ice_monkey_base1"), getTexture("ice_tower_monkey") }, DartType.NormalDart, 0, 271, 0.8f, 500, getTexture("ice_avatar_small"));

	Texture[] textures;
	private Texture icon;
	DartType dartType;
	int damage, range, cost;
	float firingSpeed;

	MonkeyTowerType(Texture[] textures, DartType dartType, int damage, int range, float firingSpeed, int cost,
			Texture icon_tex) {
		this.textures = textures;
		this.dartType = dartType;
		this.damage = damage;
		this.range = range;
		this.firingSpeed = firingSpeed;
		this.cost = cost;
		this.setIcon(icon_tex);
	}

	public Texture getIcon() {
		return icon;
	}

	public void setIcon(Texture icon) {
		this.icon = icon;
	}

}