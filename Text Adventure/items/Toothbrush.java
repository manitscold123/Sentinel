package items;

import textadventure.World;

public class Toothbrush extends Item {

	public Toothbrush(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {

		World.print("You brush your teeth with your toothbrush. How impressive. Would you like a medal now? Perhaps gold for the olympic orathlon? HMMM?\n\n");
		getWorld().getPlayer().setBrushedTeeth(true);
		
	}

}
