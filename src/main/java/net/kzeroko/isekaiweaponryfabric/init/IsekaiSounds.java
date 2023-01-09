package net.kzeroko.isekaiweaponryfabric.init;

import net.minecraft.sound.SoundEvent;
import net.kzeroko.isekaiweaponryfabric.IsekaiUtils;
import net.minecraft.util.Identifier;

public class IsekaiSounds {
    // Special ID
    public static final Identifier CAST_ACTIVATE_REG = registerId("cast_activate");
    public static final Identifier CAST_BUFF_REG = registerId("cast_buff");
    public static final Identifier CAST_DARK_REG = registerId("cast_dark");
    public static final Identifier CAST_NIGHTMARE_REG = registerId("cast_nightmare");
    public static final Identifier CAST_REPLENISH_REG = registerId("cast_replenish");
    public static final Identifier CRESCENTROSE_SHOOT_REG = registerId("crescentrose_shoot");
    public static final Identifier CRESCENTROSE_CHARGE_REG = registerId("crescentrose_charge");
    public static final Identifier DONNERANDSCHLAG_HIT_REG = registerId("donnerandschlag_hit");
    public static final Identifier DONNERANDSCHLAG_RELOAD_REG = registerId("donnerandschlag_reload");
    public static final Identifier DONNERANDSCHLAG_SHOOT_REG = registerId("donnerandschlag_shoot");
    public static final Identifier MAGICAL_HIT_REG = registerId("magical_hit");
    // Templates ID
    public static final Identifier WHOOSH_BLAZING1_REG = registerId("whoosh_blazing1");
    public static final Identifier WHOOSH_BLAZING2_REG = registerId("whoosh_blazing2");
    public static final Identifier WHOOSH_BLAZING3_REG = registerId("whoosh_blazing3");
    public static final Identifier WHOOSH_BLAZING4_REG = registerId("whoosh_blazing4");
    public static final Identifier WHOOSH_BLAZING5_REG = registerId("whoosh_blazing5");
    public static final Identifier WHOOSH_BLAZING6_REG = registerId("whoosh_blazing6");
    public static final Identifier WHOOSH_BLAZING7_REG = registerId("whoosh_blazing7");
    public static final Identifier WHOOSH_BLAZING8_REG = registerId("whoosh_blazing8");
    public static final Identifier WHOOSH_CHARGE1_REG = registerId("whoosh_charge1");
    public static final Identifier WHOOSH_CHARGE2_REG = registerId("whoosh_charge2");
    public static final Identifier WHOOSH_ELECTRIC1_REG = registerId("whoosh_electric1");
    public static final Identifier WHOOSH_ELECTRIC2_REG = registerId("whoosh_electric2");
    public static final Identifier WHOOSH_ELECTRIC3_REG = registerId("whoosh_electric3");
    public static final Identifier WHOOSH_ELECTRIC4_REG = registerId("whoosh_electric4");
    public static final Identifier WHOOSH_ELECTRIC5_REG = registerId("whoosh_electric5");
    public static final Identifier WHOOSH_HEAVY1_REG = registerId("whoosh_heavy1");
    public static final Identifier WHOOSH_HEAVY2_REG = registerId("whoosh_heavy2");
    public static final Identifier WHOOSH_HEAVY3_REG = registerId("whoosh_heavy3");
    public static final Identifier WHOOSH_HEAVY4_REG = registerId("whoosh_heavy4");
    public static final Identifier WHOOSH_HEAVY5_REG = registerId("whoosh_heavy5");
    public static final Identifier WHOOSH_LIGHT1_REG = registerId("whoosh_light1");
    public static final Identifier WHOOSH_LIGHT2_REG = registerId("whoosh_light2");
    public static final Identifier WHOOSH_LIGHT3_REG = registerId("whoosh_light3");
    public static final Identifier WHOOSH_LIGHT4_REG = registerId("whoosh_light4");
    public static final Identifier WHOOSH_LONG1_REG = registerId("whoosh_long1");
    public static final Identifier WHOOSH_LONG2_REG = registerId("whoosh_long2");
    public static final Identifier WHOOSH_SHARP1_REG = registerId("whoosh_sharp1");
    public static final Identifier WHOOSH_SHARP2_REG = registerId("whoosh_sharp2");
    public static final Identifier WHOOSH_SHARP3_REG = registerId("whoosh_sharp3");
    public static final Identifier WHOOSH_SHARP4_REG = registerId("whoosh_sharp4");
    public static final Identifier WHOOSH_SIMPLE1_REG = registerId("whoosh_simple1");
    public static final Identifier WHOOSH_SIMPLE2_REG = registerId("whoosh_simple2");
    public static final Identifier WHOOSH_SIMPLE3_REG = registerId("whoosh_simple3");
    public static final Identifier WHOOSH_SIMPLE4_REG = registerId("whoosh_simple4");

    // Special Event
    public static SoundEvent CAST_ACTIVATE;
    public static SoundEvent CAST_BUFF;
    public static SoundEvent CAST_DARK;
    public static SoundEvent CAST_NIGHTMARE;
    public static SoundEvent CAST_REPLENISH;
    public static SoundEvent CRESCENTROSE_SHOOT;
    public static SoundEvent CRESCENTROSE_CHARGE;
    public static SoundEvent DONNERANDSCHLAG_HIT;
    public static SoundEvent DONNERANDSCHLAG_RELOAD;
    public static SoundEvent DONNERANDSCHLAG_SHOOT;
    public static SoundEvent MAGICAL_HIT;
    // Template Event
    public static SoundEvent WHOOSH_BLAZING1;
    public static SoundEvent WHOOSH_BLAZING2;
    public static SoundEvent WHOOSH_BLAZING3;
    public static SoundEvent WHOOSH_BLAZING4;
    public static SoundEvent WHOOSH_BLAZING5;
    public static SoundEvent WHOOSH_BLAZING6;
    public static SoundEvent WHOOSH_BLAZING7;
    public static SoundEvent WHOOSH_BLAZING8;
    public static SoundEvent WHOOSH_CHARGE1;
    public static SoundEvent WHOOSH_CHARGE2;
    public static SoundEvent WHOOSH_ELECTRIC1;
    public static SoundEvent WHOOSH_ELECTRIC2;
    public static SoundEvent WHOOSH_ELECTRIC3;
    public static SoundEvent WHOOSH_ELECTRIC4;
    public static SoundEvent WHOOSH_ELECTRIC5;
    public static SoundEvent WHOOSH_HEAVY1;
    public static SoundEvent WHOOSH_HEAVY2;
    public static SoundEvent WHOOSH_HEAVY3;
    public static SoundEvent WHOOSH_HEAVY4;
    public static SoundEvent WHOOSH_HEAVY5;
    public static SoundEvent WHOOSH_LIGHT1;
    public static SoundEvent WHOOSH_LIGHT2;
    public static SoundEvent WHOOSH_LIGHT3;
    public static SoundEvent WHOOSH_LIGHT4;
    public static SoundEvent WHOOSH_LONG1;
    public static SoundEvent WHOOSH_LONG2;
    public static SoundEvent WHOOSH_SHARP1;
    public static SoundEvent WHOOSH_SHARP2;
    public static SoundEvent WHOOSH_SHARP3;
    public static SoundEvent WHOOSH_SHARP4;
    public static SoundEvent WHOOSH_SIMPLE1;
    public static SoundEvent WHOOSH_SIMPLE2;
    public static SoundEvent WHOOSH_SIMPLE3;
    public static SoundEvent WHOOSH_SIMPLE4;

    public IsekaiSounds() {
    }

    public static void init() {
        IsekaiUtils.registerSound(CAST_ACTIVATE_REG, CAST_ACTIVATE);
        IsekaiUtils.registerSound(CAST_BUFF_REG, CAST_BUFF);
        IsekaiUtils.registerSound(CAST_DARK_REG, CAST_DARK);
        IsekaiUtils.registerSound(CAST_NIGHTMARE_REG, CAST_NIGHTMARE);
        IsekaiUtils.registerSound(CAST_REPLENISH_REG, CAST_REPLENISH);
        IsekaiUtils.registerSound(CRESCENTROSE_SHOOT_REG, CRESCENTROSE_SHOOT);
        IsekaiUtils.registerSound(CRESCENTROSE_CHARGE_REG, CRESCENTROSE_CHARGE);
        IsekaiUtils.registerSound(DONNERANDSCHLAG_HIT_REG, DONNERANDSCHLAG_HIT);
        IsekaiUtils.registerSound(DONNERANDSCHLAG_RELOAD_REG, DONNERANDSCHLAG_RELOAD);
        IsekaiUtils.registerSound(DONNERANDSCHLAG_SHOOT_REG, DONNERANDSCHLAG_SHOOT);
        IsekaiUtils.registerSound(MAGICAL_HIT_REG, MAGICAL_HIT);

        IsekaiUtils.registerSound(WHOOSH_BLAZING1_REG, WHOOSH_BLAZING1);
        IsekaiUtils.registerSound(WHOOSH_BLAZING2_REG, WHOOSH_BLAZING2);
        IsekaiUtils.registerSound(WHOOSH_BLAZING3_REG, WHOOSH_BLAZING3);
        IsekaiUtils.registerSound(WHOOSH_BLAZING4_REG, WHOOSH_BLAZING4);
        IsekaiUtils.registerSound(WHOOSH_BLAZING5_REG, WHOOSH_BLAZING5);
        IsekaiUtils.registerSound(WHOOSH_BLAZING6_REG, WHOOSH_BLAZING6);
        IsekaiUtils.registerSound(WHOOSH_BLAZING7_REG, WHOOSH_BLAZING7);
        IsekaiUtils.registerSound(WHOOSH_BLAZING8_REG, WHOOSH_BLAZING8);
        IsekaiUtils.registerSound(WHOOSH_CHARGE1_REG, WHOOSH_CHARGE1);
        IsekaiUtils.registerSound(WHOOSH_CHARGE2_REG, WHOOSH_CHARGE2);
        IsekaiUtils.registerSound(WHOOSH_ELECTRIC1_REG, WHOOSH_ELECTRIC1);
        IsekaiUtils.registerSound(WHOOSH_ELECTRIC2_REG, WHOOSH_ELECTRIC2);
        IsekaiUtils.registerSound(WHOOSH_ELECTRIC3_REG, WHOOSH_ELECTRIC3);
        IsekaiUtils.registerSound(WHOOSH_ELECTRIC4_REG, WHOOSH_ELECTRIC4);
        IsekaiUtils.registerSound(WHOOSH_ELECTRIC5_REG, WHOOSH_ELECTRIC5);
        IsekaiUtils.registerSound(WHOOSH_HEAVY1_REG, WHOOSH_HEAVY1);
        IsekaiUtils.registerSound(WHOOSH_HEAVY2_REG, WHOOSH_HEAVY2);
        IsekaiUtils.registerSound(WHOOSH_HEAVY3_REG, WHOOSH_HEAVY3);
        IsekaiUtils.registerSound(WHOOSH_HEAVY4_REG, WHOOSH_HEAVY4);
        IsekaiUtils.registerSound(WHOOSH_HEAVY5_REG, WHOOSH_HEAVY5);
        IsekaiUtils.registerSound(WHOOSH_LIGHT1_REG, WHOOSH_LIGHT1);
        IsekaiUtils.registerSound(WHOOSH_LIGHT2_REG, WHOOSH_LIGHT2);
        IsekaiUtils.registerSound(WHOOSH_LIGHT3_REG, WHOOSH_LIGHT3);
        IsekaiUtils.registerSound(WHOOSH_LIGHT4_REG, WHOOSH_LIGHT4);
        IsekaiUtils.registerSound(WHOOSH_LONG1_REG, WHOOSH_LONG1);
        IsekaiUtils.registerSound(WHOOSH_LONG2_REG, WHOOSH_LONG2);
        IsekaiUtils.registerSound(WHOOSH_SHARP1_REG, WHOOSH_SHARP1);
        IsekaiUtils.registerSound(WHOOSH_SHARP2_REG, WHOOSH_SHARP2);
        IsekaiUtils.registerSound(WHOOSH_SHARP3_REG, WHOOSH_SHARP3);
        IsekaiUtils.registerSound(WHOOSH_SHARP4_REG, WHOOSH_SHARP4);
        IsekaiUtils.registerSound(WHOOSH_SIMPLE1_REG, WHOOSH_SIMPLE1);
        IsekaiUtils.registerSound(WHOOSH_SIMPLE2_REG, WHOOSH_SIMPLE2);
        IsekaiUtils.registerSound(WHOOSH_SIMPLE3_REG, WHOOSH_SIMPLE3);
        IsekaiUtils.registerSound(WHOOSH_SIMPLE4_REG, WHOOSH_SIMPLE4);
    }

    public static Identifier registerId(String name) {
        return new Identifier("isekaiweaponryfabric:" + name);
    }

    static {
        CAST_ACTIVATE = new SoundEvent(CAST_ACTIVATE_REG);
        CAST_BUFF = new SoundEvent(CAST_BUFF_REG);
        CAST_DARK = new SoundEvent(CAST_DARK_REG);
        CAST_NIGHTMARE = new SoundEvent(CAST_NIGHTMARE_REG);
        CAST_REPLENISH = new SoundEvent(CAST_REPLENISH_REG);
        CRESCENTROSE_SHOOT = new SoundEvent(CRESCENTROSE_SHOOT_REG);
        CRESCENTROSE_CHARGE = new SoundEvent(CRESCENTROSE_CHARGE_REG);
        DONNERANDSCHLAG_HIT = new SoundEvent(DONNERANDSCHLAG_HIT_REG);
        DONNERANDSCHLAG_RELOAD = new SoundEvent(DONNERANDSCHLAG_RELOAD_REG);
        DONNERANDSCHLAG_SHOOT = new SoundEvent(DONNERANDSCHLAG_SHOOT_REG);
        MAGICAL_HIT = new SoundEvent(MAGICAL_HIT_REG);

        WHOOSH_BLAZING1 = new SoundEvent(WHOOSH_BLAZING1_REG);
        WHOOSH_BLAZING2 = new SoundEvent(WHOOSH_BLAZING2_REG);
        WHOOSH_BLAZING3 = new SoundEvent(WHOOSH_BLAZING3_REG);
        WHOOSH_BLAZING4 = new SoundEvent(WHOOSH_BLAZING4_REG);
        WHOOSH_BLAZING5 = new SoundEvent(WHOOSH_BLAZING5_REG);
        WHOOSH_BLAZING6 = new SoundEvent(WHOOSH_BLAZING6_REG);
        WHOOSH_BLAZING7 = new SoundEvent(WHOOSH_BLAZING7_REG);
        WHOOSH_BLAZING8 = new SoundEvent(WHOOSH_BLAZING8_REG);
        WHOOSH_CHARGE1 = new SoundEvent(WHOOSH_CHARGE1_REG);
        WHOOSH_CHARGE2 = new SoundEvent(WHOOSH_CHARGE2_REG);
        WHOOSH_ELECTRIC1 = new SoundEvent(WHOOSH_ELECTRIC1_REG);
        WHOOSH_ELECTRIC2 = new SoundEvent(WHOOSH_ELECTRIC2_REG);
        WHOOSH_ELECTRIC3 = new SoundEvent(WHOOSH_ELECTRIC3_REG);
        WHOOSH_ELECTRIC4 = new SoundEvent(WHOOSH_ELECTRIC4_REG);
        WHOOSH_ELECTRIC5 = new SoundEvent(WHOOSH_ELECTRIC5_REG);
        WHOOSH_HEAVY1 = new SoundEvent(WHOOSH_HEAVY1_REG);
        WHOOSH_HEAVY2 = new SoundEvent(WHOOSH_HEAVY2_REG);
        WHOOSH_HEAVY3 = new SoundEvent(WHOOSH_HEAVY3_REG);
        WHOOSH_HEAVY4 = new SoundEvent(WHOOSH_HEAVY4_REG);
        WHOOSH_HEAVY5 = new SoundEvent(WHOOSH_HEAVY5_REG);
        WHOOSH_LIGHT1 = new SoundEvent(WHOOSH_LIGHT1_REG);
        WHOOSH_LIGHT2 = new SoundEvent(WHOOSH_LIGHT2_REG);
        WHOOSH_LIGHT3 = new SoundEvent(WHOOSH_LIGHT3_REG);
        WHOOSH_LIGHT4 = new SoundEvent(WHOOSH_LIGHT4_REG);
        WHOOSH_LONG1 = new SoundEvent(WHOOSH_LONG1_REG);
        WHOOSH_LONG2 = new SoundEvent(WHOOSH_LONG2_REG);
        WHOOSH_SHARP1 = new SoundEvent(WHOOSH_SHARP1_REG);
        WHOOSH_SHARP2 = new SoundEvent(WHOOSH_SHARP2_REG);
        WHOOSH_SHARP3 = new SoundEvent(WHOOSH_SHARP3_REG);
        WHOOSH_SHARP4 = new SoundEvent(WHOOSH_SHARP4_REG);
        WHOOSH_SIMPLE1 = new SoundEvent(WHOOSH_SIMPLE1_REG);
        WHOOSH_SIMPLE2 = new SoundEvent(WHOOSH_SIMPLE2_REG);
        WHOOSH_SIMPLE3 = new SoundEvent(WHOOSH_SIMPLE3_REG);
        WHOOSH_SIMPLE4 = new SoundEvent(WHOOSH_SIMPLE4_REG);
    }
}
