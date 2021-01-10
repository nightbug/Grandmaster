package Grandmaster.relics;

import Grandmaster.chr.chr_gm;

import static Grandmaster.grandmasterMod.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, chr_gm.Enums.GRANDMASTER_COLOUR);
    }
}
