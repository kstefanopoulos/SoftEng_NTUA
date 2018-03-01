package ch2;

import java.util.Set;

public class HelpMethods {
	
	public HelpMethods () {};
	
	
	public void check_and_remove(Set<willattend> rem, parent par, Set<willattend> wa, Set<hasattended> ha, OrganizerController oc) {
		
		for (willattend i : rem) {
			//remove this from the parent
			int f=0;  // 0->not found, 1->found
			event e= i.getAnevent();
			for (hasattended h : ha) {
				if (e.getEventId()==h.getAnevent().getEventId()) {
					f=1;
					break;
			} }
			if (f==0) {
				hasattended h= new hasattended();
				h.setAnevent(i.getAnevent());
				h.setAparent(par);
				ha.add(h); }
			//remove this from the event e
			organizer myorg=e.getMyorganizer();
			Set<willattend> ew = e.getWillbeattented();
			willattend wi;
			for (willattend w: ew) {
				if (w.getId()==i.getId()) {
					wi=w;
					w.setValid(0);
					ew.remove(w);
				}
			}
			f=0;
			Set<hasattended> eh = e.getHasattended();
			for (hasattended h : eh) {
				if (h.getAparent().getPemail().equals(par.getPemail())) {
					f=1;
					break;
			} }
			if (f==0) {
				hasattended h= new hasattended();
				h.setAnevent(i.getAnevent());
				h.setAparent(par);
				eh.add(h); }
			oc.UpdateUser(myorg.getOemail());
	  }
	}
		

}
