package Grandmaster.chr;

import Grandmaster.cards.bas.Defend;
import Grandmaster.cards.bas.Strike;
import basemod.abstracts.CustomEnergyOrb;
import basemod.abstracts.CustomPlayer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.cutscenes.CutscenePanel;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import Grandmaster.relics.TodoItem;
import Grandmaster.util.BetterSpriterAnimation;

import java.util.ArrayList;
import java.util.List;

import static Grandmaster.chr.chr_gm.Enums.GRANDMASTER_COLOUR;
import static Grandmaster.grandmasterMod.*;
import static Grandmaster.util.actionShortcuts.p;

public class chr_gm extends CustomPlayer {

    public static class Enums {
        @SpireEnum
        public static AbstractPlayer.PlayerClass GRANDMASTER;
        @SpireEnum(name = "TODO_COLOR")
        public static AbstractCard.CardColor GRANDMASTER_COLOUR;
        @SpireEnum(name = "TODO_COLOR")
        @SuppressWarnings("unused")
        public static CardLibrary.LibraryType LIBRARY_COLOR;
    }

    private static final String[] orbTextures = {
            getModID() + "Resources/images/char/mainChar/orb/layer1.png",
            getModID() + "Resources/images/char/mainChar/orb/layer2.png",
            getModID() + "Resources/images/char/mainChar/orb/layer3.png",
            getModID() + "Resources/images/char/mainChar/orb/layer4.png",
            getModID() + "Resources/images/char/mainChar/orb/layer5.png",
            getModID() + "Resources/images/char/mainChar/orb/layer6.png",
            getModID() + "Resources/images/char/mainChar/orb/layer1d.png",
            getModID() + "Resources/images/char/mainChar/orb/layer2d.png",
            getModID() + "Resources/images/char/mainChar/orb/layer3d.png",
            getModID() + "Resources/images/char/mainChar/orb/layer4d.png",
            getModID() + "Resources/images/char/mainChar/orb/layer5d.png",};
    private static final String ID = makeID(chr_gm.class.getSimpleName());
    private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
    private static final String[] NAMES = characterStrings.NAMES;
    private static final String[] TEXT = characterStrings.TEXT;


    public chr_gm(String name, PlayerClass setClass) {
        super(name, setClass, new CustomEnergyOrb(orbTextures, getModID() + "Resources/images/char/mainChar/orb/vfx.png", null), new BetterSpriterAnimation(
                getModID() + "Resources/images/char/mainChar/static.scml"));
        initializeClass(null,
                SHOULDER1,
                SHOULDER2,
                CORPSE,
                getLoadout(), 20.0F, -10.0F, 166.0F, 327.0F, new EnergyManager(3));


        dialogX = (drawX + 0.0F * Settings.scale);
        dialogY = (drawY + 240.0F * Settings.scale);
    }

    @Override
    public CharSelectInfo getLoadout() {
        return new CharSelectInfo(NAMES[0], TEXT[0],
                80, 80, 0, 99, 5, this, getStartingRelics(),
                getStartingDeck(), false);
    }

    @Override
    public ArrayList<String> getStartingDeck() {
        ArrayList<String> retVal = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            retVal.add(Strike.ID);
        }
        for (int i = 0; i < 4; i++) {
            retVal.add(Defend.ID);
        }
        //TODO: Change this to your specifications.
        return retVal;
    }

    public ArrayList<String> getStartingRelics() {
        ArrayList<String> retVal = new ArrayList<>();
        retVal.add(TodoItem.ID);
        //TODO: Change this too.
        return retVal;
    }

    @Override
    public void doCharSelectScreenSelectEffect() {
        CardCrawlGame.sound.playA("UNLOCK_PING", MathUtils.random(-0.2F, 0.2F));
        CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT,
                false);
        //TODO: Change this to a sound befitting your character.
    }

    @Override
    public String getCustomModeCharacterButtonSoundKey() {
        return "UNLOCK_PING"; //TODO: Change this to a sound befitting your character.
    }

    @Override
    public int getAscensionMaxHPLoss() {
        return 8;
    }

    @Override
    public AbstractCard.CardColor getCardColor() {
        return GRANDMASTER_COLOUR;
    }

    @Override
    public Color getCardTrailColor() {
        return gm_color.cpy();
    }

    @Override
    public BitmapFont getEnergyNumFont() {
        return FontHelper.energyNumFontRed;
    }

    @Override
    public String getLocalizedCharacterName() {
        return NAMES[0];
    }

    @Override
    public AbstractCard getStartCardForEvent() {
        return null;
        //TODO: Change this to your character's special starting card.
    }

    @Override
    public String getTitle(AbstractPlayer.PlayerClass playerClass) {
        return NAMES[1];
    }

    @Override
    public AbstractPlayer newInstance() {
        return new chr_gm(name, chosenClass);
    }

    @Override
    public Color getCardRenderColor() {
        return gm_color.cpy();
    }

    @Override
    public Color getSlashAttackColor() {
        return gm_color.cpy();
    }

    @Override
    public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
        return new AbstractGameAction.AttackEffect[]{
                AbstractGameAction.AttackEffect.FIRE,
                AbstractGameAction.AttackEffect.BLUNT_HEAVY,
                AbstractGameAction.AttackEffect.FIRE};
    }

    @Override
    public List<CutscenePanel> getCutscenePanels() {
        return super.getCutscenePanels();
        //TODO: Override this if you want an alternate heart win comic
    }

    @Override
    public String getSpireHeartText() {
        return TEXT[1];
    }

    @Override
    public String getVampireText() {
        return TEXT[2];
    }

    @Override
    public void damage(DamageInfo info) {
        int thisHealth = this.currentHealth;
        super.damage(info);
        int trueDamage = thisHealth - this.currentHealth;
        if (info.owner != null && info.type != DamageInfo.DamageType.THORNS && trueDamage > 0) {
            if (this.isDead) { this.playDeathAnimation(); }
            else {
                // hit
            }
        }
    }

    public static void runAnimation(String anim) {
        if (p() instanceof chr_gm) { ((chr_gm) p()).runAnim(anim); }
    }

    public void playDeathAnimation() {
        //runAnimation("Win");
    }

    public void runAnim(String animation) {
        ((BetterSpriterAnimation)this.animation).myPlayer.setAnimation(animation);
    }

    public void resetAnimation() {
        ((BetterSpriterAnimation)this.animation).myPlayer.setAnimation("Idle");
    }

    public void stopAnimation() {
        int time = ((BetterSpriterAnimation)this.animation).myPlayer.getAnimation().length;
        ((BetterSpriterAnimation)this.animation).myPlayer.setTime(time);
    }

}
