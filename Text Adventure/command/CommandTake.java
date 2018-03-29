package command;

import items.Container;
import items.Item;
import textadventure.World;

public class CommandTake extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[]{"take", "get", "grab", "hold"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if (params.length == 1) {
			String itemName = params[0];
			if (world.getPlayer().getCurrentRoom().hasItem(itemName)) {
				Item item = world.getPlayer().getCurrentRoom().getItem(itemName);
				item.doTake(world.getPlayer().getCurrentRoom());
			}
			else if (world.getPlayer().hasItem(itemName))
				World.print("You already have that!\n\n");
			else
				World.print("You can't see any " + itemName + " here.\n\n");
		}
		else if ( params.length == 3 ) {
			String container = params[2];
			String item = params[0];
			Container container1 = (Container) world.getPlayer().getCurrentRoom().getItem(container);
			Item item1 = container1.getItem(item);
			if ( !params[1].equals("from") ) {
				World.print("I don't understand.\n\n");
			} else if ( !world.getPlayer().getCurrentRoom().hasItem( container ) && !world.getPlayer().hasItem(container) ) {
				World.print("You can't see any " + container + " here.\n\n");
			} else if ( !container1.hasItem(item) ) {
				World.print("You can't see any " + item + " here.\n\n");
			} else if ( !(world.getPlayer().getCurrentRoom().getItem(container) instanceof Container) ) {
				World.print( "The " + container + " can't hold things!" );
			} else if ( !((Container) world.getPlayer().getCurrentRoom().getItem(container)).hasItem( item ) ) {
				World.print( "The " + container + " doesn't have a[n] " + item +"."  );
			} else {
				container1.doTake(item1);
			}
			
		} else {
			World.print("I don't understand.\n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "[item] or [item] from [container]";
	}

}
