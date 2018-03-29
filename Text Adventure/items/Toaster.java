package items;

import textadventure.World;

public class Toaster extends Container {

	public Toaster(World world, String name, int weight, boolean takeable, String description) {
		super(world, name, weight, takeable, description);
	}

	@Override
	public void doUse() {
		
		World.print("You use the toaster...\n\n");
		if ( items.size() > 1 ) {
			World.print("There are too many items in the " + this.getName() + "\n\n");
			return;
		} else if ( items.size() == 0 ) {
			World.print("There's nothing in the " + this.getName() + " to toast.\n\n");
			return;
		} else if ( items.size() == 1 && items.containsKey("bread") ) {
			World.print("You toast the bread, chemically cooking it into a crunchy piece of toast that you can now eat. Your dad has magically altered the toaster (or so he claims) to toast bread in an instant, so you don't have to wait. You question the science behind such a device but you decide that it's not worth the time or energy right now. Strike the Toast!\n\n");
			items.remove("bread");
			items.put("toast", new Food( this.getWorld(), "toast", 2, Item.TAKEABLE, "A crunchy piece of well cooked toast. It's not charred or anything. Mostly carbs, this piece of bread is good for surviving, but not for your health.\n\n" ));
		} else if ( items.size() == 1 ) {
			World.print("You realize that whatever you just put into the toaster was not bread. The magically altered toaster begins to whine, glowing red. You back away, realizing that what you had just done was a mistake. You run to the back of the kitchen, as fire begins to spew from the top of the toaster. Your house is one fire, as you sprint for the door. In a fluke of adrenaline, you tear it off with monster strength, as your house burns down behind you. That fire spread really fast, you think to yourself, but what's important is the fact that your parents are probably going to eat you for dinner. RIP.\n\n");
			System.exit(0);
		}
		
	}
	
}
