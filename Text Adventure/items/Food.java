package items;

import interfaces.Edible;
import textadventure.World;

public class Food extends Item implements Edible {

	
	
	public Food(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doEat() {
		
		World.print("You inhale the " + this.getName() + " and feel the calories rush through your body.\n\n");
		getWorld().getPlayer().removeItem(this);
		getWorld().getPlayer().setBrushedTeeth(false);
		if ( this.getName().equals("bread") ) getWorld().getPlayer().setHealth(2);
		else if ( this.getName().equals("toast") ) getWorld().getPlayer().setHealth(1);

	}

	@Override
	public void doUse() {
		doEat();
	}

}
