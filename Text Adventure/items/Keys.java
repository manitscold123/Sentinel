package items;

import textadventure.World;

public class Keys extends Item {

	public Keys(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {

		if ( getWorld().getPlayer().getCurrentRoom().getName().equals(World.HALLWAY) ) {
			getWorld().getRoom(World.BATHROOM).doUnlock();
			World.print("With a click the bathroom unlocks.\n\n");
		} else if ( getWorld().getPlayer().getCurrentRoom().getName().equals(World.KITCHEN) ) {
			getWorld().getRoom(World.OUTSIDE).doUnlock();
			World.print("With a click the door to the outside unlocks.\n\n");
		} else {
			World.print("The " + this.getName() + " doesn't fit anything here.\n\n");
		}
		
	}

}
