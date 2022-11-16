package analytics_lib;

public class SubMenuFactorty {
	
	static SubMenuFactorty factory = null;
	static ArrOpMenu arrayOpsMenu = null;
	static FileOpsMenu fileOpsMenu = null;
	static SimpleOpsMenu simplesOpsMenu = null;
	static VectorOpsMenu vectorOpsMenu = null;
	
	private SubMenuFactorty() {
		
	}

	public static SubMenuFactorty getInstance() {
		if (factory == null) {
			factory = new SubMenuFactorty();
		}
		return factory;
	}
	
	public ISubMenu getSubMenuInterface(char menu) {
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
			
		case 'e':
			return null;

		default:
			return null;
			
		}
	}
}
