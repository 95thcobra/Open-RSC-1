/**
* Generated By NPCScript :: A scripting engine created for openrsc by Zilent
*/
//npc ID 446
package org.openrsc.server.npchandler.Plague_City;
import org.openrsc.server.event.DelayedQuestChat;
import org.openrsc.server.event.SingleEvent;
import org.openrsc.server.model.Npc;
import org.openrsc.server.model.Player;
import org.openrsc.server.model.Quest;
import org.openrsc.server.model.World;
import org.openrsc.server.npchandler.NpcHandler;



public class Ted implements NpcHandler 
{

	public void handleNpc(final Npc npc, final Player owner) throws Exception 
	{
		npc.blockedBy(owner);
		owner.setBusy(true);
		Quest q = owner.getQuest(35);
		if(q != null) 
		{
			if(q.finished())
			{
				finished(npc, owner);
			} 
			else 
			{
				switch(q.getStage())
				{
					default:
						noQuestStarted(npc, owner);
				}
			}
		} 
		else
		{
			noQuestStarted(npc, owner);
		}
	}
	
	private void noQuestStarted(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"Hi I hear a woman called Elena is staying here"}, true) 
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Yes she was staying here", "but slightly over a week ago she was getting ready to go back", "However she never managed to leave", "My Daughter Milli was playing near the west wall", "When she saw some shadowy figures jump out and grab her", "Milli is upstairs if you wish to speak to her"}) 
				{
					public void finished()
					{	
						owner.setBusy(false);
						npc.unblock();						
					}
				});
			}
		});
	}
	
	private void finished(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
		{
			public void action()
			{
				owner.sendMessage("Ted is not interested in talking");
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}
	
}