package items;

import interfaces.Closeable;
import textadventure.World;

public class CloseableContainer extends Container implements Closeable {

	private boolean isOpen;
	
	public CloseableContainer(World world, String name, int weight, boolean takeable, boolean isOpen, String description) {
		super(world, name, weight, takeable, description);
		this.isOpen = isOpen;
	}

	@Override
	public void doExamine() {
		if ( isOpen ) super.doExamine();
		else if ( !isOpen ) World.print("The " + this.getName() + " is closed.");
	}
	
	@Override
	public Item doTake( Item item ) {
		if ( isOpen ) {
			return super.doTake(item);
		} else if ( !isOpen )  {
			World.print( "The " + this.getName() + " is closed." );
			return null;
		}
		return null;
	}
	
	@Override
	public Item doPut( Item item, Container source ) {
		if ( isOpen ) super.doPut(item, source);
		else if ( !isOpen ) {
			World.print( "The " + this.getName() + " is closed." );
			return null;
		}
		return null;
	}
	
	@Override
	public boolean isOpen() {
		return isOpen;
	}

	@Override
	public void doOpen() {
		isOpen = Closeable.OPEN;
		World.print("Opened.\n\n");
		
	}

	@Override
	public void doClose() {
		isOpen = Closeable.CLOSED;
		World.print("Closed.\n\n");
	}

}
