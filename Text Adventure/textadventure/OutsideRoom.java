package textadventure;

public class OutsideRoom extends Room {

	public OutsideRoom(String name, String description, boolean isLocked, World world) {
		super(name, description, isLocked, world);
	}

	@Override
	public void doGo() {
		
		World.print("Your carpool arrives in their car. You see their broad faces as they gleam on you from the backseat of their Acura MDX. They yell at you that you forgot your backpack, but those were for scrubs anyway.\n\n");
		if ( !getWorld().getPlayer().isDressed() ) {
			World.print("You forgot to wear pants. Or a shirt. Or anything, for that matter. You should get a trophy for epic failure. Commit seppuku.\n\n");
			System.exit(0);
		} else if ( !getWorld().getPlayer().hasBrushedTeeth() ) {
			World.print("As you get into the car, you see a purple cloud of miasma float from your mouth. Your carpool makes a joke of the barnacles encrusting your teeth as they giggle with laughter. Brush 'em good next time. The school nurse will probably lecture you on the importance of oral hygiene and brushing every century or so.\n\n");
			System.exit(0);
		} else if ( getWorld().getPlayer().getHealth() == 0 ) {
			World.print("You forgot to eat anything for breakfast. Your metabolism runs out halfway through third period as you collapse halfway through Mr. Mcleod's newest rap. THE END.\n\n");
			System.exit(0);
		} else if ( getWorld().getPlayer().getHealth() == 2 ) {
			World.print("Raw white bread is not good for your bowels. You feel the movement as you enter your carpool. It seems that all uncooked bread in this universe comes with its own version of the smallpox. Congrats. GG NO RE, AMR? Scrublord.\n\n");
			System.exit(0);
		} else {
			World.print("You become the king of the world due to your showing up to school (or something like that don't question my logic) you win the game.\n\n");
			System.exit(0);
		}
	}
	
}
