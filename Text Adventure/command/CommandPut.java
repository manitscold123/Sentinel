package command;

import items.Container;
import items.Item;
import textadventure.World;

public class CommandPut extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[]{ "put", "drop" };
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		if ( params.length != 3 || !params[1].equals("in") ) {
			World.print("Incorrect Syntax.\n\n");
		}
		String itemString = params[0];
		String containerString = params[2];
		Item item = null;
		if ( world.getPlayer().hasItem(itemString) ) {
			item = world.getPlayer().getItem(itemString);
		} else if ( world.getPlayer().getCurrentRoom().hasItem(itemString) ) {
			item = world.getPlayer().getCurrentRoom().getItem(itemString);
		} else {
			World.print( "Can't see any " + itemString +"[s] here!\n\n" );
			return;
		}
		
		Container container = null;
		if ( world.getPlayer().hasItem(containerString) ) {
			if ( world.getPlayer().getItem(containerString) instanceof Container ) container = (Container) world.getPlayer().getItem(containerString);
			else {
				World.print( "The " + containerString + " can't hold things.\n\n" );
				return;
			}
		} else if ( world.getPlayer().getCurrentRoom().hasItem(containerString) ) {
			if ( world.getPlayer().getCurrentRoom().getItem(containerString) instanceof Container ) container = (Container) world.getPlayer().getCurrentRoom().getItem(containerString); 
			else {
				World.print( "The " + containerString + " can't hold things.\n\n" );
				return;
			}
		} else {
			World.print( "Can't see any " + containerString +"[s] here!\n\n" );
			return;
		}
		if ( container.equals(item) ) World.print("Can't put the " + container + " into itself!");  

		if ( world.getPlayer().hasItem(item) ) container.doPut(item, world.getPlayer());
		else container.doPut(item, world.getPlayer().getCurrentRoom());
		
	}

	@Override
	public String getHelpDescription() {
		return "[item] in [container]";
	}

}












