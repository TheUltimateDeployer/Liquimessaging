package org.liquimessaging.config;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ChangeSetProcessor {
	
	
	
	public void process(LiquiMessaging lm)  {
		List<ChangeSet> allChangeSets = resolveImports(lm);
		detectNonExecutedChangesSets(allChangeSets);
	}


	
	private void resolveImports(LiquiMessaging lm) {
		// TODO Auto-generated method stub
		
	}



	public void execute(List<ChangeSet> changeSets) throws ChangeException{
		for (Iterator<ChangeSet> iterator = changeSets.iterator(); iterator.hasNext();) {
			ChangeSet changeSet = (ChangeSet) iterator.next();
			changeSet.execute();
		}
	}
	
}
