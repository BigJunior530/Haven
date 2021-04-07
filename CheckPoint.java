/**
 * This class contains the progress of the game
 * @author Carlos
 *
 */
public class CheckPoint {
	static int SMV = 0;
	static int FTV = 0;
	static int SDV = 0;
	static int GJV = 0;
	static int BTV = 0;
	static int CAV = 0;
	static int DFV = 0;
	static int CLV = 0;
	static int AVV = 0;
	static int ARV = 0;
	
	/**
	 * This returns the Snowy Mountain Variable
	 * 
	 * @return SMV
	 */
	public static int SM() {
		return SMV;
	}
	/**
	 * This returns the Frozen Tundra Variable
	 * 
	 * @return FTV
	 */
	public static int FT() {
		return FTV;
	}
	/**
	 * This returns the Scorching Dessert Variable
	 * 
	 * @return SDV
	 */
	public static int SD() {
		return SDV;
	}
	/**
	 * This returns the Green Jungle Variable
	 * 
	 * @return GJV
	 */
	public static int GJ() {
		return GJV;
	}
	/**
	 * This returns ther Bermuda Triangle Variable
	 * 
	 * @return BTV
	 */
	public static int BT() {
		return BTV;
	}
	/**
	 * This returns the Lost City of Alantis Variable
	 * 
	 * @return CAV
	 */
	public static int CA() {
		return CAV;
	}
	/**
	 * This returns the Dark Forest Variable
	 * 
	 * @return DFV
	 */
	public static int DF() {
		return DFV;
	}
	/**
	 * This returns the Crystal Lake Variable
	 * 
	 * @return CLV
	 */
	public static int CL() {
		return CLV;
	}
	/**
	 * This returns the Abandoned Village Variable
	 * 
	 * @return AVV
	 */
	public static int AV() {
		return AVV;
	}
	/**
	 * This returns the Ancient Ruins Variable
	 * 
	 * @return ARV
	 */
	public static int AR() {
		return ARV;
	}
	/**
	 * This is a placeholder
	 * 
	 * @return 0
	 */
	public static int placeHolder() {
		return 0;
	}
	/**
	 * This increases the Snowy Mountain Variable
	 * 
	 */
	public static void increaseSMV() {
		SMV++;
	}
	/**
	 * This increases the Frozen Tundra Variable
	 * 
	 */
	public static void increaseFTV() {
		FTV++;
	}
	/**
	 * This increases the Scorching Dessert Variable
	 * 
	 */
	public static void increaseSDV() {
		SDV++;
	}
	/**
	 * This increases the Green Jungle Variable
	 * 
	 */
	public static void increaseGJV() {
		GJV++;
	}
	/**
	 * This increases ther Bermuda Triangle Variable
	 * 
	 */
	public static void increaseBTV() {
		BTV++;
	}
	/**
	 * This increases the Lost City of Alantis Variable
	 * 
	 */
	public static void increaseCAV() {
		CAV++;
	}
	/**
	 * This increases the Dark Forest Variable
	 * 
	 */
	public static void increaseDFV() {
		DFV++;
	}
	/**
	 * This increases the Crystal Lake Variable
	 * 
	 */
	public static void increaseCLV() {
		CLV++;
	}
	/**
	 * This increases the Abandoned Village Variable
	 * 
	 */
	public static void increaseAVV() {
		AVV++;
	}
	/**
	 * This increases the Ancient Ruins Variable
	 * 
	 */
	public static void increaseARV() {
		ARV++;
	}
	/**
	 * This checks if the player has completed both ares in the Ocean Region
	 * 
	 */
	public static boolean checkOcean() {
		boolean result = true;
		if(BTV < 3) {
			result = false;
		}
		if(CAV < 3) {
			result = false;
		}
		return result;
	}
	/**
	 * This checks if the player has completed both ares in the West Region
	 * 
	 */
	public static boolean checkWest() {
		boolean result = true;
		if(DFV < 3) {
			result = false;
		}
		if(CLV < 3) {
			result = false;
		}
		if(ARV < 3) {
			result = false;
		}
		return result;
	}
	/**
	 * This checks if the player has completed both ares in the East Region
	 * 
	 */
	public static boolean checkEast() {
		boolean result = true;
		if(DFV < 3) {
			result = false;
		}
		if(CLV < 3) {
			result = false;
		}
		if(AVV < 3) {
			result = false;
		}
		return result;
	}
	/**
	 * This checks if the player has completed both ares in the South Region
	 * 
	 */
	public static boolean checkSouth() {
		boolean result = true;
		if(SDV < 3) {
			result = false;
		}
		if(GJV < 3) {
			result = false;
		}
		return result;
	}
	/**
	 * This checks if the player has completed both ares in the North Region
	 * 
	 */
	public static boolean checkNorth() {
		boolean result = true;
		if(SMV < 3) {
			result = false;
		}
		if(FTV < 3) {
			result = false;
		}
		return result;
	}
	/**
	 * This checks if the player has completed all land regions
	 * 
	 */
	public static boolean checkAllLand() {
		boolean result = true;
		if(checkNorth() != true) {
			result = false;
		}
		if(checkSouth() != true) {
			result = false;
		}
		if(checkWest() != true) {
			result = false;
		}
		if(checkEast() != true) {
			result = false;
		}
		return result;
	}
	/**
	 * This checks if the player has completed all regions
	 * 
	 */
	public static boolean checkAll() {
		boolean result = true;
		if(checkAllLand() != true) {
			result = false;
		}
		if(checkOcean() != true) {
			result = false;
		}
		return result;
	}
}
