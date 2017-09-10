package com.cdev.hearthtrust.util.api;

import com.cdev.hearthtrust.util.enums.HSClass;

public class ApiUrl {
    //"https://omgvamp-hearthstone-v1.p.mashape.com/cards/classes/Hunter"
    private final String PREFIX = "https://omgvamp-hearthstone-v1.p.mashape.com/cards";

    public String forClass(HSClass hsClass) {
        String str = "";
        switch (hsClass) {
            case DRUID:
                str = "/Druid";
                break;
            case HUNTER:
                str = "/Hunter";
                break;
            case MAGE:
                str = "/Mage";
                break;
            case PALADIN:
                str = "/Paladin";
                break;
            case PRIEST:
                str = "/Priest";
                break;
            case ROGUE:
                str = "/Rogue";
                break;
            case SHAMAN:
                str = "/Shaman";
                break;
            case WARLOCK:
                str = "/Warlock";
                break;
            case WARRIOR:
                str = "/Warrior";
                break;
            default:
                str = "/Neutral";
                break;
        }
        return PREFIX + "/classes" + str + "?collectible=1";
    }
}
