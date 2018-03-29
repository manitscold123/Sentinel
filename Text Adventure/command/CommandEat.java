package command;

import items.Food;
import textadventure.World;

public class CommandEat extends Command {

	@Override
	public String[] getCommandWords() {
		return new String[] {"eat", "consume", "devour", "inhale"};
	}

	@Override
	public void doCommand(String cmd, String[] params, World world) {
		
		if ( params.length != 1 ) {
			World.print("What do you want to eat?\n\n");
			return;
		}
		String foodString = params[0];
		Food food;
		if ( world.getPlayer().hasItem(foodString) ) food = (Food) world.getPlayer().getItem(foodString) ;
		else if ( world.getPlayer().getCurrentRoom().hasItem(foodString) ) food = (Food) world.getPlayer().getCurrentRoom().getItem(foodString);
		else {
			World.print("Can't see any " + foodString + "[s] here!\n\n");
			return;
		}
		if ( food instanceof Food ) {
			food.doEat();
		} else {
			World.print("You think about eating the " + foodString + " but afterwards decide that consuming it would be both be bad for you health and your sanity. Probably should find some real food to consume. Some souls might be delish as well.\n\n");
		}
	}

	@Override
	public String getHelpDescription() {
		return "[food item]";
	}

}
