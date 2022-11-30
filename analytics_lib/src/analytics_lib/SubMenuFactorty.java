package analytics_lib;

/**
 * Factory class to create sub menu based on the user selection.
 * @author Marina
 *
 */
public class SubMenuFactorty {
	static SubMenuFactorty factory = null; /**< Sub menu factory singleton instance. */
	ArrOpMenu arrayOpsMenu = null; /**< Array operations sub menu object. */
	FileOpsMenu fileOpsMenu = null; /**< File operations sub menu object. */
	SimpleOpsMenu simplesOpsMenu = null; /**< Simple operations sub menu object. */
	VectorOpsMenu vectorOpsMenu = null; /**< Vector operations sub menu object. */
	
	/**
	 * Private default constructor to implement singleton.
	 */
	private SubMenuFactorty() {
		
	}

	/**
	 * Gets singleton instance of the sub menu factory.
	 * @return Singleton instance to the factory.
	 */
	public static SubMenuFactorty getInstance() {
		if (factory == null) {
			factory = new SubMenuFactorty();
		}
		return factory;
	}
	
	/**
	 * Returns the sub menu object based on user selection, if object is not created it creates the object.
	 * @param Character representing user choice.
	 * @return menu instance of the sub menu object.
	 * @throws IllegalArgumentException if the selected sub menu is not valid.
	 */
	public ISubMenu getSubMenuInterface(char menu) throws IllegalArgumentException {
		switch(menu) {
		case 's':
			if (simplesOpsMenu == null) {
				simplesOpsMenu = new SimpleOpsMenu();
			}
			return simplesOpsMenu;
			
		case 'f':
			if (fileOpsMenu == null) {
				fileOpsMenu = new FileOpsMenu();
			}
			return fileOpsMenu;
			
		case 'a':
			if (arrayOpsMenu == null) {
				arrayOpsMenu = new ArrOpMenu();
			}
			return arrayOpsMenu;
			
		case 'v':
			if (vectorOpsMenu == null) {
				vectorOpsMenu = new VectorOpsMenu();
			}
			return vectorOpsMenu;
			
		default:
			throw new IllegalArgumentException("Invalid submenu choice");
			
		}
	}
}
