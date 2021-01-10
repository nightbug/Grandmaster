package Grandmaster.vars;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;;
import Grandmaster.cards.abs.abs_gm_card;
import static Grandmaster.grandmasterMod.makeID;

public class gm_card_magic extends DynamicVariable {

    @Override
    public String key() {
        return makeID("si");
    } //TODO: Change this, if you want. It's already modID prefixed, so no worries about conflicts (ASSUMING YOU CHANGED YOUR MODID!)

    @Override
    public boolean isModified(AbstractCard card) {
        if (card instanceof abs_gm_card) {
            return ((abs_gm_card) card).isGMSecondMagicNumberModified;
        }
        return false;
    }

    @Override
    public int value(AbstractCard card) {
        if (card instanceof abs_gm_card) {
            return ((abs_gm_card) card).gmSecondMagicNumber;
        }
        return -1;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof abs_gm_card) {
            ((abs_gm_card) card).isGMSecondMagicNumberModified = v;
        }
    }

    @Override
    public int baseValue(AbstractCard card) {
        if (card instanceof abs_gm_card) {
            return ((abs_gm_card) card).gmBaseSecondMagicNumber;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        if (card instanceof abs_gm_card) {
            return ((abs_gm_card) card).upgradedGMSecondMagicNumber;
        }
        return false;
    }
}