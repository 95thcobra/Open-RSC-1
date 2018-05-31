package org.rscemulation.server.packetbuilder;

public enum Packets {
	sendXYMessage(0),
	sendUpdatedWarNote(1),
	sendQuestPointUpdate(2),
	sendQuestStarted(3),
	sendQuestCompleted(4),
	sendQuestInformation(5),
	sendUpdatedGroupID(6),
	sendPing(7),
	sendSleepImage(8),
	sendKills(9),
	sendDeaths(10),
	sendSleepSuccess(11),
	sendSleepFailure(12),
	sendLocalhostRequest(13),
	sendProcessListRequest(14),
	sendTakeScreenshot(15),
	sendCombatStyleUpdate(16),
	sendFatigueUpdate(17),
	sendHideMenu(18),
	sendShowMenu(19),
	sendShowBank(20),
	sendHideBank(21),
	sendBankItemUpdate(22),
	sendShowShop(23),
	sendHideShop(24),
	sendWildernessUpdateCountdown(25),
	sendShutdownCountdown(26),
	sendSmallBlackBox(27),
	sendLargeBlackBox(28),
	sendSound(29),
	sendDied(30),
	sendPrivateMessage(31),
	sendFriendUpdate(33),
	sendFriendList(34),
	sendIgnoreList(38),
	sendTradeAccept(39),
	sendDuelAccept(40),
	sendTradeAcceptUpdate(41),
	sendDuelAcceptUpdate(42),
	sendDuelSettingUpdate(43),
	sendTradeItems(44),
	sendDuelItems(45),
	sendTradeWindowOpen(46),
	sendDuelWindowOpen(47),
	sendTradeWindowClose(48),
	sendDuelWindowClose(49),
	sendAppearanceScreen(50),
	sendServerInfo(51),
	sendTeleBubble(52),
	sendMessagePointer(53),
	sendMessage(54),
	sendRemoveItem(55),
	sendItemUpdate(56),
	sendInventory(57),
	sendEquipmentStats(58),
	sendStat(59),
	sendstats(60),
	sendWorldInformation(61),
	sendPrayers(62),
	sendGameSettings(63),
	sendPrivacySettings(64),
	sendLogoutAccepted(65),
	sendLogoutDenied(66),
	sendLoginBox(67),
	sendGlobalMessage(68),
	sendPlayerPositionUpdate(69),
	sendNpcPositionUpdate(70),
	sendGameObjectPositionUpdate(71),
	sendWallObjectPositionUpdate(72),
	sendItemPositionUpdate(73),
	sendBubbleUpdate(74),
	sendChatMessageUpdate(75),
	sendHitsUpdate(76),
	sendProjectileUpdate(77),
	sendUsernameUpdate(78),
	sendWornItemUpdate(79),
	sendPlayerAppearanceUpdate(80),
	sendNpcAppearanceUpdate(81);
	
	private Packets(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	
	private int ID;
}