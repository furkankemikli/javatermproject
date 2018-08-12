package si.um.opj.kemikli.logic;

import si.um.opj.kemikli.logic.persons.Passenger;

public interface Salable {
	/*only launcher needs some changes to check its correct*/

	public void sellTicket(int cabin,Passenger passenger);
	public void cancelTicket(int cabin,Passenger passenger);
	public boolean cabinEmpty(int cabin);
}
