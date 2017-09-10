package com.cdev.hearthtrust.models;

public class HsCard {
    private String cardId, name, rarity, faction, cardSet, type, playerClass, img, imgGold, text;
    private int attack, health, cost;
    private boolean collectible;

    public HsCard(String cardId, String name, String rarity, String faction, String cardSet, String type, String playerClass, String img, String imgGold, String text, int attack, int health, int cost, boolean collectible) {
        this.cardId = cardId;
        this.name = name;
        this.rarity = rarity;
        this.faction = faction;
        this.cardSet = cardSet;
        this.type = type;
        this.playerClass = playerClass;
        this.img = img;
        this.imgGold = imgGold;
        this.text = text;
        this.attack = attack;
        this.health = health;
        this.cost = cost;
        this.collectible = collectible;
    }

    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public String getFaction() {
        return faction;
    }

    public String getCardSet() {
        return cardSet;
    }

    public String getType() {
        return type;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public String getImg() {
        return img;
    }

    public String getImgGold() {
        return imgGold;
    }

    public String getText() {
        return text;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getCost() {
        return cost;
    }

    public boolean isCollectible() {
        return collectible;
    }

    @Override
    public String toString() {
        return "["+name+"] "+cost+" "+attack+"/"+health;
    }
}
