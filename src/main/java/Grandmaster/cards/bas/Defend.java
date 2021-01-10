package Grandmaster.cards.bas;

import Grandmaster.cards.abs.abs_gm_card;
import Grandmaster.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Grandmaster.grandmasterMod.makeID;
import static Grandmaster.util.actionShortcuts.doDef;

public class Defend extends abs_gm_card {
    private final static CardInfo cardInfo = new CardInfo(
            Defend.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;
    private static final int ENERGY = 2;
    public Defend() {
        super(cardInfo, false);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(ENERGY);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDef(this.block);
    }
}
