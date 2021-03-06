/**
* Generated By NPCScript :: A scripting engine created for openrsc by Zilent
*/
//npc ID 454
package org.openrsc.server.npchandler.Plague_City;
import org.openrsc.server.event.DelayedQuestChat;
import org.openrsc.server.event.SingleEvent;
import org.openrsc.server.model.ChatMessage;
import org.openrsc.server.model.MenuHandler;
import org.openrsc.server.model.Npc;
import org.openrsc.server.model.Player;
import org.openrsc.server.model.Quest;
import org.openrsc.server.model.World;
import org.openrsc.server.npchandler.NpcHandler;



public class Bravek implements NpcHandler
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
					case 9:
						questStage9(npc, owner);
					break;
					case 10:
						questStage10(npc, owner);
					break;
					case 11:
						questStage11(npc, owner);
					break;
					case 12:
						questStage12(npc, owner);
					break;
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
	
	private void questStage9(final Npc npc, final Player owner)
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"My head hurts", "I'll speak to you another day"}, true)
		{
			public void finished()
			{	
				World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
				{
					public void action()
					{
						final String[] options107 = {"This is really important though", "Ok goodbye"};
						owner.setBusy(false);
						owner.sendMenu(options107);
						owner.setMenuHandler(new MenuHandler(options107) 
						{
							public void handleReply(final int option, final String reply)
							{
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView())
								{
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) 
								{
									case 0:
										importantTho(npc, owner);
									break;
									case 1:
										owner.setBusy(false);
										npc.unblock();
									break;
								}
							}
						});
					}
				});	
			}	
		});			
	}
	
	private void importantTho(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"I can't possibly speak to you with my head spinning like this", "I went a bit heavy on the drink again last night", "Curse my herbalist", "she made the best hang over cures", "Darn inconvenient of her catching the plague"}) 
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
				{
					public void action()
					{
						final String[] options107 = {"Ok goodbye", "You shouldn't drink so much then", "Do you know what is in the cure?"};
						owner.setBusy(false);
						owner.sendMenu(options107);
						owner.setMenuHandler(new MenuHandler(options107) 
						{
							public void handleReply(final int option, final String reply)
							{
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView())
								{
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) 
								{
									case 0:
										owner.setBusy(false);
										npc.unblock();
									break;
									case 1:
										drinkSoMuch(npc, owner);
									break;
									case 2:
										cure(npc, owner);
									break;
								}
							}
						});
					}
				});
			}
		});
	}
	
	private void drinkSoMuch(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Well positions of responsibility are hard", "I need something to take my mind off things", "Especially with the problems this place has"}) 
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
				{
					public void action()
					{
						final String[] options107 = {"Ok goodbye", "Do you know what is in the cure?", "I dont think drinking is the best solution"};
						owner.setBusy(false);
						owner.sendMenu(options107);
						owner.setMenuHandler(new MenuHandler(options107) 
						{
							public void handleReply(final int option, final String reply)
							{
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView())
								{
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) 
								{
									case 0:
										owner.setBusy(false);
										npc.unblock();
									break;
									case 1:
										cure(npc, owner);
									break;
									case 2:
										drinkSoMuch(npc, owner);
									break;
								}
							}
						});
					}
				});
			}
		});
	}
	
	private void cure(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Hmm let me think", "ouch - thinking not clever", "Ah here, she did scribble it down for me"}) 
		{
			public void finished()
			{
				owner.sendMessage("Bravek hands you a tatty piece of paper");
				owner.incQuestCompletionStage(35);
				owner.getInventory().add(781, 1);
				owner.sendInventory();
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}
	
	private void questStage10(final Npc npc, final Player owner)
	{
		if(owner.getInventory().countId(771) > 0)
		{
			World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"uurgh", "My head still hurts too much to think straight", "Oh for one of Trudi's hangover cures"}, true)
			{
				public void finished()
				{	
					World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"Try this"})
					{
						public void finished()
						{	
							owner.sendMessage("You give Bravek the hangover cure");
							World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
							{
								public void action()
								{
									owner.sendMessage("Bravek gulps down the foul looking liquid");
									owner.incQuestCompletionStage(35);
									owner.getInventory().remove(771, 1);
									owner.sendInventory();
									World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"grruurgh", "Ooh that's much better", "Thanks that's the clearest my head has felt in a month", "Ah now what was it you wanted me to do for you?"})
									{
										public void finished()
										{
											World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"I need to rescue a kidnap victim called Elena", "She's being held in a plague house I need permission to enter"})
											{
												public void finished()
												{
													World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Well the mourners deal with that sort of thing"})
													{
														public void finished()
														{
															World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
															{
																public void action()
																{
																	final String[] options107 = {"Is that all anyone says around here?", "They won't listen to me"};
																	owner.setBusy(false);
																	owner.sendMenu(options107);
																	owner.setMenuHandler(new MenuHandler(options107) 
																	{
																		public void handleReply(final int option, final String reply)
																		{
																			owner.setBusy(true);
																			for(Player informee : owner.getViewArea().getPlayersInView())
																			{
																				informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
																			}
																			switch(option) 
																			{
																				case 0:
																					anyoneSays(npc, owner);
																				break;
																				case 1:
																					wontListen(npc, owner);
																				break;
																			}
																		}
																	});
																}
															});
														}
													});
												}
											});
										}
									});
								}
							});
						}
					});
				}	
			});
		}
		else if(owner.getInventory().countId(781) == 0)
		{
			World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"uurgh", "My head still hurts too much to think straight", "Oh for one of Trudi's hangover cures"}, true)
			{
				public void finished()
				{	
					World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"Bravek, I have seem to have lost the note", "Do you have another on you?"})
					{
						public void finished()
						{
							World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"uuugh, ah here", "I magically found another one in my pocket for some reason"})
							{
								public void finished()
								{
									owner.sendMessage("Bravek hands you a tatty piece of paper");
									owner.getInventory().add(781, 1);
									owner.sendInventory();
									owner.setBusy(false);
									npc.unblock();
								}
							});
						}
					});
				}	
			});
		}
		else
		{
			World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"uurgh", "My head still hurts too much to think straight", "Oh for one of Trudi's hangover cures"}, true)
			{
				public void finished()
				{	
					owner.setBusy(false);
					npc.unblock();
				}	
			});
		}
	}
	
	
	
	private void questStage11(final Npc npc, final Player owner)
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Thanks again for the hangover cure", "Ah now what was it you wanted me to do for you?"}, true)
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"I need to rescue a kidnap victim called Elena", "She's being held in a plague house I need permission to enter"})
				{
					public void finished()
					{
						World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Well the mourners deal with that sort of thing"})
						{
							public void finished()
							{
								World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
								{
									public void action()
									{
										final String[] options107 = {"Is that all anyone says around here?", "They won't listen to me"};
										owner.setBusy(false);
										owner.sendMenu(options107);
										owner.setMenuHandler(new MenuHandler(options107) 
										{
											public void handleReply(final int option, final String reply)
											{
												owner.setBusy(true);
												for(Player informee : owner.getViewArea().getPlayersInView())
												{
													informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
												}
												switch(option) 
												{
													case 0:
														anyoneSays(npc, owner);
													break;
													case 1:
														wontListen(npc, owner);
													break;
												}
											}	
										});
									}
								});
							}
						});
					}
				});
			}
		});
	}
	
	private void anyoneSays(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Well they know best about plague issues"}) 
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
				{
					public void action()
					{
						final String[] options107 = {"Don't you want to take an interest in it at all?", "They won't listen to me"};
						owner.setBusy(false);
						owner.sendMenu(options107);
						owner.setMenuHandler(new MenuHandler(options107) 
						{
							public void handleReply(final int option, final String reply)
							{
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView())
								{
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) 
								{
									case 0:
										interest(npc, owner);
									break;
									case 1:
										wontListen(npc, owner);
									break;
								}
							}	
						});
					}
				});	
			}
		});
	}
	
	private void interest(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Nope I don't wish to take a deep interest in plagues", "That stuff is too scary for me"}) 
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
				{
					public void action()
					{
						final String[] options107 = {"I see why people say you're a weak leader", "They won't listen to me", "Ok I'll talk to the mourners"};
						owner.setBusy(false);
						owner.sendMenu(options107);
						owner.setMenuHandler(new MenuHandler(options107) 
						{
							public void handleReply(final int option, final String reply)
							{
								owner.setBusy(true);
								for(Player informee : owner.getViewArea().getPlayersInView())
								{
									informee.informOfChatMessage(new ChatMessage(owner, reply, npc));
								}
								switch(option) 
								{
									case 0:
										weakLeader(npc, owner);
									break;
									case 1:
										wontListen(npc, owner);
									break;
									case 2:
										owner.setBusy(false);
										npc.unblock();
									break;
								}
							}	
						});
					}
				});	
			}
		});
	}
	
	private void weakLeader(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Bah people always criticise their leaders", "But delegating is the only way to lead", "I delegate all plague issues to the mourners"}) 
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"This whole city is a plague issue"}) 
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
	
	private void questStage12(final Npc npc, final Player owner) 
	{
		if(owner.getInventory().countId(775) == 0)
		{
			World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Thanks again for the hangover cure"}, true) 
			{
				public void finished()
				{
					World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"Not a problem, happy to help out", "You wouldn't happen to have another warrant on you do ya?"}) 
					{
						public void finished()
						{
							World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"yeah sure here you go"}) 
							{
								public void finished()
								{
									owner.sendMessage("Bravek hands you a warrant");
									owner.getInventory().add(775, 1);
									owner.sendInventory();
									owner.setBusy(false);
									npc.unblock();	
								}
							});
						}
					});
				}
			});
		}
		else
		{
			World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Thanks again for the hangover cure"}, true) 
			{
				public void finished()
				{
					World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"Not a problem, happy to help out"}) 
					{
						public void finished()
						{
							World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"I'm just having a little bit of whisky", "Then I'll feel really good"}) 
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
			});
		}
	}
	
	private void wontListen(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new DelayedQuestChat(owner, npc, new String[] {"They say I'm not properly equipped to go in the house", "Though I do have a very effective gas mask"}) 
		{
			public void finished()
			{
				World.getDelayedEventHandler().add(new DelayedQuestChat(npc, owner, new String[] {"Hmm well I guess they're not taking the issue of a kidnapping seriously enough", "They do go a bit far sometimes", "I've heard of Elena, she has helped us a lot", "Ok I'll give you this warrant to enter the house"}) 
				{
					public void finished()
					{
						owner.incQuestCompletionStage(35);
						owner.sendMessage("Bravek hands you a warrant");
						owner.getInventory().add(775, 1);
						owner.sendInventory();
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
				owner.sendMessage("Bravek is not interested in talking");
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}
	
	private void noQuestStarted(final Npc npc, final Player owner) 
	{
		World.getDelayedEventHandler().add(new SingleEvent(owner, 2000)
		{
			public void action()
			{
				owner.sendMessage("Bravek is not interested in talking");
				owner.setBusy(false);
				npc.unblock();
			}
		});
	}
	
}